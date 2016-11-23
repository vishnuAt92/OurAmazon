package model;

public class ItemBean
{
	private String number, name; 
	private double price;
	private int catid;
	
	
	public ItemBean(String number, String name, double price, int catid)
	{
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.catid = catid;
	}
	
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getCatid()
	{
		return catid;
	}
	public void setCatid(int catid)
	{
		this.catid = catid;
	}
	@Override
	public String toString()
	{
		return "ItemBean [number=" + number + ", name=" + name + ", price=" + price + ", catid=" + catid + "]";
	}
}
