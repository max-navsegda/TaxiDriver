package max.com.taxidriver.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import max.com.taxidriver.R;
import max.com.taxidriver.model.OrderDto;

/**
 * Created by max on 10.04.17.
 */
public class MarkerAdapter implements GoogleMap.InfoWindowAdapter {
    private Context context;

    public MarkerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        try {
            OrderDto orderDto = OrderDto.Oreders.getOrders().get(OrderDto.Oreders.getOrders().size() - 1);
            View convertView = LayoutInflater.from(context).inflate(R.layout.order_list_style, null);
            ((TextView) convertView.findViewById(R.id.fromET)).setText(orderDto.getPointA());
            ((TextView) convertView.findViewById(R.id.toET)).setText(orderDto.getPointB());
            ((TextView) convertView.findViewById(R.id.whenTV)).setText(orderDto.getTime());
            convertView.findViewById(R.id.close).setVisibility(View.GONE);
            return convertView;
        } catch (Exception e) {
            return null;
        }
    }
}
