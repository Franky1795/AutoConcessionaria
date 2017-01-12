package bean;

import java.util.ArrayList;

public class Auto
{
	public Auto()
	{
		codice = -1;
		nome = "";
		colore = "";
		setImmagine("");
		setPrezzo(-1);
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
	
	public void addAccessorio(Accessorio acc){
		accessori.add(acc);
	}
	
	public ArrayList<Accessorio> getListaAccessorio(){
		return accessori;
	}


	private int codice;
	private String nome;
	private String colore;
	private String immagine;
	private int prezzo;
	private ArrayList<Accessorio> accessori = new ArrayList<Accessorio>();
	
}
