package preparedStatement;


public class ExecMain {

    public static void main(String[] args) {
        // create a QueryService object
        QueryService queryServicer = new QueryService();
        // load the years to array
        int[] movieYear1 = {1990};
        int[] movieYear2 = {1990, 1991};
        int[] movieYear3 = {1990, 1991, 1992};
        int[] movieYear4 = {1990, 1991, 1992, 1993};
        int[] movieYear5 = {1990, 1991, 1992, 1993, 2000};
        int[] movieYear6 = {1990, 1991, 1992, 1993, 2000, 2001};
        int[] movieYear7 = {1990, 1991, 1992, 1993, 2000, 2001, 2002};
        int[] movieYear8 = {1990, 1991, 1992, 1993, 2000, 2001, 2002, 1996};
        int[] movieYear9 = {1990, 1991, 1992, 1993, 2000, 2001, 2002, 1996, 1995};
        int[][] movieYears = {movieYear1, movieYear2, movieYear3, movieYear4, movieYear5, movieYear6, movieYear7, movieYear8, movieYear9};
        try {
            for(int i = 0; i < movieYears.length; i++) {
                //queryServicer.getMovie(movieYear[i]);
                queryServicer.getRatingTime(queryServicer.formPrepSt(), movieYears[i]);
            }
        }
        catch(Exception ex){
            System.out.println("process could not run");
        }

    }

    // help to load the repeated year in movieYear array
    private static void loadHelper(int[] movieYearTimes) {
        // create the movieYear in which element year is no larger than 2005
        int[] movieYearBase = {1990, 1991, 1992, 1993, 2000, 2001, 2002, 1996, 1995, 1994};
        for(int i = 0; i < movieYearTimes.length; i++) {
            movieYearTimes[i] = movieYearBase[i % 10];
        }
    }
}