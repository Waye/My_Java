package CardWarGame;
public class PlayerHands extends Pile{
	@Override
	public void shuffle(){}

	@Override
	public Card draw() {return null;}
	
	public void displayWar(Card c, Card d)
	{
		PlayerHands object1=new PlayerHands();
		PlayerHands object2=new PlayerHands();
		
		object1.getPile().addToFront(c);
		System.out.printf("%-20s",object1.getPile().getNode(0).getData().toString()); 
		System.out.printf("%-15s", " ");
		
		object2.getPile().addToFront(d);
		System.out.printf("%-20s",object2.getPile().getNode(0).getData().toString()); 
		System.out.printf("%-15s", " ");
		
		System.out.println();
		
	
	}
	
	
}