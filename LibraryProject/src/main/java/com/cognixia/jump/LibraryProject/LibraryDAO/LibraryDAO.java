package com.cognixia.jump.LibraryProject.LibraryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.LibraryProject.connection.ConnectionManager;

public class LibraryDAO {
	
	public static final Connection conn = ConnectionManager.getConnection();
	
	private static final String PARTON_LOGIN = "select * from patron where username = ? and password = ?";
	private static final String LIBRARIAN_LOGIN = "select * from lirarian where username = ? and password = ?";
	
	

}
