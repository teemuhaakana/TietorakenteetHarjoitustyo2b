//TNode luokka binääripuun solmuille
class TNode {
	//attribuuttina luokan AvainTietoPari avain-tieto-pari, vasen ja oikea lapsisolmu
  protected AvainTietoPari sisalto;
  protected TNode left;
  protected TNode right;
  //konstruktori uuden solmun muodostamiseen
  public TNode(AvainTietoPari sisalto, TNode newL, TNode newR) {
    this.sisalto = sisalto;
    this.left = newL;
    this.right = newR;
  }
  //getteri solmun vasemman lapsisolmun palauttamiseen
  public TNode LST() {
	  return left;
  }
//getteri solmun vasemman lapsisolmun palauttamiseen
  public TNode RST() {
	  return right;
  }
  //palauttaa solmun sisällön merkkijonona
  @Override
  public String toString() {
      return sisalto.toString();
  }
  //etsii annetulla avaimella solmua
  public TNode find(int x) {
	  //jos annettu avain on pienempi kuin solmun avain, etsi vasemmasta alipuusta
    if (x < sisalto.getAvain()) {
      if (left != null)
        return left.find(x);
      else
    	  //avainta ei löytynyt
        return null;
    } else
    	//jos annettu avain on suurempi kuin solmun avain, oikeasta vasemmasta alipuusta
    if (x > sisalto.getAvain()) {
      if (right != null)
        return right.find(x);
      else
    	//avainta ei löytynyt
        return null;
    } else
    	//palauttaa solmun, joka löytyi avaimella
      return this;
  }
  
  //lisää uuden avain-tieto-parin puuhun
  public TNode insert(AvainTietoPari a) {
	  //jos lisättävän olion avain on pienempi kuin solmun avain, lisää vasemmalle
	    if (a.lt(sisalto)) { 
	        if (left == null) {
	            left = new TNode(a, null, null);
	            return left;
	        } else {
	            return left.insert(a);
	        }
	    } else if (a.gt(sisalto)) {
	    	//jos lisättävän olion avain on suurempi kuin solmun avain, lisää oikealle
	        if (right == null) {
	            right = new TNode(a, null, null);
	            return right;
	        } else {
	            return right.insert(a);
	        }
	    } else {
	    	//mikäli sama avain, palauta
	        return this;
	    }
	}

  }
