package moduls;

import java.util.Scanner;

public class usar {
	private Scanner sc;
	private Jugador jugador;
	private Boolean repeatBucle;
	private Boolean teEina;
	private Boolean teVestit;
	private Boolean repararMotors;

	public usar(Jugador jugador) {
		sc = new Scanner(System.in);
		this.jugador = jugador;
		repeatBucle = true;
		teEina = false;
		teVestit = false;
		repararMotors = false;
	}

	public void showHerramientas() {
		repeatBucle=true;
		while (repeatBucle) {
			try {
				System.out.println("--Quin item vols usar?--");
				System.out.println("1.- Eina");
				System.out.println("2.- Engegar motors");
				System.out.println("3.- Sortir");
				System.out.println("--------------------------");

				int opcio = sc.nextInt();
				switch (opcio) {
				case 1:
					if (jugador.GetHabActual() == 10) {
						int lenght = jugador.getInventari().size();
						for (int i = 0; lenght > i; i++) {
							if (jugador.getInventari().get(i).getID() == 3) {
								teEina = true;
							} else if (jugador.getInventari().get(i).getID() == 2) {
								teVestit = true;
							}
						}
						if (teEina && teVestit) {
							System.out.println("Motors reparats");
							repararMotors = true;
							repeatBucle = false;
							jugador.nouGonzalin();
						} else {
							System.out.println("No s'han pogut reparar els motors");
							System.out.println("------------------------------------");
						}
					} else {
						System.out.println("No et trobes a la sala propulsors");
						System.out.println("-------------------------------------");
						repeatBucle = true;
					}
					break;
				case 2:
					if (jugador.GetHabActual() == 8) {
						if (repararMotors) {
							jugador.nouGonzalin();
							System.out.println("***********************************");
							System.out.println("HAS CONSEGUIT REPARAR ELS MOTORS!!");
							System.out.println("------Guanyes la partida!!------");
							System.out.println("***********************************");
							
							jugador.getJoc().setBucle();
							jugador.getJoc().iniciarJoc();
							
						} else {
							System.out.println("No has reparat encara els motors");
							System.out.println("-----------------------------------");
						}
					} else {
						System.out.println("No et trobes a la sala de commandament");
						System.out.println("-----------------------------------------");

					}
					break;
				case 3:
					repeatBucle = false;
					break;
				default:
					System.out.println("Opcio no disponible");
					repeatBucle = true;
				}
			} catch (Exception e) {
				System.out.println("Introdueix sols valors numerics");
				sc.nextLine();
				repeatBucle = true;
			}

		}
	}

	public boolean returnReparat() {
		return repararMotors;
	}

}
