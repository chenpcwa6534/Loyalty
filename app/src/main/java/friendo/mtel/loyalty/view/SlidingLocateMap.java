package friendo.mtel.loyalty.view;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.adapter.FirmsMapAdapter;
import friendo.mtel.loyalty.component.FirmListData;


/**
 * Created by MTel on 2015/8/26.
 */
public class SlidingLocateMap extends RelativeLayout {
    private String TAG = SlidingLocateMap.class.getSimpleName();

    private WebMapJSInterface mMap;
    private RecyclerView mListView;

    private View mView;
    private Context mContext;

    public SlidingLocateMap(Context context){
        super(context);
        this.mContext = context;
    }

    public SlidingLocateMap(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    private void initView(){
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        mView = layoutInflater.inflate(R.layout.fragment_slidinglocatemap, null);
    }

    private void initMap(FirmListData[] data){
        mMap = (WebMapJSInterface) mView.findViewById(R.id.map);
        for(int i=0; i<data.length; i++){
            mMap.addLocation(data[i].getLatitude(),data[i].getLongitude(),data[i].getCatID());
        }
        mMap.locateMap();
    }

    private void initListView(FirmsMapAdapter adapter){
        mListView = (RecyclerView) mView.findViewById(R.id.listView);
        mListView.setAdapter(adapter);
        mListView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mListView.setLayoutManager(linearLayoutManager);

    }

    public void setAdapter(FirmsMapAdapter adapter,FirmListData[] data){
        initView();
        initMap(data);
        initListView(adapter);
        this.addView(mView);
    }

}
