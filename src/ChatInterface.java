import java.rmi.*;

public interface ChatInterface extends Remote {
	
	public void connect(ChatClient client) throws RemoteException;
	
	public void bye(ChatClient client) throws RemoteException;
	
	public void who() throws RemoteException;
	
	public void displayMsgs(ChatClient cli) throws RemoteException;
	
	public void send(Message msg, ChatClient cli) throws RemoteException ;
	
	public boolean isConnected(ChatClient cli) throws RemoteException ;
	
	public void test() throws RemoteException;
}
