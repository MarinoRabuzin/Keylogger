package hr.fer.zavrsni.Handlers;

import java.util.ArrayList;
import java.util.List;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 * Razred implementira sucelje NativeKeyListener.
 * 
 * @author Marino Rabuzin
 */
public class NativeKeyboard implements NativeKeyListener{

	/**
	 * Sadrzi listu u kojoj su pohranjene informacije za pritisnute tipke.
	 */
	private List<KeyStorage> keyCache = new ArrayList<>(); 
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent e) {
		keyCache.add(new KeyStorage(e.getKeyCode(), true, System.currentTimeMillis()));
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) {
		keyCache.add(new KeyStorage(e.getKeyCode(), false, System.currentTimeMillis()));
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) {
		
	}

	/**
	 * Metoda prazni listu u kojoj se pohranjuju informacije o tipkama.
	 */
	public void clearCache() {
		keyCache.clear();
	}
	
	/**
	 * Metoda ispisuje poruku za neispravno pohranjivanje podataka.
	 */
	public void onFail() {
		System.out.println("Keystroke failed to be stored.");
	}
	
	/**
	 * Metoda vraca listu s informacijama o pritisnutim tipkama
	 * 
	 * @return lista s informacijama o pritisnutim tipkama
	 */
	public List<KeyStorage> getKeyCache() {
		return keyCache;
	}
}
