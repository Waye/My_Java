/*
 * A CS1101 sample implementation of a Linked List.
 * Intended to work only with String objects.
 * 
 * Author: Bonnie Mackay, with edits from Jeremy Porter
 */ 
package CardWarGame;
public class LinkedList{
   private Node head; // the 'front' or 'head' node of the linked list
   private int count;
   
   public LinkedList() {
      head = null;
      count = 0;
   }
   
   // Method #1
   public void addToFront(Card d) {
      Node n = new Node(d, head);
      head = n;
      count++;
   }
   
   // Method #2
   public int size() {
      return count;
   }
      
   // Method #3
   public boolean isEmpty() {
      //return (count == 0);
      return (head == null);
   }
   
   // Method #4
   public void clear() {
      head = null;
      count = 0;
   }
   
   // Method #5
   public Card getFrontData() {
      return head.getData();
   }
   
   // Method #6
   public Node getFrontNode() {
      return head; // returns a reference!
   }
   
   // Method #7
   public void enumerate() {
      Node cur = head;
      
      System.out.print("[ ");
      while(cur != null) {
         System.out.print(cur);
         cur = cur.getNext();
      }
       System.out.println(" ]");
   }
   
   // Method #8
   public void removeFront() {
      if(!isEmpty()) {
         head = head.getNext();
         count--;
      } else {
         System.out.println("Can't remove front - list empty");
      }
   }
   
   // Method #9
   public void addToEnd(Card d) {
      Node n = new Node(d, null);
      
      if(isEmpty()) {
         head = n;
      } else {
         Node cur = head;
         while(cur.getNext() != null) {
            cur = cur.getNext();
         }
         cur.setNext(n);
      }
      
      count++;
   }
   
   // Method #10
   public void removeLast() {
      if(isEmpty()) {
         System.out.println("Can't remove last - list empty");
      } else if(head.getNext() == null) { // if only one node
         head = null;
         count = 0;
      } else {
         Node cur = head;
         while(cur.getNext().getNext() != null) {
            cur = cur.getNext();
         }
         cur.setNext(null);
         count--;
      }
   }
   
   // Method #11
   public int contains(String d) {
      Node cur = head;
      boolean found = false;
      int index = -1;
      
      while(cur != null && !found) {
         index++;
         if(cur.getData().equals(d))
            found = true;
         cur = cur.getNext();
      }
      if(!found)
         index = -1;
      return index;
   }
   
   // Method #12
   public void add(int index, Card d) {
      if(index < 0 || index > size()) { // check bounds
         System.out.println("Can't add - index out of bounds");
      } else { 
         if(index == 0) {
            addToFront(d);
         } else {
            Node cur = head;
            for(int i=0; i<index-1; i++) {
               cur = cur.getNext();
            }
            
            Node n = new Node(d, cur.getNext());
            cur.setNext(n);
            count++;
         }
      }
   }
   
   // Method #13
   public void remove(int index) {
      if(index < 0 || index >= size()) {
         System.out.println("Can't remove - index out of bounds.");
      } else if(index == 0) {
         removeFront();
      } else if(index == size()-1) {
         removeLast();
      } else {
         Node cur = head;
         for(int i=0; i<index-1; i++) {
            cur = cur.getNext();
         }
         cur.setNext(cur.getNext().getNext());
         count--;
      }
   }
   
   // Method #14
   public Node getNode(int index) {
      Node cur = null;
      
      if(index < 0 || index >= size()) {
         System.out.println("Cannot return - index out of bounds.");
      } else if(index == 0) {
         cur = head;
      } else {
         cur = head;
         for(int i=0; i<index; i++) {
            cur = cur.getNext();
         }
      }
      
      return cur;
   }
   
   
   // Exercise #1
   public void addAll(LinkedList otherList) {
      Node cur = otherList.getFrontNode();
      while(cur != null) {
         addToEnd(cur.getData());
         cur = cur.getNext();
      }
   }
   
   
   
  

}