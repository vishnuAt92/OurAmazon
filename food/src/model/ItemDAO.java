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

public class ItemDAO
{
	private DataSource dataSource;
	private String QUERY = "select * from ROUMANI.ITEM";

	public ItemDAO() throws NamingException
	{
		this.dataSource = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/EECS");
	}
	
	public List<ItemBean> getItems() throws SQLException {
		String number, name;
		double price;
		int catid;
		Connection myCon = dataSource.getConnection();
		PreparedStatement stmt = myCon.prepareStatement(QUERY);
		ResultSet rs = stmt.executeQuery();
		List<ItemBean> items = new ArrayList<ItemBean>();
		while (rs.next()) {
			items.add(new ItemBean(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(7)));
		}
		return items;
	}
}
