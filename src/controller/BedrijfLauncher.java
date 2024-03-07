package controller;

import model.Persoon;

/**
 * @author Vincent Velthuizen
 *
 * Maak personen aan binnen mijn bedrijf
 **/
public class BedrijfLauncher {

    public static void main(String[] args) {
        System.out.println(Persoon.aantalPersonen);
        Persoon baas = new Persoon("Mark", "Den Haag", 10000);
        System.out.println(Persoon.aantalPersonen);
        System.out.println(baas.getPersoneelsNummer());
        Persoon medewerker = new Persoon("Caroline", "Delft", 4000);
        System.out.println(Persoon.aantalPersonen);
        System.out.println(medewerker.getPersoneelsNummer());
        Persoon assistent = new Persoon ("Klaas");
        Persoon manager = new Persoon();
        System.out.println(Persoon.aantalPersonen);

        printPersoonsInformatie(baas);
        printPersoonsInformatie(medewerker);
        printPersoonsInformatie(assistent);
        printPersoonsInformatie(manager);
    }

    public static void printPersoonsInformatie(Persoon persoon) {
        System.out.printf("%s verdient %.2f en woont in %s en heeft %s recht op een bonus.\n",
                persoon.getNaam(),persoon.getMaandSalaris(), persoon.getWoonplaats(),
                persoon.heeftRechtOpBonus() ? "wel" : "geen");
    }

}
