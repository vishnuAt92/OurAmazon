package ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CategoryBean;
import model.Category;
import model.CategoryDAO;
import model.Item;
import model.ItemBean;
/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static model.Category categoryModel; 
	public static model.Item itemModel;
	public static List<CategoryBean> cataloglist;
	public static List<ItemBean> itemlist;
    /**
     * @throws ServletException 
     * @see HttpServlet#HttpServlet()
     */
    public Home() throws Exception {
        super();	
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException{
    	super.init();
    	Category category;
        Item item;
		try
		{
			category = new Category();
			item = new Item();
			this.getServletContext().setAttribute("categoryModel", category);
			this.getServletContext().setAttribute("itemModel", item);
			/*cataloglist = category.getMyDAO().getCatalogs();
			itemlist = item.getMyDao().getItems();
			this.getServletContext().setAttribute("itemlist", itemlist);
			this.getServletContext().setAttribute("cataloglist", cataloglist);*/
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			//this.getServletContext().setAttribute("errMsg", e.getMessage());
			throw new ServletException("Init error");
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/" + "Home.jspx").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
