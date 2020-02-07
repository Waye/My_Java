/*Assignment2  CSCI 1101
Play.java is basic code for a game.
July 14, 2016
Weiyi Hu B00651403
This is entirely my own work.
*/
package Connect4;
import java.util.Scanner;
public class Play{
public static void main(String []args){
		for (int i=0;i>=0;i++) {
		//1.Start	
		System.out.println("Welcome to Connect4.Please enter your names.");
		Scanner keyboard=new Scanner(System.in);
		System.out.print("Player 1 name:");
		String Player1=keyboard.nextLine();
		System.out.print("Player 2 name:");
		String Player2=keyboard.nextLine();
		
		
		Connect4Board board=new Connect4Board(6,7);
		Chip player1=new Chip("R",Player1);
		Chip player2=new Chip("Y",Player2);
		
		Chip player;//use this agent to switch between player1 and player2
		Boolean series=true;// true for player1 and false for player2
		
		//tell player who go first
		System.out.println(player1.getName()+"- you have red chips 'R', you go first");
		System.out.println(player2.getName()+"- you have yellow chips 'Y', you go next");
		
		
		
		
		//2.progress of game
		
		//a switch between two players
		int counter=0;//calculate times of turn
		do
		{
			
			if(series==true)
			{
				player=player1;
				series=false;
			}
			else
			{
				player=player2;
				series=true;
			}
			System.out.print(player.getName()+" Please input a column# between 1-6:");
			Scanner keyboard1=new Scanner(System.in);
			int cols=keyboard1.nextInt();
			
			
			//check place in specific column
			if(board.add(cols-1,player.getColour())==true)
			{
				System.out.println(board.toStirng());
			}
			else
			{
				System.out.println("column"+cols+" is full, it is other player turn.");
			}
			counter++;
		}
		while(!board.winner() && !board.isFull());
		
			
		
		
		
		//3.deal with winner or full stack
		if(board.winner() )
		{
			System.out.println(player.getName()+ "– Connect 4! Congratulations "+player.getName()+"! You Win in " +counter +" turns.\nway to win:"+board.winType());
			
		}
		else if(!board.winner() && board.isFull())
		{
			System.out.println("No such Winner");
		}
		
		
		
		
		
		//4.ask to play again
		Scanner keyboard2=new Scanner(System.in);
		System.out.println("Play Again? y/n:");
		String userInput=keyboard2.nextLine();
		
		if(userInput.equals("y"))
		{
			continue;
		}
		else
		{
			break;
		}
		
		
		
		
		
		
		}	
		
	}
}