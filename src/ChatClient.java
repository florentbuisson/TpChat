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
	
	public void showMsg(Message msg, int id) {
		System.out.println(msg.getContenu());
		setIdDernier(id);
	}

/** MAIN --------------------------------^---^------------------------------------- **/

	public static void main(String args[]) {
		try { 
			
			ChatClient cli = new ChatClient("toris");
			
			// On recupere le stub sur l'objet serveur 
			ChatInterface obj = (ChatInterface) Naming.lookup("chat1"); 
			
			// On se connecte au serveur 
			obj.connect(cli);
			
			DisplayThread dt = new DisplayThread("thread1", obj, cli);
			dt.run();
			UserThread ut = new UserThread("thread2", obj, cli);
			ut.run();
			
		} catch (Exception exc) {} 
		
	}

}
