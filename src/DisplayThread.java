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
		while (true) {
			try {
				serv.displayMsgs(cli.getIdDernier(), cli.getNom());
				sleep(30000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
