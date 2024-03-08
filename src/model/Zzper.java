package model;

/**
 * @author Vincent Velthuizen
 *
 * Personen die incidenteel ingehuurd worden door ons bedrijf
 **/
public class Zzper extends Persoon {
    private double uurtarief;
    private int urenGewerkt;

    public Zzper(String naam, String woonplaats, Afdeling afdeling, double uurtarief) {
        super(naam, woonplaats, afdeling);
        this.uurtarief = uurtarief;
        this.urenGewerkt = 0;
    }

    @Override
    public double berekenJaarInkomen() {
        return urenGewerkt * uurtarief;
    }

    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    @Override
    public String toString() {
        return String.format("%s en is een zzp-er met een uurtarief van %s", super.toString(), this.uurtarief);
    }
}
