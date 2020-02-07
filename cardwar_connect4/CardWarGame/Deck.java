/*Assignment3  CSCI 1101
Deck.java is basic code for a game.
July 24, 2016
Weiyi Hu B00651403
This is entirely my own work.
*/
package CardWarGame;
import java.util.Random;
public class Deck extends Pile{
	LinkedList cards = new  LinkedList();
	
	private int []suit={1,2,3,4};
	private int []value={2,3,4,5,6,7,8,9,10,11,12,13,14};
	
	//constructor for deck class
	public Deck()
	{
		this.setDeck();
		
		//shuffle the cards since it creates
		this.shuffle();
	}
	
	
	//set method to add all 52 cards into into one cards 
	public void setDeck()
	{
		cards.clear();
		for(int i=0;i<suit.length;i++)
		{
			for(int j=0;j<value.length;j++)
			{
				Card newCard=new Card(suit[i],value[j]);//add each card into cards array-list
				cards.addToEnd(newCard);
			}
		}
	}
	
	//get method
	public LinkedList getDeck()
	{
		return this.cards;
	}
	
	
	//to string method
	public String toString()
	{
		return cards.toString();
	}
	
	//shuffling cards
		
		public void shuffle()
		{
			Random random = new Random();
			for(int i=0; i<cards.size(); i++)
			{
				int j = random.nextInt(i + 1);
				//swap value to both card
				Card temp = cards.getNode(i).getData();
				cards.getNode(i).setData(cards.getNode(j).getData());
				cards.getNode(j).setData(temp);
			}
		}
		
		public Card draw()
		{
			Card c = cards.getFrontData();
			if(!cards.isEmpty()){
				cards.removeFront();
			}
			else{
				System.exit(0);
			}
			return c;
		}
}