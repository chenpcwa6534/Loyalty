package friendo.mtel.loyalty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;

import friendo.mtel.loyalty.component.FirmListData;
import friendo.mtel.loyalty.data.DataCache;
import friendo.mtel.loyalty.utility.ColorTable;


/**
 * Created by MTel on 2015/8/26.
 */
public class WebMapJSInterface extends WebView {
    private String TAG = WebMapJSInterface.class.getSimpleName();
    private String MAP_URL = "file:///android_asset/googleMap.html";
    private int ITEMINDE = 1;

    private Context mContext;
    private String defaultLat = "[25.033971,25.041182]";
    private String defaultLng = "[121.564331,121.554657]";
    private String defaultIcon = "[0,1]";

    private ArrayList<String> latitude = new ArrayList<>();
    private ArrayList<String> longitude = new ArrayList<>();
    private ArrayList<Integer> icon = new ArrayList<>();
    private int defaultPosition = 0;
    private int currentPosition = -1;
    private boolean isDataError = false;

    //控制地圖縮放大小  0~18 , 0:最遠 18：最近
    private int zoom = 14;
    //是否顯示放大縮小控制項
    private boolean zoomControl  = false;
    //是否顯示移動控制項
    private boolean panControl = false;
    //是否顯示切換地圖檢視類型控制項
    private boolean mapTypeControl = false;
    //是否顯示比例尺資訊
    private boolean scaleControl = false;
    //是否顯示街景服務控制項
    private boolean streetViewControl = false;
    //是否顯示總覽圖的面板，在右下力有個開合的圖示
    private boolean overviewMapControl = false;

    public WebMapJSInterface(Context context) {
        super(context);
        this.mContext = context;
        //onCreateView();
    }

    public WebMapJSInterface(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        //onCreateView();
    }

    private void onCreateView(){
        this.getSettings().setJavaScriptEnabled(true);
        this.setWebViewClient(new WebViewClient());
        this.loadUrl(MAP_URL);

        this.addJavascriptInterface(new JavascriptInterface(), "android");
    }

    public void addLocation(String lat, String lng){
        addLocation(lat, lng, 0);
    }

    public void addLocation(String lat, String lng ,int catID){
        lat = lat.equals("")? "0":lat;
        lng = lng.equals("")? "0":lng;
        latitude.add(lat);
        longitude.add(lng);
        icon.add(ColorTable.getInstance(mContext).getLocationIcon(catID));
    }

    public void centerAt(int position){
        final String centerURL = "javascript:centerAt(" +
                latitude.get(position) + "," +
                longitude.get(position)+ ")";
        this.loadUrl(centerURL);
        defaultPosition = position;
    }

    public void locateMap(){
        if(currentPosition != defaultPosition){
            if(latitude.size() != 0 && longitude.size() !=0){
                String JSInterface_lat = "";
                String JSInterface_lng = "";
                String JSInterface_icon = "";
                for(int i=0; i<latitude.size(); i++){
                    if(i != 0){
                        JSInterface_lat += ",";
                        JSInterface_lng += ",";
                        JSInterface_icon += ",";
                    }
                    JSInterface_lat += latitude.get(i).toString();
                    JSInterface_lng += longitude.get(i).toString();
                    JSInterface_icon += icon.get(i).toString();
                }
                defaultLat = "[" + JSInterface_lat + "]";
                defaultLng = "[" + JSInterface_lng + "]";
                defaultIcon = "[" + JSInterface_icon + "]";
            }
            onCreateView();
            FirmListData[] data = DataCache.cacheFirmListData;
            Log.d(TAG,"position = "+ defaultPosition +" ;catid = " +data[defaultPosition].getCat_id() + " iconid = "+icon.get(defaultPosition));
        }
    }


    private class JavascriptInterface{
        @android.webkit.JavascriptInterface
        public String getLatitude(){
            String lat = defaultLat;
            return lat;
        }
        @android.webkit.JavascriptInterface
        public String getLongitude(){
            String lng = defaultLng;
            return lng;
        }
        @android.webkit.JavascriptInterface
        public String getIcon(){
            String icon = defaultIcon;
            return icon;
        }
        @android.webkit.JavascriptInterface
        public int getPosition(){
            int position = defaultPosition;
            return position;
        }
    }
}
