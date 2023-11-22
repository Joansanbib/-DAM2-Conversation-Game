package moduls;
import java.util.Scanner;

public class Allien {

	private boolean distraccio;
	private int spawn;
	private int cont_moviments_Bond;
	private Zona zona;
	private Mapa mapa;
	private Scanner sc;

	public Allien(Mapa mapa) {
		this.spawn = (int) (Math.random() * 7) + 4;
		this.mapa = mapa;
		zona = new Zona();
		zona.setId(spawn);
		setDireccions(spawn);
		cont_moviments_Bond = 0;
		distraccio = false;
		sc = new Scanner(System.in);
	}

	public void moviment() {
		if (cont_moviments_Bond == 2 && !distraccio) {
			int random = (int) (Math.random() * 10) + 1;
			if (random == zona.getAbaix()) {
				zona.setId(random);
				setDireccions(random);
			} else if (random == zona.GetAdalt()) {
				zona.setId(random);
				setDireccions(random);
			} else if (random == zona.GetDreta()) {
				zona.setId(random);
				setDireccions(random);
			} else if (random == zona.GetEsquerra()) {
				zona.setId(random);
				setDireccions(random);
			} else {
				while (random != zona.getAbaix() || random != zona.GetAdalt() || random != zona.GetDreta()
						|| random != zona.GetEsquerra()) {

					random = (int) (Math.random() * 10) + 1;

					if (random == zona.getAbaix() || random == zona.GetAdalt() || random == zona.GetDreta()
							|| random == zona.GetEsquerra()) {

						zona.setId(random);
						setDireccions(random);
						break;
					}
				}

			}
		}
		cont_moviments_Bond = 0;

	}

	public void getPosicio() {

		int lenght = mapa.GetZones().size();

		for (int i = 0; lenght > i; i++) {
			if (mapa.GetZones().get(i).getId() == zona.getId()) {
				System.out.println("Gonzalin es troba a la sala " + mapa.GetZones().get(i).GetNom() + " ("
						+ mapa.GetZones().get(i).getId() + ") ");
			}
		}
	}


	public void setDireccions(int indice) {
		zona.SetAdalt(mapa.GetZones().get(indice - 1).GetAdalt());
		zona.setAbaix(mapa.GetZones().get(indice - 1).getAbaix());
		zona.SetDreta(mapa.GetZones().get(indice - 1).GetDreta());
		zona.SetEsquerra(mapa.GetZones().get(indice - 1).GetEsquerra());
	}
	
	public void trobarseJug(Jugador jugador) {
		
		int lenght = jugador.getInventari().size();
		boolean repeatBucle = true, tensDonut = false, tensEina = false;
		while (repeatBucle) {
			System.out.println("T'has trobat amb Gonzalin!!");
			System.out.println("---Que vols fer al respecte?---");
			System.out.println("1.- Donut");
			System.out.println("2.- Atacar amb eina");
			System.out.println("3.- No tinc res amb que atacar (morir)");
			System.out.println("--------------------------------");

			boolean errorInput = false;
			int opcio = 0;
			
			while (!errorInput) {
				try {
					opcio = sc.nextInt();
					errorInput = true;
				} catch (Exception e) {
					errorInput = false;
					System.out.println("Introdueix sols valors numerics");
					sc.nextLine();
				}
			}
			
			
			switch (opcio) {
			case 1:
				int cont=0; 
				repeatBucle = false;
				for (int i = 0; lenght > i; i++) {
					if (jugador.getInventari().get(i).getID() == 4) {
						setDistraccio();
						cont = i;
						System.out.println("Has usat el donut per a distreure a l'Alien!");
						tensDonut = true;
					}
					
				}
				if (distraccio) {
					jugador.getInventari().remove(cont);
				}
				
				if (!tensDonut) {
					System.out.println("No tens donut, usa l'eina");
					System.out.println("---------------------------");
					repeatBucle = true;
				}

				break;
			case 2:
				repeatBucle = false;
				for (int i = 0; lenght > i; i++) {
					if (jugador.getInventari().get(i).getID() == 3) {
						System.out.println("Has usat l'eina per a atacar a l'Alien!");
						setDistraccio();
						tensEina = true;
						jugador.setAtacEina();
					}
				}
				if (!tensEina) {
					System.out.println("No tens l'eina, no pots atacar a Gonzalin");
					repeatBucle = true;
				}
				tensEina = false;

				break;
			case 3:
				repeatBucle = false;
				jugador.getJoc().setBucle();
				jugador.getJoc().iniciarJoc();
				break;
			default:
				System.out.println("No t'entenc...");
				System.out.println("------------------");
				repeatBucle = true;
			}
		}
	}
	
	public void nouGonzalin(Jugador jugador, boolean atacEina, int deathMoviments) {
		atacEina = jugador.getAtacEina();
		if (atacEina) {
			jugador.setMovimentDeath();
			deathMoviments = jugador.getDeathMoviments();
			System.out.println(
					"Et queden un total de " + deathMoviments + " fins a morir per l'incuvació d'un nou àlien");
		}
		if (deathMoviments == 0) {
			jugador.getJoc().setBucle();
		}
	}
	
	public void setContMoviments(int contMoviments) {
		this.cont_moviments_Bond = contMoviments;
	}

	public void setDistraccio() {
		distraccio = true;
	}

	public boolean getDistraccio() {
		return distraccio;
	}

	public int returnPos() {
		return zona.getId();
	}

}
