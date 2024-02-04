//luokka, joka sisältää attribuutit avain ja tieto
public class AvainTietoPari {
	private int avain ;
	private int tieto ;
	//konstruktori avain-tieto-parin luomiselle
	public AvainTietoPari(int avain, int tieto) {
		this.avain = avain;
		this.tieto = tieto;
	}
	//tarkistaa onko tämän olion avain suurempi kuin parametrinä annetun olion avain
	public boolean gt(AvainTietoPari s) {
	        return this.avain > s.avain;
	}
	//tarkistaa onko tämän olion avain pienempi kuin parametrinä annetun olion avain
	public boolean lt(AvainTietoPari s) {
	        return this.avain < s.avain;
	}
	 //getteri olion avaimen palauttamiselle   
	public int getAvain() {
	        return avain;
	}
	//getteri olion tiedon (luvun) palauttamiselle  
	public int getTieto() {
	        return tieto;
	}
	@Override
	public String toString() {
	        return "(" + avain + ", " + tieto + ")";
	}
}
