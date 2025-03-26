class Verden {
    protected int genNr = 0;
    protected Rutenett rutenett;
    protected int antRader;
    protected int antkol;

    public Verden(int antRader, int antKolonner){
        this.antRader = antRader;
        this.antkol = antKolonner;
        rutenett = new Rutenett(antRader , antKolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }
//lager instansvariablene fra oppgaven og en konstruktør som tar imot rad og kolonne og lager en Rutenett objekt
    public void tegn() {
        System.out.println("Generasjon nr: " + genNr );
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
        rutenett.tegnRutenett();
    }
//skriver ut genNr og antall levende ved å kalle på antallLevende med rutenett. Til slutt kaller jeg på tegnRutenett
    public void oppdatering() {
        for (int x = 0; x < antRader; x++){
            for (int y = 0; y < antkol; y++){
                Celle celle = rutenett.hentCelle(x,y);
                celle.tellLevendeNaboer();
                celle.oppdaterStatus();
                
            }
        }   
        this.genNr++; 
    }     
}    
//I oppdatering iterwer jeg gjennom rad og kolonnene og henter cellene for hver iterasjon. Her gjør jeg om cellene til en Celle objekt for å 
//kalle på tellLevendeNaboer og oppdaterStatus på Celle.java siden.

