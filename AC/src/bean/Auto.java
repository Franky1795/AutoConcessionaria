package bean;

import java.util.ArrayList;

public class Auto
{
	public Auto()
	{
		setCodice(-1);;
		setNome("");
		setImmagine("");
		setPrezzo(-1);
		setDescrizione("");
		accessori = new ArrayList<Accessorio>();
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
	
	public void addAccessorio(Accessorio acc){
		accessori.add(acc);
	}
	
	public ArrayList<Accessorio> getListaAccessorio(){
		return accessori;
	}


	public String getDescrizione() {
		return descrizione;
	}



	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	private int codice;
	private String nome;
	private String immagine;
	private int prezzo;
	private String descrizione;
	private ArrayList<Accessorio> accessori;
	
}
