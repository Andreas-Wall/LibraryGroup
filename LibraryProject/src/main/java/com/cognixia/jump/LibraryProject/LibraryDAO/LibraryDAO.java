package com.cognixia.jump.LibraryProject.LibraryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.cognixia.jump.LibraryProject.connection.ConnectionManager;
import com.cognixia.jump.LibraryProject.model.Library;
public class LibraryDAO {
	public String patronID, LibrarianID;
	public static final Connection conn = ConnectionManager.getConnection();
	//login sql statements
	private static final String PARTON_LOGIN = "select * from patron where username = ? and password = ?";
	private static final String LIBRARIAN_LOGIN = "select * from lirarian where username = ? and password = ?";
	//used to update patron and librarian login
	private static final String PATRON_LOGIN_UPDATE="update patron set first_name = ?, last_name = ?, username = ?, "
			+ "password = ?, where account_id = ?";
	private static final String LIBRARIAN_LOGIN_UPDATE="update lirarian set username = ?, password = ?, where librarian_id = ?";
	//used by librarian to see what account need to be unfrozen.
	private static final String PATRON_LIST = "select patron_id, first_name, last_name, account_frozen from patron order by account_frozen desc";
	private static final String PATRON_UNFREEZE="update patron set account_frozen = 1 where account_id = ?";
	//used for all dml transactions relating to the books
	private static final String SELECT_BOOKS = "select * from books";
	private static final String SELECT_CHECKOUT_BOOK = "select * from Book_Checkout";
	private static final String CHECKOUT_BOOK = "update book set rented = 1 where isbn = ?";
	private static final String CHECKIN_BOOK = "update book set rented = 0 where isbn = ?";
	private static final String RECORD_CHECKOUT = "insert into Book_Checkout (patron_id, isbn, checkout, due_date) values (?,?,?,?)";
	private static final String ADD_BOOK = "insert into Book (isbn, title, descr, added_to_library) values (?,?,?,?)";
	private static final String UPDATE_BOOK = "update Book set isbn = ?, title = ?, descr = ?, rented = ?, added_to_library = ? where isbn = ?";
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
				allBooks.add(new Library(isbn, title, descr, rented, added_to_library));}//end while
		} catch(SQLException e) {e.printStackTrace();}//end try/catch
		return allBooks;
	}//end getallBooks
	public boolean addBook(Library Library) {
		try(PreparedStatement pstmt = conn.prepareStatement(ADD_BOOK)) {
			pstmt.setString(1, Library.getIsbn());
			pstmt.setString(2, Library.getTitle());
			pstmt.setString(3, Library.getDescr());
			pstmt.setDate(4, Library.getAdded_to_library());
			// at least one row added
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}//end of program
