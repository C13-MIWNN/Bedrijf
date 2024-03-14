package controller;

import database.AfdelingDAO;
import database.DBaccess;
import database.WerknemerDAO;
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
 * <p>
 * Maak personen aan binnen mijn bedrijf
 **/
public class BedrijfLauncher {

    public static void main(String[] args) {
        DBaccess dBaccess = new DBaccess("Bedrijf", "userBedrijf", "userBedrijfPW");
        WerknemerDAO werknemerDAO = new WerknemerDAO(dBaccess);

        dBaccess.openConnection();

        werknemerDAO.slaWerknemerOp(new Werknemer("Lodewijk", "Zaandam",
                new Afdeling("Support", "Amsterdam"), 2500));

        dBaccess.closeConnection();
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }

}
