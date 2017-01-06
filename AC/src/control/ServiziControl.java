import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServiziControl
 */
public class ServiziControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServiziControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		try {
			if(action.equalsIgnoreCase("preventivo")){
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String codiceFiscale = request.getParameter("codicefiscale");
				String indirizzo = request.getParameter("indirizzo");
				String email = request.getParameter("email");
				String contattotelefonico = request.getParameter("contattotelefonico");
				
				
			}
			else if (action.equalsIgnoreCase("noleggio")){
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String codiceFiscale = request.getParameter("codicefiscale");
				Date datainizio = request.getParameter("datainizio");
				Date datafine = request.getParameter("datafine");
				String email = request.getParameter("email");
				String contattotelefonico = request.getParameter("contattotelefonico");
				model.Noleggio(noleggio);
			}
			
			else if (action.equalsIgnoreCase("testdrive")){
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String codiceFiscale = request.getParameter("codicefiscale");
				Date datainizio = request.getParameter("datainizio");
				String email = request.getParameter("email");
				String contattotelefonico = request.getParameter("contattotelefonico");
				model.TestDrive(test);
			}
			
			else if (action.equalsIgnoreCase("newsletter")){
				String nome = request.getParameter("nome");
				String cognome = request.getParameter("cognome");
				String email = request.getParameter("email");
				String contattotelefonico = request.getParameter("contattotelefonico");
				model.Newsletter(news);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/auto.html");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	static AutoModel model = new AutoModel();
}
