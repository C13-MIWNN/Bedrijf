package model;

/**
 * @author Vincent Velthuizen
 *
 * Een persoon binnen ons bedrijf die niet betaald krijgt
 **/
public class Vrijwilliger extends Persoon implements Oproepbaar {
    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling) {
        super(naam, woonplaats, afdeling);
        this.urenGewerkt = 0;
    }

    @Override
    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    @Override
    public double berekenJaarInkomen() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " en is een vrijwilliger";
    }
}
