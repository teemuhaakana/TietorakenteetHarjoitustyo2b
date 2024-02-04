//binäärisen hakupuun BST-luokka
class BST {
	//puun juurisolmu root ja viimeksi löydetty solmu lastFound
  protected TNode root;
  protected TNode lastFound;
  //konstruktori binääriselle hakupuulle
  public BST() {
    root = null;
    lastFound = null;
  }
  //palauttaa viimeksi löydetyn solmun
  public TNode getLastFound() {
		return lastFound;
	}
  
  //metodi solmun etsimiselle puusta annetulla avaimella
  public boolean find(int avain) {
	  //jos puu on tyhjä, palauttaa false
	    if (root == null) {
	        return false;
	    } else {
	    	//luodaan muuttuja f johon tallennetaan TNoden find metodin palauttama arvo
	        TNode f = root.find(avain);
	        if (f != null) {
	        	//jos f ei ole null, päivitetään lastFound muuttuja ja palautetaan true
	        	//tällöin saadaan viimeksi löydetty solmu tallennettua
	            lastFound = f;
	            return true;
	        } else {
	        	//solmua ei löytynyt
	            return false;
	        }
	    }
	}
  //metodi joka lisää uuden solmun puuhun
  public void insert(AvainTietoPari a) {
    if (root == null) {
    	// jos puu tyhjä, lisää juureksi 
      root = new TNode(a, null, null);
      lastFound = root;
    } else {
    	// jos ei tyhjä, lisää juuresta alkavaan puuhun
      lastFound = root.insert(a);
    }
  }
  //metodi poistamiselle, jota voidaan kutsua muista luokista, kutsuu sitten omassa luokassaan deleteRecursive metodia
  public void delete(int avain) {
      root = deleteRecursive(root, avain);
  }
  //rekursiivinen metodi solmun poistamiseen
  private TNode deleteRecursive(TNode root, int avain) {
	// puu on tyhjä tai avainta ei löydy
      if (root == null) {
          return root;
      }

      //etsii poistettavaa solmua annetulla avaimella
      if (avain < root.sisalto.getAvain()) {
    	//jos annettu avain on pienempi, etsi vasemmasta alipuusta
          root.left = deleteRecursive(root.left, avain);
      } else if (avain > root.sisalto.getAvain()) {
    	//jos annettu avain on suurempi, etsi vasemmasta alipuusta
          root.right = deleteRecursive(root.right, avain);
      } else {
          //solmu löydetty
          //jos solmulla ei ole lapsia tai vain yksi lapsi
          if (root.left == null) {
        	  //jos ei vasenta lasta, palauta oikea lapsi
              return root.right;
          } else if (root.right == null) {
        	//jos ei oikeaa lasta, palauta vasen lapsi
              return root.left;
          }

          //jos solmulla kaksi lasta etsii pienimmän avaimen oikeassa alipuussa
          root.sisalto = minValue(root.right);
          //rekursiivinen poisto alipuusta
          root.right = deleteRecursive(root.right, root.sisalto.getAvain());
      }

      return root;
  }

  //etsii pienimmän arvon binääripuusta
  private AvainTietoPari minValue(TNode root) {
      while (root.left != null) {
          root = root.left;
      }
      return root.sisalto;
  }
  //public-metodi tulostamiselle, kutsuu metodia joka tulostaa puun järjestyksessä (sisäjärjestys)
  public void printInOrder() {
      printInOrder(root);
      System.out.println();
  }
  //luokan private metodi joka tulostaa puun sisäjärjestyksessä
  private void printInOrder(TNode node) {
      if (node != null) {
          printInOrder(node.LST());
          System.out.println(node);
          printInOrder(node.RST());
      }
  }
}