/*Assignment3  CSCI 1101
Demo.java is basic code for a game.
July 24, 2016
Weiyi Hu B00651403
This is entirely my own work.
*/
package CardWarGame;
import java.util.Scanner;
public class Demo{
	//fields
	public static int counter=0;//calculate how many times war happen in a war
	public static String name1;//name1 is the name matching player1
	public static String name2;//name2 is the name matching player2
	public static boolean caseHappen=false;//value equal true when second last card are equal in war processing
	public static String winner;//name of winner
	
	
	//main method
	public static void main(String []args)
	{
		boolean tryAgain=true; 
		
		//game start and continue when try again is true
		while(tryAgain)
		{
			
			
			//1.Start the game
			//initialize fields,get input and create two array lists for two players
			counter=0;
			System.out.println("Welcome to WAR! Let's Play!");
			Scanner keyboard1=new Scanner(System.in);
			System.out.print("Enter the first player's name: ");
			name1=keyboard1.next();
			
			System.out.print("Enter the second player's name: ");
			name2=keyboard1.next();
			
			
			
			
			
			//2.assign cards
			Deck deck=new Deck();
			LinkedList player1=new LinkedList();
			LinkedList player2=new LinkedList();
			
			player1.addAll(deck.getDeck());
			player2.addAll(deck.getDeck());

			for(int i=0; i<(deck.getDeck().size()/2); i++){
				player1.removeLast();
			}
			
			for(int i=0; i<(deck.getDeck().size()/2); i++){
				player2.removeFront();
			}
			//finish assigning card and deck is equal to null
			deck.getDeck().clear();
			
			
			
			
			//3.game process
			
			
			
			System.out.println();
			//set name for header
			System.out.printf("%-20s",name1); 
			System.out.printf("%-15s", "#Cards");
			System.out.printf("%-20s",name2); 
			System.out.printf("%-15s", "#Cards");
			System.out.println("Winner");
			
			//output unchanged two cards sets size and first card
			System.out.printf("%-20s",player1.getFrontData().toString()); 
			System.out.printf("%-15s", player1.size());
			System.out.printf("%-20s",player2.getFrontData().toString()); 
			System.out.printf("%-15s", player2.size());
			
			
			//game ends with one of sets is full
			while(player1.size()!=52 && player2.size()!=52)
			{
				counter=0;
				
				
				
				
				
				//war happen
				if(player1.getFrontData().compare(player2.getFrontData())==1)
				{	
					PlayerHands twoPlayerhands=new PlayerHands();
					
					
					//initialize winner to nobody
					winner=null;
					
					
					
					//compare rest of cards are whether equal
					
					boolean isEqual=true;
					//get larger size value of two players
					int loopSize;
					if(player1.size()-player2.size()>=0)
					{
						loopSize=player2.size();
					}
					else
					{
						loopSize=player1.size();
					}
					
					for(int i=0;i<loopSize;i++)
					{
						if(player1.getNode(player1.size()-1-i).getData().getValue()!=player2.getNode(player2.size()-1-i).getData().getValue())
						{
							isEqual=false;
							break;
						}
					}
					
					//if rest cards of both set are equal
					if(isEqual==true)
					{
						System.out.println();
						System.out.println("Cannot play war, rest cards are equal");
						break;
					}
					else//if rest cards of both set are not equal
					{
						if((player1.size()<3||player2.size()<3))//condition war cannot happen
						{
							System.out.println();
							System.out.println("Not enough card to support War");
							break;
						}
						else
						{
							System.out.print("War happen");
							System.out.println();
							counter=0;
							
							System.out.println("************************************************WAR*******************************************");
							System.out.println();
							
							//method to show the cards on the both players' hands
							//twoPlayerhands.displayWar(player1.getNode(0).getData(),player2.getNode(0).getData());
							
							
							war(player1,player2);
							if(caseHappen==true)
							{
								break;
							}
							if(player1.size()==52 || player2.size()==52)
							{
								break;
							}
							System.out.println();
							System.out.printf("After war "+winner+" win "+counter+" card/cards");
							System.out.println();
							System.out.println("************************************************END WAR***************************************");
							
							//output the first card after war and cards size
							System.out.printf("%-20s",player1.getNode(0).getData().toString()); 
							System.out.printf("%-15s", player1.size());
							System.out.printf("%-20s",player2.getNode(0).getData().toString()); 
							System.out.printf("%-15s", player2.size());
						
						}
					}
						
				}
				
				
				
				
				
				
				
				//player1's first card is greater than player2's first card
				if(player1.getFrontData().compare(player2.getFrontData())==2)
				{
					winner=null;
					if(player1.size()==52 || player2.size()==52)
					{
						break;
					}
					counter=0;
					cWin(player1,player2);
					if(player1.size()==52 || player2.size()==52)
					{
						break;
					}
					System.out.println(winner+" (win "+counter+" card/cards)");
					System.out.printf("%-20s",player1.getFrontData().toString()); 
					System.out.printf("%-15s", player1.size());
					System.out.printf("%-20s",player2.getFrontData().toString()); 
					System.out.printf("%-15s", player2.size());
					
					
				}
				
				
				
				
				
				
				
				
				//player2's first card is greater than player1's first card
				if(player1.getFrontData().compare(player2.getFrontData())==3)
				{
					winner=null;
					if(player1.size()==52 || player2.size()==52)
					{
						break;
					}
					counter=0;
					dWin(player1,player2);
					
					if(player1.size()==52 || player2.size()==52)
					{
						break;
					}
						
					System.out.println(winner+" (win "+counter+" card/cards)");
					System.out.printf("%-20s",player1.getFrontData().toString()); 
					System.out.printf("%-15s", player1.size());
					System.out.printf("%-20s",player2.getFrontData().toString()); 
					System.out.printf("%-15s", player2.size());
					
					
				}
				
			}
			
			
			
			
			//4.After game
			
			//4.1.conclusion
			System.out.println();
			if(player2.size()>player1.size())
			{
				System.out.println( name2+" Wins! Congratulations");
			}
			if(player1.size()>player2.size())
			{
				System.out.println( name1+" Wins! Congratulations");
			}
			
			//4.2.play again decision
			Scanner keyboard2=new Scanner(System.in);
			System.out.print("Play again (y/n)?");
			String answer=keyboard2.next();
			if(answer.equals("y"))
			{
				tryAgain=true;
			}
			if(answer.equals("n"))
			{
				tryAgain=false;
				System.out.println("Thanks for playing...");
			}
			
		}
		System.exit(0);
	}
	
	
	
	
	
	
	//implemented method
	
