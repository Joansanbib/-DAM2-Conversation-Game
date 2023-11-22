package moduls;

import java.util.Scanner;

public class anar {
	protected Mapa mapa;
	protected Jugador jugador;
	protected String segHab;
	protected int abaix = 0;
	protected int adalt = 0;
	protected int esq = 0;
	protected int dreta = 0;
	protected int habJugador;
	protected boolean pistaFalsa;
	protected int posVertader;
	protected boolean portoVestit;
	protected int contMoviments;
	protected int deathMoviments;
	protected boolean atacEina;
	protected Company company;
	protected Allien alien;
	private mapaPrint sysoMapa;

	public anar(Mapa mapa, Jugador jugador, Company company) {
		this.mapa = mapa;
		this.jugador = jugador;
		abaix = 0;
		adalt = 0;
		dreta = 0;
		esq = 0;
		habJugador = jugador.GetHabActual();
		posVertader = jugador.GetHabActual();
		pistaFalsa = false;
		portoVestit = false;
		contMoviments = 0;
		deathMoviments = 7;
		this.company = company;
		sysoMapa = new mapaPrint();
	}

	public void anar(Scanner sc) {

		company = jugador.getCompany();
		boolean errorChar = true;
		int segHabInt = -1;
		while (errorChar) {
			anarMenu();
			errorChar = false;
			segHab = sc.next();
			segHab = segHab.toUpperCase();
			if (segHab.equals("SORTIR")) {
				
			} else {
				try {
					segHabInt = Integer.parseInt(segHab);

				} catch (NumberFormatException e) {
					System.out.println("Introdueix sols valors numerics");
					errorChar = true;
				}
			}
		}

		boolean error = false;
		if (abaix == segHabInt && !pistaFalsa) {
			
			comprovEntrar(segHabInt, abaix);

		} else if (adalt == segHabInt && !pistaFalsa) {
			
			comprovEntrar(segHabInt, adalt);

		} else if (dreta == segHabInt && !pistaFalsa) {
			
			comprovEntrar(segHabInt, dreta);

		} else if (esq == segHabInt && !pistaFalsa) {
			
			comprovEntrar(segHabInt, esq);
		} 
		else if(segHab.equals("SORTIR")) {
			
		}
		else {
			System.out.println("Habitació no disponible o pista falsa. Torna-ho a intentar!");
			error = true;
		}
		while (error == true && !pistaFalsa) {
			
			anarMenu();
			
			try {
				String inputHab = sc.next();
				inputHab = inputHab.toUpperCase();
				if (inputHab.equals("SORTIR")) {
					break;
				}
				segHabInt = Integer.parseInt(inputHab);
				
				if (segHabInt == abaix || segHabInt == adalt || segHabInt == dreta || segHabInt == esq
						|| segHabInt == dreta && !pistaFalsa) {
					
					comprovEntrar(segHabInt, segHabInt);
					error = false;

				} else {
					System.out.println("Habitació no disponible. Torna-ho a intentar!");
				}
			}
			catch(Exception e) {
				System.out.println("Introdueix sols valors numerics");
				sc.nextLine();
			}
			

		}

	}

	public void anarMenu() {

		System.out.println("---------------------------------------");
		System.out.println("A quina de les habitacions vols anar?");
		System.out.println();
		habJugador = jugador.GetHabActual();
		for (int i = 0; mapa.GetZones().size() > i; i++) {
			if (mapa.GetZones().get(i).getId() == habJugador) {
				
				printZones(i);
			}

		}
		showItems();
		System.out.println("------------------------------");
		System.out.println("******************************");
	}

	public void showItems() {
		System.out.println();
		System.out.println("****************************");
		System.out.println("---ITEMS DE LA SALA---");
		
		habJugador = jugador.GetHabActual();

		for (int i = 0; mapa.GetZones().size() > i; i++) {
			if (mapa.GetZones().get(i).getId() == habJugador) {
				for (int j = 0; mapa.GetZones().get(i).getItems().size() > j; j++) {
					System.out.println(mapa.GetZones().get(i).getItems().get(j).getNom()); 
				}
			}
		}
	}

