package bean;

public class Auto
{
	public Auto()
	{
		codice = -1;
		nome = "";
		colore = "";
		optional_base = "";
		optional_agg= "";
		setImmagine("");
		setPrezzo(-1);
	}
	
	public String getOptional_base() {
		return optional_base;
	}

	public void setOptional_base(String optional_base) {
		this.optional_base = optional_base;
	}

	public String getOptional_agg() {
		return optional_agg;
	}

	public void setOptional_agg(String optional_agg) {
		this.optional_agg = optional_agg;
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
	
	
	public String getColore()
	{
		return colore;
	}
	
	public void setColore(String colore)
	{
		this.colore = colore;
	}
	
	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}


	private int codice;
	private String nome;
	private String colore;
	private String immagine;
	private int prezzo;
	private String optional_base;
	private String optional_agg;
	
}
