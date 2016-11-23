package model;

/*
 * List catalog in the Database
 * */
public class CategoryBean
{
	public int ID;
	public String name;
	public String description;

	public CategoryBean(int ID, String name, String description) {
		this.ID = ID;
		this.name = name;
		this.description = description;
	}
	
	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public String toString()
	{
		return "CategoryBean [getID()=" + getID() + ", getName()=" + getName() + ", getDescription()="
				+ getDescription() + "]";
	}
	
	
}
