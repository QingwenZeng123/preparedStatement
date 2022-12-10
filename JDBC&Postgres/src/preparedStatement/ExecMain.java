package preparedStatement;


public class ExecMain {

    public static void main(String[] args) {
        // create a QueryService object
        QueryService queryServicer = new QueryService();
        // load the years to array
        int[] movieYear1 = new int[10];
        int[] movieYear2 = new int[20];
        int[] movieYear3 = new int[30];
        int[] movieYear4 = new int[40];
        int[] movieYear5 = new int[50];
        int[] movieYear6 = new int[60];
        int[][] movieYears = {movieYear1, movieYear2, movieYear3, movieYear4, movieYear5, movieYear6};
        // load the years to movieYears array
        for(int i = 0; i < movieYears.length; i++) {
            loadHelper(movieYears[i]);
        }
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