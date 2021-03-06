package friendo.mtel.loyalty.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.Receiver.GetReceverResponse;
import friendo.mtel.loyalty.Receiver.ReceiverManager;
import friendo.mtel.loyalty.component.VerificationData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.data.GetPagesResponse;
import friendo.mtel.loyalty.httpsparams.ParamsManager;
import friendo.mtel.loyalty.preferences.LoyaltyPreference;

/**
 * Created by MTel on 2015/7/2.
 */
public class LoginVerificationFragment extends Fragment implements View.OnClickListener,View.OnKeyListener{
    private String TAG = LoginVerificationFragment.class.getSimpleName();

    private TextView mSkip;
    private TextView mNumber;
    private EditText mVerificaion;


    private GetPagesResponse mGetPagesResponse;

    private static String key = "PhoneNumber";

    public LoginVerificationFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_liginverification,container,false);
        Log.d(TAG,"SMS onCreate");
        findView(v);
        initView();
        SMSReceiver();
        return v;
    }

    public static Fragment newInstance(GetPagesResponse getPagesResponse,String phoneNumber){
        LoginVerificationFragment fragment = new LoginVerificationFragment();
        fragment.mGetPagesResponse = getPagesResponse;
        Bundle bundle = new Bundle();
        bundle.putString(key, phoneNumber);
        fragment.setArguments(bundle);
        return fragment;
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
        ReceiverManager.unregisterSMSReceiver(getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.skip:
                mGetPagesResponse.onSkip();
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(KeyEvent.KEYCODE_ENTER == keyCode) {
            verification();
        }
        return false;
    }

    private void verification(){
        String token = LoyaltyPreference.getDeviceToken(getActivity());
        String userfilter = ParamsManager.getVerificationOTPParams(mNumber.getText().toString(), mVerificaion.getText().toString(), token);
        DataManager.getInstance(getActivity()).qryVerificationOTP(userfilter,getDataResponse);
    }

    private void findView(View v){
        mSkip = (TextView) v.findViewById(R.id.skip);
        mNumber = (TextView) v.findViewById(R.id.phonenumber);
        mVerificaion = (EditText) v.findViewById(R.id.verifvation);
    }

    private void initView(){
        mNumber.setText(getArguments().getString(key));
        mVerificaion.requestFocus();
        mVerificaion.setOnKeyListener(this);
        mSkip.setOnClickListener(this);
        //openKeyBroad();
    }

    private void SMSReceiver(){
        ReceiverManager.registerSMSReceiver(getActivity(), getReceverResponse);
    }

    private void openKeyBroad(){
        InputMethodManager imm = ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE));
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,InputMethodManager.HIDE_IMPLICIT_ONLY);
    }


    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            VerificationData verificationData = (VerificationData) obj;
            try{
                String memberID = verificationData.getMember_id();
                LoyaltyPreference.setMemberID(getActivity(), memberID);
                mGetPagesResponse.onVerification(verificationData.getMessage());
            }catch (Exception e){
                Log.e(TAG,"VerifcationOTP parse fail (LoginVerificationFragment.class) Exception :" + e.getMessage());
            }
        }

        @Override
        public void onSuccess(Object[] obj) {

        }

        @Override
        public void onFailure(Object obj) {
            openKeyBroad();
        }

        @Override
        public void onFinish() {

        }
    };

    private GetReceverResponse getReceverResponse = new GetReceverResponse() {
        @Override
        public void onSMSRecever(String msg) {
            mVerificaion.setText(msg);
            mVerificaion.requestFocus();
            verification();
        }
    };

}
