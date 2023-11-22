package moduls;

import java.util.Scanner;

public class agafar {

	private Jugador jugador;
	private int habActual;
	private Mapa mapa;
	private Zona zona;
	private Objecte objecte;
	private Boolean teLlanterna;
	private Boolean esEina;
	private Boolean fakeLlanterna;
	private Boolean printLlanterna;
	private Boolean calaixObert;
	Scanner sc;

	public agafar(Jugador jugador, Mapa mapa, int habActual) {
		this.jugador = jugador;
		this.habActual = habActual;
		this.mapa = mapa;
		zona = mapa.GetZones().get(habActual - 1);
		objecte = new Objecte();
		sc = new Scanner(System.in);
		teLlanterna = false;
		esEina = false;
		fakeLlanterna = false;
		printLlanterna = false;
		calaixObert = true;
		accion();
	}

	public void accion() {

		System.out.println("----ITEMS DE LA SALA: ----");
		int lenght = mapa.GetZones().get(habActual - 1).getItems().size();
		int cont = 1, i = 0;

		if (lenght > 0) {

			fakeLlanterna = fakeInfoLlanterna();

			for (i = 0; lenght > i; i++) {
				System.out.println(cont + ".-" + zona.getItems().get(i).getNom());
				if (zona.getItems().get(i).getID() == 5) {
					printLlanterna = true;
				}
				cont++;
			}
			if (fakeLlanterna && !printLlanterna) {
				System.out.println(cont + ".-" + "Llanterna");
				cont++;
			}
			System.out.println(cont + ".- Escriu 'sortir' per sortir");
			System.out.println("---------------------------");
			System.out.println("Escriu el número a agafar: ");

			try {
				String opcio = sc.next();
				int opcio1 = 0;
				opcio = opcio.toUpperCase();
				if (opcio.equals("SORTIR")) {

				} else {
					opcio1 = Integer.parseInt(opcio);

					opcio1 = opcio1 - 1;
					objecte.setID(zona.getItems().get(opcio1).getID());
					if (zona.getItems().get(opcio1).getID() == 3) {
						teLlanterna = ifLlanterna();
						esEina = true;
					}
					if ((esEina && teLlanterna) || (!esEina)) {
						if (jugador.getEnces() == true || !esEina) {

							if (zona.getItems().get(opcio1).getID() == 1) {
								int contCalaix = 0;
								System.out.println("Obra primer un dels següents calaixos per a trobar la targa: ");
								System.out.println("--Calaix 1--");
								System.out.println("--Calaix 2--");
								System.out.println("--Calaix 3--");
								System.out.println("--Calaix 4--");
								System.out.println("--Calaix 5--");
								System.out.println("------------------------------------------------------");
								try {
									contCalaix = sc.nextInt();
									contCalaix = contCalaix - 1;
									if (zona.getCalaixos().get(contCalaix) != null) {
										calaixObert = true;
									} else {
										System.out.println("La targeta no es troba en aquest calaix...");
										calaixObert = false;
									}
								} catch (Exception e) {
									System.out.println("Introdueix sols valors numèrics!!");
								}

							}

							if (calaixObert) {
								setItem(opcio1);
							}

						} else {
							System.out.println("La llanterna està apagada; no pots trobar l'eina");
						}
					} else if (esEina && !teLlanterna) {
						System.out.println("No pots agafar l'eina; al no tenir llanterna no la pots trobar...");
					}
				}

			} catch (Exception e) {
				System.out.println("Item no disponible o pista falsa. Torna-ho a intentar: ");
			}
		}

	}

	public void setItem(int opcio) {
		objecte.setNom(zona.getItems().get(opcio).getNom());
		objecte.setDescr(zona.getItems().get(opcio).getDescr());
		jugador.setInventari(objecte);

		objecte = new Objecte();

		zona.getItems().remove(opcio);
		jugador.nouGonzalin();
		System.out.println("Has agafat l'objecte");
	}

	public boolean ifLlanterna() {
		Boolean teLlanterna = false;
		int lenghtInventari = jugador.getInventari().size();
		if (lenghtInventari > 0) {
			for (int i = 0; lenghtInventari > i; i++) {
				if (jugador.getInventari().get(i).getID() == 5) {
					teLlanterna = true;
				}
			}
		}
		return teLlanterna;
	}

	public Boolean fakeInfoLlanterna() {
		int random = (int) (Math.random() * 2 + 1);
		boolean fakeLlanterna = false;

		if (random == 2) {
			fakeLlanterna = true;
		}
		return fakeLlanterna;
	}
}
