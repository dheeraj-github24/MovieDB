package databaseConnection;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Dheeraj
 */
public class MovieDatabase {

    public static void main(String[] args) throws SQLException {
        
        Scanner strSC = new Scanner(System.in);
        Scanner intSC = new Scanner(System.in);

        databaseOperations objOper = new databaseOperations();

        //creating the database
        objOper.createNewDatabase("movies.db");

        //creating the table
        objOper.createNewTable("Movies");

        //Inserting data into MovieDetails Table
        System.out.println("Enter the number of movies you want to insert");
        int numberOfMovies = intSC.nextInt();
        System.out.println("Enter the details in Order\nMovieID MovieName LeadActor LeadActress YearOfRelease DirectorName");
        for(int i=0; i<numberOfMovies; i++){
            objOper.insert(intSC.nextInt(), strSC.nextLine(), strSC.nextLine(), strSC.nextLine(), intSC.nextInt(), strSC.nextLine());
        }
        
        //Retrieving All the data from the Movie Table
        objOper.SelectAll();
        
        //Retrieving data from Movies table with specific Lead Actor name
        objOper.selectMovieByActor("Sudeep");
    }
}