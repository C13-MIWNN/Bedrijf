package database;

import model.Afdeling;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Vincent Velthuizen
 * Haal afdelingen uit en zet ze in de DB
 **/
public class AfdelingDAO {
    private final DBaccess dBaccess;

    public AfdelingDAO(DBaccess dBaccess) {
        this.dBaccess = dBaccess;
    }

    public void slaAfdelingOp(Afdeling afdeling) {
        String sql = "INSERT INTO afdeling VALUES (?, ?);";

        try {
            PreparedStatement preparedStatement = dBaccess.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, afdeling.getAfdelingsNaam());
            preparedStatement.setString(2, afdeling.getAfdelingsPlaats());

            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.err.println(DBaccess.SQL_EXCEPTION + sqlException.getMessage());
        }
    }
}
