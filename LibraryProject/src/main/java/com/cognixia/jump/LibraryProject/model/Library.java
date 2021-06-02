package com.cognixia.jump.LibraryProject.model;

import java.sql.Date;

public class Library 
{

	private int patron_id; //Patron and Book_Checkout
	private String first_name;
	private String last_name;
	private String username; //Patron AND librarian
	private String password; //Patron AND librarian
	private boolean account_frozen;
	
	private int librarian_id;
	
	private int checkout_id;
	private String isbn; //Book_Checkout and book
	private Date checkedout;
	private Date due_date;
	private Date returned;
	
	private String title;
	private String descr;
	private boolean rented;
	private Date added_to_library;
	
	
	//Constructor for Patron
	public Library(int patron_id, String first_name, String last_name, String username, String password, boolean account_frozen) {
		super();
		this.patron_id = patron_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.account_frozen = account_frozen;
	}

	//Constructor for Librarian
	public Library(String username, String password, int librarian_id) {
		super();
		this.username = username;
		this.password = password;
		this.librarian_id = librarian_id;
	}

	//Constructor for Book_Checkout
	public Library(int patron_id, int checkout_id, String isbn, Date checkedout, Date due_date, Date returned) {
		super();
		this.patron_id = patron_id;
		this.checkout_id = checkout_id;
		this.isbn = isbn;
		this.checkedout = checkedout;
		this.due_date = due_date;
		this.returned = returned;
	}

	//Constructor for Book
	public Library(String isbn, String title, String descr, boolean rented, Date added_to_library) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.descr = descr;
		this.rented = rented;
		this.added_to_library = added_to_library;
	}

}
