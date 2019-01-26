import java.awt.*;
import java.util.Random;

public class Bird extends Animal {   // this is a hummingbird
    private final int Y_SKYBOX = 295;
    Random rng = new Random();
    private int h, w, x, xRight, xLeft, randomMover,startPos;
    private int yPos = rng.nextInt(Y_SKYBOX);
    private boolean changeStart;
    boolean goLeft = false;
    boolean goRight = false;
    int speed = rng.nextInt(3)+1;
    private int flapCount = 0;

    /*----------------------Member Data-----------------------------*/

    public Bird (int xPos){
        super(xPos);
        h = super.getHeight();  // get height
        w = super.getWidth();  // get width
        x = xPos;
        startPos = xPos;

        randomMover = rng.nextInt(800);
        xRight = startPos - randomMover;
        xLeft = startPos + randomMover;
    }
    /*----------------------Returns starting identity-----------------------------*/
    public int getStart(){
        if (changeStart == true){
            startPos = Math.abs(startPos-800);
            changeStart = false;
        }
        return startPos;
    }

    /*----------------------Fly from right to left-----------------------------*/

    public void flyLeft(Graphics g){
        Color blueHead = new Color (70,0,205);  // custom bird head colour
        Color yellowNeck = new Color (255,215,0);
        Color greenWings = new Color (50,205,50);
        Color pinkTail = new Color(199,21,133);

        int []x1pts = {xLeft, xLeft+2, xLeft+6};
        int []y1pts = {yPos+22,yPos+14,yPos+20};    // first triangle (head)

        int []x2pts = {xLeft+2, xLeft+10, xLeft+12};
        int []y2pts = {yPos+14,yPos+26,yPos+16};   // second triangle (neck/body)


        int []x3pts = {xLeft+10, xLeft+13, xLeft+20, xLeft+30};
        int []y3pts = {yPos+26,yPos+8,yPos+26,yPos};

        if (flapCount%2 == 0){
            y3pts = new int[]{yPos+16,yPos+30,yPos+18,yPos+38};  // third polygon (body/wings) yPos+30,yPos+18,yPos+38}
        } //int []y3pts = {yPos+26,yPos+8,yPos+26,yPos};
        else{
            y3pts = new int[] {yPos+26,yPos+8,yPos+26,yPos};
        }
        flapCount++;


        int []x4pts = {xLeft+18, xLeft+19, xLeft+26};
        int []y4pts = {yPos+26,yPos+21,yPos+30};      // fourth polygon (tail)

        g.setColor(blueHead);
        g.fillPolygon(x1pts,y1pts,3);    // draw head

        g.setColor(yellowNeck);
        g.fillPolygon(x2pts,y2pts,3);  // draw neck/body

        g.setColor(greenWings);
        g.fillPolygon(x3pts,y3pts,3);   // draw body/wings

        g.setColor(pinkTail);
        g.fillPolygon(x4pts,y4pts,3);   // draw tail

        xLeft=xLeft - speed;

        if (xLeft < 0-w) {
            yPos = rng.nextInt(Y_SKYBOX);
            xLeft = 800;
            xRight = 0;
            speed = rng.nextInt(4)+2;
            flapCount = 0;

            changeStart = rng.nextBoolean();
            /*--------------------------------------------------------*/
        }
    }

    /*----------------------Fly from left to right-----------------------------*/

    public void flyRight (Graphics g){
        Color blueHead = new Color (70,0,205);  // custom bird head colour
        Color yellowNeck = new Color (255,215,0);
        Color greenWings = new Color (50,205,50);
        Color pinkTail = new Color(199,21,133);

        int []x1pts = {xRight, xRight-2, xRight-6};
        int []y1pts = {yPos+22,yPos+14,yPos+20};    // first triangle (head)

        int []x2pts = {xRight-2, xRight-10, xRight-12};
        int []y2pts = {yPos+14,yPos+26,yPos+16};   // second triangle (neck/body)

        int []x3pts = {xRight-10, xRight-13, xRight-20, xRight-30};
        int []y3pts = {yPos+26,yPos+8,yPos+26,yPos};
        if (flapCount%2 == 0){
            y3pts = new int[]{yPos+16,yPos+30,yPos+18,yPos+38};  // third polygon (body/wings) yPos+30,yPos+18,yPos+38}
        } //int []y3pts = {yPos+26,yPos+8,yPos+26,yPos};
        else{
            y3pts = new int[] {yPos+26,yPos+8,yPos+26,yPos};
        }
        flapCount++;

        int []x4pts = {xRight-18, xRight-19, xRight-26};
        int []y4pts = {yPos+26,yPos+21,yPos+30};      // fourth polygon (tail)

        g.setColor(blueHead);
        g.fillPolygon(x1pts,y1pts,3);    // draw head

        g.setColor(yellowNeck);
        g.fillPolygon(x2pts,y2pts,3);  // draw neck/body

        g.setColor(greenWings);
        g.fillPolygon(x3pts,y3pts,3);   // draw body/wings

        g.setColor(pinkTail);
        g.fillPolygon(x4pts,y4pts,3);   // draw tail

        xRight += speed;

        if (xRight > 870) {
            yPos = rng.nextInt(Y_SKYBOX);
            xLeft = 800;
            xRight = 0;
            speed = rng.nextInt(4)+2;
            flapCount = 0;

            changeStart = rng.nextBoolean();
            /*--------------------------------------------------------*/
        }
    }
}

/*
        int []x1pts = {x-30, x+(w/2), x+w+30};  // x coordinates of triangle
        int []y1pts = {GROUND-h,GROUND-h-50,GROUND-h};  // y coordinates of first triangle

        int []x2pts = {x-30, x+(w/2), x+w+30};  // x coordinates of triangle
        int []y2pts = {GROUND-h,GROUND-h-50,GROUND-h};  // y coordinates of first triangle

        int []x3pts = {x-30, x+(w/2), x+w+30};  // x coordinates of triangle
        int []y3pts = {GROUND-h,GROUND-h-50,GROUND-h};  // y coordinates of first triangle

        int []x4pts = {x-30, x+(w/2), x+w+30};  // x coordinates of triangle
        int []y4pts = {GROUND-h,GROUND-h-50,GROUND-h};  // y coordinates of first triangle



        g.fillPolygon(x1pts,y1pts,3);
        g.fillPolygon(x1pts,y1pts,3);
        g.fillPolygon(x1pts,y1pts,3);
        g.fillPolygon(x1pts,y2pts,3);    // green triangles are leaves*/
