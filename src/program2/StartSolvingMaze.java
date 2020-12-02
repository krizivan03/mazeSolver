package program2;
/*
This java file contains the StartSolvingMaze class that will ask user to input
rows & columns for a maze and then runs
*/
import java.io.*;
import java.util.*;

public class StartSolvingMaze {
    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);
        
        System.out.println("How many rows will this Maze have?");
        int rows = kb.nextInt();
        System.out.println("How many columns will this Maze have?");
        int col = kb.nextInt();
        
        //new instance of MazeSolver called theMS, user input rows & columns are passed in
        MazeSolver theMS = new MazeSolver(rows,col); 
        theMS.solve();
        
        
    }
    
}
