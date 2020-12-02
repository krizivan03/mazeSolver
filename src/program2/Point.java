package program2;

//package Program1;


import java.math.*;


public class Point {
    private int x;
    private int y;
    
    public Point(){
    this.x=2;
    this.y=-7;
    }
    public Point(int x, int y){
    this.x = x;
    this.y = y;
    }
    Point(Point aPoint){
        if (aPoint==null)
            throw new IllegalArgumentException("your meaningful String here");
        this.x = aPoint.x;
        this.y = aPoint.y;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
    public double distanceTo(Point otherPoint){
          if (otherPoint==null)
            throw new IllegalArgumentException("your meaningful String here");
          return Math.hypot(otherPoint.x-this.x,otherPoint.y-this.y);
    }
    public boolean equals(Object obj){
        if (obj == null)
            return false;    
        if (this.getClass() != obj.getClass())
            return false;    
        Point objPoint = (Point)obj;
            return this.x == objPoint.x 
                    && this.y == objPoint.y;
    }
    public boolean inQuadrant(int quadrant){
        while (quadrant >=1 && quadrant <=4 ){
            if (quadrant == 1)
                return this.x>0 && this.y>0;
            if (quadrant == 2)
                return this.x<0 && this.y>0;
            if (quadrant == 3)
                return this.x<0 && this.y<0;
            if (quadrant == 4)
                return this.x>0 && this.y<0;
        }
        throw new IllegalArgumentException("your meaningful String here");     
    }
    public void translate(int xMove, int yMove){
        this.x += xMove;
        this.y += yMove;
    }
    public boolean onXAxis(){
        return this.y == 0;
    }
    public boolean onYAxis(){
        return this.x == 0;
    }
    public static void main(String[] args) {
           
    }
}