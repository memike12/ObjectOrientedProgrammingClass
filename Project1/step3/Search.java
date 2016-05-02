import java.util.Scanner;
import java.io.File;

public class Search {
    public static void main(String[] args) {

        Queue tweetQ = readFile(args[0]);
        System.out.println("Queue size: " + tweetQ.length);
        
        System.out.print("? ");

        Scanner in = new Scanner(System.in);
        String cmd = in.next();
        //String[] splits = cmd.split(" ");
        Queue resultQ = tweetQ;
        while (!cmd.equals("!dump")){
            resultQ = resultQ.filterForKeyword(cmd);
            System.out.println("Queue size: " + resultQ.length);
            //printAll(resultQ);
            System.out.print("? ");
            cmd = in.next();
        }
        printAll(resultQ);
        /*for( int ii = 0; ii < Queue.length; ii++){
          String out = tweetsIn[ii].toString();
          System.out.println(out);
          }*/
        return;
    }

    public static void printAll(Queue tweetQ){
        Node n = tweetQ.head;
        while(n != null){
            Tweet tweet = n.data;
            n = n.next;
            String printMe = tweet.toString();
            System.out.println(printMe);
        }
    }


    public static Queue readFile(String path){
        //Tweet [] tweetArray = new Tweet[33];
        Queue q = new Queue();
        try {
            Scanner in = new Scanner(new File(path), "utf-8");
            while (in.hasNextLine()){
                //Queue q = new Queue();
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


