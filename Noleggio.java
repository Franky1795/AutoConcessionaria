package bean;

import java.sql.Date;
public class Noleggio
{
	public Noleggio()
	{
		setDataInizio(null);
		setDataFine(null);
		setNome("");
		setCognome("");
		setCodiceFiscale("");
		setCodiceAuto(-1);
		setEmail("");
	}
	
	public Date getDataInizio() {
		return datainizio;
	}
	
	public void setDataInizio(Date datainizio) {
		this.datainizio = datainizio;
	}
	
	public Date getDataFine() {
		return datafine;
	}
	
	public void setDataFine(Date datafine) {
		this.datafine = datafine;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public int getCodiceAuto() {
		return codiceAuto;
	}

	public void setCodiceAuto(int codiceAuto) {
		this.codiceAuto = codiceAuto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private Date datainizio;
	private Date datafine;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String email;
	private int codiceAuto;

}
