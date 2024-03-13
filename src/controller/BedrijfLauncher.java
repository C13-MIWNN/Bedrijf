package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 *
 * Maak personen aan binnen mijn bedrijf
 **/
public class BedrijfLauncher {

    public static void main(String[] args) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        try (Scanner afdelingenBestand = new Scanner(new File("resources/Afdelingen.txt"))) {
            while (afdelingenBestand.hasNextLine()) {
                String afdelingsNaam = afdelingenBestand.nextLine();
                String afdelingsPlaats = afdelingenBestand.nextLine();

                afdelingen.add(new Afdeling(afdelingsNaam, afdelingsPlaats));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het afdelingen bestand kon niet gevonden worden.");
        }

        ArrayList<Persoon> personen = new ArrayList<>();

        try (Scanner personenBestand = new Scanner(new File("resources/Personen.csv"))) {
            while (personenBestand.hasNextLine()) {
                String[] persoonsInformatie = personenBestand.nextLine().split(",");

                String type = persoonsInformatie[0];
                String naam = persoonsInformatie[1];
                String woonplaats = persoonsInformatie[2];
                int afdelingsNummer = Integer.parseInt(persoonsInformatie[3]);
                double ietsMetGeld = Double.parseDouble(persoonsInformatie[4]);

                switch (type) {
                    case "Werknemer":
                        personen.add(new Werknemer(naam, woonplaats, afdelingen.get(afdelingsNummer), ietsMetGeld));
                        break;
                    case "Zzper":
                        personen.add(new Zzper(naam, woonplaats, afdelingen.get(afdelingsNummer), ietsMetGeld));
                        break;
                    case "Vrijwilliger":
                        personen.add(new Vrijwilliger(naam, woonplaats, afdelingen.get(afdelingsNummer)));
                        break;
                    default:
                        System.err.println("Onbekend persoonstype tegengekomen, geen persoon aangemaakt: "
                                + Arrays.toString(persoonsInformatie));
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het personen bestand kon niet gevonden worden.");
        }

        Collections.sort(personen);
        for (Persoon persoon : personen) {
            System.out.println(persoon);
        }

        try (PrintWriter personenSchrijver = new PrintWriter("resources/PersonenPerAfdeling.txt")) {
            for (Afdeling afdeling : afdelingen) {
                personenSchrijver.printf("Afdeling: %s\n", afdeling.getAfdelingsNaam());

                for (Persoon persoon : personen) {
                    if (persoon.getAfdeling().equals(afdeling)) {
                        personenSchrijver.printf("-- %s\n", persoon);
                    }
                }

                personenSchrijver.println();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het is niet gelukt het personenbestand te openen om in te schrijven");
        }
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }

}
