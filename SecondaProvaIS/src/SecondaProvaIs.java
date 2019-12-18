import static org.junit.Assert.assertEquals;

import java.util.Date;

import ControlClass.GestioneAppelli;
import ControlClass.GestioneCorsi;
import EntityClass.*;

public class SecondaProvaIs {

	public static <T,V> void main(String[] args) {

		GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo un corso
		String nome ="ciao";
		int cfu = 3;
		Corso c1 = new Corso (nome,cfu);
		vettoreCorsi.CreaCorso(c1.getCodice(),c1);
		
		
		//creo un appello per il corso
		GestioneAppelli listaApp = new GestioneAppelli();
		System.out.println("creo un appello per il corso c1");

		System.out.println("creo l'appello");
		int id = 1;
		Appello nuovoApp = new Appello(id);
		
		System.out.println("creo la data per il nuovo appello");
		String nuovaAula = "I-5";							  //creo una nuova aula
		Date nuovaData = new Date();						  //creo una nuova data
		TipoAppello nuovoTipo = TipoAppello.AL_CALCOLATORE;   //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello1);
		
		String nome1 = "ciao";
		String cognome = "boh";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome,mat);
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(nuovoApp,uno);
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		
		listaApp.stampaStudentiPrenotati(appello1);
		
	}
}
