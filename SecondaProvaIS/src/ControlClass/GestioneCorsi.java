package ControlClass;

import java.util.TreeMap;

public class GestioneCorsi <T,V> {

	//variabili/strutture membro
	private TreeMap <T,V> listaCorsi = new TreeMap <> ();
		
	//costruttore; do per scontato che se non si specifica la lunchezza della struttura, si potranno
	//inserire al massimo 10 corsi, dunque ho dim = 10
	public GestioneCorsi()
	{	}
			
	//Metodi della classe
	
	public void CreaCorso (T codice, V c)
	{
		listaCorsi.put(codice, c);
	}
	
	public boolean RicercaCorso(T codice)
	{
		if(listaCorsi.containsKey(codice))   //verifico se l'elemento è presente nella struttura 
		{
			return true;                     //se lo trovo ritorno "true"
		}
		System.out.println("il corso non è presente");
		return false;
	}
	
	public void Rimuovi (T codice)
	{
		listaCorsi.remove(codice);           //rimuove l'elemento corrispondente alla chiave passata 
		System.out.println("il Corso è stato eliminato");
	}
}
