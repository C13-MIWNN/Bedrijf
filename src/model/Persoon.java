package model;

/**
 * @author Vincent Velthuizen
 *
 * Dit is een persoon betrokken bij de activiteiten van ons bedrijf
 **/
public class Persoon {
    public static final double GRENSWAARDE_BONUS = 4500.00;

    private static final String DEFAULT_NAAM = "Onbekend";
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final double DEFAULT_MAAND_SALARIS = 0.0;

    public static int aantalPersonen = 0;

    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private double maandSalaris;

    public Persoon(String naam, String woonplaats, double maandSalaris) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        setMaandSalaris(maandSalaris);
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, DEFAULT_MAAND_SALARIS);
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public double berekenJaarInkomen() {
        return 12 * maandSalaris;
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public double getMaandSalaris() {
        return maandSalaris;
    }

    private void setMaandSalaris(double hetNieuweMaandsalaris) {
        if (hetNieuweMaandsalaris < 0) {
            System.err.println("Het opgegeven maandsalaris is niet geldig, het mag geen negatief getal zijn. " +
                    "Maandsalaris wordt op 0 gezet");
            this.maandSalaris = DEFAULT_MAAND_SALARIS;
        } else {
            this.maandSalaris = hetNieuweMaandsalaris;
        }
    }
}
