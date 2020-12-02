package mazeSolver;
/*
This class will contain the actual code to how the maze will solve itself
*/
import java.io.*;
import java.util.*;

public class MazeSolver implements Serializable{
    //data
    public int cols,rows;
    public boolean[ ][ ] visited;//2d array that holds booleans named visited
    public Maze myMaze;
    public Stack<Direction> moves; //Stack that contains directions called moves. similar to int x;
    
    //parameterized constructor
    public MazeSolver(int rows,int cols){
        //Builds maze
        myMaze = new Maze(rows,cols);
        myMaze.buildMaze(10);//0 is delay in sec, larger number ,slower the build
        myMaze.setSolveAnimationDelay(10);
        
        //initializes Stack called moves. gives it values. similar to x=6;
        moves = new Stack<Direction>();
        visited = new boolean[rows][cols];
    }
    //method
    public void solve() throws FileNotFoundException, IOException{
        MazeDisplay theMD =new MazeDisplay(myMaze);
        System.out.println("Enter Q to quit, S to save or ENTER to move");
        
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        
        do{ 
            int cRow = myMaze.getCurrentRow();//Gets current row as an int
            int cCol = myMaze.getCurrentCol();//Gets current col as an int
            visited [cRow][cCol] = true;
            
            
            if (input.equalsIgnoreCase("s")){
                System.out.println("what file should we serialize to?");
		String filename = kb.nextLine();
                ObjectOutputStream oosVar = new ObjectOutputStream(new FileOutputStream(filename)); // <-- could be a String variable
		oosVar.writeObject(this);
                oosVar.close();//writes it out as "whole thing"
                
            }
            if (input.equalsIgnoreCase("q")){
                System.out.println("Program ended without solving.");
                break;
            }
            
            //DOWN?  Checks if down is open      checks if row has been visited
            if (myMaze.isOpen(Direction.DOWN) && visited[cRow+1][cCol] == false){
                myMaze.move(Direction.DOWN);
                moves.push(Direction.DOWN);
            }
            //RIGHT? Checks if right is open      checks if col has been visited
            else if (myMaze.isOpen(Direction.RIGHT) && visited[cRow][cCol+1] == false){
                myMaze.move(Direction.RIGHT);
                moves.push(Direction.RIGHT);
            }
            //LEFT? Checks if left is open      checks if col has been visited
            else if (myMaze.isOpen(Direction.LEFT) && visited[cRow][cCol-1] == false){
                myMaze.move(Direction.LEFT);
                moves.push(Direction.LEFT);
            }
            //UP?   Checks if up is open      checks if row has been visited
            else if (myMaze.isOpen(Direction.UP) && visited[cRow-1][cCol] == false){
                myMaze.move(Direction.UP);
                moves.push(Direction.UP);
            }
            else {
                if (moves.peek().equals(Direction.UP)){
                    myMaze.move(Direction.DOWN);
                }
                else if (moves.peek().equals(Direction.DOWN)){
                    myMaze.move(Direction.UP);
                }
                else if (moves.peek().equals(Direction.LEFT)){
                    myMaze.move(Direction.RIGHT);
                }
                else if (moves.peek().equals(Direction.RIGHT)){
                    myMaze.move(Direction.LEFT);
                }
                moves.pop();}//end else statement
            if (myMaze.goalReached()){
                System.out.println("Maze is solved");            
                break;
            }
            input = kb.nextLine();
        }while(!myMaze.goalReached() || !input.equalsIgnoreCase("q") || !input.equalsIgnoreCase("s"));    
    }//End Solve()
    
}//End MazeSolver()
