import java.util.Scanner;
import java.io.File;

public class Search {
    /**
     *This Program searches through the provided file from the command line and displays results
     */
    public static void main(String[] args) {
        Queue tweetQ = readFile(args[0]);
        
        System.out.println("Queue size: " + tweetQ.length);
        System.out.print("? ");

        Scanner in = new Scanner(System.in);
        String cmd = in.next();
        Queue resultQ = tweetQ;
        
        while (!cmd.equals("!quit")){
            if(cmd.charAt(0)=='-'){
                resultQ = resultQ.filterForNotKeyword(cmd.substring(1));
            }
            else if (cmd.charAt(0)=='+'){
                resultQ = resultQ.filterForDate(cmd.substring(1));
            }
            else if(cmd.equals("!dump")){
                 printAll(resultQ);
            }
            else if(cmd.equals("!reset")){
                 resultQ = tweetQ;
            }
            else{
                resultQ = resultQ.filterForKeyword(cmd);
            }
            System.out.println("Queue size: " + resultQ.length);
            System.out.print("? ");
            cmd = in.next();
        }
        return;
    }

    /**
     *This function prints all the Tweets in the array provided
     */
    public static void printAll(Queue tweetQ){
        Node n = tweetQ.head;
        while(n != null){
            Tweet tweet = n.data;
            n = n.next;
            String printMe = tweet.toString();
            System.out.println(printMe);
        }
    }

    /**
     *This function reads in the file that the user provides in the command path
     */
    public static Queue readFile(String path){
        Queue q = new Queue();
        try {
            Scanner in = new Scanner(new File(path), "utf-8");
            while (in.hasNextLine()){
                String[] parts = in.nextLine().split("\t");
                Tweet toPush = new Tweet(parts[0], parts[1], parts[2]);
                q.push(q,toPush);
            }
            in.close();
        }
        catch ( Exception ex ) {
            ex.printStackTrace();
            System.exit(0);
        }
        return q;
    }
}


