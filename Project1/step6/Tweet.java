public class Tweet{
    private String tweetText;
    private String userName;
    private int year;
    private int month;
    private int day;

    /**
     *This is the Tweet constructor
     */
    public Tweet(String newtext, String newuser, String newdate){
        tweetText = newtext;
        userName = newuser;
        String[] parts = newdate.split("-");
        year = Integer.parseInt(parts[0]);
        month = Integer.parseInt(parts[1]);
        day = Integer.parseInt(parts[2]);
    }

    /**
     *This is a boolean that searches the tweet text for the given string
     */
    public boolean containsKeyword(String keyword){
        boolean ishere = this.tweetText.contains(keyword.toLowerCase());
        if (ishere)
            return true;
        else
            return false;
    }

    /**
     *This is a boolean that searches the tweet data for the given string
     */
    public boolean containsDate(String newdate){
        String[] parts = newdate.split("-");
        int newYear = Integer.parseInt(parts[0]);
        int newMonth = Integer.parseInt(parts[1]);
        int newDay = Integer.parseInt(parts[2]);
        if ((day == newDay) && (month == newMonth) && (year == newYear))
            return true;
        else
            return false;
    }
    
    /**
     *This returns the tweet text
     */
    public String getText(){
        return tweetText;
    }

     /**
     *This returns the tweet username
     */
    public String getUser(){
        return userName;
    }

    /**
     *This returns the tweet year
     */
    public int getYear(){
        return year;
    }

    /**
     *This returns the tweet month
     */
    public int getMonth(){
        return month;
    }

    /**
     *This returns the tweet day
     */
    public int getDay(){
        return day;
    }
   
    /**
     *This returns the tweet as a string
     */
    public String toString(){
        String returnedString = tweetText + "\t[" + userName + "]\t" + month +"/" + day + "/" + year;
        return returnedString;
    }
}