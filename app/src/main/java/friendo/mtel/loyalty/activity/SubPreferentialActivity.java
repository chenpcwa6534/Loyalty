package friendo.mtel.loyalty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.utility.PicassoUtility;

import org.w3c.dom.Text;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.components.CollectibleCoupon;
import friendo.mtel.loyalty.components.MyCouponData;
import friendo.mtel.loyalty.components.PeriodData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.fragment.PocketFragment;
import friendo.mtel.loyalty.utility.JudgeRule;
import friendo.mtel.loyalty.utility.Utilitys;

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
        int allotID = bundle.getInt("allotID");
        if(allotID !=-1){
            DataManager.getInstance(this).qryMyCouponData(this, String.valueOf(allotID), true, getDataResponse);
        }else{
            CollectibleCoupon data = (CollectibleCoupon) bundle.getSerializable("data");
            initView(data);
        }

    }

    private void initView(CollectibleCoupon data){
        mBtnDoubleView.setVisibility(View.VISIBLE);
        mCollect = (Button) findViewById(R.id.btn_collect);
        mUse = (Button) findViewById(R.id.btn_nowuse);

        mToolsbarTitle.setText(data.getFirm_name());
        mPreferenialTitle.setText(JudgeRule.getCouponType(this, data.getCoupon_rule_type()));
        mDesc.setText(data.getDescription());
        mDeadline.setText(data.getBegin_time()+"~"+data.getEnd_time());
        PicassoUtility.load(this, mPreferenialPicture, data.getPicture());
        PicassoUtility.load(this,mStorePicture,data.getFirm_picture());
        mAddress.setText(data.getAddress());

        mCollect.setOnClickListener(this);
        mUse.setOnClickListener(this);
    }

    private void initView(MyCouponData data){
        mBtnUseView.setVisibility(View.VISIBLE);
        mUse = (Button) findViewById(R.id.btn_Use);
        mDesc.setText(data.getCoupon_conf().getDescription());
        PicassoUtility.load(this, mPreferenialPicture, data.getCoupon_conf().getPicture().getUrl());
        mExplanation.setText(data.getProd_conf().getDescription());

        mUse.setOnClickListener(this);
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
                break;
            case R.id.btn_nowuse:
                break;
            case R.id.btn_Use:
                break;
        }
    }

    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            MyCouponData data = (MyCouponData) obj;
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
}
