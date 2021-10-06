package Model;

/**
 *
 * @author Dheeraj
 */
public class MovieModel {

    private int movieID;
    private String movieName;
    private String leadActor;
    private String leadActress;
    private int yearOfRelease;
    private String directorName;

    public MovieModel(int movieID, String movieName, String leadActor, String leadActress, int yearOfRelease, String directorName) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.leadActor = leadActor;
        this.leadActress = leadActress;
        this.yearOfRelease = yearOfRelease;
        this.directorName = directorName;
    }

    public MovieModel() {
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getLeadActress() {
        return leadActress;
    }

    public void setLeadActress(String leadActress) {
        this.leadActress = leadActress;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    @Override
    public String toString() {
        return movieID + "\t\t" + movieName + "\t\t" + leadActor + "\t\t" + leadActress + "\t\t" + yearOfRelease + "\t\t" + directorName;

    }

}
