package friendo.mtel.loyalty.utility;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;

import java.util.List;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.preferences.LoyaltyPreference;

/**
 * Created by MTel on 2015/6/26.
 */
public class Utilitys {

    public static boolean isBluetooth(){
//        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        return bluetoothAdapter.isEnabled();
        return false;
    }

    public static boolean isGPS(Context context){
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps || network) {
            return true;
        }
        return false;
    }

    public static Location getLocation(Context context){
        String bestProvider = LocationManager.GPS_PROVIDER;
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        bestProvider = locationManager.getBestProvider(criteria,true);
        Location location = locationManager.getLastKnownLocation(bestProvider);

        return location;
    }

    public static boolean isLogin(Context context){
        int memerID = LoyaltyPreference.getMemberID(context);
        if(memerID == -1){
            return false;
        }else{
            return true;
        }
    }

    public static Location locationServiceInital(Context context){
        Location location = null;
        if(isGPS(context)){
            LocationManager lms = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            criteria.setSpeedRequired(true);
            String bestProvider = lms.getBestProvider(criteria, true);
            location = lms.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location == null){
                location = lms.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }
        }
        return location;
    }

    public static double getDistance(Context context,double latitude, double longitude){
        double EARTH_RADIUS = 6378137.0;
        double radLat1 = (locationServiceInital(context).getLatitude() * Math.PI /180.0);
        double radLat2 = (latitude * Math.PI / 180.0);
        double radLat = radLat1 - radLat2;
        double radlng = (locationServiceInital(context).getLongitude() - longitude) * Math.PI / 180.0;
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(radLat / 2), 2)+Math.cos(radLat1)* Math.cos(radLat2) * Math.pow(Math.sin(radlng/2),2)));
        distance = distance * EARTH_RADIUS;
        distance = Math.round(distance * 10000) / 10000;
        return distance;
    }

    public static String codeToWeekday(Context context, int daycode){
        String[] weekday = context.getResources().getStringArray(R.array.weekday);
        return weekday[daycode];
    }

    public static String codeToWeekday(Context context, int[] daycode){
        String weekdays;
        String[] weekday = context.getResources().getStringArray(R.array.weekday);
        return weekday[daycode[0]] +" ~ " +weekday[daycode[daycode.length-1]];
    }

}
