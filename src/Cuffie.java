import java.math.BigDecimal;
import java.math.RoundingMode;

public class Cuffie extends Prodotto {

    private String colore;
    private boolean wireless;
    private boolean cablate;

    public Cuffie(int codice, String nome, String marca, double prezzo, double iva, String colore, boolean wireless,
            boolean cablate) {
        super(codice, nome, marca, prezzo, iva);
        this.colore = colore;
        this.wireless = wireless;
        this.cablate = cablate;
    }

    public String getColore() {
        return colore;
    }

    public boolean getWireless() {
        return wireless;
    }

    public boolean getCablate() {
        return cablate;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    public void setCablate(boolean cablate) {
        this.cablate = cablate;
    }

    @Override
    public String toString() {
        return super.toString() + ". Colore del prodotto: " + colore + ". Collegamento Wireless possibile: "
                + (wireless ? "Si" : "No") + ". Collegamento tramite cavo possibile: " + (cablate ? "Si" : "No");
    }

    @Override
    public BigDecimal getPrezzoScontato() {
        if (cablate) {
            BigDecimal sconto = BigDecimal.valueOf(0.05);
            BigDecimal prezzoBase = getPrezzo();
            BigDecimal unoMenoSconto = BigDecimal.ONE.subtract(sconto);
            BigDecimal prezzoScontato = prezzoBase.multiply(unoMenoSconto);
            return prezzoScontato.setScale(2, RoundingMode.HALF_UP);
        }
        return super.getPrezzoScontato();
    }
}
