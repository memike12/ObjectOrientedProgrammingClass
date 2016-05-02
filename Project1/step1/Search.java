import java.util.Scanner;
import java.io.File;

public class Search {
    public static void main(String[] args) {

        Tweet[] tweetsIn = readFile("./sometweets.txt");
        System.out.println("Array size: " + tweetsIn.length);
        for( int ii = 0; ii < tweetsIn.length; ii++){
            String out = tweetsIn[ii].toString();
            System.out.println(out);
        }
    }

    public static Tweet[] readFile(String path){
        Tweet [] tweetArray = new Tweet[33];
        try {
            Scanner in = new Scanner(new File(path), "utf-8");
            int ii=0;
            while (in.hasNextLine()){
                String[] parts = in.nextLine().split("\t");
                tweetArray[ii] = new Tweet(parts[0], parts[1], parts[2]);
                ii++;
            }
            in.close();
        }
        catch ( Exception ex ) {
            ex.printStackTrace();
            System.exit(0);
        }
        return tweetArray;
    }
}