	//war happen method
	public static void war(LinkedList a,LinkedList b)
	{
		
		if(a.getNode(counter+2).getData().compare(b.getNode(counter+2).getData())==1)//a=b
		{
			counter=counter+2;
			if(counter+2>=a.size()||counter+2>=b.size())//avoid  [A,B,C,D],[A,E,C,F] repeated case
			{
				caseHappen=true;
				System.out.println();
				System.out.println("Cannot play War, second last cards are equal");
				return;
			}
			else
			{
				war(a,b);
				return;
			}
			
		}
		if(a.getNode(counter+2).getData().compare(b.getNode(counter+2).getData())==2)//a>b
		{
			counter=counter+2;
			cWin(a,b);
			return;
		}
		if(a.getNode(counter+2).getData().compare(b.getNode(counter+2).getData())==3)//a<b
		{
			counter=counter+2;
			dWin(a,b);
			return;
		}
		
		
		
	}
	
	//method to add remove,when player2 card value > player1 card value
	public static void dWin(LinkedList c,LinkedList d)
	{	
			LinkedList c1=new LinkedList();
			LinkedList d1=new LinkedList();
			PlayerHands twoPlayerhands=new PlayerHands();
			
			
			if(counter==0)
			{
				c1.addToEnd(c.getNode(0).getData());
				c.removeFront();
				
				d1.addToEnd(d.getNode(0).getData());
				d.removeFront();
				
				d.addToEnd(d1.getNode(0).getData());
				d.addToEnd(c1.getNode(0).getData());
				
				
			}
			//happen in a war
			if(counter >0)
			{	
				for(int i=0;i<=counter;i++)
				{
					twoPlayerhands.displayWar(c.getNode(0).getData(),d.getNode(0).getData());
					c1.addToEnd(c.getNode(0).getData());
					c.removeFront();
				
					d1.addToEnd(d.getNode(0).getData());
					d.removeFront();
				
				
				}
			
				d.addAll(d1);
				d.addAll(c1);
				
			}
			counter=counter+1;//calculate how many cards remove from one player and add to other player
			winner=name2;//set winner to player2
	}
	
	
	//method to add remove,when player1 card value > player2 card value
	public static void cWin(LinkedList c,LinkedList d)
	{	
			LinkedList c1=new LinkedList();
			LinkedList d1=new LinkedList();
			PlayerHands twoPlayerhands=new PlayerHands();
			
			if(counter==0)
			{
				c1.addToEnd(c.getNode(0).getData());
				c.removeFront();
				
				d1.addToEnd(d.getNode(0).getData());
				d.removeFront();
				
				c.addToEnd(c1.getNode(0).getData());
				c.addToEnd(d1.getNode(0).getData());	
				
			}
			//happen in a war 
			if(counter >0)
			{	
				for(int i=0;i<=counter;i++)
				{
					twoPlayerhands.displayWar(c.getNode(0).getData(),d.getNode(0).getData());
					c1.addToEnd(c.getNode(0).getData());
					c.removeFront();
				
					d1.addToEnd(d.getNode(0).getData());
					d.removeFront();
				
				
				}
				c.addAll(c1);
				c.addAll(d1);
			}
			counter=counter+1;//calculate how many cards remove from one player and add to other player
			winner=name1;//set winner to player1
	}
	
	
}//end class