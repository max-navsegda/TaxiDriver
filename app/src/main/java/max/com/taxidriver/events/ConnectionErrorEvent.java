package max.com.taxidriver.events;

/**
 * Created by max on 01.05.17.
 */

public class ConnectionErrorEvent {
    private boolean isShow;

    public ConnectionErrorEvent(boolean isShow) {
        this.isShow = isShow;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
