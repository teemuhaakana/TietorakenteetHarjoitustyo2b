import java.util.Scanner;

public class Kayttoliittyma {
	public static void main(String args[]) {
		//luodaan uusi BST olio eli siis uusi binäärinen hakupuu
        BST bst = new BST();
        //käytetään javan scanneria käyttäjän syötteen lukemiseen
        Scanner scanner = new Scanner(System.in);
        while (true) {
        	//eri operaatiot
            System.out.println("1. Lisää olio(avain, tieto)");
            System.out.println("2. Etsi solmua");
            System.out.println("3. Poista solmu");
            System.out.println("4. Binääripuun tulostaminen sisäjärjestyksessä");
            System.out.println("5. Lopeta ohjelman käyttö");
            
            //muuttuja, johon tallennetaan käyttäjän valinta
            int valinta = scanner.nextInt();
            switch(valinta) {
            
	        	case 1:
		            // lisää olio puuhun
		            System.out.print("Syötä avain: ");
		            //pyydetään avain ja tieto (luku) käyttäjältä
		            int avain = scanner.nextInt();
		            System.out.print("Syötä luku (tieto): ");
		            int tieto = scanner.nextInt();
		            bst.insert(new AvainTietoPari(avain, tieto));
		            break;
	        	case 2:
                    //etsi solmua
                    System.out.print("Syötä etsittävän solmun avain: ");
                    int haettava = scanner.nextInt();
                    if (bst.find(haettava)) {
                        System.out.println("Solmu löytyi: " + bst.getLastFound());
                    } else {
                        System.out.println("Solmua ei löytynyt");
                    }
                    break;

                case 3:
                    //poista solmu
                    System.out.print("Syötä poistettavan solmun avain: ");
                    int poistettava = scanner.nextInt();
                    bst.delete(poistettava);
                    System.out.println("Solmu poistettu.");
                    break;

                case 4:
                    //tulosta binääripuun solmut sisäjärjestyksessä
                    System.out.println("Tulostetaan binääripuun solmujen tiedot sisäjärjestyksessä: ");
                    bst.printInOrder();
                    break;

                case 5:
                    // lopeta ohjelman käyttö
                    break;    
            }
	}
}
}
