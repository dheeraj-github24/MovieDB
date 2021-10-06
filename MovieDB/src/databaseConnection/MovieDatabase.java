package databaseConnection;

import java.sql.SQLException;

/**
 *
 * @author Dheeraj
 */
public class MovieDatabase {

    public static void main(String[] args) throws SQLException {

        databaseOperations objOper = new databaseOperations();

        //creating the database
        objOper.createNewDatabase("movies.db");

        //creating the table
        objOper.createNewTable("MovieDetails");

        //Inserting data into MovieDetails Table
        objOper.insert(1000, "Maharshi", "Mahesh Babu", "Pooja Hegde", 2019, "Vamshi Paidpally");
        objOper.insert(1001, "Yuvarathnaa", "Puneeth Rajkumar", "Sayyeshaa", 2021, "Santhosh Ananddram");
        objOper.insert(1002, "Pailwaan", "Sudeep", "Aakanksha Singh", 2019, "S. Krishna");
        objOper.insert(1003, "Zero", "Shah Rukh Khan", "Katrina Kaif", 2018, "Aanand L. Rai");
        objOper.insert(1004, "PK", "Aamir Khan", "Anushka Sharma", 2014, "Rajkumar Hirani");
        objOper.insert(1005, "My Autograph", "Sudeep", "Meena", 2006, "Sudeep");

        //Retrieving All the data from the MovieDetails Table
        objOper.SelectAll();
        
        //Retrieving data from Movies table with specific Lead Actor name
        objOper.selectMovieByActor("Mahesh Babu");
    }
}