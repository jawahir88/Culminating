import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


// Abstract parent class for all clock screens

public abstract class ClockScreen extends JFrame {

    protected JLabel timeLabel;// Label to show the time
    protected DateTimeFormatter formatter; // Format for displaying time
    protected JButton exitButton;  // Button to close the window
    // Constructor that sets up the window
    public ClockScreen(String title) {
        setTitle(title);
        setSize(300, 180);
        setLocationRelativeTo(null);// Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// Close only this window
// Set the time format (hours:minutes:seconds)
        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        setupUI(); // Build the user interface
        startClock();// Start updating the time
    }
 // Method that creates and arranges UI components
   private void setupUI() {
    // Create a panel with a background image
    BackgroundPanel panel = new BackgroundPanel(getBackgroundImage());

// Create label to display the time
    timeLabel = new JLabel("--:--:--", SwingConstants.CENTER);
    timeLabel.setFont(new Font("Consolas", Font.BOLD, 32));
    timeLabel.setForeground(Color.RED);

 // Create exit button
    exitButton = new JButton("Exit");
    exitButton.addActionListener(e -> dispose());// Close window when clicked

// Panel to hold the exit button
    JPanel bottomPanel = new JPanel();
    bottomPanel.setOpaque(false); // Make panel transparent
    bottomPanel.add(exitButton);

// Add components to the background panel
    panel.add(timeLabel, BorderLayout.CENTER);
    panel.add(bottomPanel, BorderLayout.SOUTH);

    setContentPane(panel);
}

 // Child classes must provide a background image path
protected abstract String getBackgroundImage();

 // Starts a timer that updates the time every second
    private void startClock() {
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }
// Child classes must provide the time zone
    protected abstract ZoneId getZone();

 // Updates the time shown on the label
    private void updateTime() {
        LocalTime time = LocalTime.now(getZone());
        timeLabel.setText(time.format(formatter));
    }
}
