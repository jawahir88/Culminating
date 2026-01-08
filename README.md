# Culminating

## Project Overview: 
This project's main objective is time management in various time zones. Users can interact with an interactive digital clock interface, create reminders, and view the current time in several global time zones.

Java Swing elements like buttons, labels, text fields, combo boxes, and panels can be used efficiently with this project.

It provides an obvious opportunity to apply two object-oriented programming concepts: inheritance and modular class design.

By the time this project is finished, the application aims to:
Show a real-time updating digital clock.

Using an interactive interface, let users choose and see several time zones.

Give consumers the option to set alarms or reminders according to specific time zones.

To ensure data preservation between sessions, use file I/O to store user-selected time zones and reminders.

We chose this because this application would allow us to incorporate various different elements to thoroughly demonstrate our understanding of the concepts we have learned throughout the course. The clock app is also an extremely commonly used app, so it would be educational for us to attempt to code it, as we can learn the logistics behind a very helpful and frequently used application.


## Ai generated code:
Prompt: give me a java swing code program of a digital clokc that shows a basic outline of a clock and itsz elements that im able to build upon and successfully complete myself to achieve a working digital clock
Code:import javax.swing.*;
import java.awt.*;

public class DigitalClock extends JFrame {

    // This label will eventually show the time
    private JLabel timeLabel;

    // Constructor sets up the window
    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center window

        // Call method to build UI
        initializeUI();
    }

    private void initializeUI() {
        // Use a simple layout
        setLayout(new BorderLayout());

        // Create label (placeholder text)
        timeLabel = new JLabel("HH:MM:SS", SwingConstants.CENTER);

        // Set font and color (basic styling)
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        // Add label to window
        add(timeLabel, BorderLayout.CENTER);

        // TODO:
        // 1. Create a Timer
        // 2. Get the current system time
        // 3. Format it
        // 4. Update timeLabel every second
    }

    public static void main(String[] args) {
        // Ensure Swing runs on correct thread
        SwingUtilities.invokeLater(() -> {
            new DigitalClock().setVisible(true);
        });
    }
}


Explanation:
We are using this code as a foundation for building a fully functional digital clock. The purpose of the code is not to provide a complete solution, but to give a structured outline.The program makes the main window, sets up the layout, and includes a JLabel where the time will be displayed. First we will use Java’s time API to get the current system time. Then  well format the time into a readable digital format (hours, minutes, and seconds). To keep the clock acting as in real time and work as a clock,  we will add a Swing timer that triggers every second. Each time the timer runs, it will update the text of the label and itll display the new current time. This allows the clock to refresh continuously without freezing the user interface.


## Ai number 2
Prompt: can you add to the previous code you generated to include adding backgrounds, changing the layout of the page, and posibly having multiple timezones on this clock? 
Code: import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DigitalClock extends JFrame {

    private JLabel localTimeLabel;
    private JLabel utcTimeLabel;
    private JLabel tokyoTimeLabel;

    private DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    public DigitalClock() {
        setTitle("Multi-Timezone Digital Clock");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initializeUI();
        startClock();
    }

    private void initializeUI() {
        // Custom background panel
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(Color.BLACK);
        backgroundPanel.setLayout(new BorderLayout());

        // Title at the top
        JLabel titleLabel = new JLabel("Digital Clock", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        backgroundPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel to hold clocks
        JPanel clockPanel = new JPanel();
        clockPanel.setBackground(Color.BLACK);
        clockPanel.setLayout(new GridLayout(3, 1, 10, 10));

        localTimeLabel = createClockLabel("Local Time");
        utcTimeLabel = createClockLabel("UTC Time");
        tokyoTimeLabel = createClockLabel("Tokyo Time");

        clockPanel.add(localTimeLabel);
        clockPanel.add(utcTimeLabel);
        clockPanel.add(tokyoTimeLabel);

        backgroundPanel.add(clockPanel, BorderLayout.CENTER);

        add(backgroundPanel);
    }

    private JLabel createClockLabel(String title) {
        JLabel label = new JLabel(title + ": --:--:--", SwingConstants.CENTER);
        label.setFont(new Font("Consolas", Font.BOLD, 22));
        label.setForeground(Color.GREEN);
        label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        return label;
    }

    private void startClock() {
        Timer timer = new Timer(1000, e -> updateTimes());
        timer.start();
    }

    private void updateTimes() {
        LocalTime localTime = LocalTime.now();
        LocalTime utcTime = LocalTime.now(ZoneId.of("UTC"));
        LocalTime tokyoTime = LocalTime.now(ZoneId.of("Asia/Tokyo"));

        localTimeLabel.setText("Local Time: " + localTime.format(formatter));
        utcTimeLabel.setText("UTC Time: " + utcTime.format(formatter));
        tokyoTimeLabel.setText("Tokyo Time: " + tokyoTime.format(formatter));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DigitalClock().setVisible(true);
        });
    }
}

Explanation:
Improving the clock's design and layout is one of the major changes we plan to make. To properly organize the elements on the screen, we will use various layout managers including Gridlayout and Borderlayout. In order to make the clock appear more like a genuine digital display rather than a simple window and more unique, we also plan to add background panels and change fonts, colors, and borders. Additionally, we want to add more time zones to the clock to increase its functionality. To accomplish this, we will get the current time for different areas using Java's time API, specifically LocalTime and ZoneId. Each time zone will be displayed using the current label structure, and they will all be updated by a single Swing Timer that runs every second.

