package com.cognixia.jump.LibraryProject.LibraryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.cognixia.jump.LibraryProject.connection.ConnectionManager;
import com.cognixia.jump.LibraryProject.model.Library;

public class LibraryDAO {
	public int patronID, LibrarianID;
	public static final Connection conn = ConnectionManager.getConnection();
	
	//login sql statements
	private static final String PARTON_LOGIN = "select * from patron where username = ? and password = ?";
	private static final String LIBRARIAN_LOGIN = "select * from librarian where username = ? and password = ?";
	//used to update patron and librarian login
	private static final String PATRON_LOGIN_UPDATE="update patron set first_name = ?, last_name = ?, username = ?, "
			+ "password = ?, where account_id = ?";
	private static final String LIBRARIAN_LOGIN_UPDATE="update librarian set username = ?, password = ?, where librarian_id = ?";
	//used to allow user to sign up
	private static final String PATRON_SIGNUP="insert into patron (first_name, last_name, username, password) values (?,?,?,?)";
	//used by librarian to see what account need to be unfrozen.
	private static final String PATRON_LIST = "select patron_id, first_name, last_name, account_frozen from patron order by account_frozen desc";
	private static final String PATRON_UNFREEZE="update patron set account_frozen = 1 where account_id = ?";
	//used for all dml transactions relating to the books
	private static final String SELECT_BOOKS = "select * from book";
	private static final String SELECT_CHECKOUT_BOOK = "select * from Book_Checkout";
	private static final String CHECKOUT_BOOK = "update book set rented = 1 where isbn = ?";
	private static final String CHECKIN_BOOK = "update book set rented = 0, returned = ?, where isbn = ?";
	private static final String RECORD_CHECKOUT = "insert into Book_Checkout (patron_id, isbn, checkout, due_date) values (?,?,?,?)";
	private static final String ADD_BOOK = "insert into Book (isbn, title, descr, added_to_library) values (?,?,?,?)";
	private static final String UPDATE_BOOK = "update Book set isbn = ?, title = ?, descr = ?, rented = ?, added_to_library = ? where isbn = ?";
	
