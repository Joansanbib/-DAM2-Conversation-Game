package moduls;

import java.util.ArrayList;

public class Mapa {

	
	private Zona zona;
	private ArrayList<Zona> zones;

	public Mapa(Joc joc) {
		
		zones = new ArrayList<Zona>();
		creacioZones();
		
		
	}
	
	public void creacioZones() {
		
	zona = new Zona();
	zona.SetNom("Dormitori");
	zona.SetDescripcio("");
	zona.setId(1);
	zona.setAbaix(0);
	zona.SetDreta(0);
	zona.SetAdalt(2);
	zona.SetEsquerra(6);
	zones.add(zona);
	//----------------------------------------
	zona = new Zona();
	zona.SetNom("Banys");
	zona.SetDescripcio("");
	zona.setId(2);
	zona.setAbaix(1);
	zona.SetDreta(0);
	zona.SetAdalt(0);
	zona.SetEsquerra(3);
	zones.add(zona);
	//-----------------------------------------
	zona = new Zona();
	zona.SetNom("Oficines");
	zona.SetDescripcio("");
	zona.setId(3);
	zona.setAbaix(8);
	zona.SetDreta(2);
	zona.SetAdalt(7);
	zona.SetEsquerra(4);
	zones.add(zona);
	//-----------------------------------------
	zona = new Zona();
	zona.SetNom("Vestuari");
	zona.SetDescripcio("");
	zona.setId(4);
	zona.setAbaix(5);
	zona.SetDreta(3);
	zona.SetAdalt(0);
	zona.SetEsquerra(0);
	zones.add(zona);
	//-----------------------------------------
	zona = new Zona();
	zona.SetNom("Cuina");
	zona.SetDescripcio("");
	zona.setId(5);
	zona.setAbaix(0);
	zona.SetDreta(6);
	zona.SetAdalt(4);
	zona.SetEsquerra(0);
	zones.add(zona);
	//-----------------------------------------
	zona = new Zona();
	zona.SetNom("Menjador");
	zona.SetDescripcio("");
	zona.setId(6);
	zona.setAbaix(9);
	zona.SetDreta(1);
	zona.SetAdalt(0);
	zona.SetEsquerra(5);
	zones.add(zona);
	//-----------------------------------------
	zona = new Zona();
	zona.SetNom("Tallers");
	zona.SetDescripcio("");
	zona.setId(7);
	zona.setAbaix(3);
	zona.SetDreta(0);
	zona.SetAdalt(0);
	zona.SetEsquerra(0);
	zones.add(zona);
	//-----------------------------------------
	zona = new Zona();
	zona.SetNom("Comandament");
	zona.SetDescripcio("");
	zona.setId(8);
	zona.setAbaix(0);
	zona.SetDreta(0);
	zona.SetAdalt(3);
	zona.SetEsquerra(0);
	zones.add(zona);
	//-----------------------------------------
	zona = new Zona();
	zona.SetNom("Sala Sortida exterior");
	zona.SetDescripcio("");
	zona.setId(9);
	zona.setAbaix(10);
	zona.SetDreta(0);
	zona.SetAdalt(6);
	zona.SetEsquerra(0);
	zones.add(zona);
	//-----------------------------------------
	zona = new Zona();
	zona.SetNom("Propulsors");
	zona.SetDescripcio("");
	zona.setId(10);
	zona.setAbaix(0);
	zona.SetDreta(0);
	zona.SetAdalt(9);
	zona.SetEsquerra(0);
	zones.add(zona);
	//-----------------------------------------
	
	}
	

	public ArrayList<Zona> GetZones() {
		return this.zones;
	}

	


}
