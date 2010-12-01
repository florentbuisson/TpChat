import java.rmi.*;

public interface ChatInterface extends Remote {
	
	public void connect(ChatClient client) throws RemoteException;
	
	public void bye(ChatClient nomClient) throws RemoteException;
	
	public void who() throws RemoteException;
	
	public void displayMsgs(int idDernier, String nom) throws RemoteException;
	
	public void send(String msg, String nomCli);

}
