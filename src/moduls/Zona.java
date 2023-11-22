package moduls;

import java.util.ArrayList;

public class Zona {
	private String nom;
	private String descripcio;
	private int id;
	private int adalt;
	private int abaix;
	private int dreta;
	private int esquerra;
	private int contMoviments;
	private ArrayList<Objecte> items;
	private ArrayList<Objecte> calaix;
	private int randomCalaix;

	public Zona() {
		items = new ArrayList<Objecte>();
		calaix = new ArrayList<Objecte>();
		calaix.add(null);
		calaix.add(null);
		calaix.add(null);
		calaix.add(null);
		calaix.add(null);
		randomCalaix = (int)(Math.random()*5+1);
		randomCalaix = randomCalaix-1;
	}

	public String GetNom() {
		return this.nom;
	}

	public void SetNom(String value) {
		this.nom = value;
	}

	public String GetDescripcio() {
		return this.descripcio;
	}

	public void SetDescripcio(String value) {
		this.descripcio = value;
	}

	public int GetAdalt() {
		return this.adalt;
	}

	public void SetAdalt(int value) {
		this.adalt = value;
	}

	public int GetDreta() {
		return this.dreta;
	}

	public void SetDreta(int value) {
		this.dreta = value;
	}

	public int GetEsquerra() {
		return this.esquerra;
	}

	public void SetEsquerra(int value) {
		this.esquerra = value;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setAbaix(int abaix) {
		this.abaix = abaix;
	}

	public int getAbaix() {
		return abaix;
	}

	public void setCont() {
		contMoviments++;
	}

	public int getCont() {
		return contMoviments;
	}
	public void setItem(Objecte objecte) {
		items.add(objecte);
	}
	public ArrayList<Objecte> getItems() {
		return items;
	}
	
	public void setCalaixItem(Objecte objecte) {
		calaix.set(randomCalaix, objecte);
	}
	public ArrayList<Objecte> getCalaixos() {
		return calaix;
	}
	

}
