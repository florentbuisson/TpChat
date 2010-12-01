import java.rmi.Naming;


public class ChatClient {
	
	protected String nom;
	protected int idDernier;
	
	public ChatClient(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	public int getIdDernier() {
		return idDernier;
	}

	public void setIdDernier(int idDernier) {
		this.idDernier=idDernier;
	}

/** main --------------------------------^---^------------------------------------- **/

	public static void main(String args[]) {
		try { 
			ChatClient cli = new ChatClient("toris");
			// Recuperation du stub sur l'objet serveur 
			ChatInterface obj = (ChatInterface) Naming.lookup("chat1"); 
			// Appel d'une methode sur l'objet distant. 
			obj.connect(cli.getNom());
			
			boolean connecte = true;
			while (connecte) {
				obj.displayMsgs(cli.getIdDernier(), cli.getNom());
				//sleep(30000);
			}
			
		} catch (Exception exc) {} 
		
	}

}
