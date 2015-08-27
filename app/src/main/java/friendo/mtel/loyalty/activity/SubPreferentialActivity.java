package friendo.mtel.loyalty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.utility.PicassoUtility;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.component.CouponDetailData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;

/**
 * Created by MTel on 2015/7/27.
 */
public class SubPreferentialActivity extends CommonActionBarActivity implements View.OnClickListener{
    private String TAG = SubPreferentialActivity.class.getSimpleName();

    private View mToolsbar;
    private TextView mToolsbarTitle;
    private ImageView mBack;
    private ImageView mMessage;
    private TextView mMessageQTY;

    private View mBtnUseView;
    private View mBtnDoubleView;
    private TextView mPreferenialTitle;
    private TextView mDesc;
    private TextView mDeadline;
    private ImageView mPreferenialPicture;
    private Button mUse;
    private Button mCollect;
    private TextView mExplanation;
    private ImageView mStorePicture;
    private TextView mAddress;

    private CouponDetailData db_data;

    private int STATUS_USE = 1;
    private int STATUS_COLLECT = 0;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subpreferential);
        findView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void findView(){
        mToolsbar = (View) findViewById(R.id.toolbar);
        mToolsbarTitle = (TextView) mToolsbar.findViewById(R.id.txt_title);
        mBack = (ImageView) mToolsbar.findViewById(R.id.img_back);
        mMessage = (ImageView) mToolsbar.findViewById(R.id.img_message);
        mMessageQTY = (TextView) mToolsbar.findViewById(R.id.img_messageQTY);

        mBtnUseView = (View) findViewById(R.id.btnuse);
        mBtnDoubleView = (View) findViewById(R.id.btndouble);

        mPreferenialTitle = (TextView) findViewById(R.id.txt_PreferentialName);
        mDesc = (TextView) findViewById(R.id.txt_desc);
        mDeadline = (TextView) findViewById(R.id.txt_useTime);
        mPreferenialPicture = (ImageView) findViewById(R.id.img_picture);

        mExplanation = (TextView) findViewById(R.id.txt_Explanation);
        mStorePicture = (ImageView) findViewById(R.id.img_storesmailpicture);
        mAddress = (TextView) findViewById(R.id.txt_address);

        mBack.setOnClickListener(this);
    }

    private void initData(){
        Bundle bundle = getIntent().getExtras();
        int CouponID = bundle.getInt("couponID");
        DataManager.getInstance(this).qryCouponDetail(CouponID, getDataResponse);
    }

    private void initView(CouponDetailData data){
        db_data = data;
        if(data.isCollect()){
            mBtnUseView.setVisibility(View.VISIBLE);
            mUse = (Button) findViewById(R.id.btn_Use);
            mUse.setOnClickListener(this);
        }else{
            mBtnDoubleView.setVisibility(View.VISIBLE);
            mCollect = (Button) findViewById(R.id.btn_collect);
            mUse = (Button) findViewById(R.id.btn_nowuse);
            mCollect.setOnClickListener(this);
            mUse.setOnClickListener(this);
        }

        mToolsbarTitle.setText(data.getStoreInfo().getFirmName());
        mPreferenialTitle.setText(data.getTitle());
        mDesc.setText(data.getDescription());
        mDeadline.setText(data.getAvailable());
        PicassoUtility.load(this, mPreferenialPicture, data.getPicture());
        PicassoUtility.load(this, mStorePicture, data.getStoreInfo().getPicture());
        mAddress.setText(data.getStoreInfo().getAddress());

        if(data.getCancellationStatus() == 1){
            //SHOW DIALOG 等待店家確認中
        }else if(data.getCancellationStatus() == 2){
            //SHOW DIALOG 已兌換
        }
    }


    private void couponControl(int status,int couponID){
        switch (status){
            case 0:
                DataManager.getInstance(this).qryCouponControl(couponID,status, getCouponControlResponse);
                break;
            case 1:
                convertControl(status,couponID);
                break;
        }
    }

    private void convertControl(int status,int couponID){
        switch (db_data.getCancellationType()){
            case 1:
                DataManager.getInstance(this).qryCouponControl(couponID,status, getCouponControlResponse);
                break;
            case 2:
                break;
            case 3:
                //SHOW DIALOG請感應beacon
                //感應到才送 api
                break;
        }
    }


    private void onFinish(){
        this.finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                onFinish();
                break;
            case R.id.btn_collect:
                couponControl(STATUS_COLLECT,getIntent().getExtras().getInt("couponID"));
                break;
            case R.id.btn_nowuse:
                couponControl(STATUS_USE,getIntent().getExtras().getInt("couponID"));
                break;
            case R.id.btn_Use:
                couponControl(STATUS_USE,getIntent().getExtras().getInt("couponID"));
                break;
        }
    }



    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            CouponDetailData data = (CouponDetailData) obj;
            initView(data);
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

    private GetDataResponse getCouponControlResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            boolean restlt = (boolean) obj;
            //SHOW DIALOG
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
