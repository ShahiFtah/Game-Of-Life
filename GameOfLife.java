import java.util.Scanner;

class GameOfLive{

    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);

        System.out.print("Skriv inn antall rader: " );
        int rad = scan.nextInt();

        System.out.print("Skriv inn antall kolonner: ");
        int kol = scan.nextInt();

        Verden verden = new Verden(rad, kol);

        verden.tegn();

        for (int x = 0; x < 3; x++){
            verden.oppdatering();
            verden.tegn();
       }
    }
}

//På denne siden lager jeg en Scanner objekt smed variabel scan
//videre spør jeg brukeren om antall rader og kolonner, og registrerer disse på hver sin variabel ved hjelp av scanner
//Videre lager jeg en Verden objekt, med rad og kol. Her kaller jeg på tegn() som tegner objektet
//Videre lager jeg en for-løkke som oppdaterer naboer og status, og tegner en ny generasjon. Dette skjer fra generasjon 0 til 3