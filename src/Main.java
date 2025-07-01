public class Main {

    public static void main(String[] args) {
        System.out.println("----Prodotti disponibili----");

        // Prodotto base per prova
        System.out.println("---Prodotto generico");
        Prodotto productGeneric = new Prodotto(1001, "Tastiera", "Logitech", 100.00, 22);
        System.out.println(productGeneric.toString());

        // smartphone
        System.out.println("---Smartphone");
        Smartphone pixel7Pro = new Smartphone(1555, "Pixel 7 Pro", "Pixel", 690.00, 22, "abchedhglofg", 256);
        System.out.println(pixel7Pro.toString());

        // televisione
        System.out.println("---TV");
        Televisori samsung = new Televisori(7845, "SamsungBH", "Samsung", 1099.00, 22, 80, 140, 12, true);
        System.out.println(samsung.toString());
        if (samsung.getSmart()) {
            System.out.println("Questa tv è smart!");
        } else {
            System.out.println("no non lo è");
        }

        // cuffie
        System.out.println("---Cuffie");
        Cuffie trustGaming = new Cuffie(1205, "Cuffie da Gaming", "Trust", 24.99, 22, "nero", false, true);
        System.out.println(trustGaming.toString());
        if (trustGaming.getWireless() && !trustGaming.getCablate()) {
            System.out.println("Queste cuffie sono solo Wireless");
        } else if (!trustGaming.getWireless() && trustGaming.getCablate()) {
            System.out.println("Queste cuffie sono solo Cablate");
        } else if (trustGaming.getWireless() && trustGaming.getCablate()) {
            System.out.println("Queste cuffie sono sia Wireless che Cablate");
        }

    }
}
