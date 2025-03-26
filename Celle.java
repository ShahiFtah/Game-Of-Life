class Celle {
    protected boolean status;
    protected Celle[] naboer;
    protected int antNaboer;
    protected int antLevendeNaboer;
    //lager instansvariablene

    public Celle() {
        this.status = false;
        this.naboer = new Celle[8];
        this.antNaboer = 0;
        this.antLevendeNaboer = 0;
    }
    //lager en konstruktør som setter verdi til variablene når Celle kalles

    public void settDoed() {
        this.status = false;
    }
//endrer status til false
    public void settLevende() {
        this.status = true;
    }
//endrer status til true
    public boolean erLevende() {
        return this.status;
    }
//returnerer enten false eller true
    public char hentStatusTegn() {
        if (this.status){
            return 'O';
        } 
        else {
            return '.';
        }
    }
//skriver char som sender O eller . avhengig av status
    public void leggTilNabo(Celle nabo) {
        this.naboer[this.antNaboer] = nabo;
        this.antNaboer++;
    }

    public void tellLevendeNaboer() {
        antLevendeNaboer = 0;
        for (int x = 0; x < this.antNaboer; x++) {
            if (this.naboer[x].erLevende()){
                this.antLevendeNaboer +=1;
            }
        }

    }
//Over kjører forløkken så lang antNaboer er og kaller på erLevende for å sjekke om naboer er true, og dermed legge til +1
    public void oppdaterStatus () { 
        if (this.status) {
            if (this.antLevendeNaboer < 2 || this.antLevendeNaboer > 3){
                settDoed();
            }

            else if (this.antLevendeNaboer == 2 || this.antLevendeNaboer == 3){
                settLevende();
            }
        }

        else {
            if(this.antLevendeNaboer == 3){
                settLevende();
            }
        }
//dersom status er true og antLevendeNaboer er mindre enn 2 eller større enn 3 = sett doed
//ellers hvis status er sant, men antLevendeNaboer er lik 2 eller lik 3 = sett levende
//hvis ikke status er sant, sett status til levende hvis antLevendeNaboer er lik 3
    }

}
