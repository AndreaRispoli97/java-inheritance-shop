import java.math.BigDecimal;
import java.math.RoundingMode;

public class Smartphone extends Prodotto { // sottoclasse che si estende alla superclasse
    // attributi
    private String imei;
    private int memoriaGB;

    // costruttore
    // prendiamo anche gli attributi appartenenti alla superclasse(Prodotto)
    public Smartphone(int codice, String nome, String marca, double prezzo, double iva, String imei, int memoriaGB) {
        // chiamata al costruttore padre
        super(codice, nome, marca, prezzo, iva);
        this.imei = imei;
        this.memoriaGB = memoriaGB;
    }

    // getter

    public String getImei() {
        return imei;
    }

    public int getMemoriaGb() {
        return memoriaGB;
    }

    // setter

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setMemoriaGb(int memoriaGB) {
        this.memoriaGB = memoriaGB;
    }

    // metodi

    // sovrascriviamo nuovamente aggiungendo anche i dati specifici dello smartphone
    @Override
    public String toString() {
        return super.toString() + ". Codice IMEI: " + imei + ". Memoria dispositivo di: " + memoriaGB + "GB";
    }

    @Override
    public BigDecimal getPrezzoScontato() {

        if (memoriaGB < 32) {
            BigDecimal sconto = new BigDecimal("0.05"); // BigDecimal.valueOf(0.05);
            BigDecimal prezzoBase = getPrezzo();
            BigDecimal unoMenoSconto = BigDecimal.ONE.subtract(sconto);
            BigDecimal prezzoScontato = prezzoBase.multiply(unoMenoSconto);
            return prezzoScontato.setScale(2, RoundingMode.HALF_UP);
        }
        return super.getPrezzoScontato();
    }
}
