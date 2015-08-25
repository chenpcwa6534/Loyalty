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
import friendo.mtel.loyalty.component.AdsInfoData;
import friendo.mtel.loyalty.component.AdvertisingData;
import friendo.mtel.loyalty.component.FirmListData;
import friendo.mtel.loyalty.components.FrontPageAdData;
import friendo.mtel.loyalty.components.FrontPageFirmData;
import friendo.mtel.loyalty.components.FrontPageRTNData;
import friendo.mtel.loyalty.data.DataCache;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.data.GetSearchResponse;
import friendo.mtel.loyalty.fragment.CommonFragment;
import friendo.mtel.loyalty.view.ConditionsSearchView;
import friendo.mtel.loyalty.view.SearchBarView;

/**
 * Created by MTel on 2015/7/24.
 */
public class FrontPageFragment extends CommonFragment {
    private String TAG = FrontPageFragment.class.getSimpleName();

    private View mView;

    private RecyclerView mListView;
    private PageSlidingPagerView mAdverising;
    private SearchBarView mSearchbar;
    private View mGeneralModeView;
    private View mMapModeView;
    private FirmsAdapter firmsAdapter;

    private String[] url;
    private int pageIndex = 1 ;

    private FirmListData[] db_firmListData;

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
        DataManager.getInstance(getActivity()).qryAdvertising(getDataResponse);
        FrontPageInParams frontPageInParams = ParamsManager.getfrontPageInParams(getActivity());
        DataCache.cacheFrontPageInParams = frontPageInParams;
        Gson gson = new Gson();
        String userFilter = gson.toJson(frontPageInParams);
        DataManager.getInstance(getActivity()).qryFirmList(pageIndex,userFilter,getDataResponse);
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
        mSearchbar = (SearchBarView) v.findViewById(R.id.csv_Search);
        mSearchbar.setCallback(getSearchResponse);
        mAdverising = (PageSlidingPagerView) v.findViewById(R.id.csv_Advertising);
        mGeneralModeView = (View) v.findViewById(R.id.generalMode);
        mMapModeView = (View) v.findViewById(R.id.mapMode);

    }

    private void initAdverisingView(AdsInfoData[] adsData){
        if(adsData != null){
            url = new String[adsData.length];
            for(int i=0; i<adsData.length; i++){
                url[i] = adsData[i].getPicture();
            }
        }
        mAdverising.setViewPagerData(url);
        mAdverising.show();
    }

    private void initFirms(FirmListData[] firmListDatas){
        if(firmListDatas.length != 0){
            mListView = (RecyclerView) mView.findViewById(R.id.listView);
            mListView.setVisibility(View.VISIBLE);

            firmsAdapter = new FirmsAdapter(getActivity(),firmListDatas,onClickListener);
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
            FirmListData firmListData = db_firmListData[position];
            Intent intent = new Intent(getActivity(), SubFrontPageActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("firmID",db_firmListData[position].getFirmID());
            bundle.putString("firmName", db_firmListData[position].getFirmName());
            bundle.putString("picture",db_firmListData[position].getPicture());
            bundle.putBoolean("partner",db_firmListData[position].isPartner());
            bundle.putString("partnermessage",db_firmListData[position].getPartnerMessage());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };

//    private SearchBarView.ClickListener onReSearchListener = new SearchBarView.ClickListener() {
//        @Override
//        public void onSearch(String userFilter) {
//            //重新搜資料
//            String data = userFilter;
//        }
//    };

    private GetSearchResponse getSearchResponse = new GetSearchResponse() {
        @Override
        public void onFirmSearch(String userFilter) {
            String data = userFilter;
        }

        @Override
        public void onLimitSearch(String userFilter) {
            String data = userFilter;
        }
    };

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
            if(obj instanceof FirmListData[]){
                FirmListData[] firmListData = (FirmListData[]) obj;
                db_firmListData = firmListData;
                initFirms(firmListData);
            }
        }

        @Override
        public void onFailure(Object obj) {

        }

        @Override
        public void onFinish() {

        }
    };
}
