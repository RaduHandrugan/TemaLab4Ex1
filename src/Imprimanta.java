public class Imprimanta extends Echipament
{
    private int ppm;
    private int dpi;
    private int pCar;
    private ModTiparire modTiparire;

    public enum ModTiparire
    {
        COLOR,
        ALB_NEGRU
    }

    public Imprimanta(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, int ppm, int dpi, int pCar, ModTiparire modTiparire)
    {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.pCar = pCar;
        this.modTiparire = modTiparire;
    }

    public void setModTiparire(ModTiparire modTiparire)
    {
        this.modTiparire = modTiparire;
    }

    public ModTiparire getModTiparire()
    {
        return modTiparire;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", PPM: " + ppm + ", DPI: " + dpi + ", Mod: " + modTiparire;
    }
}
