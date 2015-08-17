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
import android.widget.Toast;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.activity.SubPreferentialActivity;
import friendo.mtel.loyalty.adapter.StorePreferentialAdapter;
import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.components.MemberCouponsData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;

/**
 * Created by MTel on 2015/8/5.
 */
public class StorePreferentialFragmemt extends CommonFragment {
    private String TAG = StorePreferentialFragmemt.class.getSimpleName();

    private View mView;
    private RecyclerView mList;

    public static StorePreferentialFragmemt newInstance(int firmID){
        StorePreferentialFragmemt storePreferentialFragmemt = new StorePreferentialFragmemt();
        Bundle bundle = new Bundle();
        bundle.putInt("firmID", firmID);
        storePreferentialFragmemt.setArguments(bundle);
        return storePreferentialFragmemt;
    }

    public StorePreferentialFragmemt() {
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
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        String firmID = String.valueOf(getArguments().getInt("firmID"));
        DataManager.getInstance(getActivity()).qryFirmCouponData(getActivity(), Env.getMemberID(),firmID,Env.DeviceToken(),false,getDataResponse);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initStorePreferential(MemberCouponsData[] firmCouponData){
        if(firmCouponData.length != 0){
            mList = (RecyclerView) mView.findViewById(R.id.listView);
            mList.setVisibility(View.VISIBLE);
            StorePreferentialAdapter storePreferentialAdapter = new StorePreferentialAdapter(getActivity(),firmCouponData,onClickListener);
            mList.setAdapter(storePreferentialAdapter);
            mList.setItemAnimator(new DefaultItemAnimator());
            mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
    }


    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {

        }

        @Override
        public void onSuccess(Object[] obj) {
            MemberCouponsData[] firmCoupons = (MemberCouponsData[]) obj;
            initStorePreferential(firmCoupons);
        }

        @Override
        public void onFailure(Object obj) {

        }

        @Override
        public void onFinish() {

        }
    };

    StorePreferentialAdapter.ViewHolder.ClickListener onClickListener = new StorePreferentialAdapter.ViewHolder.ClickListener() {
        @Override
        public void onClick(int allotID) {
            if(allotID != 0){
                Intent intent = new Intent(getActivity(), SubPreferentialActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("allotID",allotID);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
            Toast.makeText(getActivity(),"id:"+allotID,Toast.LENGTH_SHORT).show();
        }
    };
}
