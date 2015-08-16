
package hackerranklinkedlists;

/**
 *
 * @author Johnny
 */
public class HackerRankLinkedLists {
    class Node {
        int data;
        Node next;
    }
    
    //Print elements of a linked list
    void Print(Node head) {
         if(head == null) { return; }
         System.out.println(head.data);
         Print(head.next);   
    }    
    
    //Insert a node at the tail of a linked list
    Node Insert(Node head,int data) {   
        Node startHead = head;
        Node tempHead = new Node();
        tempHead.data = data;
        if (head == null){return tempHead;}
        while (head.next!=null) {
            head = head.next;       
        }
        head.next = tempHead;

        return startHead;
    } 
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