	//login methods used by both groups
	public int patronLogin(Library Library) {
		try(PreparedStatement pstmt = conn.prepareStatement(PARTON_LOGIN);
				ResultSet rs = pstmt.executeQuery()){
			String user = Library.getUsername();
			String pass = Library.getPassword();
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			//boolean used to pass if the login credentials were correct. if not will inform the user that the login failed.
			boolean check = false;
			while(rs.next()) {
				String userName = rs.getString("username");
				String paswword = rs.getString("password");
				//if statement used to make the values will match that way the patron id can be pulled and used for later functions.
				if(user.equals(userName) & pass.equals(paswword)) {
					patronID = rs.getInt("patron_ID");
					check = true;}//end if
				}//end while
		} catch(SQLException e) {e.printStackTrace();}//end try/catch
		return patronID;
	}//end patronLogin
	public int librarianLogin(Library Library) {
		try(PreparedStatement pstmt = conn.prepareStatement(LIBRARIAN_LOGIN);
				ResultSet rs = pstmt.executeQuery()){
			String user = Library.getUsername();
			String pass = Library.getPassword();
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			//boolean used to pass if the login credentials were correct. if not will inform the user that the login failed.
			boolean check = false;
			while(rs.next()) {
				String userName = rs.getString("username");
				String paswword = rs.getString("password");
				//if statement used to make the values will match that way the librarian id can be pulled and used for later functions.
				if(user.equals(userName) & pass.equals(paswword)) {
					patronID = rs.getInt("librarian_id");
					check = true;}//end if
				}//end while
		} catch(SQLException e) {e.printStackTrace();}//end try/catch
		return patronID;
	}//end librarianLogin
	//will allow the user to update all info of their account other than id. You have to pay extra for that. A patron account will be set up later.
	public boolean patronLoginUpdate(Library Library) {
		try (PreparedStatement pstmt = conn.prepareStatement(PATRON_LOGIN_UPDATE)) {
			pstmt.setString(1, Library.getFirst_name());
			pstmt.setString(2, Library.getLast_name());
			pstmt.setString(3, Library.getUsername());
			pstmt.setString(4, Library.getPassword());
			pstmt.setInt(5, Library.getPatron_id());
			// at least one row updated
			if (pstmt.executeUpdate() > 0) {
				return true;}
		} catch (SQLException e) {e.printStackTrace();}//end try/catch
		return false;}
	//end patronLoginUpdate
	//will allow the librarian to update their username and password. If the librarian brings the dba a box of chocolate then they can get a new ID.
	public boolean librarianLoginUpdate(Library Library) {
		try (PreparedStatement pstmt = conn.prepareStatement(LIBRARIAN_LOGIN_UPDATE)) {
			pstmt.setString(1, Library.getUsername());
			pstmt.setString(2, Library.getPassword());
			pstmt.setInt(3, Library.getLibrarian_id());
			// at least one row updated
			if (pstmt.executeUpdate() > 0) {
				return true;}
		} catch (SQLException e) {e.printStackTrace();}//end try/catch
		return false;}
	//end librarianLoginUpdate
	//will add new user to the library. we need customers 
	public boolean addUser(Library Library) {
		try(PreparedStatement pstmt = conn.prepareStatement(PATRON_SIGNUP)) {
			pstmt.setString(1, Library.getFirst_name());
			pstmt.setString(2, Library.getLast_name());
			pstmt.setString(3, Library.getUsername());
			pstmt.setString(4, Library.getPassword());
			// at least one row added
			if(pstmt.executeUpdate() > 0) {
				return true;}
		} catch(SQLException e) {e.printStackTrace();}
		return false;
	}//end addBook
	//methods used to look at patrons and unfreeze them.
	//will list all the patrons to the librarian to check which accounts need to be unfrozen.
	public List<Library> getAllPatrons() {
		List<Library> allPatrons = new ArrayList<Library>();
		try(PreparedStatement pstmt = conn.prepareStatement(PATRON_LIST);
				ResultSet rs = pstmt.executeQuery() ) {
			while(rs.next()) {
				int patron_id = rs.getInt("patron_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				boolean account_frozen = rs.getBoolean("account_frozen");
				allPatrons.add(new Library(patron_id, first_name, last_name, account_frozen));}//end while
		} catch(SQLException e) {e.printStackTrace();}//end try/catch
		return allPatrons;
	}//end getAllPatrons
	//will allow the librarian to unfreeze an account
	public boolean patron_Unfreeze(Library Library) {
		try (PreparedStatement pstmt = conn.prepareStatement(PATRON_UNFREEZE)) {
			pstmt.setString(1, Library.getUsername());
			pstmt.setString(2, Library.getPassword());
			pstmt.setInt(3, Library.getPatron_id());
			// at least one row updated
			if (pstmt.executeUpdate() > 0) {
				return true;}
		} catch (SQLException e) {e.printStackTrace();}//end try/catch
		return false;}//end patron_Unfreeze
	//All book methods
	//will list all books to the user
	public List<Library> getAllBooks() {
		List<Library> allBooks = new ArrayList<Library>();
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_BOOKS);
				ResultSet rs = pstmt.executeQuery() ) {
			while(rs.next()) {
				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String descr = rs.getString("descr");
				boolean rented = rs.getBoolean("rented");
				Date added_to_library = rs.getDate("added_to_library");
				System.out.println(isbn + title + descr);
				allBooks.add(new Library(isbn, title, descr, rented, added_to_library));}//end while
		} catch(SQLException e) {e.printStackTrace();}//end try/catch
		return allBooks;
	}//end getallBooks
	//will list all the books that are checked out
	public List<Library> getCheckOutBooks(){
		List<Library> checkOutBooks = new ArrayList<Library>();
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_CHECKOUT_BOOK);
				ResultSet rs = pstmt.executeQuery() ) {
			while(rs.next()) {
				int patron_id = rs.getInt("patron_id");
				int checkout_id = rs.getInt("checkout_id");
				String isbn = rs.getString("isbn");
				Date checkedout = rs.getDate("checkedout");
				Date due_date = rs.getDate("due_date");
				Date returned = rs.getDate("returned");
				checkOutBooks.add(new Library(patron_id, checkout_id, isbn, checkedout, due_date, returned));}//end while
		} catch(SQLException e) {e.printStackTrace();}//end try/catch
		return checkOutBooks;
	}//end getCheckOutBooks
	//will set the book to being checked out.
	public boolean checkOutBook(String isbn) {
		try (PreparedStatement pstmt = conn.prepareStatement(CHECKOUT_BOOK)) {
			pstmt.setString(1, isbn);
			// at least one row updated
			if (pstmt.executeUpdate() > 0) {
				return true;}
		} catch (SQLException e) {e.printStackTrace();}//end try/catch
		return false;}//end checkOut_Book
	//will set the book to being checked in.
	public boolean checkInBook(Library Library) {
		try (PreparedStatement pstmt = conn.prepareStatement(CHECKIN_BOOK)) {
			pstmt.setDate(1, Library.getReturned());
			pstmt.setString(2, Library.getIsbn());
			// at least one row updated
			if (pstmt.executeUpdate() > 0) {
				return true;}
		} catch (SQLException e) {e.printStackTrace();}//end try/catch
		return false;}//end checkIn_Book
	//will add the record of the book being checked out
	public boolean recordCheckout(Library Library) {
		try(PreparedStatement pstmt = conn.prepareStatement(RECORD_CHECKOUT)) {
			pstmt.setInt(1, Library.getPatron_id());
			pstmt.setString(2, Library.getIsbn());
			pstmt.setDate(3, Library.getCheckedout());
			pstmt.setDate(4, (Date) Library.getDue_date());
			// at least one row added
			if(pstmt.executeUpdate() > 0) {
				return true;}
		} catch(SQLException e) {e.printStackTrace();}
		return false;
	}//end addBook
	//will allow the librarian to add a book to the library
	public boolean addBook(Library Library) {
		try(PreparedStatement pstmt = conn.prepareStatement(ADD_BOOK)) {
			pstmt.setString(1, Library.getIsbn());
			pstmt.setString(2, Library.getTitle());
			pstmt.setString(3, Library.getDescr());
			pstmt.setDate(4, (Date) Library.getAdded_to_library());
			// at least one row added
			if(pstmt.executeUpdate() > 0) {
				return true;}
		} catch(SQLException e) {e.printStackTrace();}
		return false;
	}//end addBook
	//allows the librarian to update the info of a book.
	public boolean updateBook(Library Library) {
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_BOOK)) {
			pstmt.setString(1, Library.getIsbn());
			pstmt.setString(2, Library.getTitle());
			pstmt.setString(3, Library.getDescr());
			pstmt.setBoolean(4, Library.isRented());
			pstmt.setDate(5, (Date) Library.getAdded_to_library());
			pstmt.setString(6, Library.getIsbn());
			// at least one row updated
			if (pstmt.executeUpdate() > 0) {
				return true;}
		} catch (SQLException e) {e.printStackTrace();}//end try/catch
		return false;}//end updateBook
	
	
	
}//end of program
