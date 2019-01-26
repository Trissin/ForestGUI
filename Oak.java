import java.awt.*; // imports

public class Oak extends Deciduous { // subclass of deciduous and tree

    final int GROUND = 450; // ground height


    public Oak (int xPos) {
        super(xPos);
    } // oak class

    public void grow (Graphics g){ // draw  method
        // This method would draw an OAK tree, not a regular tree.
        int x = super.getPos();    // get position
        int h = super.getHeight();  // get height
        int w = super.getWidth();  // get width

        Color brown = new Color (83,53,10);    // custom trunk  color
        Color treeLeaf = new Color (77, 158, 58);  // custom leaf color

        g.setColor(brown);
        g.fillRect(x,GROUND-h, w, h);    // brown rectangle is trunk
        g.setColor(treeLeaf);
        g.fillOval(x-(3*w/3),GROUND-5*h/4,4*w/2,3*w/2);
        g.fillOval(x-(w/3),GROUND-3*h/2,4*w/2,3*w/2);
        g.fillOval(x+(2*w/10),GROUND-5*h/4,4*w/2,3*w/2);    // draw green circles as leaves

    }
}