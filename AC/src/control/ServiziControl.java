package control;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Newsletter;
import bean.Noleggio;
import bean.TestDrive;
import model.AutoModel;

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
//				Preventivo preventivo = new Preventivo();
//				preventivo.setNome(request.getParameter("nome"));
//				preventivo.setCognome(request.getParameter("cognome"));
//				preventivo.setCodiceFiscale(request.getParameter("codicefiscale"));
//				preventivo.setIndirizzo(request.getParameter("indirizzo"));
//				preventivo.setEmail(request.getParameter("email"));
//				preventivo.setContattoTelefonico(request.getParameter("contattotelefonico"));
//				String nome = request.getParameter("nome");
//				String cognome = request.getParameter("cognome");
//				String codiceFiscale = request.getParameter("codicefiscale");
//				String indirizzo = request.getParameter("indirizzo");
//				String email = request.getParameter("email");
//				String contattotelefonico = request.getParameter("contattotelefonico");
				
				
			}
			else if (action.equalsIgnoreCase("noleggio")){
//				Noleggio noleggio = new Noleggio();
//				noleggio.setNome(request.getParameter("nome"));
//				noleggio.setCognome(request.getParameter("cognome"));
//				noleggio.setCodiceFiscale(request.getParameter("codicefiscale"));
//				noleggio.setDataInizio(request.getParameter("datainizio"));
//				noleggio.setDataFine(request.getParameter("datafine"));
//				noleggio.setEmail(request.getParameter("email"));
//				noleggio.setContattoTelefonico(request.getParameter("contattotelefonico"));
//				String nome = request.getParameter("nome");
//				String cognome = request.getParameter("cognome");
//				String codiceFiscale = request.getParameter("codicefiscale");
//				Date datainizio = request.getParameter("datainizio");
//				Date datafine = request.getParameter("datafine");
//				String email = request.getParameter("email");
//				String contattotelefonico = request.getParameter("contattotelefonico");
//				model.doSave(noleggio);
			}
			
			else if (action.equalsIgnoreCase("testdrive")){
				TestDrive test = new TestDrive();
				test.setNome(request.getParameter("nome"));
				test.setCognome(request.getParameter("cognome"));
				test.setCodiceFiscale(request.getParameter("cf"));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			    java.util.Date d = null;
			    
			    try {
					d = sdf.parse(request.getParameter("data"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
			    java.sql.Date data = new java.sql.Date(d.getTime());
				test.setData(data);
				test.setEmail(request.getParameter("email"));
				int cod = Integer.parseInt(request.getParameter("codiceAuto"));
				test.setCodiceAuto(cod);
				
				model.doSave(test);
			}
			
			else if (action.equalsIgnoreCase("newsletter")){
				Newsletter news = new Newsletter();
				news.setNome(request.getParameter("nome"));
				news.setCognome(request.getParameter("cognome"));
				news.setEmail(request.getParameter("email"));
				int cod = Integer.parseInt(request.getParameter("codiceAuto"));
				news.setCodiceAuto(cod);
				model.doSave(news);
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
