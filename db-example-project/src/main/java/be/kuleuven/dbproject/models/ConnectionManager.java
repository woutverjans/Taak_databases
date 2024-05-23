package be.kuleuven.dbproject.models;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
    private Connection connection;
    Statement s = null;

    public void createDb() throws SQLException {
        try{
            connection = DriverManager.getConnection("jbdc:sqlite:mydb.db"); //TODO juiste database gebruiken
        } catch (SQLException e){
            throw new RuntimeException();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                throw new RuntimeException(); //Sluit dit de db al terug af?
            }
        }
    }
}