import java.time.ZoneId;

public class TokyoTimeScreen extends ClockScreen {

    public TokyoTimeScreen() {
        super("Tokyo Time");
    }

    @Override
    protected ZoneId getZone() {
        return ZoneId.of("Asia/Tokyo");
    }

    @Override
    protected String getBackgroundImage() {
        return "59a4bc60-f23c-11eb-bf75-c38993010fb7.jpg";
    }
}
