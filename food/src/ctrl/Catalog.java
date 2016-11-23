package ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.CategoryBean;
import model.CategoryDAO;
import model.ItemBean;

/*
 * TODO: deal with Dynamic database;
 * */
@WebServlet("/Catalog")
public class Catalog extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	int meatId, cheeseId, icecreamId, cerealId;
	String meatName, meatDescription, cheeseName, cheeseDescription, icecreamName, icecreamDescription, cerealName,
			cerealDescription;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Catalog()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//List<CategoryBean> list = (List<CategoryBean>) request.getServletContext().getAttribute("cataloglist");
		Category categoryModle = (Category) request.getServletContext().getAttribute("categoryModel");
		List<CategoryBean> list;
		try
		{
			list = (List<CategoryBean>) categoryModle.getMyDAO().getCatalogs();
			System.out.println("list is " + list.toString());
			//System.out.println("item list is" + Home.itemlist.toString());
			extractInfo(list);
			setAttributes(request);
			// TODO ---- Doesn't work
			request.getServletContext().getRequestDispatcher("/CatalogUI.jspx").forward(request, response);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setAttributes(HttpServletRequest request)
	{
		request.setAttribute("meatId", meatId);
		request.setAttribute("meatName", meatName);
		request.setAttribute("meatDescription", meatDescription);

		request.setAttribute("cheeseId", cheeseId);
		request.setAttribute("cheeseName", cheeseName);
		request.setAttribute("cheeseDescription", cheeseDescription);

		request.setAttribute("icecreamId", icecreamId);
		request.setAttribute("icecreamName", icecreamName);
		request.setAttribute("icecreamDescription", icecreamDescription);

		request.setAttribute("cerealId", cerealId);
		request.setAttribute("cerealName", cerealName);
		request.setAttribute("cerealDescription", cerealDescription);

	}

	private void extractInfo(List<CategoryBean> list)
	{
		for (int i = 0, n = list.size(); i < n; i++)
		{
			CategoryBean bean = list.get(i);
			if (bean.getName().equals("Meat"))
			{
				meatId = bean.getID();
				meatName = bean.getName();
				meatDescription = bean.getDescription();
			} else if (bean.getName().equals("Cheese"))
			{
				cheeseId = bean.getID();
				cheeseName = bean.getName();
				cheeseDescription = bean.getDescription();
			} else if (bean.getName().equals("Ice Cream"))
			{
				icecreamId = bean.getID();
				icecreamName = bean.getName();
				icecreamDescription = bean.getDescription();
			} else if (bean.getName().equals("Cereal"))
			{
				cerealId = bean.getID();
				cerealName = bean.getName();
				cerealDescription = bean.getDescription();
			} else
			{
				/* TODO */
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//doGet(request, response);
/*		List<ItemBean> item = Home.itemlist;
		
		System.out.println("4 buttons are " + request.getParameter("meatButton") + " " + request.getParameter("icecreamButton") );
*/
	}
}
