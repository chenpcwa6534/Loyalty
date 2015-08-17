package friendo.mtel.loyalty.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.activity.SubPreferentialActivity;
import friendo.mtel.loyalty.adapter.PocketAdapter;
import friendo.mtel.loyalty.adapter.PocketExchangeAdapter;
import friendo.mtel.loyalty.adapter.PocketPointAdapter;
import friendo.mtel.loyalty.adapter.PocketPreferentialAdapter;
import friendo.mtel.loyalty.components.MemberCouponsData;
import friendo.mtel.loyalty.components.MemberLoyaltyData;
import friendo.mtel.loyalty.components.MemberRedeemLogData;
import friendo.mtel.loyalty.components.PointedFirmData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.data.GetListResponse;

/**
 * Created by MTel on 2015/6/24.
 */
public class PocketFragment extends Fragment implements View.OnClickListener{

    private String TAG = PocketFragment.class.getSimpleName();

    private TextView mLevel;
    private TextView mStoreQTY;
    private TextView mPointQTY;
    private TextView mFrequencyQTY;
    private TextView mMoneyQTY;
    private TextView mPoint;
    private TextView mPreferential;
    private TextView mExchange;

    private String[] toppings;
    private ArrayList<Fragment> pages;



    private View mView;
    private RecyclerView mPages_myPoint;
    private RecyclerView mPages_myPreferential;
    private RecyclerView mPages_myExchange;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private int currentposition;

    public PocketFragment() {
        super();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_pocket,container,false);
        initData();
        initFindView(mView);
        initView();
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initData(){
        DataManager.getInstance(getActivity()).qryMemberLoyaltyData(getActivity(),true,getDataResponse);

        DataManager.getInstance(getActivity()).qryMemberCouponsData(getActivity(), true, getDataResponse);

        DataManager.getInstance(getActivity()).qryMemberRedeemLogDataData(getActivity(), true, getDataResponse);
    }

    private void initFindView(View v){
        mLevel = (TextView) v.findViewById(R.id.txt_level);
        mStoreQTY = (TextView) v.findViewById(R.id.txt_storeQTY);
        mPointQTY = (TextView) v.findViewById(R.id.txt_pointQTY);
        mFrequencyQTY = (TextView) v.findViewById(R.id.txt_frequencyQTY);
        mMoneyQTY = (TextView) v.findViewById(R.id.txt_moneyQTY);

        mPoint = (TextView) v.findViewById(R.id.txt_myPoint);
        mPreferential = (TextView) v.findViewById(R.id.txt_myPreferential);
        mExchange = (TextView) v.findViewById(R.id.txt_myExchange);




    }

    private void initInformation(MemberLoyaltyData[] data){
        for(MemberLoyaltyData informat : data){
            mLevel.setText(""+informat.getGrade_no());
            mStoreQTY.setText(""+informat.getVisited_firm_cnt());
            mPointQTY.setText(""+informat.getTotal_point());
            mFrequencyQTY.setText(""+informat.getPointed_cnt());
            mMoneyQTY.setText("$" + informat.getSaved_money());
        }
    }

    private void initPointView(PointedFirmData[] data){
        mPages_myPoint = (RecyclerView) mView.findViewById(R.id.myPoint);
        PointedFirmData[] adapterData;
        if(data != null){
            adapterData = data;
        }else{
            adapterData = new PointedFirmData[0];
        }
        PocketPointAdapter pointAdapter = new PocketPointAdapter(getActivity(),adapterData,null);
        mPages_myPoint.setAdapter(pointAdapter);
        mPages_myPoint.setItemAnimator(new DefaultItemAnimator());
        mPages_myPoint.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initPreferentialView(MemberCouponsData[] data){
        mPages_myPreferential = (RecyclerView) mView.findViewById(R.id.myPreferential);
        PocketPreferentialAdapter preferentialAdapter = new PocketPreferentialAdapter(getActivity(),data,getPreferentialListResponse);
        mPages_myPreferential.setAdapter(preferentialAdapter);
        mPages_myPreferential.setItemAnimator(new DefaultItemAnimator());
        mPages_myPreferential.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void initExchange(MemberRedeemLogData[] data){

        PocketExchangeAdapter exchangeAdapter = new PocketExchangeAdapter(getActivity(),data,null);
        mPages_myExchange.setAdapter(exchangeAdapter);
        mPages_myExchange.setItemAnimator(new DefaultItemAnimator());
        mPages_myExchange.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    private void initView(){
        mPages_myExchange = (RecyclerView) mView.findViewById(R.id.myExchange);
        mPoint.setOnClickListener(this);
        mPreferential.setOnClickListener(this);
        mExchange.setOnClickListener(this);

        initExchange(new MemberRedeemLogData[0]);
        setNonPress();
        setPressed(mPoint);
        changePages(0);
    }

    @Override
    public void onClick(View v) {
        setNonPress();
        switch (v.getId()){
            case R.id.txt_myPoint:
                setPressed(mPoint);
                changePages(0);
                break;
            case R.id.txt_myPreferential:
                setPressed(mPreferential);
                changePages(1);
                break;
            case R.id.txt_myExchange:
                setPressed(mExchange);
                changePages(2);
                break;
        }

    }

    private void setNonPress(){
        mPoint.setTextColor(getResources().getColor(R.color.white));
        mPoint.setBackground(getResources().getDrawable(R.mipmap.btn_common_red_normal));
        mPreferential.setTextColor(getResources().getColor(R.color.white));
        mPreferential.setBackground(getResources().getDrawable(R.mipmap.btn_common_red_normal));
        mExchange.setTextColor(getResources().getColor(R.color.white));
        mExchange.setBackground(getResources().getDrawable(R.mipmap.btn_common_red_normal));
    }

    private void setPressed(TextView textView){
        textView.setTextColor(getResources().getColor(R.color.str_level));
        textView.setBackground(getResources().getDrawable(R.mipmap.btn_common_white_pressed));
    }

    private void changePagesDefaule(){
        mPages_myPoint.setVisibility(View.INVISIBLE);
        mPages_myPreferential.setVisibility(View.INVISIBLE);
        mPages_myExchange.setVisibility(View.INVISIBLE);
    }

    private void changePages(int position){
        if(currentposition != position){
            changePagesDefaule();
            switch (position){
                case 0:
                    mPages_myPoint.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    mPages_myPreferential.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    mPages_myExchange.setVisibility(View.VISIBLE);
                    break;
            }
        }
        currentposition = position;
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
            if(obj instanceof MemberCouponsData[]){
                initPreferentialView((MemberCouponsData[]) obj);
            }else if(obj instanceof MemberLoyaltyData[]){
                initInformation((MemberLoyaltyData[]) obj);
                initPointView(((MemberLoyaltyData[]) obj)[0].getPointed_firm());
            }else if(obj instanceof  MemberRedeemLogData[]){
                initExchange((MemberRedeemLogData[]) obj);
            }
        }

        @Override
        public void onFailure(Object obj) {

        }

        @Override
        public void onFinish() {

        }
    };

    private GetListResponse getPreferentialListResponse = new GetListResponse() {
        @Override
        public void onFirmResponse(String firmID) {

        }

        @Override
        public void onCouponResponse(int allotID) {
            Intent intent = new Intent(getActivity(), SubPreferentialActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("allotID", allotID);
            intent.putExtras(bundle);
            getActivity().startActivity(intent);
        }
    };

}
