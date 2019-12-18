package EntityClass;

public class CreazioneAppello {
	
	//variavili membro
	private Appello App;
	private DataAppello data;
	private int codiceCorso;
	
	//costruttori
	public CreazioneAppello ()
	{
		this.App = null;
		this.data = null;
		this.codiceCorso = -1;
	}
	
	public CreazioneAppello (Appello a, DataAppello d, int cod)
	{
		this.App = a;
		this.data = d;
		this.codiceCorso = cod;
	}
	
	public CreazioneAppello (Appello a, DataAppello d)
	{
		this.App = a;
		this.data = d;
		this.codiceCorso = 0;
	}
	
	public CreazioneAppello (Appello a)
	{
		this.App = a;
		this.data = null;
		this.codiceCorso = 0;
	}
	
	
	//metodi della Classe CreazioneAppello
	
	public Appello getAppello() {
		return this.App;
	}

	public void setAppello(Appello id) {
		this.App = id;
	}

	public DataAppello getData() {
		return this.data;
	}

	public void setData(DataAppello d) {
		this.data = d;
	}
	
	public int getCod() {
		return this.codiceCorso;
	}

	public void setCod(int d) {
		this.codiceCorso = d;
	}
}
