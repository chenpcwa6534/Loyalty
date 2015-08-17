package friendo.mtel.loyalty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.page.sliding.PageSlidingPagerView;
import com.google.gson.Gson;

import friendo.mtel.loyalty.HttpsParams.ParamsManager;
import friendo.mtel.loyalty.activity.SubFrontPageActivity;
import friendo.mtel.loyalty.adapter.FirmsAdapter;
import friendo.mtel.loyalty.HttpsParams.FrontPageInParams;
import friendo.mtel.loyalty.common.DeviceInformation;
import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.components.FrontPageAdData;
import friendo.mtel.loyalty.components.FrontPageFirmData;
import friendo.mtel.loyalty.components.FrontPageRTNData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.fragment.CommonFragment;
import friendo.mtel.loyalty.view.ConditionsSearchView;

/**
 * Created by MTel on 2015/7/24.
 */
public class FrontPageFragment extends CommonFragment {
    private String TAG = FrontPageFragment.class.getSimpleName();

    private View mView;

    private RecyclerView mListView;
    private PageSlidingPagerView mAdverising;
    private ConditionsSearchView mSearchbar;
    private View mGeneralModeView;
    private View mMapModeView;
    private FirmsAdapter firmsAdapter;

    private String[] url;
    private int pageIndex = 1 ;

    private FrontPageRTNData db_frontPageRTNData;

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
        FrontPageInParams frontPageInParams = ParamsManager.getfrontPageInParams(getActivity());
        Gson gson = new Gson();
        String userFilter = gson.toJson(frontPageInParams);
        DataManager.getInstance(getActivity()).qryFrontPageRTNData(getActivity(), Env.getMemberID(getActivity()), DeviceInformation.getDeviceToken(), String.valueOf(pageIndex), userFilter, false, getDataResponse);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void findView(View v){
        mSearchbar = (ConditionsSearchView) v.findViewById(R.id.csv_Search);
        mSearchbar.setCallback(onSearchResponse);
        mAdverising = (PageSlidingPagerView) v.findViewById(R.id.csv_Advertising);
        mGeneralModeView = (View) v.findViewById(R.id.generalMode);
        mMapModeView = (View) v.findViewById(R.id.mapMode);

    }

    private void initAdverisingView(FrontPageAdData[] adsData){
        if(adsData != null){
            url = new String[adsData.length];
            for(int i=0; i<adsData.length; i++){
                url[i] = adsData[i].getPicture();
            }
        }
        mAdverising.setViewPagerData(url);
        mAdverising.show();
    }

    private void initFirms(FrontPageFirmData[] frontPageFirmData){
        if(frontPageFirmData.length != 0){
            mListView = (RecyclerView) mView.findViewById(R.id.listView);
            mListView.setVisibility(View.VISIBLE);

            firmsAdapter = new FirmsAdapter(getActivity(),frontPageFirmData,onClickListener);
            mListView.setAdapter(firmsAdapter);
            mListView.setItemAnimator(new DefaultItemAnimator());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mListView.setLayoutManager(linearLayoutManager);
        }
    }


    private  FirmsAdapter.ViewHolder.ClickListener onClickListener = new FirmsAdapter.ViewHolder.ClickListener(){

        @Override
        public void onClick(int position) {
            Intent intent = new Intent(getActivity(), SubFrontPageActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("firmID",db_frontPageRTNData.getFirms()[position].getFirm_id());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

    private ConditionsSearchView.SearchResponse onSearchResponse = new ConditionsSearchView.SearchResponse() {
        @Override
        public void onSearch(FrontPageInParams data) {
            Gson gson = new Gson();
            String json = gson.toJson(data);
        }
    };

    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            FrontPageRTNData frontPageRTNData = (FrontPageRTNData) obj;
            db_frontPageRTNData = frontPageRTNData;
            initAdverisingView(frontPageRTNData.getAds());
            initFirms(frontPageRTNData.getFirms());
        }

        @Override
        public void onSuccess(Object[] obj) {

        }

        @Override
        public void onFailure(Object obj) {

        }

        @Override
        public void onFinish() {

        }
    };
}
