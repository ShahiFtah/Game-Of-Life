class Rutenett {
    protected int antRader; 
    protected int antKolonner;
    protected Celle[][] rutene;
//lager instansvariablene for rad, kol, og todimensjonale Celle 

    public Rutenett(int antRader, int antKolonner){
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        this.rutene = new Celle[antRader][antKolonner];
    }
//Lager en konstruktør som tar inn rader og kolonner og registrerer disse i variablene, og legger til i en Celle i rutene. 
    public void lagCelle( int rad, int kolonne){
        rutene[rad][kolonne]= new Celle();
        if (Math.random()<=0.3333){
            rutene[rad][kolonne].settLevende();
        }
    }
//tar imot to parametre rad og kolonne, og lager en ny Celle objekt, videre genererer vi en if setning som sier at hvis math.random er mindre eller lik 0,33 sett cellen til levende

    public void fyllMedTilfeldigeCeller(){
        for (int x = 0; x < antRader; x++){
            for (int y = 0; y < antKolonner; y++){
                lagCelle(x, y); //se int for x og y 
            }
        }
    }
//iterer gjennom ant rader og antkolonner og kaller på lagCelle med x og y som parametre for hver itering
    public Celle hentCelle( int rad, int kolonne){
        if (rad >=0 && rad < antRader && kolonne >=0 && kolonne < antKolonner){
            return rutene[rad][kolonne];
        }
        return null;
    }
//lager en if setning som sjekker om cellene ligger innenfor kravet/cellene, og ikke utenfor. Hvis den ligger innenfor returnerer den en celle med koordinatene, ellers null
    public void tegnRutenett() {
        System.out.println();

        for (int x = 0; x < antRader; x++){
            for (int y = 0; y < antKolonner; y++){
                System.out.print(rutene[x][y].hentStatusTegn());
            }
            System.out.println();
        }
    for (int x = 0; x < 5; x++){
        System.out.println(); 
    }
    }
//iterer igjen gjennom ant rad og kolonne og skriver ut cellene i posisjon x og y, ved å koble til hentStatusTegn.
//jeg setter litt mellomrom foran og under for hver generasjon, ved hjelp av for-løkke
    public void settNaboer(int rad, int kolonne){
        Celle Cellene = hentCelle(rad, kolonne); 
        if (Cellene == null){
            ;
        }

        for (int x = rad - 1; x <= rad + 1; x++){
            for (int y = kolonne -1; y <= kolonne + 1; y++){
                if (hentCelle(x,y) == null || x == rad && y == kolonne){
                    continue;
                }
                Cellene.leggTilNabo(hentCelle(x,y));
            } 
        }
    }
//tar imot to parametre og setter den i en Celle objekt, som henter cellen med hentCelle()
//hvis Cellen som vi har fått er null = ikke gjør noe, ellers iterer vi gjennom rad og kolonne, ved å sette opp alle mulige koorinater for både rader og kolonner
//og hvis denne cellen er null slutter vi iterasjonen ved å bruke continue som fortsetter og legger til nabo med cellene med koordinatene x og y
    public void kobleAlleCeller(){
        for( int rad = 0; rad < rutene.length; rad++){
            for (int kol = 0; kol < rutene[rad].length; kol++){
                settNaboer(rad, kol);
            }
        }

    }

    public int antallLevende() { 
        int antlevende = 0;
        for( int rad = 0; rad < rutene.length; rad++){
            for (int kol = 0; kol < rutene[rad].length; kol++){
                if (rutene[rad][kol].erLevende()){
                    antlevende++;
                }
            }
        }  
        return antlevende;
    }
}
//KobleAlleCeller- iterer gjennom cellene og setter dem sammen med settNaboer(rad,kol)
//antallLevende - itere gjennom hver celle og sjekke med if-setning om de er levende eller ikke. 