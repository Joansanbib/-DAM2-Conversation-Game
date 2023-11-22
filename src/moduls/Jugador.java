package moduls;

import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {

	private ArrayList<Objecte> inventari;
	private int contMoviments;
	private int habActual;
	Scanner sc;
	private anar classeAnar;
	private Joc joc;
	private Mapa mapa;
	private agafar Agafar;
	private Boolean tincTargeta;
	public obrir classeObrir;
	private encendre_apagar usEncendreApagar;
	private boolean tincLlanterna;
	private deixar usoDeixar;
	private Allien usoAlien;
	private usar usoUsar;
	private Company company;
	private int deathMoviments;
	private boolean atacEina;
	

	public Jugador(int habActual, Joc joc) {

		inventari = new ArrayList<Objecte>();
		contMoviments = 0;
		this.habActual = habActual;
		sc = new Scanner(System.in);
		this.joc = joc;
		mapa = joc.getMapa();
		tincTargeta = false;
		tincLlanterna = false;
		usEncendreApagar = new encendre_apagar();
		usoAlien = joc.getAlien();
		deathMoviments = 7;
		atacEina = false;
		usoUsar = new usar(this);

	}

	public void menu() {
		menuAccions();
		String descripcio = "";
		String items = "";
		String accio = sc.next();
		accio = accio.toUpperCase();

		if (accio.equals("ANAR")) {
			tincTargeta = checkTargeta();
			if (tincTargeta) {
				System.out.println("Tens targeta, usa 'OBRIR' per obrir automàticament les portes");
			} else {
				classeAnar = new anar(mapa, this, company);
				classeAnar.setVestit();
				classeAnar.sinTarjeta();
				classeAnar.anar(sc);
				classeAnar.showItems();
				System.out.println("------------------------------");
				System.out.println("******************************");
				this.SetHabActual(classeAnar.getPosVert());

			}

		} else if (accio.equals("ENCENDRE")) {
			tincLlanterna = checkLlanterna();
			if (tincLlanterna) {
				usEncendreApagar.encendre();
				System.out.println("Llanterna encesa");
				nouGonzalin();
			} else {
				System.out.println("No tens llanterna");
			}

		}

		else if (accio.equals("USAR")) {
			
			usoUsar.showHerramientas();

		} else if (accio.equals("DEIXAR")) {
			usoDeixar = new deixar(this, mapa, habActual);
			usoDeixar.accion();

		} else if (accio.equals("APAGAR")) {
			tincLlanterna = checkLlanterna();
			if (tincLlanterna) {
				usEncendreApagar.apagar();
				System.out.println("Llanterna apagada");
				nouGonzalin();
			} else {
				System.out.println("No tens llanterna");
			}

		} else if (accio.equals("PARLAR")) {
			company.conversar();
			
			
		} else if (accio.equals("AGAFAR")) {
			Agafar = new agafar(this, mapa, habActual);

		} else if (accio.equals("OBRIR")) {
			classeObrir = new obrir(mapa, this, company);
			tincTargeta = checkTargeta();
			if (tincTargeta) {
				classeObrir.setVestit();
				classeObrir.anar(sc);
				classeObrir.showItems();
				System.out.println("------------------------------");
				System.out.println("******************************");
			} else {
				System.out.println("No pots obrir automàticament, no tens targeta");
			}

		}else if(accio.equals("ALIEN")){
			usoAlien.getPosicio();
		}

		else {

			System.out.println("Ho sento, però no t'entenc...");
		}
	}

	public void menuAccions() {

		System.out.println("-----------------------------------------------------");
		System.out.println("Escriu una de les següents accions per a continuar: ");
		System.out.println();
		System.out.println();
		System.out.print("ANAR  ");
		System.out.print("ENCENDRE  ");
		System.out.print("USAR  ");
		System.out.println();
		System.out.println();
		System.out.print("DEIXAR  ");
		System.out.print("APAGAR  ");
		System.out.print("PARLAR  ");
		System.out.println();
		System.out.println();
		System.out.print("AGAFAR  ");
		System.out.print("OBRIR  ");
		System.out.print("ALIEN  ");
		System.out.println();
		System.out.println();

	}

	public Boolean checkTargeta() {
		Boolean tincTargeta = false;
		for (int i = 0; inventari.size() > i; i++) {
			if (inventari.get(i).getID() == 1 || inventari.get(i).getID() == 6) {
				tincTargeta = true;
			}

		}
		return tincTargeta;
	}

	public Boolean checkLlanterna() {
		Boolean tincLlanterna = false;
		for (int i = 0; inventari.size() > i; i++) {
			if (inventari.get(i).getID() == 5) {
				tincLlanterna = true;
			}

		}
		return tincLlanterna;
	}
	
	public void nouGonzalin() {
		if (atacEina) {
			deathMoviments--;
			System.out.println(
					"Et queden un total de " + deathMoviments + " accions fins a morir per l'incuvació d'un nou àlien");
		}
		if (deathMoviments == 0) {
			this.getJoc().setBucle();
			this.getJoc().iniciarJoc();
		}
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public boolean getEnces() {
		return usEncendreApagar.getEnces();
	}
	
	public boolean getAtacEina() {
		return atacEina;
	}
	
	public Allien getAlien() {
		return usoAlien;
	}
	
	public Joc getJoc() {
		return joc;
	}

	public int GetContMoviments() {
		return this.contMoviments;
	}

	public void SetContMoviments() {
		if (contMoviments==2) contMoviments=0;
		this.contMoviments++;
	}

	public int GetHabActual() {
		return this.habActual;
	}

	public void SetHabActual(int value) {
		this.habActual = value;
	}

	public void setInventari(Objecte objecte) {
		inventari.add(objecte);
	}

	public ArrayList<Objecte> getInventari() {
		return this.inventari;
	}
	
	public void setAtacEina() {
		atacEina = true;
	}
	public void setMovimentDeath() {
		deathMoviments--;
	}
	public int getDeathMoviments() {
		return deathMoviments;
	}
	
	
	public Company getCompany() {
		return company;
	}

}
