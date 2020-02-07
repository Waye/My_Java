/*
 * A CS1101 sample implementation of a Node to be used with a Linked List.
 * Intended to work only with String objects.
 * 
 * Author: Bonnie Mackay, with edits from Jeremy Porter
 */
package CardWarGame;
public class Node {
   private Card data;
   private Node next;
   
   public Node(Card d, Node n) {
      data = d;
      next = n;
   }
   
   public void setData(Card d) {
      data = d;
   }
   
   public Card getData() {
      return data;
   }
   
   public void setNext(Node n) {
      next = n;
   }
   
   public Node getNext() {
      return next;
   }
   
   public String toString() {
      return data + "--> ";
   }
}