package model;

/**
 * @author Vincent Velthuizen
 *
 * Dit is een persoon betrokken bij de activiteiten van ons bedrijf
 **/
public abstract class Persoon implements Comparable<Persoon> {
    public static final double GRENSWAARDE_BONUS = 4500.00;

    protected static final String DEFAULT_NAAM = "Onbekend";
    protected static final String DEFAULT_WOONPLAATS = "Onbekend";

    public static int aantalPersonen = 0;

    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private Afdeling afdeling;

    public Persoon(String naam, String woonplaats, Afdeling afdeling) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.afdeling = afdeling;
        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public abstract double berekenJaarInkomen();

    @Override
    public int compareTo(Persoon anderePersoon) {
        return this.naam.compareTo(anderePersoon.naam);
    }

    @Override
    public String toString() {
        return String.format("%s woont in %s en werkt op %s", this.naam, this.woonplaats, this.afdeling);
    }

    public String getNaam() {
        return naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }
}
