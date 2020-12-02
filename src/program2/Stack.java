package program2;

/*
Stack class that uses Generics 
and multiple methods to implement a LIFO Data Structure
*/
import java.io.*;
import java.util.*;

public class Stack<E> implements Serializable{
    //Data
    private ArrayList<E> contents;

    //Default Constructor
    //Creates stack
    public Stack(){
    this.contents = new java.util.ArrayList<E>();
    }
    
    //Methods
    
    //Push, adds whatever is passed in to the top of the  Stack
    public void push(E elt){
        this.contents.add(elt);
    }
    //pop,removes top value from stack and returns it
    public E pop(){
        if (contents.isEmpty())
            throw new EmptyStackException();
        return contents.remove(contents.size()-1);
    }
    //Peek,  returns top value from stack without removing it
    public E peek(){
        if (contents.isEmpty())
            throw new EmptyStackException();
        return contents.get(contents.size()-1);
    }
    //isEmpty, boolean that returns true if the stack is empty
    public boolean isEmpty(){
        return contents.isEmpty();
    }
    //size, returns stack size in integer form
    public int size(){
        return contents.size();
    }
    public static void main(String[] args) {
    }
    
}
