package preparedStatement;

// import the JDBC class library
import java.io.*;
import java.sql.*;

public class QueryService {

    //constructor
    public QueryService() {}

    public PreparedStatement formPrepSt () throws SQLException, IOException {
        //Load the JDBC driver, if it failed, catch the exception
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException x) {
            System.out.println("Driver could not be loaded");
        }
        String querySt = "select movie.title,AVG(rating) from movie,rating where movie.id = rating.movie_id AND movie.year = ? group by movie.title";
        long startTimeCon = System.currentTimeMillis();
        Connection db = DriverManager.getConnection("jdbc:postgresql://localhost/postgres");
        long stopTimeCon = System.currentTimeMillis();
        long elapsedTimeCon = stopTimeCon - startTimeCon;
        System.out.println("Connecting to database time is " + elapsedTimeCon + "\n");
        long startTimePS = System.currentTimeMillis();
        PreparedStatement p = db.prepareStatement(querySt);
        long stopTimePS = System.currentTimeMillis();
        long elapsedTimePS = stopTimePS - startTimePS;
        System.out.println("Forming PreparedStatement Processing time is " + elapsedTimePS + "\n");
        return p;
    }

    public void getRatingTime (PreparedStatement p, int[] movieYear) throws SQLException, IOException {
        long startTimeEQ = System.currentTimeMillis();
        for(int i = 0; i < movieYear.length; i++) {
            p.clearParameters();
            p.setInt(1, movieYear[i]);
            ResultSet r = p.executeQuery();
        }
        long stopTimeEQ = System.currentTimeMillis();
        long elapsedTimeEQ = stopTimeEQ - startTimeEQ;
        System.out.println(movieYear.length + " Query loop Processing time is " + elapsedTimeEQ + "\n");
    }


    public void getMovie (int[] movieYear) throws SQLException, IOException {
        //Load the JDBC driver, if it failed, catch the exception
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException x) {
            System.out.println("Driver could not be loaded");
        }
        // Create variables
        String title;
        int year;
        String querySt = "select title, year from movie where year = ?";
        // Connecting to the database
        long startTimePS = System.currentTimeMillis();
        Connection db = DriverManager.getConnection("jdbc:postgresql://localhost/postgres");
        PreparedStatement p = db.prepareStatement(querySt);
        long stopTimePS = System.currentTimeMillis();
        long elapsedTimePS = stopTimePS - startTimePS;
        System.out.println("Forming PreparedStatement Processing time is " + elapsedTimePS + "\n");
        long startTimeEQ = System.currentTimeMillis();
        for(int i = 0; i < movieYear.length; i++) {
            p.clearParameters();
            p.setInt(1, movieYear[i]);
            ResultSet r = p.executeQuery();
        }
        long stopTimeEQ = System.currentTimeMillis();
        long elapsedTimeEQ = stopTimeEQ - startTimeEQ;
        // see the final query
        String statementText = p.toString();
        System.out.print(statementText + "\n");
        System.out.println(movieYear.length + " Query loop Processing time is " + elapsedTimeEQ + "\n");

    }

}