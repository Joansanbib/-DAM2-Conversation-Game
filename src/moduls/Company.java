package moduls;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {

	private int habActual;
	private boolean targeta;
	private boolean dormint;
	private Allien alien;
	private Mapa mapa;
	private ArrayList<Objecte> items;
	private Jugador jugador;
	private Scanner sc;
	private Zona zona;

	public Company(Mapa mapa, Jugador jugador, Joc joc) {

		habActual = 1;
		targeta = true;
		dormint = true;
		this.mapa = mapa;
		items = new ArrayList<Objecte>();
		this.jugador = jugador;
		sc = new Scanner(System.in);
		zona = new Zona();
		zona.setId(habActual);
		setDireccions(1);
		alien = joc.getAlien();

	}

	public void menjarDonut() {
		if (habActual == 5 && !dormint) {
			int ifMenjar = (int) (Math.random() * 2 + 1);
			if (ifMenjar == 1) {
				int lenght = mapa.GetZones().get(4).getItems().size();
				for (int i = 0; lenght > i; i++) {
					if (mapa.GetZones().get(4).getItems().get(i).getID() == 4) {
						mapa.GetZones().get(4).getItems().remove(i);
					}
				}
			}
		}
	}

	public void despertar() {
		this.dormint = false;
		System.out.println("Has despertat al company");
		jugador.nouGonzalin();
	}

	public void donarTargeta() {
		if (!dormint && targeta) {
			jugador.setInventari(items.get(0));
			items.remove(0);
			jugador.nouGonzalin();
			targeta = false;
			System.out.println("Targeta agafada amb èxit!!");
		} else {
			System.out.println("No pots agafar la targeta; el company està dormint");
		}
	}

	public void conversar() {
		if (jugador.GetHabActual() == this.habActual) {
			System.out.println("***************************************************");
			System.out.println("-----Escriu 'TARGETA' per rebre la targeta---------");
			System.out.println("--Escriu 'DESPERTAR' per a despertar al company----");
			System.out.println("------Escriu 'SORTIR' per a sortir del menú--------");
			System.out.println("***************************************************");

			String opcio = sc.next();
			opcio = opcio.toUpperCase();

			if (opcio.equals("TARGETA")) {
				donarTargeta();
			} else if (opcio.equals("DESPERTAR")) {
				despertar();
			} else {
				System.out.println("No t'entenc...");
			}

		} else {
			System.out.println("No pots parlar amb el company; esteu en hab. diferents");
			System.out.println("o t'estan donant una pista falsa");
		}
	}

	public void moviment() {
		if (!dormint) {
			int random = (int) (Math.random() * 10) + 1;
			if (random == zona.getAbaix()) {
				zona.setId(random);
				setDireccions(random);
				habActual = random;
			} else if (random == zona.GetAdalt()) {
				zona.setId(random);
				setDireccions(random);
				habActual = random;
			} else if (random == zona.GetDreta()) {
				zona.setId(random);
				setDireccions(random);
				habActual = random;
			} else if (random == zona.GetEsquerra()) {
				zona.setId(random);
				setDireccions(random);
				habActual = random;
			} else {
				while (random != zona.getAbaix() || random != zona.GetAdalt() || random != zona.GetDreta()
						|| random != zona.GetEsquerra()) {

					random = (int) (Math.random() * 10) + 1;

					if (random == zona.getAbaix() || random == zona.GetAdalt() || random == zona.GetDreta()
							|| random == zona.GetEsquerra()) {

						zona.setId(random);
						setDireccions(random);
						habActual = random;

						break;
					}
				}

			}
			if (habActual == alien.returnPos() && alien.getDistraccio() == false) {
				
				System.out.println("L'Àlien s'ha trobat amb el company i l'ha matat.");
				System.out.println("Finalitza la partida....");
				jugador.getJoc().setBucle();
				jugador.getJoc().iniciarJoc();

			}

		}
	}

	public void setDireccions(int indice) {
		zona.SetAdalt(mapa.GetZones().get(indice - 1).GetAdalt());
		zona.setAbaix(mapa.GetZones().get(indice - 1).getAbaix());
		zona.SetDreta(mapa.GetZones().get(indice - 1).GetDreta());
		zona.SetEsquerra(mapa.GetZones().get(indice - 1).GetEsquerra());
	}

	public void setItems(Objecte objecte) {
		items.add(objecte);
	}
	
	public void returnPos() {
		int lenght = mapa.GetZones().size();

		for (int i = 0; lenght > i; i++) {
			if (mapa.GetZones().get(i).getId() == zona.getId()) {
				System.out.println("Company es troba a la sala " + mapa.GetZones().get(i).GetNom() + " ("
						+ mapa.GetZones().get(i).getId() + ") ");
			}
		}
	}

}
