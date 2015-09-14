package friendo.mtel.loyalty.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.astuetz.page.sliding.PageSlidingPagerView;
import com.google.gson.Gson;

import org.json.JSONException;

import friendo.mtel.loyalty.HttpsParams.ParamsManager;
import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.activity.SubFrontPageActivity;
import friendo.mtel.loyalty.adapter.FirmsAdapter;
import friendo.mtel.loyalty.HttpsParams.FrontPageInParams;
import friendo.mtel.loyalty.adapter.FirmsMapAdapter;
import friendo.mtel.loyalty.component.AdsInfoData;
import friendo.mtel.loyalty.component.AdvertisingData;
import friendo.mtel.loyalty.component.FirmListData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.data.GetListResponse;
import friendo.mtel.loyalty.data.GetSearchResponse;
import friendo.mtel.loyalty.view.SearchBarView;
import friendo.mtel.loyalty.view.WebMapJSInterface;

/**
 * Created by MTel on 2015/7/24.
 */
public class FrontPageFragment extends CommonFragment {
    private String TAG = FrontPageFragment.class.getSimpleName();

    private View mView;
    private RecyclerView mListView;
    private RecyclerView mListViewMap;
    private PageSlidingPagerView mAdverising;
    private SearchBarView mSearchbar;
    private FirmsAdapter firmsAdapter;
    private FirmsMapAdapter firmsMapAdapter;
    private WebMapJSInterface mMap;
    private String[] url;

    private Animation slide_in_left, slide_out_right;
    private ViewSwitcher viewSwitcher;
    private int pages = 1 ;

    private FirmListData[] db_FirmListData;

    private int MODE_MAP = 1;
    private int MODE_LIST = 0;
    private int MODE = MODE_LIST;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_store,container,false);
        findView(mView);
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        DataManager.getInstance(getActivity()).qryAdvertising(false,getDataResponse);
        FrontPageInParams frontPageInParams = ParamsManager.getfrontPageInParams(getActivity());
        Gson gson = new Gson();
        String userFilter = gson.toJson(frontPageInParams);
        dataConnection(false,userFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * call list api
     * @param isNeedAPI    isNeedAPI == true is anyway call api data, false is if cache not data then call data
     * @param userFilter
     */
    private void dataConnection(boolean isNeedAPI, String userFilter){
        try{
            Log.d(TAG,"qryFirmList request data = "+userFilter);
            DataManager.getInstance(getActivity()).qryFirmList(pages, userFilter, isNeedAPI, getDataResponse);
        }catch (JSONException e){
            Log.e(TAG,"firm list JSON to data fail ,Exception :" +e);
        }
    }

    private void findView(View v){
        mSearchbar = (SearchBarView) v.findViewById(R.id.csv_Search);
        mSearchbar.setCallback(getSearchResponse);
        mAdverising = (PageSlidingPagerView) v.findViewById(R.id.csv_Advertising);
        viewSwitcher = (ViewSwitcher) v.findViewById(R.id.textSwitcher);

        slide_in_left = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation(getActivity(),android.R.anim.slide_out_right);
        viewSwitcher.setInAnimation(slide_in_left);
        viewSwitcher.setOutAnimation(slide_out_right);

    }

    /**
     * map or list mode change
     * @param mode
     */
    private void ModeControl(int mode){
        if(mode == MODE_LIST){
            viewSwitcher.showNext();
        }else if(mode == MODE_MAP){
            viewSwitcher.showPrevious();
        }
    }

    private void initAdverisingView(AdsInfoData[] db_AdsData){
        if(db_AdsData != null){
            url = new String[db_AdsData.length];
            for(int i=0; i<db_AdsData.length; i++){
                url[i] = db_AdsData[i].getPicture();
            }
        }
        mAdverising.setViewPagerData(url);
        mAdverising.show();
    }

    private void initFirms_List(){
        mListView = (RecyclerView) mView.findViewById(R.id.listView);
        if(db_FirmListData.length != 0){
            mListView.setVisibility(View.VISIBLE);
            firmsAdapter = new FirmsAdapter(getActivity(),db_FirmListData,getListResponse);
            mListView.setAdapter(firmsAdapter);
            mListView.setItemAnimator(new DefaultItemAnimator());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mListView.setLayoutManager(linearLayoutManager);
        }else{
            mListView.setVisibility(View.GONE);
        }
    }

    private void initMap(){
        mMap = (WebMapJSInterface) mView.findViewById(R.id.map);
        for(int i=0; i<db_FirmListData.length; i++){
            mMap.addLocation(db_FirmListData[i].getLatitude(),db_FirmListData[i].getLongitude(),db_FirmListData[i].getCat_id());
        }
        mMap.locateMap();
    }

    private void initFirms_Map(){
        if(db_FirmListData.length != 0){
            mListViewMap = (RecyclerView) mView.findViewById(R.id.listViewMap);
            mListViewMap.setVisibility(View.VISIBLE);
            firmsMapAdapter = new FirmsMapAdapter(getActivity(),db_FirmListData,getListResponse);
            mListViewMap.setAdapter(firmsMapAdapter);
            mListViewMap.setItemAnimator(new DefaultItemAnimator());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mListViewMap.setLayoutManager(linearLayoutManager);
            mListViewMap.setOnScrollListener(onScrollListener);
        }
    }

    /**
     * list onclick
     */
    private GetListResponse getListResponse = new GetListResponse() {
        @Override
        public void onFirmResponse(int position) {
            FirmListData firmListData = db_FirmListData[position];
            Intent intent = new Intent(getActivity(), SubFrontPageActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("value",firmListData);
            intent.putExtras(bundle);
            startActivity(intent);
        }

        @Override
        public void onCouponResponse(int couponID) {

        }
    };

    /**
     * Search bar select end callback
     */
    private GetSearchResponse getSearchResponse = new GetSearchResponse() {
        @Override
        public void onFirmSearch(String userFilter) {
            String data = userFilter;
            dataConnection(true,data);
        }

        @Override
        public void onLimitSearch(String userFilter) {
            String data = userFilter;
        }

        @Override
        public void onModeChange(int modeCode) {
            MODE = modeCode;
            ModeControl(modeCode);
        }
    };

    /**
     * api callback
     */
    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            if(obj instanceof AdvertisingData){
                AdvertisingData advertisingData = (AdvertisingData) obj;
                initAdverisingView(advertisingData.getAdsInfo());
            }
        }

        @Override
        public void onSuccess(Object[] obj) {
            if(obj instanceof FirmListData[]) {
                FirmListData[] firmListData = (FirmListData[]) obj;
                db_FirmListData = firmListData;
                initMap();
                initFirms_List();
                initFirms_Map();
            }
        }

        @Override
        public void onFailure(Object obj) {
            FirmListData[] firmListData = new FirmListData[0];
            db_FirmListData = firmListData;
            initMap();
            initFirms_List();
            initFirms_Map();
        }

        @Override
        public void onFinish() {

        }
    };

    @Override
    public void intentGoogleSearch(String str) {
        super.intentGoogleSearch(str);
    }

    /**
     * Scroll list change map maker point
     */
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if(newState == RecyclerView.SCROLL_STATE_IDLE){
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int position = ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();
                mMap.centerAt(position);
                mMap.locateMap();
                Toast.makeText(getActivity(),"pos:"+position,Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

        }
    };
}
