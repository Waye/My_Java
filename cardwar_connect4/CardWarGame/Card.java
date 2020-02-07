/*Assignment3  CSCI 1101
Card.java is basic code for a game.
July 24, 2016
Weiyi Hu B00651403
This is entirely my own work.
*/
package CardWarGame;
public class Card{
	private int suit;
	private int value;
	//constructor for card
	public Card(int suit,int value)
	{
		if(suit>=1 && suit<=4)
		{
			this.suit=suit;
		}
		if(value>=2 && value<=14)
		{
			this.value=value;
		}
		
	}
	
	
	
	//get set method
	public int getSuit()
	{
		return this.suit;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	
	
	//compare method between two cards
	public int compare(Card A)
	{
		int result=0;
		if(this.getValue()==A.getValue())
		{
			result=1;
		}
		if(this.getValue()>A.getValue())
		{
			result=2;
		}
		if(this.getValue()<A.getValue())
		{
			result=3;
		}
		return result;
		
	}
	
	
	//to string method return suit and value of one card
	public String toString()
	{
		String resultSuit=Integer.toString(this.getSuit());
		String resultValue=Integer.toString(this.getValue());
		
		//output for suit
		if(this.getSuit()==1)
		{
			resultSuit="Hearts";
		}
		if(this.getSuit()==2)
		{
			resultSuit="Diamonds";
		}
		if(this.getSuit()==3)
		{
			resultSuit="Clubs";
		}
		if(this.getSuit()==4)
		{
			resultSuit="Spades";
		}
		
		//output for value
		if(this.getValue()==11)
		{
			resultValue="Jack";
		}
		if(this.getValue()==12)
		{
			resultValue="Queen";
		}
		if(this.getValue()==13)
		{
			resultValue="King";
		}
		if(this.getValue()==14)
		{
			resultValue="Ace";
		}
		
		return resultValue +" of "+resultSuit;
	}
}