import java.util.Scanner;
public class Lab02 {
  public static void push(Queue q, String s){
    //This function appends data to the end of the queue and then renames the last 
    Node newNode = new Node();
    newNode.data = s;
    q.last.next = newNode;
    q.last = newNode;
}
  public static void pop(Queue q){
    //This function repeats the first thing in queue and then deletes it and moves the start to the next thing
    System.out.println(q.first.data);
      q.first = q.first.next;
  } 
  public static void peek(Queue q){
    //This function repeats the first thing in the queue but doesn't do anything to the queue
    System.out.println(q.first.data);
  }

  // The main() function that is executed.
  public static void main(String[] args) {
    //initializes a queue
    Queue myData = new Queue();
    Node firstNode = new Node();
    firstNode.data = args[0];
    myData.first = firstNode;
    myData.last = firstNode;
    // load into the queue all the strings that came after the command
    for (int xx = 1; xx < args.length; xx++){
      //call push for every string on the back of the command
      push(myData, args[xx]);
          }

    //ask user for input
    System.out.print(">");

    //save the users input
    Scanner in = new Scanner(System.in);
    String cmd = in.nextLine();
    String[] splits = cmd.split(" ");
    while (!cmd.equals("!quit")){
   
	//figure out what the user entered
        if (cmd.equals("!pop")){
            pop(myData);
        }
        else if (cmd.equals("!peek")){
            //call peek
            peek(myData);
        }
        else {
            for (int x = 0; x < splits.length; x++){
                String cmds = splits[x];
                //if the string is not a command add it to the end of the args array
                push(myData, cmds);
            }
	}
	System.out.print(">");  
	cmd = in.nextLine();
    }  return;
  }
     
  }



