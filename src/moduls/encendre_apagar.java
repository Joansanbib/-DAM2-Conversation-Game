package moduls;

public class encendre_apagar {
	
	private boolean ences;
	private boolean apagat;
	
	public encendre_apagar() {
		ences = false;
		apagat = true;
	}
	
	public void encendre() {
		ences = true;
		apagat = false;
	}
	public void apagar() {
		ences = false;
		apagat = true;
	}
	
	public boolean getEnces() {
		return ences;
	}
	public boolean getApagat() {
		return apagat;
	}
	
	
}
