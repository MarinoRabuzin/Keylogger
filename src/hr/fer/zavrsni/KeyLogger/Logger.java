package hr.fer.zavrsni.KeyLogger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import hr.fer.zavrsni.Handlers.ManageService;

/**
 * Razred predstavlja glavni program za prikupljanje informacija o pritisnutim tipkama.
 * 
 * @author Marino Rabuzin
 */
public class Logger {

	public static void main(String[] args) {

		ManageService service = new ManageService();

		try {
			System.out.println("Collecting data in progress:");
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			e.printStackTrace();
		}

		GlobalScreen.getInstance().addNativeKeyListener(service.getKeyboard());
	}
}

