/*Assignment2  CSCI 1101
Connect4Board.java is basic code for a game.
July 14, 2016
Weiyi Hu B00651403
This is entirely my own work.
*/
package Connect4;
public class Connect4Board extends Board{
	private Chip [][]board;
	private int numWinType=0;

	public Connect4Board(int rows, int cols) {
		super(rows, cols);
		this.board=new Chip[rows][cols];
	}
	
	public Chip[][] getBoard()
	{
		return this.board;
	}
	
	public void setBoard(Chip [][]board)
	{
		this.board=board;
	}
	
	//check if there is enough space to place
	public boolean add(int cols,String s)
	{
		boolean result=true;
		Chip c=new Chip();
		c.setColour(s);
		for(int i=5;i>=0;i--)
			{
				if(board[i][cols]==null)
				{
					board[i][cols]=c;
					result=true;
					break;
				}
				else
				{
					result=false;
				}
			}
			return result;
		
	}
	
	
	//check whether board is full stack
	public boolean isFull()
	{
		boolean result=true;
		for(int i=0;i<getRows();i++)
		{
			for(int j=0;j<getCols();j++)
			{
				if(board[i][j]==null)
				{
					result=false;
					break;
				}
				else
				{
					result=true;
					continue;
				}
			}
			break;
		}
		return result;
	}
	
	//method check if there is a winner
	public boolean winner()
	{
		boolean result=false;
		
		//check horizontal
		for(int i=0;i<getRows();i++)
		{
			for(int j=0;j<getCols()-3;j++)
			{
				if(board[i][j]!=null && board[i][j+1]!=null && board[i][j+2]!=null && board[i][j+3]!=null)
				{
					if(board[i][j].equals(board[i][j+1])&&board[i][j].equals(board[i][j+2])&&board[i][j].equals(board[i][j+3]))
					{
						result=true;
						numWinType=1;
					}

				}
				
				
			}
			
		}
		
		//check vertical
				for(int j=0;j<getCols();j++)
				{
					for(int i=0;i<getRows()-3;i++)
					{
						if(board[i][j]!=null && board[i+1][j]!=null && board[i+2][j]!=null && board[i+3][j]!=null)
						{
							if(board[i][j].equals(board[i+1][j])&&board[i][j].equals(board[i+2][j])&&board[i][j].equals(board[i+3][j]))
							{
								result=true;
								numWinType=2;
							}

						}
					}
					
					
				}
				
				
		//check diagonal
				//check top-left to bottom-right
				
				for(int i=0;i<getRows()-3;i++)
				{
					for(int j=0;j<getCols()-3;j++)
					{
						if(board[i][j]!=null && board[i+1][j+1]!=null && board[i+2][j+2]!=null && board[i+3][j+3]!=null)
						{
							if(board[i][j].equals(board[i+1][j+1])&&board[i][j].equals(board[i+2][j+2])&&board[i][j].equals(board[i+3][j+3]))
							{
								result=true;
								numWinType=3;
							}
						}
					}
				}
				//check top-right to bottom-left
				for(int i=getRows()-1;i>2;i--)
				{
					for(int j=getCols()-4;j>=0;j--)
					{
						if(board[i][j]!=null && board[i-1][j+1]!=null && board[i-2][j+2]!=null && board[i-3][j+3]!=null)
						{
							if(board[i][j].equals(board[i-1][j+1])&&board[i][j].equals(board[i-2][j+2])&&board[i][j].equals(board[i-3][j+3]))
							{
								result=true;
								numWinType=3;
							}
						}
					}
				}
				return result;
		
				
			
		
	}
	
	//return type of win,including "horizontal","vertical","diagonal"
	public String winType()
	{
		if(numWinType==1)
		{
			return " Win Horizontal";
		}
		if(numWinType==2)
		{
			return "Win Vertical";
		}
		if(numWinType==3)
		{
			return "Win Diagonal";
		}
		return null;
	}
	
	
	//return the layout of current board
	public String toStirng()
	{
		String result="\tCol\n\t1\t2\t3\t4\t5\t6\t7";
		for(int i=0;i<getRows();i++)
		{
			result +="\n"+(i+1)+"\t";
			for(int j=0;j<getCols();j++)
			{
				if(board[i][j]!=null)
				{
					result+=board[i][j].getColour()+"\t";
				}
				else
				{
					result+="\t";
				}
			}
		}
		return result;

	}
}