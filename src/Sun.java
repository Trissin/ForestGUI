import java.awt.*;  // imports
public class Sun {   // sun class

    final int WIDTH = 50;  // predetermined height
    final int HEIGHT = 50;  // predetermined width

    int degrees;  // degrees
    int counter = 0;   // will count for loops
    double radians;  // radians
    int x1, y1, x2, y2;   // line coordinates
    double PI = 3.1415926535;   // pi!

    public void draw(Graphics g){  // draw method
        Color sun = new Color(253, 184, 19);   // custom sun colour
        g.setColor(sun);
        g.fillOval(45, 35, 50, 50);   // draw a circle

        for (int i = 0; i < 18; i++) {   // draw the rays
            degrees = i*20+counter;      // the degree of the rays
            radians = degrees*PI / 180;  // convert degrees to radians
            x1 = (int) (35 * Math.cos(radians) + 70);  // first x coordinate of the ray, represented through cos function of radians
            y1 = (int) (35 * Math.sin(radians) + 60);  // first y coordinate of the ray, represented through sin functions of radians
            x2 = (int) (50 * Math.cos(radians) + 70);  // second x coordinate of the ray, represented through cos function of radians
            y2 = (int) (50 * Math.sin(radians) + 60);  // second y coordinate of the ray, represented through sin function of radians
            g.drawLine(x1, y1, x2, y2);  // draw that line!
        }
        counter++; // increase the degree of the rays by one
        /*---------------------------- Delay Creator -------------------------------*/
        try
        {
            Thread.sleep(10);  // wait 10 ms
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
