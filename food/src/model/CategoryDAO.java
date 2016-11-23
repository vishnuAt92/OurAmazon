package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * Communicating with DBMS
 * */
public class CategoryDAO
{
	private DataSource dataSource;
	private String QUERY = "select * from ROUMANI.CATEGORY";

	public CategoryDAO() throws NamingException
	{
		this.dataSource = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
	}

	/* Getter methods */
	public List<CategoryBean> getCatalogs() throws SQLException
	{
		int tmpID;
		String tmpName;
		String tmpDescription;
		Connection myCon = dataSource.getConnection();
		PreparedStatement stmt = myCon.prepareStatement(QUERY);
		ResultSet rs = stmt.executeQuery();
		List<CategoryBean> catalogs = new ArrayList<CategoryBean>();
		while (rs.next()) {
			//System.out.println("category is " + rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			catalogs.add(new CategoryBean(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return catalogs;
	}
}
