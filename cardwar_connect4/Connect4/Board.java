/*Assignment2  CSCI 1101
Board.java is basic code for a game.
July 14, 2016
Weiyi Hu B00651403
This is entirely my own work.
*/
package Connect4;
public class Board{
	private int rows;
	private int cols;

	//Constructor	
	public Board(int rows,int cols)
	{
		this.rows=rows;
		this.cols=cols;
	}


	//get set method
	public void setRows(int rows)
	{
		this.rows=rows;
	}
	
	public void setCols(int cols)
	{
		this.cols=cols;
	}
	
	public int getRows()
	{
		return this.rows;
	}
	
	public int getCols()
	{
		return this.cols;
	}
	
	
	
	
}