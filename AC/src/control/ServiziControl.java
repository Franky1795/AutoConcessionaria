package control;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Auto;
import bean.Newsletter;
import bean.TestDrive;
import model.AutoModel;

public class ServiziControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServiziControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher=null;
		try {
			if(action.equalsIgnoreCase("preventivo")){
                int prezzo= Integer.parseInt(request.getParameter("prezzoAuto"));
				String nome = request.getParameter("nome");
			    String cognome = request.getParameter("cognome");
				String codiceFiscale = request.getParameter("codicefiscale");
				String email = request.getParameter("e-mail");
				String[] Accessori = request.getParameterValues("aggiuntivi");
				int somma=prezzo;
				for(int i = 0; i<Accessori.length;i++) {
					somma+= Integer.parseInt(Accessori[i]);				            	
				}
				request.setAttribute("somma", somma);
				request.setAttribute("cognome", cognome);
				dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
				
				
			}
			else if (action.equalsIgnoreCase("noleggio")){
//				Noleggio noleggio = new Noleggio();
//				noleggio.setNome(request.getParameter("nome"));
//				noleggio.setCognome(request.getParameter("cognome"));
//				noleggio.setCodiceFiscale(request.getParameter("cf"));
//				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
//				noleggio.setDataInizio(datainizio));
//				noleggio.setDataFine(datafine);
//				noleggio.setEmail(request.getParameter("email"));
//				noleggio.setContattoTelefonico(request.getParameter("contattotelefonico"));
//				int cod = Integer.parseInt(request.getParameter("codiceAuto"));
//				noleggio.setCodiceAuto(cod);

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
				dispatcher = getServletContext().getRequestDispatcher("/auto.html");
			}
			
			else if (action.equalsIgnoreCase("newsletter")){
				Newsletter news = new Newsletter();
				news.setNome(request.getParameter("nome"));
				news.setCognome(request.getParameter("cognome"));
				news.setEmail(request.getParameter("email"));
				int cod = Integer.parseInt(request.getParameter("codiceAuto"));
				news.setCodiceAuto(cod);
				model.doSave(news);
				dispatcher = getServletContext().getRequestDispatcher("/auto.html");
			}
			
			else if(action.equalsIgnoreCase("readall")){
				Collection<Auto> auto = model.doRetrieveAll();
				request.removeAttribute("auto");
				request.setAttribute("auto", auto);
				dispatcher = getServletContext().getRequestDispatcher("/elenco.jsp");
			}
			
			else if (action.equalsIgnoreCase("amministrazione")){
				ArrayList<Auto> auto = model.doRetrieveAll();
				request.removeAttribute("auto");
				request.setAttribute("auto", auto);
				dispatcher = getServletContext().getRequestDispatcher("/amministrazione.jsp");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	static AutoModel model = new AutoModel();
}
