package hr.fer.zavrsni.Handlers;

/**
 * Razred predstavlja informacije o tipki koja je pritisnuta.
 * 
 * @author Marino Rabuzin
 */
public class KeyStorage {

	/**
	 * Sadrzi sifru tipke.
	 */
	private int keyCode;
	
	/**
	 *  Sadrzi je li tipka pritisnuta ili ne.
	 */
	private boolean pressed;
	
	/**
	 * Sadrzi sistemsko vrijeme kada je pritisnuta tipka. 
	 */
	private long systemTimePressedMillis;
	
	/**
	 * Konstruktor s parametrima.
	 * 
	 * @param keyCode sifra tipke
	 * @param pressed je li tipka pritisnuta ili nije
	 * @param systemTimePressedMillis sistemsko vrijeme pritiska tipke
	 */
	public KeyStorage(int keyCode, boolean pressed, long systemTimePressedMillis) {
		this.keyCode = keyCode;
		this.pressed = pressed;
		this.systemTimePressedMillis = systemTimePressedMillis;
	}

	/**
	 * Metoda vraca vrijednost sifre tipke.
	 * 
	 * @return sifra tipke
	 */
	public int getKeyCode() {
		return keyCode;
	}

	/**
	 * Metoda vraca je li pritisnuta tipka ili ne.
	 * 
	 * @return <code>true</code> ako je pritisnuto, inace <code>false</code>
	 */
	public boolean isPressed() {
		return pressed;
	}

	/**
	 * Metoda vraca sistemsko vrijeme kada je tipka pritisnuta.
	 * 
	 * @return sistemsko vrijeme kada je tipka pritistnuta
	 */
	public long getSystemTimePressedMillis() {
		return systemTimePressedMillis;
	}

	@Override
	public String toString() {
		return "KeyStorage [keyCode=" + keyCode + ", pressed=" + pressed + ", systemTimePressedMillis="
				+ systemTimePressedMillis + "]";
	}
	
}
