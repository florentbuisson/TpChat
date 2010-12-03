import java.rmi.RemoteException;
import java.util.*;

public class UserThread extends DisplayThread {
	
	public UserThread(String s, ChatInterface serv, ChatClient cli) {
		super(s, serv, cli);
	}
	
	public void run() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
			int cas = trierLigne(line);
			try {
				appliquer(cas, line);
			} catch (RemoteException rem) {
				
			}
			serv.isConnected(cli);
			
		}
	}
	
	public void appliquer(int cas, String line) throws RemoteException {
		switch (cas) {
		case 1:
			line = line.substring(5);
			Message msg = new Message(line);
			serv.send(msg, cli);
			break;
		case 2:
			serv.bye(cli);
			break;
		case 0:
			System.out.println("Erreur : cette commande n'existe pas.\n" +
					"tapez send pour envoyer un message ou bye pour quitter le serveur de chat.");
		}
	}
	
	public int trierLigne(String line) {
		if (line.substring(0, 5).equals("send ")) {
			return 1;
		} else if (line.substring(0, 4).equals("bye ")) {
			return 2;
		} else {
			return 0;
		}
	}

}
