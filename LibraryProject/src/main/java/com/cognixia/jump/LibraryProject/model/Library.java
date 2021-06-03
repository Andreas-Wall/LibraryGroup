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
	
	public int getPatron_id() {
		return patron_id;
	}
	public void setPatron_id(int patron_id) {
		this.patron_id = patron_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAccount_frozen() {
		return account_frozen;
	}
	public void setAccount_frozen(boolean account_frozen) {
		this.account_frozen = account_frozen;
	}
	public int getLibrarian_id() {
		return librarian_id;
	}
	public void setLibrarian_id(int librarian_id) {
		this.librarian_id = librarian_id;
	}
	public int getCheckout_id() {
		return checkout_id;
	}
	public void setCheckout_id(int checkout_id) {
		this.checkout_id = checkout_id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getCheckedout() {
		return checkedout;
	}
	public void setCheckedout(Date checkedout) {
		this.checkedout = checkedout;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getReturned() {
		return returned;
	}
	public void setReturned(Date returned) {
		this.returned = returned;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public boolean isRented() {
		return rented;
	}
	public void setRented(boolean rented) {
		this.rented = rented;
	}
	public Date getAdded_to_library() {
		return added_to_library;
	}
	public void setAdded_to_library(Date added_to_library) {
		this.added_to_library = added_to_library;
	}
}