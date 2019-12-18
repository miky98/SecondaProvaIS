package EntityClass;

public class Corso {

	
	private static int Corso_counter = 0;
	private int cod;
	private String nome;
	private int numCFU;
	
	//costruttori della classe Corso
	//senza parameri
	public Corso ()
	{
		this.cod = ++Corso_counter;
		this.nome = "";
		this.numCFU = 0;
	}
	//con parametri
	public Corso(String nome, int CFU)
	{
		this.cod = ++Corso_counter;
		this.nome = new String (nome);
		this.numCFU = CFU;
	}
	
	//metodi della classe Corso
	public int getCodice() {
		return cod;
	}
	
	public String getNome() {
		return new String(nome);
	}

	public int getNumCFU() {
		return numCFU;
	}
	
	public void setCodice(int nuovoCod) {
		cod = nuovoCod;
	}
	
	public void setNome(String nome) {
		nome = new String(nome);
	}
		
	public void setNumCFU(int CFU) {
		numCFU = CFU;
	}

	public String ottieniCorso() {
		return "Codice: " + cod + "Nome: " + nome + "\n" +
				"Numero CFU: " + numCFU + "\n";
	}
}
