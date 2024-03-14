package database;

import model.Werknemer;

import java.sql.SQLException;

/**
 * @author Vincent Velthuizen
 **/
public class WerknemerDAO extends AbstractDAO {
    public WerknemerDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaWerknemerOp(Werknemer werknemer) {
        int personeelsnummer = new PersoonDAO(dBaccess).slaPersoonOp(werknemer);

        String sql = "INSERT INTO werknemer (personeelsnummer, maandsalaris) VALUES (?, ?);";

        try {
            setupPreparedStatement(sql);

            preparedStatement.setInt(1, personeelsnummer);
            preparedStatement.setDouble(2, werknemer.getMaandSalaris());

            executeManipulateStatement();
        } catch (SQLException sqlException) {
            System.err.println(DBaccess.SQL_EXCEPTION + sqlException.getMessage());
        }
    }
}
