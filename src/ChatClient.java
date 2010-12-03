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
			
			// On recupere le stub sur l'objet serveur 
			ChatInterface obj = (ChatInterface) Naming.lookup("chat1"); 
			
			// On se connecte au serveur 
			obj.connect(cli);
			
			DisplayThread dt = new DisplayThread("thread1", obj, cli);
			dt.run();
			
		} catch (Exception exc) {} 
		
	}

}
