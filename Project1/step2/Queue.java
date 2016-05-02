public class Queue {
    public Node head, tail;
    public int length = 0;

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