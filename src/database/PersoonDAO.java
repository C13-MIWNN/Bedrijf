package database;

import model.Persoon;

import java.sql.SQLException;

/**
 * @author Vincent Velthuizen
 **/
public class PersoonDAO extends AbstractDAO {
    public PersoonDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public int slaPersoonOp(Persoon persoon) {
        String sql = "INSERT INTO persoon (naam, woonplaats, afdeling) VALUES (?, ?, ?);";

        try {
            setupPreparedStatementWithKey(sql);

            preparedStatement.setString(1, persoon.getNaam());
            preparedStatement.setString(2, persoon.getWoonplaats());
            preparedStatement.setString(3, persoon.getAfdeling().getAfdelingsNaam());

            return executeInsertStatementWithKey();
        } catch (SQLException sqlException) {
            System.err.println(DBaccess.SQL_EXCEPTION + sqlException.getMessage());
        }

        throw new IllegalArgumentException("Kon deze persoon niet opslaan");
    }
}
