package richwiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.google.gson.Gson;

/**
 * Servlet implementation class PageServlet
 */
public class PageServlet /*extends HttpServlet*/ implements HttpRequestHandler {
	private static final long serialVersionUID = 1L;
    private PageDao pageDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
		// TODO Auto-generated method stub        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Page p = pageDao.loadPage(request.getPathInfo().substring(1));
		Gson gson = new Gson();
		String json = gson.toJson(p);
		response.setContentType("application/json");  // let the browser know it's getting json back
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.flush(); // might not to do this
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader r = request.getReader();		
		Gson gson = new Gson();
		Page p = gson.fromJson(r,Page.class);
		pageDao.savePage(p);
		
		//-In the doPost method, read the input as JSON, convert it to a Page object using the GSON library, then write it to your PageDao by calling savePage().
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("POST".equals(request.getMethod()))
		{
			doPost(request, response);
		}
		else doGet(request, response);
	}

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}

}