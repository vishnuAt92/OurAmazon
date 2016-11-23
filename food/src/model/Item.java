package model;

import javax.naming.NamingException;

public class Item
{
	private ItemDAO dao;
	
	public Item() throws NamingException {
		dao = new ItemDAO();
	}
	public ItemDAO getMyDao(){
		return dao;
	}
	
}
