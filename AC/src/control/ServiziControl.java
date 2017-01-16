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
import bean.Noleggio;
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
		RequestDispatcher dispatcher = null;
		try {
			if(action.equalsIgnoreCase("preventivo")){
                int prezzo= Integer.parseInt(request.getParameter("prezzoAuto"));
				String nome = request.getParameter("nome");
				request.setAttribute("nome", nome);
			    String cognome = request.getParameter("cognome");
				request.setAttribute("cognome", cognome);
				String codiceFiscale = request.getParameter("cf");
				request.setAttribute("cf", codiceFiscale);
				String email = request.getParameter("email");
				request.setAttribute("email", email);
				String auto = request.getParameter("nomeAuto");
				request.setAttribute("auto", auto);
				int somma=prezzo;
				if(request.getParameterValues("aggiuntivi") != null){
					String[] Accessori = request.getParameterValues("aggiuntivi");
					for(int i = 0; i<Accessori.length;i++) {
						somma+= Integer.parseInt(Accessori[i]);				            	
					}
				}
				request.setAttribute("somma", somma);
				dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
				
				
			}
			else if (action.equalsIgnoreCase("noleggio")){
				Noleggio noleggio = new Noleggio();
				noleggio.setNome(request.getParameter("nome"));
				noleggio.setCognome(request.getParameter("cognome"));
				noleggio.setCodiceFiscale(request.getParameter("cf"));
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date di = null;
				java.util.Date df = null;
				try {
					di = sdf.parse(request.getParameter("dataInizio"));
					df = sdf.parse(request.getParameter("dataFine"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    java.sql.Date dataInizio = new java.sql.Date(di.getTime());
			    java.sql.Date dataFine = new java.sql.Date(df.getTime());
			    noleggio.setDataInizio(dataInizio);
			    noleggio.setDataFine(dataFine);
				noleggio.setEmail(request.getParameter("email"));
				int cod = Integer.parseInt(request.getParameter("codiceAuto"));
				noleggio.setCodiceAuto(cod);
				model.doSave(noleggio);	
				request.setAttribute("ris", true);
				dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
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
				request.setAttribute("ris", true);
				dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
			}
			
			else if (action.equalsIgnoreCase("newsletter")){
				Newsletter news = new Newsletter();
				news.setNome(request.getParameter("nome"));
				news.setCognome(request.getParameter("cognome"));
				news.setEmail(request.getParameter("email"));
				int cod = Integer.parseInt(request.getParameter("codiceAuto"));
				news.setCodiceAuto(cod);
				model.doSave(news);
				request.setAttribute("ris", true);
				dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
			}
			else if(action.equalsIgnoreCase("read")){
				int code = Integer.parseInt(request.getParameter("id"));
				Auto auto = model.doRetrieveByKey(code);
				if(auto == null)
				{
					dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
					request.setAttribute("ris", false);
				}
				else
				{	
					request.setAttribute("auto", auto);
					dispatcher = getServletContext().getRequestDispatcher("/auto.jsp");
				}
			}
			else if(action.equalsIgnoreCase("readall")){
				ArrayList<Auto> auto = model.doRetrieveAll();
				request.removeAttribute("auto");
				request.setAttribute("auto", auto);
				dispatcher = getServletContext().getRequestDispatcher("/elenco.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("ris", false);
			dispatcher = getServletContext().getRequestDispatcher("/risultato.jsp");
		}
		
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	static AutoModel model = new AutoModel();
}
