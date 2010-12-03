import java.rmi.*;

public class DisplayThread extends Thread {

	ChatInterface serv;
	ChatClient cli;

	public DisplayThread(String s, ChatInterface serv, ChatClient cli) {
		super(s);
		this.serv = serv;
		this.cli = cli;
	}

	public void run(){
		boolean conn = true;
		System.out.println("Les messages vont pouvoir être affichés.");
		while (conn) {
			try {
				serv.displayMsgs(cli);
				sleep(30000);
				conn = serv.isConnected(cli);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
