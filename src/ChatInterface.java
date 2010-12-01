import java.rmi.RemoteException;

public interface ChatInterface {
	
	public void connect(String nom) throws RemoteException;
	
	public void bye(String nom) throws RemoteException;
	
	public void who() throws RemoteException;
	
	public void displayMsgs(int idDernier, String nom) throws RemoteException;

}
