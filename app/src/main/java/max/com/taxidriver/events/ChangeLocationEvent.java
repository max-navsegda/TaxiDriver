package max.com.taxidriver.events;

import android.location.Location;

/**
 * Created by max on 07.04.17.
 */

public class ChangeLocationEvent {
    private Location location;

    public ChangeLocationEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}