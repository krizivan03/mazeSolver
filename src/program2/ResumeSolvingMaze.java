package program2;
/*
This java file will be able to pull up serialized file saved initially in MazeSolver.
*/
import java.io.*;
import java.util.*;

public class ResumeSolvingMaze {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Enter the name of the file that contains the serialized class");
        Scanner kb = new Scanner(System.in);
        String filename = kb.nextLine();
        
        ObjectInputStream oisVar = new ObjectInputStream(new FileInputStream(filename));
        
        
        MazeSolver mSolver = (MazeSolver)oisVar.readObject();    //reads it in as an Object; we must typecast
        mSolver.solve();
        oisVar.close();
        

    
    }
}
