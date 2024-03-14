package model;

/**
 * @author Vincent Velthuizen
 *
 * Een persoon die in dienst is bij mijn bedrijf
 **/
public class Werknemer extends Persoon {
    private static final double GRENSWAARDE_BONUS = 4500.00;

    private static final double DEFAULT_MAAND_SALARIS = 0.0;
    private static final int AANTAL_MAANDEN_PER_JAAR = 12;

    private double maandSalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandSalaris) {
        super(naam, woonplaats, afdeling);
        setMaandSalaris(maandSalaris);
    }

    public Werknemer(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling(), DEFAULT_MAAND_SALARIS);
    }

    public Werknemer() {
        this(DEFAULT_NAAM);
    }

    @Override
    public double berekenJaarInkomen() {
        double jaarInkomen =  AANTAL_MAANDEN_PER_JAAR * maandSalaris;

        if (heeftRechtOpBonus()) {
            jaarInkomen += maandSalaris;
        }

        return jaarInkomen;
    }

    @Override
    public String toString() {
        return String.format("%s en is een werknemer %s recht op een bonus",
                super.toString(), heeftRechtOpBonus() ? "met" : "zonder");
    }

    public boolean heeftRechtOpBonus() {
        return maandSalaris >= GRENSWAARDE_BONUS;
    }

    public double getMaandSalaris() {
        return maandSalaris;
    }

    private void setMaandSalaris(double hetNieuweMaandsalaris) {
        if (hetNieuweMaandsalaris < 0) {
            throw new IllegalArgumentException("Het maandsalaris mag niet negatief zijn");
        }

        this.maandSalaris = hetNieuweMaandsalaris;
    }
}
