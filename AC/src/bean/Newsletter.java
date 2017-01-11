package bean;

public class Newsletter
{
	public Newsletter()
	{
		codice = -1;
		nome = "";
		cognome = "";
		email = "";
		codiceAuto = -1;
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
	

	public int getCodiceAuto() {
		return codiceAuto;
	}

	public void setCodiceAuto(int codice_auto) {
		this.codiceAuto = codice_auto;
	}


	private int codice;
	private String nome;
	private String cognome;
	private int codiceAuto;
	private String email;
	
}
