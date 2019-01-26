import javax.swing.*;   // imports

public class Forest {
    public static void main (String [] args) {  // driver class
        // Create the frame
        JFrame frame = new JFrame("Forest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Add the forest panel
        frame.getContentPane().add(new ForestPanel());
        // Make visible
        frame.pack();
        // Organize frame properly
        frame.setVisible(true);
    }

}
