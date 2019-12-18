package EntityClass;

public class Studente {

	private String nome;
	private String cognome;
	private int matricola;
	
	//costruttori della classe - senza parametri
	public Studente() {
		matricola = 0;
		nome = "";
		cognome = "";
	}
	//con parametri
	public Studente(String nome, String cognome, int mat) {
		matricola = mat;
		this.nome = new String(nome);
		this.cognome = new String(cognome);
	}
	
	//metodi della classe Studente
	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}
	
	public int getMatricola() {
		return this.matricola;
	}
	
	public void setNome(String nome) {
		nome = new String(nome);
	}
	
	public void setCognome(String cognome) {
		cognome = new String(cognome);
	}
	
	public void setMatricola(int mat) {
		matricola = mat;
	}

	public String ottieniStudente() {
		return "Nome: " + nome + "\n" +
				"Cognome: " + cognome + "\n" +
				"Matricola: " + matricola + "\n";
	}
}
