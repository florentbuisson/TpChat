import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;


public class ChatServeur extends UnicastRemoteObject implements ChatInterface{

	
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
		Registry registry = LocateRegistry.createRegistry(port);
		// Creation d'une instance de l’objet serveur
		ChatInterface chat1 = new ChatServeur();
		// Calcul de l'URL du serveur
		URL = "//"+InetAddress.getLocalHost().getHostName()+":"+
		port+"/mon_serveur";
		Naming.rebind(URL,chat1);
		System.out.println("ChatServeur" + " bound in registry");
		} catch (Exception exc) {}
	}
	
	// Implementation du constructeur
	public ChatServeur() throws RemoteException {
		super();
		
	}
	// Implementation de la methode distante
	public void sendMessage(Message msg) throws java.rmi.RemoteException {
		messages.put(messageCount,msg);
		messageCount++;
	}
	// Connection d'un client au serveur
	public void connect(ChatClient client) throws RemoteException {
		if(!connectes.add(client)){
			RemoteException ex = new RemoteException("Impossible de supprimer le client" + client.getNom());
			throw ex;
		}
	}
	// Deconnection client
	public void bye(ChatClient client) throws RemoteException {
		if(!connectes.remove(client)){
			RemoteException ex = new RemoteException("Impossible de supprimer le client" + client.getNom());
			throw ex;
		}
	}
	// Who let the dogs out?
	public void who() throws RemoteException {
		
		
	}
	// Dites "splayMsgs"
	public void displayMsgs(int idDernier, String nom) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}
