package numbers;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Liczba {
    long liczba;

    public Liczba(long liczba) {
        this.liczba = liczba;
    }


    boolean naturalnaLiczba() {
        return liczba > 0;
    }
    boolean parzystaLiczba() {
        return liczba % 2 == 0;
    }
    boolean nieparzystaLiczba() {
        return liczba % 2 != 0;
    }
    boolean podzielnePrzez7() {
        return liczba % 7 == 0;
    }
    boolean konczyNa7() {
        StringBuilder sprawdz = new StringBuilder();
        sprawdz.append(liczba);
        sprawdz.reverse();
        return sprawdz.charAt(0) == '7';
    }

    boolean buzzLiczba () { // Buzz to liczba podzielna przez 7 lub kończąca sie na 7, np 14 jest, 32147 jest, 706 nie jest
        return podzielnePrzez7() || konczyNa7();
    }
    boolean duckLiczba() { // Duck to liczba która zawiera w sobie zero które nie jest na początku, np 132053 jest, 0123 nie jest
        StringBuilder sprawdz = new StringBuilder();
        sprawdz.append(liczba);

        for (int i = 1; i < sprawdz.length(); i++) { // sprawdzanie czy ma 0 (nie licząc poczatku)
            if (sprawdz.charAt(i) == '0') {
                return true;
            }
        }return false;
    }
    boolean palindromicLiczba() { //Sprawdzanie czy jest symetryczna
        String liczbaStr = Long.toString(liczba);
        StringBuilder odwroconaLiczb = new StringBuilder();
        for(int i = liczbaStr.length() - 1; i >= 0; i--) {
            odwroconaLiczb.append(liczbaStr.charAt(i));
        }
        return liczbaStr.equals(odwroconaLiczb.toString());
    }
    boolean gapfulLiczba() { //sprawdzanie czy pierwsza * 10 i ostatnia cyfra dzieli liczbe
        if (minTrzy()) {
            StringBuilder sprawdz = new StringBuilder();
            StringBuilder odwroc = new StringBuilder();
            sprawdz.append(liczba);
            odwroc.append(liczba).reverse();
            return (liczba % ((sprawdz.charAt(0) - 48) * 10 + (odwroc.charAt(0) - 48))) == 0;
        } else return false;
    }
    boolean minTrzy() {
        return liczba >= 100;
    }
    boolean spyLiczba() { //  sprawdzanie czy suma cyfr w liczbie jest równa iloczynowi
        StringBuilder sprawdz = new StringBuilder();
        sprawdz.append(liczba);
        int suma = 0;
        int iloczyn = 1;
        for (int i = 0; i < sprawdz.length(); i++) {
            suma += sprawdz.charAt(i) - 48;
            iloczyn *= sprawdz.charAt(i) - 48;
        }
        return suma == iloczyn;
    }
    boolean squareLiczba() { // Sprawdzanie czy liczba jest perfekcyjnie kwadratowa tzn czy pierwiastek z liczby da liczbe, np sqrt(9) = 3, 3*3 = 9
        int liczba1 = (int) Math.sqrt(liczba);
        return (long) liczba1 * liczba1 == liczba;
    }
    boolean sunnyLiczba() { // sprawdzanie czy liczba jest perfekcyjnie kwadratowa jezeli doda się do niej 1
        int liczba1 = (int) Math.sqrt(liczba);
        return (long) (liczba1 + 1) * (liczba1 + 1) == liczba + 1;
    }
    boolean jumpingLiczba() { // Sprawdzanie czy kazda cyfra obok jest większa/mniejsza o 1
            if (liczba < 10) {
                return true;
            }
            char[] sprawdz = Long.toString(liczba).toCharArray();
            for (int i = 1; i < sprawdz.length; i++) {
                if (Math.abs(sprawdz[i] - sprawdz[i-1]) != 1) {
                    return false;
                }
            }
            return true;
    }
    boolean happyLiczba() { // Sprawdzanie czy liczba po rozłożeniu na sposob: np 13: 1^2 + 3^2 = 10 -> 1^2 + 0^2 = 1, jezeli liczba rowna sie 1 po sekwencji to jest szczęśliwa
        StringBuilder sprawdz = new StringBuilder();
        sprawdz.append(liczba);
        int suma = 0;
        int licz = 0;
        while (true) {
            for (int i = 0; i < sprawdz.length(); i++) {
                suma += Math.pow(Character.getNumericValue(sprawdz.charAt(i)), 2);
            }
            licz++;
            if (suma == 1 || licz > 8) {
                break;
            } else {
                sprawdz = new StringBuilder(String.valueOf(suma));
                suma = 0;
            }
        }
        return suma == 1;
    }
    void sprawdzLiczbe() {
        NumberFormat formatuj = NumberFormat.getInstance(new Locale("en", "US")); // Formatowanie outputu z np. 3214356 na 3,214,356
        System.out.println("Rodzaje liczby " + formatuj.format(liczba));
        if (naturalnaLiczba()) {
            if (buzzLiczba()) {
                System.out.println("        Buzz: true");
            }
            else {
                System.out.println("        Buzz: false");
            }
            if (duckLiczba()) {
                System.out.println("        duck: true");
            }
            else {
                System.out.println("        duck: false");
            }
            if (palindromicLiczba()) {
                System.out.println("        palindromic: true");
            }
            if (!palindromicLiczba()) {
                System.out.println("        palindromic: false");
            };
            if (gapfulLiczba()) {
                System.out.println("        gapful: true");
            } else {
                System.out.println("        gapful: false");
            }
            if (spyLiczba()) {
                System.out.println("        spy: true");
            }
            else {
                System.out.println("        spy: false");
            }
            if (parzystaLiczba()) {
                System.out.println("        even: true");
                System.out.println("        odd:  false");
            }
            else {
                System.out.println("        even: false");
                System.out.println("        odd:  true");
            }
            if (sunnyLiczba()) {
                System.out.println("        sunny: true");
            }
            else {
                System.out.println("        sunny: false");
            }
            if (squareLiczba()) {
                System.out.println("        square: true");
            }
            else {
                System.out.println("        square: false");
            }
            if (jumpingLiczba()) {
                System.out.println("        jumping: true");
            }
            else {
                System.out.println("        jumping: false");
            }
            if (happyLiczba()) {
                System.out.println("        happy: true");
                System.out.println("        sad: false");
            }
            if (!happyLiczba()) {
                System.out.println("        sad: true");
                System.out.println("        happy: false");
            }
            System.out.println();
        }
    }
    void sprawdzLiczby() {
        System.out.print(liczba + " jest ");
        if (buzzLiczba()) {
            System.out.print("buzz, ");
        };
        if (duckLiczba()) {
            System.out.print("duck, ");
        };
        if (gapfulLiczba()) {
            System.out.print("gapful, ");
        };
        if (palindromicLiczba()) {
            System.out.print("palindromic, ");
        };
        if (parzystaLiczba()) {
            System.out.print("even, ");
        };
        if (!parzystaLiczba()) {
            System.out.print("odd, ");
        };
        if (spyLiczba()) {
            System.out.print("spy, ");
        };
        if (sunnyLiczba()) {
            System.out.print("Sunny, ");
        };
        if (squareLiczba()) {
            System.out.print("square, ");
        };
        if (jumpingLiczba()) {
            System.out.print("jumping, ");
        };
        if (happyLiczba()) {
            System.out.print("happy, ");
        };
        if (!happyLiczba()) {
            System.out.print("sad, ");
        }
        System.out.println();
    }

    public boolean szukajRodzajow(String tablicaRodzajow) {
        return switch (tablicaRodzajow.toLowerCase()) {
            case "even" -> parzystaLiczba();
            case "odd" -> nieparzystaLiczba();
            case "buzz" -> buzzLiczba();
            case "duck" -> duckLiczba();
            case "palindromic" -> palindromicLiczba();
            case "gapful" -> gapfulLiczba();
            case "spy" -> spyLiczba();
            case "square" -> squareLiczba();
            case "sunny" -> sunnyLiczba();
            case "jumping" -> jumpingLiczba();
            case "happy" -> happyLiczba();
            case "sad" -> !happyLiczba();
            default -> false;
        };
    }

    void drukujRodzaje() {
        System.out.print(liczba + " is ");
        if (parzystaLiczba()) {
            System.out.print("even, ");
        }
        if (nieparzystaLiczba()) {
            System.out.print("odd, ");
        }
        if (buzzLiczba()) {
            System.out.print("buzz, ");
        }
        if (duckLiczba()) {
            System.out.print("duck, ");
        }
        if (gapfulLiczba()) {
            System.out.print("gapful, ");
        }
        if (palindromicLiczba()) {
            System.out.print("palindromic, ");
        }
        if (spyLiczba()) {
            System.out.print("spy, ");
        }
        if (squareLiczba()) {
            System.out.print("square, ");
        }
        if (sunnyLiczba()) {
            System.out.print("sunny, ");
        }
        if (jumpingLiczba()) {
            System.out.print("jumping, ");
        }
        if (happyLiczba()) {
            System.out.print("happy, ");
        }
        if (!happyLiczba()) {
            System.out.print("sad");
        }
        System.out.println();
    }
     boolean zlyRodzaj(String rodzaj) { // Sprawdzanie czy dobrze wpisano nazwę rodzaju
        return !rodzaj.equals("even") && !rodzaj.equals("odd") && !rodzaj.equals("buzz")
                && !rodzaj.equals("duck") && !rodzaj.equals("palindromic") && !rodzaj.equals("gapful")
                && !rodzaj.equals("spy") && !rodzaj.equals("square") && !rodzaj.equals("sunny")
                && !rodzaj.equals("jumping") && !rodzaj.equals("happy") && !rodzaj.equals("sad");
    }
     void liczbyZKilkomaRodzajami(long wpiszLiczbe, long ileRazy, String[] tablicaRodzajow) {
         int bledy = 0;
         ArrayList<String> listaBledow = new ArrayList<>();
         for (String s : tablicaRodzajow) { // Szukanie ilosci blednych odpowiedzi
             if (zlyRodzaj(s.toLowerCase())) {
                 bledy++;
                 listaBledow.add(s);
             }
         }
                if (bledy > 1) { // Jezeli kilka to:
                    System.out.print("Rodzaje [");
                    for (int i = 0; i < listaBledow.size(); i++) {
                        if (i == listaBledow.size() - 1) {
                            System.out.print(listaBledow.get(i).toUpperCase());
                        } else {
                            System.out.print(listaBledow.get(i).toUpperCase() + ", ");
                        }
                    }
                    System.out.println("] są złe.");
                    System.out.println("Możliwe rodzaje: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                    return;
                }
                if (bledy == 1) { // jeżeli jedna to
                    System.out.println("Rodzaj [" + listaBledow.get(0).toUpperCase() + "] jest zły.");
                    System.out.println("Możliwy rodzaj: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                    return;
                }
         for (long k = 0; k < ileRazy; wpiszLiczbe++) { // Ilość możliwych wpisanych rodzajów naraz
             Liczba liczba = new Liczba(wpiszLiczbe);
             if (tablicaRodzajow.length == 1) {
                 if (liczba.szukajRodzajow(tablicaRodzajow[0])) {
                     liczba.drukujRodzaje();
                     k++;
                 }
             }
             if (tablicaRodzajow.length == 2) {
                 if (liczba.szukajRodzajow(tablicaRodzajow[0]) && liczba.szukajRodzajow(tablicaRodzajow[1])) {
                     liczba.drukujRodzaje();
                     k++;
                 }
             }
             if (tablicaRodzajow.length == 3) {
                 if (liczba.szukajRodzajow(tablicaRodzajow[0]) && liczba.szukajRodzajow(tablicaRodzajow[1])
                    && liczba.szukajRodzajow(tablicaRodzajow[2])) {
                     liczba.drukujRodzaje();
                     k++;
                 }
             }
             if (tablicaRodzajow.length == 4) {
                 if (liczba.szukajRodzajow(tablicaRodzajow[0]) && liczba.szukajRodzajow(tablicaRodzajow[1])
                         && liczba.szukajRodzajow(tablicaRodzajow[2]) && liczba.szukajRodzajow(tablicaRodzajow[3])) {
                     liczba.drukujRodzaje();
                     k++;
                 }
             }
         }
    }
     Boolean wykluczajaceSie(String[] tab) { // Sprawdza czy jedno nie wyklucza drugiego np. Parzyste i nieparzyste
         for (String rodzaj1 : tab) {
             for (String rodzaj2 : tab) {
                 if (rodzaj1.equals("even") && rodzaj2.equals("odd")
                         || (rodzaj1.equals("odd") && rodzaj2.equals("even"))) {
                     System.out.println("""
                             Propozycja zawiera wykluczające się rodzaje: [ODD, EVEN]
                             Nie ma takich cyfr.""");
                     return true;
                 }
                 if (rodzaj1.equals("duck") && rodzaj2.equals("spy")
                         || (rodzaj1.equals("spy") && rodzaj2.equals("duck"))) {
                     System.out.println("""
                             Propozycja zawiera wykluczające się rodzaje: [DUCK, SPY]
                             Nie ma takich cyfr.""");
                     return true;
                 }
                 if (rodzaj1.equals("sunny") && rodzaj2.equals("square")
                         || (rodzaj1.equals("square") && rodzaj2.equals("sunny"))) {
                     System.out.println("""
                             Propozycja zawiera wykluczające się rodzaje: [SUNNY, SQUARE]
                             Nie ma takich cyfr.""");
                     return true;
                 }
                 if (rodzaj1.equals("happy") && rodzaj2.equals("sad")
                         || (rodzaj1.equals("sad") && rodzaj2.equals("happy"))) {
                     System.out.println("""
                             Propozycja zawiera wykluczające się rodzaje: [HAPPY, SAD]
                             Nie ma takich cyfr.""");
                     return true;
                 }
             }
         }
        return false;
    }
}
