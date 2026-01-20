import java.time.ZoneId;

public class UTCTimeScreen extends ClockScreen {

    public UTCTimeScreen() {
        super("UTC Time");
    }

    @Override
    protected ZoneId getZone() {
        return ZoneId.of("UTC");
    }

    @Override
    protected String getBackgroundImage() {
        return "R (1).jpg";
    }
}
