
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
    
    //Insert a node at the head of a linked list
    Node InsertHead(Node head,int x) {
        Node someNode = new Node(); someNode.data = x;
        if (head == null){return someNode;}
        someNode.next = head;
        return someNode;
    }   
    
    //Insert a node at a specific position in a linked list
    Node InsertSpecific(Node head, int data, int position){
        //Will Need to Return Head Node 
        Node trackedHeadNode = head;

        Node nodeToInsert = new Node(); nodeToInsert.data = data;

        //Empty List - Returned newly created node or null
        if (head==null){return nodeToInsert;}

        //Inserting a Node ahead of the List
        if (position == 0){nodeToInsert.next = head; return nodeToInsert;}    

        //Traverse the Singly Linked List to 1 Position Prior
        //Stop traversing if you reached the end of the List
        int currPosition = 0;

        while (currPosition < position -1 && head.next != null){
            head = head.next;        
            currPosition++;       
        }

        //Inserting a Node in-between a List or at the end of of a List
        Node nodeAtPosition = head.next;
        head.next = nodeToInsert;
        head = head.next;
        head.next = nodeAtPosition;

        return trackedHeadNode;
    }

    //Delete a node
    Node Delete(Node head, int position) {
        // Complete this method
        Node trackedHeadNode = head;   
        int currPosition = 0;

        if (position == 0 && head.next == null){return null;}
        if (position == 0){head = head.next; return head;}

        while (currPosition < position -1 && head.next!=null){        
            head = head.next;currPosition++;
        }    
        Node tempNode = head.next;
        head.next = null;    
        if (tempNode.next == null){return trackedHeadNode;}
        head.next = tempNode.next;

        return trackedHeadNode;

    }

    //Print in Reverse
    void ReversePrint(Node head) {
    // This is a "method-only" submission. 
    // You only need to complete this method.     
      if (head!=null){
          //Print if given only 1 Node
          if (head.next == null){System.out.println(head.data);}
          //More than 1 Node
          if (head.next != null){        
              Node headTracker = head;
              Node prevNode = head;
              //Traverse 
              while(head.next!=null){        
                  prevNode = head;
                  head = head.next;         
              }       
              //Print Last Node
              System.out.println(head.data);
              //Delete The Last Node from the List
              prevNode.next = null;
              //Revursive Call - List - Last Node
              ReversePrint(headTracker);
          }
      }
  }
    
    //Merge two sorted linked lists    
    Node MergeLists(Node headA, Node headB) {

        //Merge headB to headA
        if(headB != null){
            if(headA == null){headA = headB;}        
            else{
                Node travNodeA = headA;
                while(travNodeA.next != null){
                    travNodeA = travNodeA.next;
                }   
                travNodeA.next = headB;
            }
        }

        Node trackedHeadA = headA;

        //Just Sort A Side, Insertion Sort
        if (headA.next != null ){        
            while(headA.next != null){
                if (headA.next.data < headA.data){
                    Node tempNode = headA.next;
                    headA.next = headA.next.next;              

                    //Head Check - Insert as Head if lower than current Head
                    if (tempNode.data < trackedHeadA.data){
                        tempNode.next = trackedHeadA;
                        trackedHeadA = tempNode;
                    }                

                    //Traverse List to Insert
                    else{                    
                        Node higherNode = trackedHeadA;
                        Node lowerNode = trackedHeadA;
                        while(higherNode.data < tempNode.data){  
                            lowerNode = higherNode;
                            higherNode = higherNode.next;                    
                        }
                        lowerNode.next = tempNode;
                        tempNode.next = higherNode;
                    }
                }
                else{
                    headA = headA.next;
                }
            }
        }

        return trackedHeadA;
    }    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
