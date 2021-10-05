package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dheeraj
 */
public class MovieDatabase {

    public static void main(String[] args) throws SQLException {

        MovieDatabase movieDB = new MovieDatabase();

        //creating the database
                createNewDatabase("movies.db");
        
        
        //creating the table
                movieDB.createNewTable("MovieDetails");
        
        
        //Inserting data into MovieDetails Table
                movieDB.insert(1000, "Maharshi", "Mahesh Babu", "Pooja Hegde", 2019, "Vamshi Paidpally");
                movieDB.insert(1001, "Yuvarathnaa", "Puneeth Rajkumar", "Sayyeshaa", 2021, "Santhosh Ananddram");
                movieDB.insert(1002, "Pailwaan", "Sudeep", "Aakanksha Singh", 2019, "S. Krishna");
                movieDB.insert(1003, "Zero", "Shah Rukh Khan", "Katrina Kaif", 2018, "Aanand L. Rai");
                movieDB.insert(1004, "PK", "Aamir Khan", "Anushka Sharma", 2014, "Rajkumar Hirani");
        
                
        //Retrieving All the data from the MovieDetails Table
               movieDB.SelectAll();
    }

    private static void createNewDatabase(String newDB) throws SQLException {
        String url = "jdbc:sqlite:C:\\Users\\user\\Desktop\\MovieDB\\MovieDB\\" + newDB;
        try {
            Connection conn = DriverManager.getConnection(url);
            System.out.println("created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\user\\Desktop\\MovieDB\\MovieDB\\movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private void createNewTable(String table) {

        String sql = "CREATE TABLE " + table + "(\n"
                + "	movieID int PRIMARY KEY NOT NULL,\n"
                + "movieName varchar(20) NOT NULL,\n"
                + "	leadActor varchar(20) NOT NULL,\n"
                + "leadActress varchar(20) NOT NULL,\n"
                + "yearOfRelease varchar(4) NOT NULL,\n"
                + "directorName varchar(20) NOT NULL"
                + ");";

        try (Connection conn = this.connect(); Statement st = conn.createStatement();) {
            st.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(int movieId, String movieName, String leadActor, String leadActress, int yearOfRelease, String directorName) throws SQLException {
        String sql = "Insert into MovieDetails (movieID, movieName, leadActor, leadActress, yearOfRelease, directorName) values(?,?,?,?,?,?)";

        try (Connection conn = this.connect(); PreparedStatement st = conn.prepareStatement(sql);) {
            st.setInt(1, movieId);
            st.setString(2, movieName);
            st.setString(3, leadActor);
            st.setString(4, leadActress);
            st.setInt(5, yearOfRelease);
            st.setString(6, directorName);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void SelectAll() throws SQLException {
        String sql = "Select *from MovieDetails";

        try (Connection conn = this.connect();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("movieID") + "\t"
                        + rs.getString("movieName") + "\t\t"
                        + rs.getString("leadActor") + "\t\t"
                        + rs.getString("leadActress") + "\t\t"
                        + rs.getInt("yearOfRelease") + "\t"
                        + rs.getString("directorName") + "\t\t"
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
