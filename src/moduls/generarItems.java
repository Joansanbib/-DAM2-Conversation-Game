package moduls;

public class generarItems {

	private Objecte objecte;
	private Mapa mapa;
	private int randomLlanterna;
	private Company npc;

	public generarItems(Mapa mapa, Company npc) {
		this.objecte = new Objecte();
		this.mapa = mapa;
		randomLlanterna = (int) (Math.random() * 10 + 1);
		this.npc = npc;
		generarItems();
		
	}

	public void generarItems() {

		objecte.setID(1);
		objecte.setNom("Targeta");
		objecte.setDescr("Targeta personal que obra automàticament les portes de la nau");
		objecte.setItem(objecte);
		mapa.GetZones().get(2).setCalaixItem(objecte);
		mapa.GetZones().get(2).setItem(objecte);
		
		objecte = new Objecte();

		objecte.setID(2);
		objecte.setNom("Vestit");
		objecte.setDescr("Vestit espacial per a sortir fora de la nau");
		objecte.setItem(objecte);
		mapa.GetZones().get(3).setItem(objecte);

		objecte = new Objecte();

		objecte.setID(3);
		objecte.setNom("Eina");
		objecte.setDescr("Eina per a reparar els propulsors averiats");
		objecte.setItem(objecte);
		mapa.GetZones().get(6).setItem(objecte);

		objecte = new Objecte();

		objecte.setID(4);
		objecte.setNom("Donut");
		objecte.setDescr("Menjar deliciós! A part, despista làlien");
		objecte.setItem(objecte);
		mapa.GetZones().get(4).setItem(objecte);

		objecte = new Objecte();

		objecte.setID(5);
		objecte.setNom("Llanterna");
		objecte.setDescr("Perme't il·luminar una sala fosca");
		objecte.setItem(objecte);
		mapa.GetZones().get(randomLlanterna - 1).setItem(objecte);

		objecte = new Objecte();

		objecte.setID(6);
		objecte.setNom("Targeta company");
		objecte.setDescr("Targeta del company que obra automàticament les portes de la nau");
		objecte.setItem(objecte);
		npc.setItems(objecte);

		objecte = new Objecte();

	}
}
