import java.rmi.Naming;


public class ChatClient {
	
	public static void main(String args[]) {
		try { 
			// Récupération du stub sur l'objet serveur 
			ChatInterface obj = (ChatInterface) Naming.lookup("//ma_machine/mon_serveur"); 
			// Appel d'une méthode sur l'objet distant. 
			obj.connecter();
		} catch (Exception exc) {
			
		} 
		
	}

}
