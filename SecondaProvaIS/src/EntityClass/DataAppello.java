package EntityClass;

import java.util.Date;

public class DataAppello {

	//variabili private
	private String aula;
	private Date data;
	private TipoAppello tipo;
	
	//Costruttori della classe DataAppello
	//con parametri
	public DataAppello(String aulaApp, Date dataApp, TipoAppello tipoApp)
	{
		this.aula = aulaApp;
		this.data = dataApp;
		this.tipo = tipoApp;
	}
	
	public DataAppello()
	{
		this.aula = null;
		this.data = null;
		this.tipo = null;
	}
	
	public DataAppello(Date dataApp, TipoAppello tipoApp)
	{
		this.aula = null;
		this.data = dataApp;
		this.tipo = tipoApp;
	}
	
	//metodi della classe DataAppello	
	public String getAula() {
		return this.aula;
	}

	public Date getData() {
		return this.data;
	}
	
	public TipoAppello getTipo() {
		return this.tipo;
	}
	
	public void setAula (String aulaApp) {
		this.aula = aulaApp;
	}
	
	public void setData(Date dataApp) {
		this.data = dataApp;
	}
	
	public void setTipo(TipoAppello tipoApp) {
		this.tipo = tipoApp;
	}
}
