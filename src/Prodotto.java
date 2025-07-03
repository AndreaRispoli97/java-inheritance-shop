public class Prodotto {
    // Questa è la superclasse
    // attributi

    private int codice;
    private String nome;
    private String marca;
    private double prezzo;
    private double iva;

    public Prodotto(int codice, String nome, String marca, double prezzo, double iva) {
        this.codice = codice;
        this.nome = nome;
        this.marca = marca;
        this.prezzo = prezzo;
        this.iva = iva;
    }

    // get
    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public double getIva() {
        return iva;
    }

    // setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo >= 0) {
            this.prezzo = prezzo;
        } else {
            System.out.println("Prezzo non inserito");
        }
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    // metodi

    public double getPrezzoIva() {
        double risultato = prezzo + (prezzo * iva / 100);
        double cifraArr = Math.round(risultato * 100) / 100d;
        return cifraArr;
    }

    // metodo bonus

    public double getPrezzoScontato() {
        double sconto = 0.02;
        double prezzoScontato = prezzo - (prezzo * sconto);
        return Math.round(prezzoScontato * 100) / 100d;
    }

    @Override
    public String toString() {
        return "Codice identificativo: " + codice + ", Nome: " + nome + ", Marca: " + marca + ", al prezzo base di: "
                + prezzo
                + ". Iva: " + iva + ". Prezzo con Iva di: " + getPrezzoIva();
    }
}
