public class Queue {
    public Node head, tail;
    public int length = 0;


    public Queue filterForNotKeyword( String keyword){
        Queue newQ = new Queue();
        Node n = this.head;
        int count = 0;
            while(count < this.length){
            if (n.data.containsKeyword(keyword)){
                n= n.next;
            }
            else{
                newQ.push(newQ, n.data);
                n=n.next;
            }
            count++;
            }
           
        return newQ;
    }
    
    /**
     *Returns a Queue with all the Tweets that contain the given String
     */
    public Queue filterForKeyword( String keyword){
        Queue newQ = new Queue();
        Node n = this.head;
        int count = 0;
            while(count < this.length){
            if (n.data.containsKeyword(keyword)){
                newQ.push(newQ, n.data);
                n= n.next;
            }
            else{
                n=n.next;}
            count++;
            }
           
        return newQ;
    }

    /**
     *Pushes the given Tweet onto the given Queue
     */
    public void push(Queue q, Tweet t) {
        Node node = new Node();
        node.data = t;
        if (q.tail != null) //If there's already something in the Queue,
            q.tail.next=node; //Add this node on the back
        q.tail = node; //tail should point to our new node, regardless
        if (q.head == null) //If Queue was empty,
            q.head = node; //head should point here, too
        length++;
    }

    /**
     * Returns the Tweet from the front of the given queue.
     */
    public Tweet peek(Queue q) {
        if (q.head == null) //If head is null, nothing to return.
            return null;
        return q.head.data;
    }

    /**
     * Removes and returns the Tweet from the front of the given queue.
     */
    public Tweet pop(Queue q) {
        if (q.head == null) //If queue is empty, nothing to return
            return null;
        Tweet t = q.head.data; //store our answer
        q.head = q.head.next; //move the q.head pointer
        if (q.head == null) //If the queue is now empty,
            q.tail = null; //Make q.tail also null
        length--;
        return t; //return our answer.
    }
}