package bean;

public class TestDrive
{
	public TestDrive()
	{
		codice = -1;
		datatest = "";
	}
	
	
	public int getCodice() {
		
		return codice;
	}
	
	public void setCodice(int codice)
	{
		this.codice = codice;
	}
	
	public Date getDatatest() 
	{
		return datatest;
	}
	
	public void setDatatest(Date datatest)
	{
		this.datatest = datatest;
	}


	private int codice;
	private Date datatest;
	
}
