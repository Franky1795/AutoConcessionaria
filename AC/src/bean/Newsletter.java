package bean;

public class Newsletter
{
	public Newsletter()
	{
		codice = -1;
		nome = "";
		cognome = "";
		email = "";
	}
	
	public int getCodice()
	{
		return codice;
	}
	
	public void setCodice(int codice)
	{
		this.codice = codice;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	private int codice;
	private String nome;
	private String cognome;
	private String email;
	
}
