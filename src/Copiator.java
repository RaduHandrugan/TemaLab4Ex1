public class Copiator extends Echipament
{
    private int pTon;
    private FormatCopiere format;

    public enum FormatCopiere
    {
        A3,
        A4
    }
    public Copiator(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, int pTon, FormatCopiere format)
    {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.pTon = pTon;
        this.format = format;
    }

    public void setFormat(FormatCopiere format)
    {
        this.format = format;
    }

    public FormatCopiere getFormat()

    {
        return format;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", Pagini/Toner: " + pTon + ", Format: " + format;
    }
}
