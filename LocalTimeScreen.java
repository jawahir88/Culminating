import java.time.ZoneId;   // Import time zone class

public class LocalTimeScreen extends ClockScreen {

    // Constructor that sets the window title
    public LocalTimeScreen() {
        super("Eastern Time");   // Call parent constructor with title
    }

    // Returns the time zone used for this clock
    @Override
    protected ZoneId getZone() {
        return ZoneId.of("America/New_York"); // Eastern Time zone
    }

    // Returns the background image for this screen
    @Override
    protected String getBackgroundImage() {
        return "R.jpg"; // Image file name
    }
}
