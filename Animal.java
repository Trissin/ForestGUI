import java.awt.*;
import java.util.Random;
// imports

public class Animal { // animal superclass

    Random rng = new Random(); // random generator

    private int h, w, x;      // member data

    public Animal(int xPos){    // constructor

        h = rng.nextInt(3)+8;    // random height
        w = rng.nextInt(3)+12;     // random width
        x = xPos;  // position parameter
    }

    public int getHeight(){
        return h;
    } // method to return height

    public int getWidth(){
        return w;
    }  // method to return width

    public int getX(){
        return x;
    }    // method to return x position

    public void draw(Graphics g) {   // empty draw method to inherit
        // This method would paint an animal.
    }
}