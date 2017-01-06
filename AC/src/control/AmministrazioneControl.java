package control;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Auto;
import model.AutoModel;

public class AmministrazioneControl extends HttpServlet
{
	public AmministrazioneControl()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		try
		{
			if (action != null)
			{
				if (action.equalsIgnoreCase("read"))
				{
					int codice = Integer.parseInt(request.getParameter("id"));
					request.removeAttribute("auto");
					request.setAttribute("auto", model.doRetrieveByKey(codice));
				}
				
				else if (action.equalsIgnoreCase("search"))
				{	
					request.removeAttribute("searched");
					Auto bean = model.doSearch(request.getParameter("name"));
					request.setAttribute("searched", bean);
				}
				else if(action.equalsIgnoreCase("write"))
				{
					Auto auto = new Auto();
					auto.setNome(request.getParameter("nome"));
					auto.setOptionalBase(request.getParameter("OptionalBase"));
					auto.setOptionalAggiuntivi(request.getParameter("OptionalAgg"));
					auto.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
					auto.setDescrizione(request.getParameter("Descrizione"));
					auto.setImmagine(request.getParameter("immagine"));
					model.doSave(auto);
				}
				else if(action.equalsIgnoreCase("update")){
					Auto auto = new Auto();
					auto.setNome(request.getParameter("nome"));
					auto.setOptionalBase(request.getParameter("OptionalBase"));
					auto.setOptionalAggiuntivi(request.getParameter("OptionalAgg"));
					auto.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
					auto.setDescrizione(request.getParameter("Descrizione"));
					auto.setImmagine(request.getParameter("immagine"));
					model.update(auto);
				}
				else if(action.equalsIgnoreCase("delete")){
					int id = Integer.parseInt(request.getParameter("id"));
					model.doDelete(id);
				}
			}
		}
		catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/auto.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private static final long serialVersionUID = 1L;
	static AutoModel model = new AutoModel();
}

