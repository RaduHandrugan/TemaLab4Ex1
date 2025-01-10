public abstract class Echipament
{
    private String denumire;
    private int nrInv;
    private double pret;
    private String zonaMag;
    private StareEchipament stare;

    public enum StareEchipament
    {
        ACHIZITIONAT,
        EXPUS,
        VANDUT
    }


    public Echipament(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare)
    {
        this.denumire = denumire;
        this.nrInv = nrInv;
        this.pret = pret;
        this.zonaMag = zonaMag;
        this.stare = stare;
    }

    public int getNrInv()
    {
        return nrInv;
    }

    //get & setter
    public void setStare(StareEchipament stare)
    {
        this.stare = stare;
    }

    public StareEchipament getStare()
    {
        return stare;
    }

    @Override
    public String toString()
    {
        return denumire + " Inventar: " + nrInv + ", Pret: " + pret + ", Stare: " + stare;
    }
}
