import java.math.BigDecimal;
import java.math.RoundingMode;

public class Prodotto {
    // Questa è la superclasse
    // attributi

    private int codice;
    private String nome;
    private String marca;
    private BigDecimal prezzo;
    private BigDecimal iva;

    public Prodotto(int codice, String nome, String marca, double prezzo, double iva) {
        this.codice = codice;
        this.nome = nome;
        this.marca = marca;
        this.prezzo = new BigDecimal(prezzo); // BigDecimal.valueOf(prezzo);
        this.iva = new BigDecimal(iva);// BigDecimal.valueOf(iva);
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

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public BigDecimal getIva() {
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
            this.prezzo = new BigDecimal(prezzo); // BigDecimal.valueOf(prezzo);
        } else {
            System.out.println("Prezzo non inserito");
        }
    }

    public void setIva(double iva) {
        this.iva = new BigDecimal(iva); // BigDecimal.valueOf(iva);
    }

    // metodi

    public BigDecimal getPrezzoIva() {
        BigDecimal cento = new BigDecimal("100"); // BigDecimal.valueOf(100);
        BigDecimal ivaPercentuale = iva.divide(cento, 2, RoundingMode.HALF_UP);
        BigDecimal soloIva = prezzo.multiply(ivaPercentuale);
        BigDecimal risultato = prezzo.add(soloIva);
        return risultato.setScale(2, RoundingMode.HALF_UP);
    }

    // metodo bonus

    public BigDecimal getPrezzoScontato() {
        BigDecimal scontoBase = new BigDecimal("0.02"); // BigDecimal.valueOf(0.02);
        BigDecimal unoMenoSconto = BigDecimal.ONE.subtract(scontoBase);// 1- lo sconto, cosi da saltare un operazione e
                                                                       // fare direttamente poi la
                                                                       // moltiplicazione(0.02-1=0.98*prezzo)
        BigDecimal prezzoScontato = prezzo.multiply(unoMenoSconto);
        return prezzoScontato.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Codice identificativo: " + codice + ", Nome: " + nome + ", Marca: " + marca + ", al prezzo base di: "
                + prezzo
                + ". Iva: " + iva + ". Prezzo con Iva di: " + getPrezzoIva();
    }
}
