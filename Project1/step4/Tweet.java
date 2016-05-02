public class Tweet{
    private String tweetText;
    private String userName;
    private int year;
    private int month;
    private int day;

    public Tweet(String newtext, String newuser, String newdate){
        tweetText = newtext;
        userName = newuser;
        String[] parts = newdate.split("-");
        year = Integer.parseInt(parts[0]);
        month = Integer.parseInt(parts[1]);
        day = Integer.parseInt(parts[2]);
    }

    public boolean containsKeyword(String keyword){
        boolean ishere = tweetText.contains(keyword.toLowerCase());
        if (ishere)
            return true;
        else
            return false;
    }

    public String getText(){
        return tweetText;
    }

    public String getUser(){
        return userName;
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }
    
    public String toString(){
        String returnedString = tweetText + "\t[" + userName + "]\t" + month +"/" + day + "/" + year;
        return returnedString;
    }
}