package friendo.mtel.loyalty.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.adapter.PointAdapter;
import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.components.MemberPointData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;

/**
 * Created by MTel on 2015/8/4.
 */
public class PointFragment extends Fragment {
    private String TAG = PointFragment.class.getSimpleName();

    private View mView;
    private TextView mDesc;
    private RecyclerView mPointList;

    public static PointFragment newInstance(int firmID){
        PointFragment pointFragment = new PointFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("firmID", firmID);
        pointFragment.setArguments(bundle);
        return pointFragment;
    }

    public PointFragment() {
        super();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_point,container,false);
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

    private void findView(View v){
        mDesc = (TextView) v.findViewById(R.id.txt_desc);
    }

    private void initData(){
        String firmID = String.valueOf(getArguments().getInt("firmID"));
        DataManager.getInstance(getActivity()).qryMemberPointData(getActivity(), Env.getMemberID(),firmID,true,getDataResponse);
    }

    private void initView(MemberPointData data){
        mDesc.setText(data.getDescription());
    }

    private void initPoint(MemberPointData data){
        mPointList = (RecyclerView) mView.findViewById(R.id.listView);
        PointAdapter pointAdapter = new PointAdapter(getActivity(),data,onClickListener);
        mPointList.setAdapter(pointAdapter);
        mPointList.setItemAnimator(new DefaultItemAnimator());

        GridLayoutManager manager = new GridLayoutManager(getActivity(),3);
        mPointList.setLayoutManager(manager);
    }

    private  PointAdapter.ViewHolder.ClickListener onClickListener = new PointAdapter.ViewHolder.ClickListener(){

        @Override
        public void onClick(int position) {

        }
    };

    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {

        }

        @Override
        public void onSuccess(Object[] obj) {
            MemberPointData[] memberPointDatas = (MemberPointData[]) obj;
            initPoint(memberPointDatas[0]);
            initView(memberPointDatas[0]);
        }

        @Override
        public void onFailure(Object obj) {

        }

        @Override
        public void onFinish() {

        }
    };
}
