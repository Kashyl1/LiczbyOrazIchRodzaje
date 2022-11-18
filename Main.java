package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean program = true;
        menu();
        System.out.println();
        while (program) {
            try {
                System.out.print("Wprowadź propozycje, np(15 3 buzz even): ");
                Scanner scanner = new Scanner(System.in);
                String asd = scanner.nextLine();
                String[] liczby1;
                long wpiszLiczbe;
                long ileRazy;
                liczby1 = asd.split(" ");
                if (liczby1.length == 1) { // wpisanie np. 15 - sprawdza rodzaje liczby
                        wpiszLiczbe = Long.parseLong(liczby1[0]);
                        if (wpiszLiczbe < 0) {
                            System.out.println("Pierwszy parametr powinien być liczbą naturalną bądź równą 0.");
                        }
                        if (wpiszLiczbe == 0) {
                            System.out.println("Żegnaj!");
                            program = false;
                        } else {
                            Liczba liczba = new Liczba(wpiszLiczbe);
                            liczba.sprawdzLiczbe();
                        }
                    }
                if (liczby1.length == 2) { // Wpisanie np 15 5 - sprawdza rodzaje w zakresie od 15 do 5 wyżej
                        wpiszLiczbe = Long.parseLong(liczby1[0]);
                        ileRazy = Long.parseLong(liczby1[1]);
                        if (wpiszLiczbe < 0) {
                            System.out.println("Pierwszy parametr powinien być liczbą naturalną bądź równą 0.");
                        }
                        if (ileRazy < 0) {
                            System.out.println("Drugi parametr powinien być liczbą naturalną.");
                        }
                        for (long koniec = wpiszLiczbe + ileRazy; wpiszLiczbe < koniec; wpiszLiczbe++) {
                            Liczba liczba1 = new Liczba(wpiszLiczbe);
                            liczba1.sprawdzLiczby();
                        }
                    }
                if (liczby1.length >= 3) { // Sprawdza czy są wpisane rodzaje, np 15 3 square
                    wpiszLiczbe = Long.parseLong(liczby1[0]);
                    ileRazy = Long.parseLong(liczby1[1]);
                    StringBuilder sprawdz = new StringBuilder();
                    for (int i = 2; i < liczby1.length; i++) {
                        if (i == liczby1.length - 1) {
                            sprawdz.append(liczby1[i]);
                        } else {
                            sprawdz.append(liczby1[i]).append(" ");
                        }

                    }
                    String[] tab = sprawdz.toString().split(" ");
                    if (wpiszLiczbe < 0) {
                        System.out.println("Pierwszy parametr powinien być liczbą naturalną bądź równą 0.");
                    }
                    if (ileRazy < 0) {
                        System.out.println("Drugi parametr powinien być liczbą naturalną.");
                    }
                        Liczba liczba = new Liczba(wpiszLiczbe);
                        if (!liczba.wykluczajaceSie(tab)) {
                            liczba.liczbyZKilkomaRodzajami(wpiszLiczbe, ileRazy, tab);
                        }

                }
            } catch (NumberFormatException e) {
                System.out.println("Źle wpisałeś, spróbuj ponownie np (10 5 odd spy");
            }
        }
    }
    public static void menu() {
        System.out.println(""" 
                Witaj!
                Obsługa:
                - Wpisz naturalną liczbe by poznać jej rodzaje;
                - Wpisz dwie naturalne liczby by poznać rodzaje przedziału od pierwszej wpisanej do pierwszej wpisanej + drugiej:
                * Pierwszy parametr reprezentuje liczbe początkową;
                * Drugi parametr pokazuje o ile ma się zwiększać i pokazywać parametry liczba początkowa;
                - Dwie naturalne liczby i ich rodzaje by zawęźlić poszukiwania;
                - Oddzielaj wszystko spacją!;
                - Wpisz 0 by zakończyć.""");
    }


}
