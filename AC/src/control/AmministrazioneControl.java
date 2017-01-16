package control;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Accessorio;
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
		RequestDispatcher dispatcher = null;
		try
		{
			if (action != null)
			{
				
				if(action.equalsIgnoreCase("write"))
				{
					Auto auto = new Auto();
					auto.setNome(request.getParameter("nomeAuto"));
					auto.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
					auto.setDescrizione(request.getParameter("descrizione"));
					auto.setImmagine(request.getParameter("immagine"));
					int i = Integer.parseInt(request.getParameter("numAccessori"));
					Accessorio acc;
					
					for(int j = 0; j < i; j++)
					{
						int value = Integer.parseInt(request.getParameter("acc"+j));
						
						if(value != 0)
						{
							acc = new Accessorio();
							acc.setId(j+1);
						
							if(value == 1)
								acc.setBase(true);
							else if(value == 2)
								acc.setBase(false);
							
							auto.addAccessorio(acc);
						}
					}
					
					model.doSave(auto);
					
					request.setAttribute("ris", true);
					dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
				}
				else if(action.equalsIgnoreCase("delete")){
					int id = Integer.parseInt(request.getParameter("autoCancellare"));
					model.doDelete(id);
					
					request.setAttribute("ris", true);
					dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
				}
				
				else if(action.equals("login")){
					String user = request.getParameter("username");
					String pass = request.getParameter("password");
					if(user.equals("admin") && pass.equals("auto123"))
					{
						HttpSession session = request.getSession();
						session.setAttribute("admin", true);
						ArrayList<Auto> auto = model.doRetrieveAll();
						session.setAttribute("auto", auto);
						ArrayList<Accessorio> accessori = model.doRetrieveAggiuntivi();
						session.setAttribute("accessori", accessori);
						dispatcher = getServletContext().getRequestDispatcher("/amministrazione.jsp");
					}
					else
					{
						request.setAttribute("errore", "err");
						dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
					}
				}
			}
		}
		catch (SQLException e)
		{
			System.out.println("Error:" + e.getMessage());
			request.setAttribute("ris", false);
			dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
		}

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private static final long serialVersionUID = 1L;
	static AutoModel model = new AutoModel();
}

