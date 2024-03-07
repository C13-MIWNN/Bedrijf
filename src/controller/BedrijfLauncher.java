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

        String krijgtBonus = "geen";
        if (baas.heeftRechtOpBonus()) {
            krijgtBonus = "wel";
        }
        System.out.printf("%s heeft %s recht op bonus.\n", baas.getNaam(), krijgtBonus);

        System.out.println(baas.geefPersoonsInformatie());
        System.out.println(medewerker.geefPersoonsInformatie());
        System.out.println(assistent.geefPersoonsInformatie());
        System.out.println(manager.geefPersoonsInformatie());
    }

}
