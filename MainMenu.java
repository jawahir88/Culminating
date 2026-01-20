import javax.swing.*;     // Import Swing components
import java.awt.*;        // Import layout classes

public class MainMenu extends JFrame {

    // Constructor that sets up the main menu window
    public MainMenu() {
       setTitle("Time Management App");   // Set window title
        setSize(350, 300);                 // Set window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app when window closes
        setLocationRelativeTo(null);       // Center the window

// Create a panel to hold buttons
    JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 rows, spacing between buttons

 // Create buttons for different screens
      JButton localBtn = new JButton("Local Time");
        JButton utcBtn = new JButton("UTC Time");
       JButton tokyoBtn = new JButton("Tokyo Time");
        JButton stopwatchBtn = new JButton("Stopwatch");
        JButton exitBtn = new JButton("Exit");

     // Open local time screen
       localBtn.addActionListener(e -> new LocalTimeScreen().setVisible(true));

// Open UTC time screen
       utcBtn.addActionListener(e -> new UTCTimeScreen().setVisible(true));

       // Open Tokyo time screen
      tokyoBtn.addActionListener(e -> new TokyoTimeScreen().setVisible(true));

 // Open stopwatch screen
  stopwatchBtn.addActionListener(e -> new StopwatchScreen().setVisible(true));

        // Exit the application
   exitBtn.addActionListener(e -> System.exit(0));

        // Add buttons to the panel
      panel.add(localBtn);
    panel.add(utcBtn);
    panel.add(tokyoBtn);
    panel.add(stopwatchBtn);
     panel.add(exitBtn);

        // Add panel to the window
       add(panel);
    }

    // Main method that starts the program
    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
    SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
