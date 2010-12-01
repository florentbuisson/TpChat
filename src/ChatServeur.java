import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;


public class ChatServeur extends UnicastRemoteObject implements ChatInterface{

	private int messageCount;
	private Hashtable<Integer, Message> messages = new Hashtable<Integer, Message>();

	public static void main(String args[]) {
		int port;
		String URL;
		try {
		// transformation d’une chaine de caracteres en entier
		Integer I = new Integer(args[0]);
		port = I.intValue();
		} catch (Exception ex) {
		System.out.println(" Please enter: Server <port>");
		return;
		}
		try {
		// Creation du serveur de nom - rmiregistry
		Registry registry = LocateRegistry.createRegistry(port);
		// Creation d’une instance de l’objet serveur
		ChatInterface chat1 = new ChatServeur();
		// Calcul de l’URL du serveur
		URL = "//"+InetAddress.getLocalHost().getHostName()+":"+
		port+"/mon_serveur";
		Naming.rebind(URL,chat1);
		} catch (Exception exc) {}
	}
	
	
	protected ChatServeur() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
