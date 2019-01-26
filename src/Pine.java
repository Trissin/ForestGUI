import java.awt.*;
// imports
public class Pine extends Coniferous { // subclass of coniferous and tree

    final int GROUND = 450; // ground height


    public Pine (int xPos) {
        super(xPos);
    }  // get position

    public void grow (Graphics g){  //draw method
        // This method would draw a PINE tree, not a regular tree.

        int x = super.getPos();   // get position
        int h = super.getHeight();  // get height
        int w = super.getWidth();  // get width

        int []x1pts = {x-30, x+(w/2), x+w+30};  // x coordinates of triangle
        int []y1pts = {GROUND-h,GROUND-h-50,GROUND-h};  // y coordinates of first triangle
        int []y2pts = {GROUND-h-h/3,GROUND-h-87,GROUND-h-h/3};  // y coordinates of second triangle

        Color brown = new Color (83,53,10);      // custom trunk color
        Color treeLeaf = new Color (77, 158, 58);  // custom leaf color


        g.setColor(brown);
        g.fillRect(x,GROUND-h, w, h);    // brown rectangle is trunk
        g.setColor(treeLeaf);
        g.fillPolygon(x1pts,y1pts,3);
        g.fillPolygon(x1pts,y2pts,3);    // green triangles are leaves

    }
}