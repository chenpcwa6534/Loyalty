package friendo.mtel.loyalty.fragment;

import android.support.v4.app.Fragment;
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
import friendo.mtel.loyalty.adapter.PocketExchangeAdapter;
import friendo.mtel.loyalty.adapter.PocketPointAdapter;
import friendo.mtel.loyalty.adapter.PocketPreferentialAdapter;
import friendo.mtel.loyalty.component.MemberExChangeData;
import friendo.mtel.loyalty.component.MemberInfoData;
import friendo.mtel.loyalty.component.MemberPointData;
import friendo.mtel.loyalty.component.MemberCouponsData;
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
    private int currentposition;

    private int page = 1;

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
        findView(mView);
        initData();
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
        DataManager.getInstance(getActivity()).qryMemberInfo(getDataResponse);
        DataManager.getInstance(getActivity()).qryMemberPoint(getDataResponse);
        DataManager.getInstance(getActivity()).qryMemberCoupons(getDataResponse);
        DataManager.getInstance(getActivity()).qryMemberExChange(page, getDataResponse);
    }

    private void findView(View v){
        mLevel = (TextView) v.findViewById(R.id.txt_level);
        mStoreQTY = (TextView) v.findViewById(R.id.txt_storeQTY);
        mPointQTY = (TextView) v.findViewById(R.id.txt_pointQTY);
        mFrequencyQTY = (TextView) v.findViewById(R.id.txt_frequencyQTY);
        mMoneyQTY = (TextView) v.findViewById(R.id.txt_moneyQTY);

        mPoint = (TextView) v.findViewById(R.id.txt_myPoint);
        mPreferential = (TextView) v.findViewById(R.id.txt_myPreferential);
        mExchange = (TextView) v.findViewById(R.id.txt_myExchange);


        mPoint.setOnClickListener(this);
        mPreferential.setOnClickListener(this);
        mExchange.setOnClickListener(this);

        setNonPress();
        setPressed(mPoint);
        changePages(0);

    }

    private void initInformation(MemberInfoData data){
            mLevel.setText(""+data.getLV());
            mStoreQTY.setText(""+data.getStore());
            mPointQTY.setText("" + data.getPoint());
            mFrequencyQTY.setText("" + data.getCount());
            mMoneyQTY.setText("$" + data.getMoney());
    }

    private void initPointView(MemberPointData[] data){
        mPages_myPoint = (RecyclerView) mView.findViewById(R.id.myPoint);
        mPages_myPoint.setVisibility(View.VISIBLE);
        PocketPointAdapter pointAdapter = new PocketPointAdapter(getActivity(),data,null);
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

    private void initExchange(MemberExChangeData[] data){
        mPages_myExchange = (RecyclerView) mView.findViewById(R.id.myExchange);
        PocketExchangeAdapter exchangeAdapter = new PocketExchangeAdapter(getActivity(),data,null);
        mPages_myExchange.setAdapter(exchangeAdapter);
        mPages_myExchange.setItemAnimator(new DefaultItemAnimator());
        mPages_myExchange.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        textView.setTextColor(getResources().getColor(R.color.font_level));
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
            if(obj instanceof MemberInfoData){
                initInformation((MemberInfoData) obj);
            }
        }

        @Override
        public void onSuccess(Object[] obj) {
            if(obj instanceof MemberPointData[]){
                initPointView((MemberPointData[]) obj);
            }else if(obj instanceof MemberCouponsData[]){
                initPreferentialView((MemberCouponsData[]) obj);
            }else if(obj instanceof MemberExChangeData[]){
                initExchange((MemberExChangeData[]) obj);
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
        public void onFirmResponse(int position) {

        }

        @Override
        public void onCouponResponse(int couponID) {
            Intent intent = new Intent(getActivity(), SubPreferentialActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("couponID", couponID);
            intent.putExtras(bundle);
            getActivity().startActivity(intent);
        }
    };

}
