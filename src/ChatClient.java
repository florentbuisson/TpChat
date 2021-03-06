import java.io.Serializable;
import java.rmi.Naming;


public class ChatClient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID=7384104961807751840L;
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

			ChatClient cli = new ChatClient("Elsa");
			System.out.println("Client cree");

			// On recupere le stub sur l'objet serveur 
			ChatInterface obj = (ChatInterface) Naming.lookup("//localhost:8080/chat1"); 
			System.out.println("Serveur trouve");
			//obj.test1();
			try {
				obj.connect(cli);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// On se connecte au serveur 
			
			System.out.println("Vous etes connecte");

			DisplayThread dt = new DisplayThread("thread1", obj, cli);
			dt.run();
			UserThread ut = new UserThread("thread2", obj, cli);
			ut.run();

		} catch (Exception exc) {
			System.out.println("Connexion ratee");
		} 

	}

}
