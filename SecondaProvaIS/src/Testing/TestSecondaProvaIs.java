package Testing;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ControlClass.GestioneAppelli;
import ControlClass.GestioneCorsi;
import EntityClass.Appello;
import EntityClass.Corso;
import EntityClass.CreazioneAppello;
import EntityClass.DataAppello;
import EntityClass.PrenotazioneStudente;
import EntityClass.Studente;
import EntityClass.TipoAppello;

public class TestSecondaProvaIs {

	@Test
	public void test01GestioneAppelli() {
		
		//Descrizione: prenotazione con un corso, un appello e uno studente
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo un corso
		String nome ="Verolino";
		int cfu = 25;
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
		TipoAppello nuovoTipo = TipoAppello.ORALE;   //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello1);
		
		//creo uno studente
		String nome1 = "Gennaro";
		String cognome1 = "Rossi";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome1,mat);
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(nuovoApp,uno);
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(1,prenotati);
	}
	
	@Test
	public void test02GestioneAppelli() {
		
		//Descrizione: prenotazione uno studente, un corso, un appello dove non è specificata la data
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo un corso
		String nome ="Ingegneria del Software";
		int cfu = 9;
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
		TipoAppello nuovoTipo = TipoAppello.ORALE;   //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaAula, null, nuovoTipo);
		
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello1);
		
		//creo uno studente
		String nome1 = "Gennaro";
		String cognome = "Rossi";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome,mat);
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(nuovoApp,uno);
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(0,prenotati);
	}

	@Test
	public void test03GestioneAppelli() {
		
		//Descrizione: prenotazione uno studente, due corsi, un appello del secondo corso
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo i corsi
		String nome ="Ingegneria del Software";
		int cfu = 9;
		Corso c1 = new Corso (nome,cfu);
		vettoreCorsi.CreaCorso(c1.getCodice(),c1);
		
		String nome2 ="Ingegneria del suicidio";
		int cfu2 = 20;
		Corso c2 = new Corso (nome2, cfu2);
		vettoreCorsi.CreaCorso(c2.getCodice(), c2);
		
		//creo un appello per il corso
		GestioneAppelli listaApp = new GestioneAppelli();
		
		System.out.println("creo un appello per il corso c2");
		System.out.println("creo l'appello");
		int id = 1;
		Appello nuovoApp = new Appello(id);
		
		System.out.println("creo la data per il nuovo appello");
		String nuovaAula = "I-5";
		Date nuovaData = new Date();						  //creo una nuova data
		TipoAppello nuovoTipo = TipoAppello.ORALE; 			  //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaAula, nuovaData, nuovoTipo);
			
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		listaApp.CreaAppello(c2.getCodice(), vettoreCorsi, appello1);
		
		//creo uno studente
		String nome1 = "Gennaro";
		String cognome = "Rossi";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome,mat);
		
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(nuovoApp, uno);
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(1,prenotati);
	}

	@Test
	public void test04GestioneAppelli() {
		
		//Descrizione: prenotazione con un corso, uno studente, ma zero appelli
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo un corso
		String nome ="Verolino";
		int cfu = 25;
		Corso c1 = new Corso (nome,cfu);
		vettoreCorsi.CreaCorso(c1.getCodice(),c1);
		
		//creo un appello per il corso
		GestioneAppelli listaApp = new GestioneAppelli();
		
		Appello nuovoApp1 = new Appello();
		DataAppello dataApp = new DataAppello();
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp1,dataApp);
		
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello1);
		
		//creo uno studente
		String nome1 = "Gennaro";
		String cognome = "Rossi";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome,mat);
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(null,uno);
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(0,prenotati);
	}
	
	@Test
	public void test05GestioneAppelli() {
		
		//Descrizione: prenotazione con un corso, due studenti, un appello
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo un corso
		String nome ="Sistemi Operativi";
		int cfu = 9;
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
		TipoAppello nuovoTipo = TipoAppello.ORALE;   //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello1);
		
		//creo gli studenti
		String nome1 = "Gennaro";
		String cognome1 = "Rossi";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome1,mat);
		
		nome1 = "Marco";
		cognome1 = "Nonloso";
		mat = 87;
		Studente due = new Studente(nome1,cognome1,mat);
		
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(nuovoApp,uno);
		PrenotazioneStudente prenota2 = new PrenotazioneStudente(nuovoApp,due);
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		listaApp.prenotaAppelloStudente(appello1, prenota2);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(2,prenotati);
	}
	
	@Test
	public void test06GestioneAppelli() {
		
		//Descrizione: prenotazione di 0 studenti, con più appelli e un corso
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo un corso
		String nome ="Sistemi Operativi";
		int cfu = 9;
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
		TipoAppello nuovoTipo = TipoAppello.ORALE;   //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		id = 2;
		Appello nuovoApp2 = new Appello(id);
		
		nuovaAula = "I-3";
		nuovaData = new Date();
		nuovoTipo = TipoAppello.SCRITTO;
		DataAppello dataApp2 = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		CreazioneAppello appello2 = new CreazioneAppello(nuovoApp2, dataApp2);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello1);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello2);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(0,prenotati);
	}
	
	@Test
	public void test07GestioneAppelli() {
		
		//Descrizione: prenotazione con un corso, un appello e uno studente dove l'aula non è specificata
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo un corso
		String nome ="Teoria dei Segnali";
		int cfu = 9;
		Corso c1 = new Corso (nome,cfu);
		vettoreCorsi.CreaCorso(c1.getCodice(),c1);
		
		//creo un appello per il corso
		GestioneAppelli listaApp = new GestioneAppelli();
		
		System.out.println("creo l'appello");
		int id = 1;
		Appello nuovoApp = new Appello(id);
		
		System.out.println("creo la data per il nuovo appello");
		//l'aula non la metto
		Date nuovaData = new Date();						  //creo una nuova data
		TipoAppello nuovoTipo = TipoAppello.ORALE;   //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaData,nuovoTipo);
		
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello1);
		
		//creo uno studente
		String nome1 = "Gennaro";
		String cognome1 = "Rossi";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome1,mat);
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(nuovoApp,uno);
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(1,prenotati);
	}
	
	@Test
	public void test08GestioneAppelli() {
		
		//Descrizione: prenotazione di uno studente a più appelli di un corso
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo un corso
		String nome ="Analisi";
		int cfu = 30;
		Corso c1 = new Corso (nome,cfu);
		vettoreCorsi.CreaCorso(c1.getCodice(),c1);
		
		//creo un appello per il corso
		GestioneAppelli listaApp = new GestioneAppelli();
		
		System.out.println("creo l'appello");
		int id = 1;
		Appello nuovoApp = new Appello(id);
		
		System.out.println("creo la data per il nuovo appello");
		String nuovaAula = "I-5";							  //creo una nuova aula
		Date nuovaData = new Date();						  //creo una nuova data
		TipoAppello nuovoTipo = TipoAppello.ORALE;   //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		id = 2;
		Appello nuovoApp2 = new Appello(id);
		nuovaAula = "I-4";
		nuovaData = new Date();
		nuovoTipo = TipoAppello.AL_CALCOLATORE;
		DataAppello dataApp2 = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		id = 3;
		Appello nuovoApp3 = new Appello(id);
		nuovaAula = "I-6";
		nuovaData = new Date();
		nuovoTipo = TipoAppello.SCRITTO;
		DataAppello dataApp3 = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		CreazioneAppello appello2 = new CreazioneAppello(nuovoApp2,dataApp2);
		CreazioneAppello appello3 = new CreazioneAppello(nuovoApp3,dataApp3);
		
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello1);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello2);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello3);
		
		//creo uno studente
		String nome1 = "Gennaro";
		String cognome1 = "Rossi";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome1,mat);
		
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(nuovoApp,uno);
		PrenotazioneStudente prenota2 = new PrenotazioneStudente(nuovoApp2,uno);
		PrenotazioneStudente prenota3 = new PrenotazioneStudente(nuovoApp3,uno);
		
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		listaApp.prenotaAppelloStudente(appello2, prenota2);
		listaApp.prenotaAppelloStudente(appello3, prenota3);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(1,prenotati);
		
		prenotati = listaApp.stampaStudentiPrenotati(appello2);
		assertEquals(1,prenotati);

		prenotati = listaApp.stampaStudentiPrenotati(appello3);
		assertEquals(1,prenotati);
	}
	
	@Test
	public void test09GestioneAppelli() {
		
		//Descrizione: prenotazione di due studenti
		//il primo prenotato ai due appelli di Analisi 
		//il secondo prenotato a un appello di analisi e uno di SO
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
		//creo un corso
		String nome ="Analisi";
		int cfu = 30;
		Corso c1 = new Corso (nome,cfu);
		
		nome = "Sistemi Operativi";
		cfu = 9;
		Corso c2 = new Corso (nome, cfu);
		
		vettoreCorsi.CreaCorso(c1.getCodice(),c1);
		vettoreCorsi.CreaCorso(c2.getCodice(),c2);
		
		//creo un appello per il corso
		GestioneAppelli listaApp = new GestioneAppelli();
		
		System.out.println("creo l'appello");
		int id = 1;
		Appello nuovoApp = new Appello(id);
		
		System.out.println("creo la data per il nuovo appello");
		String nuovaAula = "I-5";							  //creo una nuova aula
		Date nuovaData = new Date();						  //creo una nuova data
		TipoAppello nuovoTipo = TipoAppello.ORALE;   //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		id = 2;
		Appello nuovoApp2 = new Appello(id);
		nuovaAula = "I-4";
		nuovaData = new Date();
		nuovoTipo = TipoAppello.AL_CALCOLATORE;
		DataAppello dataApp2 = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		id = 3;
		Appello nuovoApp3 = new Appello(id);
		nuovaAula = "I-6";
		nuovaData = new Date();
		nuovoTipo = TipoAppello.SCRITTO;
		DataAppello dataApp3 = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		CreazioneAppello appello2 = new CreazioneAppello(nuovoApp2,dataApp2);
		CreazioneAppello appello3 = new CreazioneAppello(nuovoApp3,dataApp3);
		
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello1);
		listaApp.CreaAppello(c1.getCodice(), vettoreCorsi, appello2);
		listaApp.CreaAppello(c2.getCodice(), vettoreCorsi, appello3);
		
		//creo uno studente
		String nome1 = "Gennaro";
		String cognome1 = "Rossi";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome1,mat);
		
		nome1 = "Goku";
		cognome1 = "Rossi";
		mat = 45;
		Studente due = new Studente(nome1,cognome1,mat);
		
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(nuovoApp,uno);
		PrenotazioneStudente prenota2 = new PrenotazioneStudente(nuovoApp2,uno);
		PrenotazioneStudente prenota3 = new PrenotazioneStudente(nuovoApp2,due);
		PrenotazioneStudente prenota4 = new PrenotazioneStudente(nuovoApp3,due);
		
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		listaApp.prenotaAppelloStudente(appello2, prenota2);
		listaApp.prenotaAppelloStudente(appello2, prenota3);
		listaApp.prenotaAppelloStudente(appello3, prenota4);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(1,prenotati);
		
		prenotati = listaApp.stampaStudentiPrenotati(appello2);
		assertEquals(2,prenotati);

		prenotati = listaApp.stampaStudentiPrenotati(appello3);
		assertEquals(1,prenotati);
	}
	
	@Test
	public void test10GestioneAppelli() {
		
		//Descrizione: prenotazione con zero appell1, zero studenti, zero corsi
		GestioneAppelli listaApp = new GestioneAppelli();
		Appello nuovoApp = new Appello();
		DataAppello dataApp = new DataAppello();
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(0,prenotati);
	}
	
	@Test
	public void test11GestioneAppelli() {
		
		//Descrizione: prenotazione di uno studente
		//a più appelli ma ho 0 corsi
        GestioneCorsi <Integer, Corso> vettoreCorsi = new GestioneCorsi <>();
		
        //creo un appello
		GestioneAppelli listaApp = new GestioneAppelli();
		
		System.out.println("creo l'appello");
		int id = 1;
		Appello nuovoApp = new Appello(id);
		
		System.out.println("creo la data per il nuovo appello");
		String nuovaAula = "I-5";							  //creo una nuova aula
		Date nuovaData = new Date();						  //creo una nuova data
		TipoAppello nuovoTipo = TipoAppello.ORALE;   //assegno il tipo
		DataAppello dataApp = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
		
		id = 2;
		Appello nuovoApp2 = new Appello(id);
		nuovaAula = "I-4";
		nuovaData = new Date();
		nuovoTipo = TipoAppello.AL_CALCOLATORE;
		DataAppello dataApp2 = new DataAppello(nuovaAula,nuovaData,nuovoTipo);
				
		CreazioneAppello appello1 = new CreazioneAppello(nuovoApp,dataApp);
		CreazioneAppello appello2 = new CreazioneAppello(nuovoApp2,dataApp2);
		
		listaApp.CreaAppello(0, vettoreCorsi, appello1);
		listaApp.CreaAppello(0, vettoreCorsi, appello2);
		
		
		//creo uno studente
		String nome1 = "Gennaro";
		String cognome1 = "Rossi";
		int mat = 12;
		Studente uno = new Studente(nome1,cognome1,mat);
		
		
		PrenotazioneStudente prenota1 = new PrenotazioneStudente(nuovoApp,uno);
		PrenotazioneStudente prenota2 = new PrenotazioneStudente(nuovoApp2,uno);
				
		listaApp.prenotaAppelloStudente(appello1, prenota1);
		listaApp.prenotaAppelloStudente(appello2, prenota2);
		
		//stampo gli studenti prenotati all'appello
		int prenotati = 0;
		prenotati = listaApp.stampaStudentiPrenotati(appello1);
		assertEquals(0,prenotati);
		
		prenotati = listaApp.stampaStudentiPrenotati(appello2);
		assertEquals(0,prenotati);
	}
	
}
