package bean;

public class Noleggio
{
	public Noleggio()
	{
		codice = -1;
		datainizio = "";
		datafine = "";
	}
	

	public int getCodice() 
	{
		return codice;
	}
	
	public void setCodice(int codice) 
	{
		this.codice = codice;
	}
	
	public Date getDatainizio() 
	{
		return datainizio;
	}
	
	public void setDatainizio(Date datainizio) 
	{
		this.datainizio = datainizio;
	}
	
	public Date getDatafine() 
	{
		return datafine;
	}
	
	public void setDatafine(Date datafine) 
	{
		this.datafine = datafine;
	}
	
	private int codice;
	private Date datainizio;
	private Date datafine;
	
}
