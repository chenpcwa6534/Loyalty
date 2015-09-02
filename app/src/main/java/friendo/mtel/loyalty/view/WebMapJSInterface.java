package friendo.mtel.loyalty.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.ArrayList;


/**
 * Created by MTel on 2015/8/26.
 */
public class WebMapJSInterface extends WebView {
    private String MAP_URL = "file:///android_asset/googleMap.html";
    private int ITEMINDE = 1;

    private String defaultLat = "[25.033971,25.041182]";
    private String defaultLng = "[121.564331,121.554657]";
    private String defaultIcon = "[0,1]";

    private ArrayList<String> latitude = new ArrayList<>();
    private ArrayList<String> longitude = new ArrayList<>();
    private ArrayList<Integer> icon = new ArrayList<>();
    private int defaultPosition = 0;

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
        //onCreateView();
    }

    public WebMapJSInterface(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        latitude.add(lat);
        longitude.add(lng);
        icon.add(getLocationIcon(catID));
    }

    public void centerAt(int position){
        final String centerURL = "javascript:centerAt(" +
                latitude.get(position) + "," +
                longitude.get(position)+ ")";
        this.loadUrl(centerURL);
        defaultPosition = position;
    }

    public void locateMap(){
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
    }

    private int getLocationIcon(int catID){
        int icon = 0;
        switch (catID){
            case 1:
                icon = 0;
                break;
            case 2:
                icon = 1;
                break;
            case 3:
                icon = 2;
                break;
            case 4:
                icon = 3;
                break;
            case 5:
                icon = 4;
                break;
            case 6:
                icon = 5;
                break;
            case 7:
                icon = 6;
                break;
            case 8:
                icon = 7;
                break;
            case 9:
                icon = 8;
                break;
            case 10:
                icon =9;
                break;
            case 11:
                icon = 10;
                break;
            case 12:
                icon = 11;
                break;
            case 13:
                icon = 12;
                break;
            case 14:
                icon = 13;
                break;
            case 15:
                icon = 14;
                break;
            case 16:
                icon = 15;
                break;
            case 17:
                icon = 16;
                break;
            case 18:
                icon = 17;
                break;

        }
        return icon;
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
