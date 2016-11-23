package model;

import javax.naming.NamingException;

public class Category {
	
	private CategoryDAO dao;
	
	private static final long serialVersionUID = 1L;
	public Category() throws NamingException {
		dao = new CategoryDAO();
	}
	public CategoryDAO getMyDAO(){
		return dao;
	}
}
