package controller;

import database.AfdelingDAO;
import database.DBaccess;
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
        DBaccess dBaccess = new DBaccess("Bedrijf", "userBedrijf", "userBedrijfPW");
        AfdelingDAO afdelingDAO = new AfdelingDAO(dBaccess);

        dBaccess.openConnection();
        afdelingDAO.slaAfdelingOp(new Afdeling("Robert '); DROP TABLE Student; --", "Groningen"));
        dBaccess.closeConnection();
    }

    public static void toonJaarInkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarInkomen());
    }

}
