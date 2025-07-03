import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Carrello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---Benvenuto nel tuo carrello---");
        System.out.println("---Quanti prodotti vuoi inserire?");

        int numeroProdotti = scanner.nextInt();
        scanner.nextLine();

        Prodotto[] carrello = new Prodotto[numeroProdotti];// creiamo array della lunghezza che richiede l'acquirente

        int prodottiInseriti = 0;// per comparazione
        BigDecimal totaleCarrello = BigDecimal.ZERO;

        while (prodottiInseriti < numeroProdotti) {
            System.out.println("----Inserimento prodotto " + (prodottiInseriti + 1) + " di " + numeroProdotti);
            System.out.println("Che prodotto desideri acquistare?");
            System.out.println("1: Smarthphone");
            System.out.println("2: Televisione");
            System.out.println("3: Cuffie");
            System.out.println("Scegli un opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            int codice;
            String nome;
            String marca;
            double prezzo;
            double iva;

            if (scelta >= 1 && scelta <= 3) {
                System.out.print("Inserisci il codice del prodotto: ");
                codice = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Inserisci il nome del prodotto: ");
                nome = scanner.nextLine();

                System.out.print("Inserisci la marca del prodotto: ");
                marca = scanner.nextLine();

                System.out.print("Inserisci il prezzo base del prodotto: ");
                prezzo = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Inserisci l'IVA del prodotto (%): ");
                iva = scanner.nextDouble();
                scanner.nextLine();

                switch (scelta) {
                    case 1:
                        // Logica per inserire uno Smartphone
                        System.out.print("Inserisci il codice IMEI dello Smartphone: ");
                        String imei = scanner.nextLine();

                        System.out.print("Inserisci la memoria in GB dello Smartphone: ");
                        int memoriaGB = scanner.nextInt();
                        scanner.nextLine();

                        Smartphone smartphone = new Smartphone(codice, nome, marca, prezzo, iva, imei, memoriaGB);
                        carrello[prodottiInseriti] = smartphone;
                        System.out.println("Smartphone aggiunto al carrello!");
                        prodottiInseriti++;
                        break;
                    case 2:
                        // Logica per inserire un Televisore
                        System.out.print("Inserisci l'altezza del Televisore (cm): ");
                        float altezza = scanner.nextFloat();
                        scanner.nextLine();

                        System.out.print("Inserisci la larghezza del Televisore (cm): ");
                        float larghezza = scanner.nextFloat();
                        scanner.nextLine();

                        System.out.print("Inserisci lo spessore del Televisore (cm): ");
                        float spessore = scanner.nextFloat();
                        scanner.nextLine();

                        System.out.print("Il Televisore è Smart? (true/false): ");
                        boolean smart = scanner.nextBoolean();
                        scanner.nextLine();

                        Televisori televisore = new Televisori(codice, nome, marca, prezzo, iva, altezza, larghezza,
                                spessore, smart);
                        carrello[prodottiInseriti] = televisore;
                        System.out.println("Televisore aggiunto al carrello!");
                        prodottiInseriti++;
                        break;
                    case 3:
                        // Logica per inserire delle Cuffie
                        System.out.print("Inserisci il colore delle Cuffie: ");
                        String colore = scanner.nextLine();

                        System.out.print("Le Cuffie sono wireless? (true/false): ");
                        boolean wireless = scanner.nextBoolean();
                        scanner.nextLine();

                        System.out.print("Le Cuffie sono cablate? (true/false): ");
                        boolean cablate = scanner.nextBoolean();
                        scanner.nextLine();

                        Cuffie cuffie = new Cuffie(codice, nome, marca, prezzo, iva, colore, wireless, cablate);
                        carrello[prodottiInseriti] = cuffie;
                        System.out.println("Cuffie aggiunte al carrello!");
                        prodottiInseriti++;
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova con un altro prodotto.");
                }
            }
        }

        System.out.println("Possiedi una carta fedeltà? (si/no): ");
        String cartaFedelta = scanner.nextLine().toLowerCase();
        boolean isCartaFedelta = cartaFedelta.equals("si");

        System.out.println("Contenuto Carrello");
        if (prodottiInseriti == 0) {
            System.out.println("Il carrello è vuoto");
        } else {
            for (int i = 0; i < prodottiInseriti; i++) {
                Prodotto prodotti = carrello[i];
                System.out.println(prodotti.toString());

                if (isCartaFedelta) {
                    BigDecimal prezzoScontato = prodotti.getPrezzoScontato();
                    BigDecimal ivaScontato = prezzoScontato
                            .multiply(prodotti.getIva().divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
                    BigDecimal prezzoFinale = prezzoScontato.add(ivaScontato).setScale(2, RoundingMode.HALF_UP);

                    System.out.println("Prezzo scontato con IVA: $" + prezzoFinale);
                    totaleCarrello = totaleCarrello.add(prezzoFinale);
                } else {
                    BigDecimal prezzoFinaleIva = prodotti.getPrezzoIva();
                    System.out.println("Prezzo con IVA: $" + prezzoFinaleIva);
                    totaleCarrello = totaleCarrello.add(prezzoFinaleIva);
                }
            }
            System.out.println("Totale carrello: $" + totaleCarrello.setScale(2, RoundingMode.HALF_UP));
        }
        scanner.close();
    }
}