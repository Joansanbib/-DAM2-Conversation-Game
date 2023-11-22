package moduls;

import java.util.Scanner;

public class deixar {

	private Jugador jugador;
	private Zona zona;
	private Scanner sc;
	private Objecte objecte;

	public deixar(Jugador jugador, Mapa mapa, int habActual) {
		this.jugador = jugador;
		zona = mapa.GetZones().get(habActual - 1);
		sc = new Scanner(System.in);
		objecte = new Objecte();
	}

	public void accion() {
		System.out.println("---QUIN OBJECTE DEIXES?---");
		int lenght = jugador.getInventari().size(), cont = 1;
		for (int i = 0; lenght > i; i++) {
			System.out.println(cont + ".-" + jugador.getInventari().get(i).getNom());
			cont++;
		}
		System.out.println(cont + ".- " + "Escriu 'sortir' per a sortir");

		try {
			int opcio1 = 0;
			String opcio = sc.next();
			opcio = opcio.toUpperCase();
			if (opcio.equals("SORTIR")) {

			} else {
				opcio1 = Integer.parseInt(opcio);

				opcio1 = opcio1 - 1;
				if (jugador.getInventari().get(opcio1).getID() == 2 && jugador.GetHabActual() == 10) {
					System.out.println("No pots deixar el vestit a l'exterior");
				} else {
					objecte.setID(jugador.getInventari().get(opcio1).getID());
					objecte.setNom(jugador.getInventari().get(opcio1).getNom());
					objecte.setDescr(jugador.getInventari().get(opcio1).getDescr());

					zona.setItem(objecte);
					jugador.getInventari().remove(opcio1);
					System.out.println("S'ha deixat l'objecte");
					objecte = new Objecte();
					jugador.nouGonzalin();
				}
			}

		} catch (Exception e) {
			System.out.println("No s'ha pogut deixar l'item");

		}

	}

}
