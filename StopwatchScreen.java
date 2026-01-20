import javax.swing.*;     // Import Swing components
import java.awt.*;        // Import layout and font classes

public class StopwatchScreen extends JFrame {

    private JLabel timeLabel;   // Label to display the time
    private Timer timer;        // Timer to update the stopwatch
    private int seconds;        // Stores elapsed time in seconds

    // Constructor that sets up the stopwatch window
    public StopwatchScreen() {
        setTitle("Stopwatch");      // Set window title
        setSize(300, 200);      // Set window size
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window

        seconds = 0;              // Start stopwatch at 0
        setupUI();        // Create the user interface
        setupTimer();        // Set up the timer
    }

    // Creates and arranges all UI components
    private void setupUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());    // Use border layout

        // Label that shows the stopwatch time
        timeLabel = new JLabel("00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Consolas", Font.BOLD, 36));

        // Panel to hold the buttons
        JPanel buttonPanel = new JPanel();

        // Create control buttons
    JButton startBtn = new JButton("Start");
       JButton stopBtn = new JButton("Stop");
       JButton resetBtn = new JButton("Reset");
       JButton exitBtn = new JButton("Exit");

        // Start the stopwatch
       startBtn.addActionListener(e -> timer.start());

        // Stop the stopwatch
       stopBtn.addActionListener(e -> timer.stop());

        // Reset the stopwatch
       resetBtn.addActionListener(e -> reset());

        // Close the window
      exitBtn.addActionListener(e -> dispose());

        // Add buttons to the button panel
       buttonPanel.add(startBtn);
      buttonPanel.add(stopBtn);
      buttonPanel.add(resetBtn);
   buttonPanel.add(exitBtn);

        // Add components to the main panel
       panel.add(timeLabel, BorderLayout.CENTER);
      panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add panel to the window
    add(panel);
    }

    // Sets up the timer to update every second
    private void setupTimer() {
        timer = new Timer(1000, e -> {
            seconds++;          // Increase time by one second
            updateLabel();      // Update the display
        });
    }

    // Updates the time label in minutes and seconds
    private void updateLabel() {
        int mins = seconds / 60;    // Calculate minutes
        int secs = seconds % 60;    // Calculate remaining seconds
        timeLabel.setText(String.format("%02d:%02d", mins, secs));
    }

    // Resets the stopwatch back to zero
    private void reset() {
        timer.stop();       // Stop the timer
        seconds = 0;        // Reset seconds
        updateLabel();      // Update display
    }
}
