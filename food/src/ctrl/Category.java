package ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryBean;
import model.Item;
import model.ItemBean;

/**
 * Servlet implementation class meatCategory
 */
@WebServlet("/Category")
public class Category extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public List<ItemBean> meatlist = new ArrayList<ItemBean>(); 
	public List<ItemBean> cheeselist = new ArrayList<ItemBean>();
	public List<ItemBean> icecreamlist = new ArrayList<ItemBean>();
	public List<ItemBean> cereallist = new ArrayList<ItemBean>();
			
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Category()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//System.out.println("we are in do get");
		//System.out.println("itemlist is " + Home.itemlist.toString());
		request.getServletContext().getRequestDispatcher("/CatalogUI.jspx").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("we are in do category post");
		Item itemModle = (Item)request.getServletContext().getAttribute("itemModel");
		try
		{
			List<ItemBean> list = (List<ItemBean>) itemModle.getMyDao().getItems();
			//System.out.println("itemlist is " + list.toString());
			analyze(list);
			request.setAttribute("meatlist", meatlist);
			request.setAttribute("cheeselist", cheeselist);
			request.setAttribute("icecreamlist", icecreamlist);
			request.setAttribute("cereallist", cereallist);
			if (request.getParameter("meatButton") != null)
			{
				request.setAttribute("target", "meat");
				//System.out.println("meat list is " + meatlist.toString());
			}else if (request.getParameter("cheeseButton") != null)
			{
				request.setAttribute("target", "cheese");
			}else if (request.getParameter("icecreamButton") != null)
			{
				request.setAttribute("target", "icecream");
			}else if(request.getParameter("cerealButton") != null)
			{
				request.setAttribute("target", "cereal");
			}else{
				
			}
			//System.out.println("target is " + request.getAttribute("target"));
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("itemlist is " + list.toString());
		//System.out.println("size is " + Home.itemlist.toString());
		request.getServletContext().getRequestDispatcher("/Category.jspx").forward(request, response);
	}

	private void analyze(List<ItemBean> list)
	{
		//System.out.println("list is " + list.toString());
		int n = list.size();
		//System.out.println("size is " + n);
		for (int i = 0; i < n; i++)
		{
			ItemBean bean = list.get(i);
			int tmp = bean.getCatid();
			if (tmp == 3)
			{ // meat
				//System.out.println("bean is " + bean);
				meatlist.add(bean);
			} else if (tmp == 5)
			{ // icecream
				icecreamlist.add(bean);
			} else if (tmp == 4)
			{ // cheese
				cheeselist.add(bean);
			} else if (tmp == 6)
			{// cereal
				cereallist.add(bean);
			}
		}
	}
}
