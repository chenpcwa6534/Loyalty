package friendo.mtel.loyalty.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import friendo.mtel.loyalty.HttpsParams.FrontPageInParams;
import friendo.mtel.loyalty.HttpsParams.ParamsManager;
import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.activity.SubPreferentialActivity;
import friendo.mtel.loyalty.adapter.PreferentialAdapter;
import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.components.CollectibleCoupon;
import friendo.mtel.loyalty.components.DeluxeCoupon;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.view.ConditionsSearchView;

/**
 * Created by MTel on 2015/6/24.
 */
public class PreferentialFragment extends CommonFragment{
    private String TAG = PreferentialFragment.class.getSimpleName();

    private View mView;
    private RecyclerView mList;
    private ConditionsSearchView mSearchbar;

    public PreferentialFragment() {
        super();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_preferential,container,false);
        findView(mView);
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        FrontPageInParams frontPageInParams = ParamsManager.getfrontPageInParams(getActivity());
        Gson gson = new Gson();
        String userFilter = gson.toJson(frontPageInParams);
        DataManager.getInstance(getActivity()).qryDeluxeCouponData(getActivity(), Env.getMemberID(), Env.DeviceToken(), "1", userFilter, false, getDataResponse);
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
    }

    private void initPreferential(DeluxeCoupon data){
        PreferentialAdapter moreAdapter = new PreferentialAdapter(getActivity(),data.getCollectiblecoupon(),onItemClickListener);
        mList = (RecyclerView) mView.findViewById(R.id.listView);
        mList.setVisibility(View.VISIBLE);
        mList.setAdapter(moreAdapter);
        mList.setItemAnimator(new DefaultItemAnimator());
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private PreferentialAdapter.ViewHolder.ClickListener onItemClickListener = new PreferentialAdapter.ViewHolder.ClickListener() {
        @Override
        public void onClick(CollectibleCoupon data) {
            Intent intent = new Intent(getActivity(), SubPreferentialActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("allotID",-1);
            bundle.putSerializable("data",data);
            intent.putExtras(bundle);
            getActivity().startActivity(intent);
        }
    };

    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            DeluxeCoupon firmCouponData = (DeluxeCoupon) obj;
            initPreferential(firmCouponData);
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
