/*Assignment2  CSCI 1101
Chip.java is basic code for a game.
July 14, 2016
Weiyi Hu B00651403
This is entirely my own work.
*/
package Connect4;
public class Chip{
	private String colour;
	private String name;
	
	public Chip(){};
	
	public Chip(String colour,String name)
	{
		this.colour=colour;
		this.name=name;
	}
	
	//get set method
	public String getColour()
	{
		return this.colour;
	}
	
	public void setColour(String colour)
	{
		this.colour=colour;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public boolean equals(Chip object1)
	{	
		object1=new Chip(object1.getColour(),object1.getName());
		//return object1.colour==this.colour;
		return object1.colour.equals(this.colour);// both return works
	}
	
	//toString
	public String toString()
	{
		return this.colour;
	}
	
	
}