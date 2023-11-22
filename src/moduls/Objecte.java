package moduls;

import java.util.ArrayList;

public class Objecte {

	private int ID;
	private String descripcio;
	private String nom;
	private ArrayList<Objecte> itemsTotals;

	public Objecte() {

		itemsTotals = new ArrayList<Objecte>();
	}


	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getDescr() {
		return descripcio;
	}

	public void setDescr(String descripcio) {
		this.descripcio = descripcio;
	}

	public String getNom() {
		return nom;

	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ArrayList<Objecte> GetObj() {
		return this.itemsTotals;
	}

	public void setItem(Objecte objecte) {
		itemsTotals.add(objecte);
	}
}
