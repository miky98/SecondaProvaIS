package EntityClass;

public class PrenotazioneStudente {

	//variavili membro
		private Appello App;
		private Studente s;
		
		//costruttori
		public PrenotazioneStudente (Appello a, Studente stud)
		{
			this.App = a;
			this.s = stud;
		}

		//metodi della Classe CreazioneAppello
		
		public Appello getAppello() {
			return App;
		}

		public void setAppello(Appello id) {
			this.App = id;
		}

		public Studente getStudente() {
			return s;
		}

		public void setStudente(Studente stud) {
			this.s = stud;
		}
}
