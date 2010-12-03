import java.io.Serializable;


public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private String contenu;
	private ChatClient auteur;
	public Message(String line, ChatClient cli) {
		contenu = line;
		auteur = cli;
	}
	public ChatClient getAuteur() {
		return auteur;
	}
	public void setAuteur(ChatClient auteur) {
		this.auteur = auteur;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
