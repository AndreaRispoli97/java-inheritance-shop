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
    public double getPrezzoScontato() {
        double sconto = 0.02;
        if (cablate) {
            sconto = 0.07;
        }
        double prezzoBase = getPrezzo();
        double prezzoScontato = prezzoBase - (getPrezzo() * sconto);
        return Math.round(prezzoScontato * 100) / 100d;
    }
}
