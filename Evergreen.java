import java.awt.*;
// imports
public class Evergreen extends Coniferous { // subclass of coniferous and tree

    final int GROUND = 450; // height of the ground


    public Evergreen (int xPos) {
        super(xPos);
    } // get the position in parameter

    public void grow (Graphics g){
        // This method would draw an EVERGREEN tree, not a regular tree.

        int x = super.getPos();    // get the position
        int h = super.getHeight(); // get the height
        int w = super.getWidth();  // get the width

        int []x1pts = {x-15, x+(w/2), x+w+15};   // x coordinates of triangles
        int []y1pts = {GROUND-h/2,GROUND-h/2-50,GROUND-h/2};  // y coordinates of triangle 1
        int []y2pts = {GROUND-h/2-h/3,GROUND-h-87,GROUND-h/2-h/3};  // y coordinates of triangle 2

        Color brown = new Color (83,53,10);   // custom trunk color
        Color everLeaf = new Color (58, 95, 11);  // custom leaf color


        g.setColor(brown);
        g.fillRect(x,GROUND-h, w, h);   // draw brown rectangle as trunk
        g.setColor(everLeaf);
        g.fillPolygon(x1pts,y1pts,3);
        g.fillPolygon(x1pts,y2pts,3);   // draw green triangles as leaves

    }
}