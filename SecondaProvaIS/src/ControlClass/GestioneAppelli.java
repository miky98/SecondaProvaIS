package ControlClass;

import java.util.ArrayList;

import EntityClass.Corso;
import EntityClass.CreazioneAppello;
import EntityClass.PrenotazioneStudente;
import EntityClass.Studente;
import ControlClass.GestioneCorsi;

public class GestioneAppelli {

	//variabili/strutture membro    Appello, DataAppello
	private ArrayList <CreazioneAppello> listaAppelli = new ArrayList <CreazioneAppello> ();
	private ArrayList <PrenotazioneStudente> listaStudentiPrenotati = new ArrayList <PrenotazioneStudente> ();
	
	//costruttore; do per scontato che se non si specifica la lunchezza della struttura, si potranno
	//inserire al massimo 10 appelli, dunque ho dim = 10
	public GestioneAppelli()
	{	}
		
	//Metodi della classe
	//2) creazione appello relativo a un corso
	public void CreaAppello (int codCorso, GestioneCorsi <Integer,Corso> corsi, CreazioneAppello appelloDaInserire)  
	{//gli passo il codice del corso, la lista dei corsi, l'appello da inserire, la data
		                
		//verifico se il corso esiste
		boolean trovato = false;
		trovato = corsi.RicercaCorso(codCorso);
		if(trovato)
		{
			System.out.println("ho trovato il corso");
			
			if(appelloDaInserire.getData().getData() == null)
			{
				System.out.println("l'appello che vuoi inserire non ha una data, non posso crearlo");
				return;
			}
			
			if(appelloDaInserire.getData().getAula() == null)
			{
				System.out.println("l'appello non ha l'aula, lo creo lo stesso mettendo 'da Definire' ");
				appelloDaInserire.getData().setAula("da Definire");
			}
			
			if(appelloDaInserire.getAppello().getId() == -1)
			{
				System.out.println("l'appello che vuoi inserire non ha un id valido, non posso crearlo");
				return;
			}
			
			System.out.println("inserisco l'appello e la data nella lista degli appelli");
			appelloDaInserire.setCod(codCorso);
			listaAppelli.add(appelloDaInserire);     //inserisco Appello e DataAppello		
		}
		else
		{
			System.out.println("il corso non è presente, non posso creare l'appello");
			return;
		}		
	}
		
	public Boolean RicercaAppello(CreazioneAppello a)
	{
		//quando chiamo la funzione ci devo passare sia il codice dell'appello sia la data
		if(listaAppelli.contains(a))   //verifico se l'elemento è presente nella struttura 
		{
			return true;   //prelevo il valore corrispondente alla chiave (codice)
		}
		System.out.println("il corso non è presente");
		return false;
	}
	
	public void RimuoviAppello (CreazioneAppello a)
	{
		listaAppelli.remove(a);           						//rimuove l'appello passato 
		System.out.println("l'appello è stato eliminato");
	}
	
	
	public void prenotaAppelloStudente (CreazioneAppello appRichiesto, PrenotazioneStudente s)
	{
		//controllo se l'appello è presente
		//se vero aggiungo lo studente alla lista prenotati per quell'appello
		//altrimenti non faccio nulla e ritorno un messaggio
		Boolean trovato = false;
		trovato = listaAppelli.contains(appRichiesto);
		if(trovato)
		{			
			listaStudentiPrenotati.add(s);
		}
		else
		{
			System.out.println("l'appello non è presente, non posso fare la prenotazione");
			return;
		}
	}
	
	
	public int stampaStudentiPrenotati (CreazioneAppello a)
	{
		//Funzionamento: verifico se l'appello è presente
		//se vero allora stampo la lista di tutti gli studenti prenotati per quel corso
		//falso restituisco un messaggio di errore
		
		Boolean trovato = false;
		trovato = listaAppelli.contains(a);
		if(trovato)
		{
			int cont = 0; // MI SERVE PER TENER CONTO DEL NUMERO DI STUDENTI VISUALIZZATI
			/*Per ogni prenotazione:
			1) prelevo l'oggetto
			2) ottengo lo studente
			3) verifico se l'id è uguale a quello passato
			4) in caso affermatico prendo l'oggetto e lo visualizzo*/
			
			//aggiungo una variabile boole che mi segnala se sono presenti studenti prenotati oppure no
			Boolean ciSonoStudenti = false;
			for(int i = 0; i < listaStudentiPrenotati.size(); i++)
			{
				System.out.println("Studenti prenotati:");
				//prelevo l'elemento i-esimo e lo metto in una variabile temp
				PrenotazioneStudente temp = listaStudentiPrenotati.get(i);
				
				//da temp prelevo le informazoni dello studente
				Studente provaStud = temp.getStudente();
				String nome1 = provaStud.getNome();
				String cognome1 = provaStud.getCognome();
				
				//controllo se l'id dell'appello a cui è prenotato lo studente corrisponde all'appello passato
				if(temp.getAppello().getId() == (a.getAppello().getId()))
				{		
					cont++;
					ciSonoStudenti = true;
					System.out.println(nome1 + " " +
							           cognome1 + " " +
							           provaStud.getMatricola());
				}
			}
			if(ciSonoStudenti == false)
			{
				cont = 0;
				System.out.println("Non ci sono studenti prenotati");
			}
			return cont;
		}
		else
		{
			System.out.println("l'appello non è presente, non ci sono studenti prenotati");
			return 0;
		}
	}
}