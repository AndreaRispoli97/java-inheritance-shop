import java.math.BigDecimal;
import java.math.RoundingMode;

public class Televisori extends Prodotto {

    private float altezza;
    private float larghezza;
    private float spessore;
    private boolean smart;

    public Televisori(int codice, String nome, String marca, double prezzo, double iva, float altezza, float larghezza,
            float spessore, boolean smart) {
        super(codice, nome, marca, prezzo, iva);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.spessore = spessore;
        this.smart = smart;
    }

    public float getAltezza() {
        return altezza;
    }

    public float getLarghezza() {
        return larghezza;
    }

    public float getSpessore() {
        return spessore;
    }

    public boolean getSmart() {
        return smart;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public void setLarghezza(float larghezza) {
        this.larghezza = larghezza;
    }

    public void setSpessore(float spessore) {
        this.spessore = spessore;
    }

    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    @Override
    public String toString() {
        return super.toString() + ". Dimensione Tv di: " + altezza + "x" + larghezza + "x" + spessore
                + ". Dotata di intelligenza smart: " + (smart ? "Si" : "No");
    }

    @Override
    public BigDecimal getPrezzoScontato() {

        if (!smart) {
            BigDecimal sconto = new BigDecimal("0.10"); // BigDecimal.valueOf(0.10);
            BigDecimal prezzoBase = getPrezzo();
            BigDecimal unoMenoSconto = BigDecimal.ONE.subtract(sconto);
            BigDecimal prezzoScontato = prezzoBase.multiply(unoMenoSconto);
            return prezzoScontato.setScale(2, RoundingMode.HALF_UP);
        }
        return super.getPrezzoScontato();
    }
}
