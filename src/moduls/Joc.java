package moduls;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Joc {
	private static Joc instance = null;
	private static boolean buclePartida;
	private Mapa mapa;
	private Jugador jugador;
	private Company company;
	private Allien Gonzalin;
	private generarItems itemsGenerar;

	public Joc() {

		buclePartida = true;
		mapa = new Mapa(this);
		Gonzalin = new Allien(mapa);
		jugador = new Jugador(1, this);
		company = new Company(mapa, jugador, this);
		jugador.setCompany(company);
		itemsGenerar = new generarItems(mapa, company);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Joc joc = Joc.getInstance();
		joc.iniciarJoc();

	}
	public void iniciarJoc() {
		Scanner sc = new Scanner(System.in);
		String msBenvinguda = msBenvinguda();
		System.out.println(msBenvinguda);

		if (!buclePartida) {
			menuFinal(sc);
		}
		while (buclePartida) {
			jugador.menu();
		}

	}

	public static Joc getInstance() {
		if (instance == null) {
			instance = new Joc();
		}
		return instance;
	}

	public void menuFinal(Scanner sc) {
		System.out.println("***S'HA ACABAT EL JOC!!***");
		System.out.println("-------Que vols fer?-------");
		System.out.println("1.- Reiniciar joc");
		System.out.println("2.- Sortir del programa");
		System.out.println("----------------------------");
		System.out.println("***************************");
		try {
			int opcio = sc.nextInt();
			if (opcio == 1) {
				Joc.instance = null; 
				Joc joc = Joc.getInstance(); 
				joc.iniciarJoc();
				buclePartida = true;
			} else if (opcio == 2) {
				System.exit(0);
			} else {
				System.out.println("Opció no disponible. Torna-ho a intentar");
			}
		} catch (Exception e) {
			System.out.println("Introdueix sols valors numerics");
		}

	}

	public String msBenvinguda() {
		return ("\n" + "--Benvingut jugador/a a la nau PiaXXII!!--\n "
				+ "Acabem de xocar contra un petit aeròlit i es requereix la vostra intervenció per a reparar els propulsors."
				+ "\n La teva missió és clara; posa't el vestit espacial, agafa l'eina del taller i ves a reparar els propulsors.\n"
				+ " COMPTE! Ronda un àlien (mortal) per la nau\n" + "--Molta sort!!--" + "\n" + "\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣶⣾⣿⡉⢤⣍⡓⢶⣶⣦⣤⣉⠒⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣷⡀⠙⣿⣷⣌⠻⣿⣿⣿⣶⣌⢳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠈⢿⣿⡆⠹⣿⣿⣿⣿⣷⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠹⣿⡄⢻⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣷⣽⣷⢸⣿⡿⣿⡿⠿⠿⣆⠀⠀⠀⠀⠀⠀⠀\r\n" + "⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠐⠾⢭⣭⡼⠟⠃⣤⡆⠘⢟⢺⣦⡀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢛⣥⣶⠾⠿⠛⠳⠶⢬⡁⠀⠀⠘⣃⠤⠤⠤⢍⠻⡄⠀⠀⠀⠀\r\n" + "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⡿⣫⣾⡿⢋⣥⣶⣿⠿⢿⣿⣿⣿⠩⠭⢽⣷⡾⢿⣿⣦⢱⡹⡀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡟⠈⠛⠏⠰⢿⣿⣿⣧⣤⣼⣿⣿⣿⡏⠩⠽⣿⣀⣼⣿⣿⢻⣷⢡⠀⠀⠀\r\n" + "⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⢁⣿⣷⣦⡀⠀⠉⠙⠛⠛⠛⠋⠁⠙⢻⡆⠀⢌⣉⠉⠉⠀⠸⣿⣇⠆⠀⠀\r\n"
				+ "⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⣿⠷⣄⢠⣶⣾⣿⣿⣿⣿⣿⠁⠀⠀⢿⣿⣿⣿⣷⠈⣿⠸⡀⠀\r\n" + "⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⠀⣌⡛⠿⣿⣿⠀⠈⢧⢿⣿⡿⠟⠋⠉⣠⣤⣤⣤⣄⠙⢿⣿⠏⣰⣿⡇⢇⠀\r\n"
				+ "⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⣶⣤⣙⠣⢀⠈⠘⠏⠀⠀⢀⣴⢹⡏⢻⡏⣿⣷⣄⠉⢸⣿⣿⣷⠸⡄\r\n" + "⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⠁⣾⣟⣛⠛⠛⠻⠿⠶⠬⠔⠀⣠⡶⠋⠿⠈⠷⠸⠇⠻⠏⠻⠆⣀⢿⣿⣿⡄⢇\r\n"
				+ "⠀⢰⣿⣿⣿⣿⠿⠿⠛⠋⣰⣿⣿⣿⣿⠿⠿⠿⠒⠒⠂⠀⢨⡤⢶⣶⣶⣶⣶⣶⣶⣶⣶⠆⠃⣀⣿⣿⡇⣸\r\n" + "⢀⣿⣿⠿⠋⣡⣤⣶⣾⣿⣿⣿⡟⠁⠀⣠⣤⣴⣶⣶⣾⣿⣿⣷⡈⢿⣿⣿⣿⣿⠿⠛⣡⣴⣿⣿⣿⣿⠟⠁\r\n"
				+ "⣼⠋⢁⣴⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣎⠻⠟⠋⣠⣴⣿⣿⣿⣿⠿⠋⠁⠀⠀\r\n" + "⢿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣴⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣠⣾⣿⠿⠿⠟⠋⠁⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠉⠛⠛⠿⠿⠿⢿⣿⣿⣿⣵⣾⣿⣧⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀");
	}
	
	public Mapa getMapa() {
		return this.mapa;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public Allien getAlien() {
		return this.Gonzalin;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setBucle() {
		buclePartida = false;
	}

}
