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
public class databaseOperations {

    public void createNewDatabase(String newDB) throws SQLException {
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

    public void createNewTable(String table) {

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
    
    public void selectMovieByActor(String leadActor) throws SQLException{
        String sql = "select *from MovieDetails where leadActor = '"+leadActor+"'";
        
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
         }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
