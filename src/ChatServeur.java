import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;


public class ChatServeur extends UnicastRemoteObject implements ChatInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3711570597258749865L;
	private int messageCount=0;
	private Hashtable<Integer, Message> messages = new Hashtable<Integer, Message>();
	private ArrayList<ChatClient> connectes;

	
	public static void main(String args[]) {
		int port;
		String URL;
		
		try {
			// transformation d'une chaine de caracteres en entier
			Integer I = new Integer(args[0]);
			port = I.intValue();
		} catch (Exception ex) {
			System.out.println(" Please enter: Server <port>");
			return;
		}
		
		try {
			// Creation du serveur de nom - rmiregistry
			System.out.println(port);
			Registry registry = LocateRegistry.createRegistry(port);
			// Creation d'une instance de l'objet serveur
			ChatInterface chat1 = new ChatServeur();
			// Calcul de l'URL du serveur
			URL = "//"+InetAddress.getLocalHost().getHostName()+":"+
			port+"/chat1";
			Naming.rebind(URL,chat1);
			System.out.println("ChatServeur" + " bound in registry");
		} catch (Exception exc) {
			System.out.println("Creation et nommage du serveur rates");
		}
	}
	
	// Implementation du constructeur
	public ChatServeur() throws RemoteException {
		super();
		
	}
	// Implementation de la methode distante
	public void send(Message msg, ChatClient cli) throws java.rmi.RemoteException {
		messages.put(messageCount,msg);
		messageCount++;
	}
	// Connexion d'un client au serveur
	public void connect(ChatClient client) throws RemoteException {
		if(!connectes.add(client)){
			System.out.println("Erreur");
			RemoteException ex = new RemoteException("Impossible d'ajouter le client " + client.getNom());
			throw ex;
		}
	}
	// Deconnexion client
	public void bye(ChatClient client) throws RemoteException {
		if(!connectes.remove(client)){
			RemoteException ex = new RemoteException("Impossible de supprimer le client " + client.getNom());
			throw ex;
		}
	}
	// Who let the dogs out?
	public void who() throws RemoteException {
		for(int i= 0; i < connectes.size(); i++){
			System.out.println("Membre " + connectes.get(i).getNom() + " bound in registry");
		}
	}
	// Dites "splayMsgs"
	public void displayMsgs(ChatClient cli) throws RemoteException {
		for(int i = cli.getIdDernier()+1; i < messageCount; i++){
			cli.showMsg(messages.get(i), i);
		}
	} 
	public boolean isConnected(ChatClient cli) {
		if(connectes.contains(cli)){
			return true;
		}
		return false;
	}
	
	public void test1() throws RemoteException {
		System.out.println("methode non implementee");
	}
}
