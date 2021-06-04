package com.cognixia.jump.LibraryProject.LibraryServlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.LibraryProject.LibraryDAO.LibraryDAO;
import com.cognixia.jump.LibraryProject.connection.ConnectionManager;

import com.cognixia.jump.LibraryProject.model.Library;

@WebServlet("/")
public class LibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LibraryDAO libraryDAO;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		libraryDAO = new LibraryDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action  = request.getServletPath();
		
		switch(action) {
		case "/listBooks":
			listBooks(request, response);
			break;
		case "/insert":
			try {
				addNewBook(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			editBookInfo(request, response);
			break;
		case "/bookCheckout":
			bookCheckout(request, response);
			break;
		case "/checkedOut":
			checkedOutBooks(request, response);
			break;
		case "/login":
			login(request, response);
			break;
		case "/returnBooks":
			returnBooks(request, response);
			break;
		case "/listUsers":
			listUsers(request, response);
			break;
		case "/addUser":
			addNewUser(request, response);
			break;
		case "/editUserInfo":
			editUserInfo(request, response);
			break;
		case "/editLibrarianInfo":
			editLibrarianInfo(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	//Books
	private void listBooks(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Library> allBooks = libraryDAO.getAllBooks();
		System.out.println("called, allBooks = " + allBooks);
		request.setAttribute("allBooks", allBooks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("patron.jsp");
		dispatcher.forward(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void checkedOutBooks(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Library> checkedOutBooks = libraryDAO.getCheckOutBooks();
		System.out.println("called, checkedOutBooks = " + checkedOutBooks);
		request.setAttribute("checkedOutBooks", checkedOutBooks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("patron.jsp");

		dispatcher.forward(request, response);
	}

	private void addNewBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String descr = request.getParameter("descr");
		boolean rented = Boolean.parseBoolean(request.getParameter("rented")) ;
		Date added_to_library = Date.valueOf(request.getParameter("added_to_library"));
		Library book = new Library(isbn, title, descr, rented, added_to_library);
			
		libraryDAO.addBook(book);

		response.sendRedirect("listBooks");		
	}
	
  
	private void editBookInfo (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String descr = request.getParameter("descr");
		boolean rented = Boolean.parseBoolean(request.getParameter("rented")) ;
		//Date added_to_library = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("added_to_library"));
		Date added_to_library = Date.valueOf(request.getParameter("added_to_library"));
		Library book = new Library(isbn, title, descr, rented, added_to_library);
		libraryDAO.updateBook(book);
		response.sendRedirect("listBooks");
	}

	private void bookCheckout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");

		libraryDAO.bookCheckout(isbn);

		response.sendRedirect("listBooks");
	}
	
	private void returnBooks(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		Date retuned = Date.valueOf(request.getParameter("retuned"));
		// need to fix date problem libraryDAO.checkInBook(isbn, retuned);
		response.sendRedirect("listBooks");
	}
	
	
	//User & Librarian
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Library> allUsers = libraryDAO.getAllPatrons();
		System.out.println("called, allUsers = " + allUsers);
		request.setAttribute("allUsers", allUsers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("librarian.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addNewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Library user = new Library(firstName, lastName, username, password);
			
		libraryDAO.addUser(user);
		response.sendRedirect("listBooks");		
	}
	
	private void editUserInfo (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Library user = new Library(firstName, lastName, username, password);
		libraryDAO.patronLoginUpdate(user);
		response.sendRedirect("listBooks");
	}
  
  private void editLibrarianInfo (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int librarianId = Integer.parseInt(request.getParameter("librarian_id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Library librarian = new Library(username, password);
		libraryDAO.librarianLoginUpdate(librarian);
		response.sendRedirect("listUsers");
	}
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			ConnectionManager.getConnection().close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}


}
