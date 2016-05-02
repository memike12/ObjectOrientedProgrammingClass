
/** A class to store a Queue */
public class Lab5Queue {

    // The head of the queue. The head is a Node and each Queue will have a head.
    private Node head;

    // The tail of the queue. The tail is a Node and each Queue will have a head. 
    private Node tail;


    /** Used to construct the Queue. This takes no paramaters. */
    public Lab5Queue(){
        head = null;
        tail = null;
    }
    
    /** Used to push a String into the queue. This appends the string to the end of the queue.
     *  This method needs a String to add it to the queue.
     *
     * @param s The string you want to put into the queue.
     */
    public void push(String s) {
        Node node = new Node(s);
        if (tail != null)
            tail.setNext(node);
        tail = node;
        if (head == null)
            head = node;
    }
    
    /**
     * Used to see the first node in the queue but not pop it off the queue.
     *
     *@return String if there is data in the head.
     *@return Null if the head is empty.
     */
    public String peek() {
        if (head == null)
            return null;
        return head.getData();
    }
    /**
     * Used to read the first element and then remove it from the queue
     *
     *@return the string that is the first element in the queue
     */
    public String pop() {
        if (head == null)
            return null;
        String s = head.getData();
        head = head.getNext();
        if (head == null)
            tail = null;
        return s;
    }
}
