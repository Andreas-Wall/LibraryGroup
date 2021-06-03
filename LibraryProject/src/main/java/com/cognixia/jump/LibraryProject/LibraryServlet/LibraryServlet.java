package com.cognixia.jump.LibraryProject.LibraryServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.LibraryProject.LibraryDAO.LibraryDAO;
import com.cognixia.jump.LibraryProject.connection.ConnectionManager;



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
		case "/list":
			listBooks(request, response);
			break;
		case "/insert":
			addNewBook(request, response);
			break;
		case "/edit":
			editBookInfo(request, response);
			break;
		case "/delete":
			deleteBook(request, response);
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
	

	
	//lists
	private void listBooks(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Book> allBooks = LibraryDAO.getAllBooks();
		System.out.println("called, allBooks = " + allBooks);
		request.setAttribute("allBooks", allBooks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		dispatcher.forward(request, response);
	}
	
	//insert
	private void addNewBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String title = request.getParameter("title");
			int isbn = Integer.parseInt( request.getParameter("isbn") );
			String description = request.getParameter("description");
			
			Library library = new Library(0, title, isbn, description);
			
			libraryDAO.addBook(library);
			
			response.sendRedirect("list");
			
	}
	
	//delete
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		libraryDAO.deleteBook(isbn);
		response.sendRedirect("list");
	}
	
	//edit
	private void editBookInfo (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String descr = request.getParameter("descr");
		boolean rented = Boolean.parseBoolean(request.getParameter("rented")) ;
		Date added_to_library = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("added_to_library"));
		Library book = new Library(isbn, title, descr, rented, added_to_library);
		libraryDAO.updateBook(book);
		response.sendRedirect("list");
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
