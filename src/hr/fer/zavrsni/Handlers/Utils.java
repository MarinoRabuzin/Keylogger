package hr.fer.zavrsni.Handlers;

import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Razred predstavlja obradu prikupljenih podataka te se razred ne moze nasljediti.
 * 
 * @author Marino Rabuzin
 */
public final class Utils {

	/**
	 * Privatni konstruktor razred kako se ne bih mogao instacirati objekt tipa <code>Utils</code>.
	 */
	private Utils() {}
	
	/**
	 * Metoda ispisuje sve prikupljene informacije o pritisnutim tipkama. Koja je tipka pritisnuta i
	 * vrijeme pritiska tipke.
	 * 
	 * @param storage lista s informacijama o pritisnutim tipkama
	 * @return sve prikupljene informacije o pritisnutim tipkama
	 */
	public static String rawPrint(List<KeyStorage> storage) {
		if(storage.isEmpty())
			return "Nothing has been pressed.";
		
		StringBuilder sb = new StringBuilder("Raw strike data:" + System.lineSeparator());
		for(KeyStorage keyStorage : storage)
			sb.append(keyStorage.toString() + System.lineSeparator());
		
		return sb.toString();
 	}
	
	/**
	 * Metoda ispisuje formatirane informacije o pritisnutim tipkama. Format je ispisivanje samo naziva tipke.
	 * 
	 * @param storage lista s informacijama o pritisnutim tipkama
	 * @return formatirane prikupljene informacije o pritistnutim tipkama
	 */
	public static String formattedPrint(List<KeyStorage> storage) {
		if(storage.isEmpty())
			return "Nothing has been pressed.";
		
		StringBuilder sb = new StringBuilder("Logged strike data:" + System.lineSeparator());
		//save which letter is pressed in CAPS mode
		boolean[] caps = new boolean[256];
		for(KeyStorage keyStorage : storage) {
			caps[keyStorage.getKeyCode()] = keyStorage.isPressed();
			String key = processKey(keyStorage.getKeyCode(), caps[KeyEvent.VK_SHIFT]);
			
			if(keyStorage.isPressed()) {
				if(caps[KeyEvent.VK_SHIFT])
					sb.append(key.toUpperCase());
				else
					sb.append(key.toLowerCase());
			}
		}
		
		return sb.toString();
	}

	/**
	 * Metoda procesira specijalne znakove na tipkovnici kao sto su !, #, &, itd...
	 * ako predana sifra nije specijalni znak vraca se samo pritisnuto slovo.
	 * 
	 * @param keycode sifra tipke
	 * @param shifted <code>true</code> pritisnut shift, inace <code>false</code>
	 * @return znak na tipkovnici
	 */
	private static String processKey(int keyCode, boolean shifted) {
		String key = KeyEvent.getKeyText(keyCode);
		if(key.length() != 1) {
			if(KeyEvent.getKeyText(keyCode).equalsIgnoreCase("enter"))
				return "\n{" + KeyEvent.getKeyText(keyCode) + "}";
				
			return "{" + KeyEvent.getKeyText(keyCode) + "}";
		}
		
		if(keyCode == KeyEvent.VK_SHIFT)
			return "";
		
		if(keyCode == KeyEvent.VK_SPACE)
			return " ";
		
		if(keyCode == KeyEvent.VK_1 && shifted)
			return "!";
		
		if(keyCode == KeyEvent.VK_3 && shifted)
			return "#";
		
		if(keyCode == KeyEvent.VK_4 && shifted)
			return "$";
		
		if(keyCode == KeyEvent.VK_5 && shifted)
			return "%";
		
		if(keyCode == KeyEvent.VK_6 && shifted)
			return "&";
		
		if(keyCode == KeyEvent.VK_8 && shifted)
			return "(";
		
		if(keyCode == KeyEvent.VK_9 && shifted)
			return ")";
		
		if(keyCode == KeyEvent.VK_0 && shifted)
			return "=";
		
		if(keyCode == KeyEvent.VK_DEAD_ACUTE && shifted)
			return "_";
		
		if(keyCode == KeyEvent.VK_DEAD_ACUTE && !shifted)
			return "-";
		
		if(keyCode == KeyEvent.VK_PERIOD && shifted)
			return ":";
		
		if(keyCode == KeyEvent.VK_PERIOD && !shifted)
			return ".";
		
		if(keyCode == KeyEvent.VK_COMMA && shifted)
			return ";";
		
		if(keyCode == KeyEvent.VK_COMMA && !shifted)
			return ",";

		return key;
	}
}
