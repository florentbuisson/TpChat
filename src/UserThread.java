import java.util.*;

public class UserThread extends DisplayThread {
	
	public UserThread(String s, ChatInterface serv, ChatClient cli) {
		super(s, serv, cli);
	}
	
	public void run() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			String line = sc.nextLine();
		}
	}
	
	public void appliquer(int cas, String line) {
		switch (cas) {
		case 1:
			line = line.substring(5);
			Message msg = new Message(line);
			serv.send(msg, cli);
		}
	}
	
	public int trierLigne(String line) {
		int resTri = 0;
		
		if (line.substring(0, 5).equals("send ")) {
			resTri = 1;
		} else if (line.substring(0, 4).equals("bye ")) {
			resTri = 2;
		}
		
		return resTri;
	}

}
