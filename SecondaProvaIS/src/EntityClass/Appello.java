package EntityClass;

public class Appello {

	//variabili private
	private int Id;
	//costruttori della classe Appello
	//senza parametri
	public Appello(int id)
	{
		this.Id = id;
	}
	
	public Appello()
	{
		this.Id = -1;
	}
	
	//metodi della classe Appello
	public int getId() {
		return Id;
	}
			
	public void setId(int newId) {
		Id = newId;
	}

	public String ottieniAppello() {
		return "Id appello: " + Id + "\n";
	}

}