	public void sinTarjeta() {

		boolean indFalses = false;
		int rndIndicacions = (int) (Math.random() * 3 + 1);
		if (rndIndicacions == 1)
			indFalses = true;

		if (indFalses) {
			int habRandom = (int) (Math.random() * 10 + 1);
			while (habRandom == jugador.GetHabActual()) {
				habRandom = (int) (Math.random() * 10 + 1);
			}
			jugador.SetHabActual(habRandom);
			pistaFalsa = true;

		} else {
			jugador.SetHabActual(posVertader);
			posVertader = jugador.GetHabActual();
			pistaFalsa = false;
		}

	}

	public void setVestit() {
		portoVestit = portoVestitFun();
	}

	public Boolean portoVestitFun() {
		boolean portoVestit = false;
		int lenght = jugador.getInventari().size();
		portoVestit = false;
		for (int i = 0; lenght > i; i++) {
			if (jugador.getInventari().get(i).getID() == 2) {
				portoVestit = true;
			}
		}
		return portoVestit;
	}

	public int getContMoviments() {
		return contMoviments;
	}

	public void trobarseGonzalin() {
		if (jugador.GetHabActual() == jugador.getAlien().returnPos() && jugador.getAlien().getDistraccio() == false) {
			
			alien = jugador.getAlien();
			
			alien.trobarseJug(jugador);

		}
	}

	public void nouGonzalin() {
		
		alien = jugador.getAlien();
		
		alien.nouGonzalin(jugador, atacEina, deathMoviments);
	}
	
	public void alEntrar(int segHabInt) {
		
		trobarseGonzalin();
		jugador.SetHabActual(segHabInt);
		jugador.SetContMoviments();
		alien = jugador.getAlien();
		alien.setContMoviments(jugador.GetContMoviments());
		alien.moviment();
		nouGonzalin();
		company.moviment();
		posVertader = jugador.GetHabActual();
	}
	
	public void comprovEntrar(int segHabInt, int direccio) {
		setVestit();
		if ((segHabInt == 10 && portoVestit) || segHabInt != 10) {
			
			
			alEntrar(segHabInt);
			
			System.out.println("**Passes a l'habitacio " + mapa.GetZones().get(direccio - 1).GetNom() + "("
					+ mapa.GetZones().get(direccio - 1).getId() + ")**");

			System.out.println();
		} else {
			System.out.println("No portes el vestit, no pots sortir de la nau");
		}
	}
	
	public void printZones(int i) {
		if (mapa.GetZones().get(i).GetAdalt() != 0) {
			adalt = mapa.GetZones().get(i).GetAdalt();
			System.out.println(
					mapa.GetZones().get(i).GetAdalt() + ".-" + " " + mapa.GetZones().get(adalt - 1).GetNom());	
		}
		
		if (mapa.GetZones().get(i).getAbaix() != 0) {
			abaix = mapa.GetZones().get(i).getAbaix();
			System.out.println(
					mapa.GetZones().get(i).getAbaix() + ".-" + " " + mapa.GetZones().get(abaix - 1).GetNom());
		}
		if (mapa.GetZones().get(i).GetDreta() != 0) {
			dreta = mapa.GetZones().get(i).GetDreta();
			System.out.println(
					mapa.GetZones().get(i).GetDreta() + ".-" + " " + mapa.GetZones().get(dreta - 1).GetNom());
		}
		if (mapa.GetZones().get(i).GetEsquerra() != 0) {
			esq = mapa.GetZones().get(i).GetEsquerra();
			System.out.println(
					mapa.GetZones().get(i).GetEsquerra() + ".-" + " " + mapa.GetZones().get(esq - 1).GetNom());
		}
		System.out.println("Escriu 'sortir' per a sortir");
		System.out.println();
		System.out.println("**Estas a l'habitacio " + mapa.GetZones().get(i).GetNom() + "("
				+ mapa.GetZones().get(i).getId() + ")**");

		System.out.println();
	}
	
	public int getPosVert() {
		return posVertader;
	}
}
