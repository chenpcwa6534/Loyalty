package friendo.mtel.loyalty.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.data.GetPagesResponse;
import friendo.mtel.loyalty.httpsparams.ParamsManager;

/**
 * Created by MTel on 2015/7/2.
 */
public class LoginNumberFragment extends Fragment implements View.OnClickListener,View.OnKeyListener {
    private String TAG = LoginNumberFragment.class.getSimpleName();

    private EditText mNumber;
    private TextView mSkip;
    private Button mSend;

    private GetPagesResponse mGetPagesResponse;
    public LoginNumberFragment() {
        super();
    }

    public static Fragment newInstance(GetPagesResponse getPagesResponse){
        LoginNumberFragment fragment = new LoginNumberFragment();
        fragment.mGetPagesResponse = getPagesResponse;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_loginnumber,container,false);
        findView(v);
        initView();
        return v;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.skip:
                break;
            case R.id.PhoneNumber:
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(KeyEvent.KEYCODE_ENTER == keyCode) {
            if(mNumber.getText().toString().equals("") || mNumber.getText().toString().length() != 10){
                Toast.makeText(getActivity(),getActivity().getString(R.string.login_trip),Toast.LENGTH_SHORT).show();
                opKeyBroad();
            }else{
                String userfilter = ParamsManager.getAskOPTParams(mNumber.getText().toString());
                Log.d(TAG,"AspOTP request data = "+ userfilter);
                DataManager.getInstance(getActivity()).qryAskOTP(userfilter,getDataResponse);
            }
        }
        return false;
    }

    private void findView(View v){
        mNumber = (EditText) v.findViewById(R.id.PhoneNumber);
        mSkip = (TextView) v.findViewById(R.id.skip);

    }

    private void initView(){
        mNumber.requestFocus();
        mNumber.setOnKeyListener(this);
        mSkip.setOnClickListener(this);
        opKeyBroad();
    }

    private void opKeyBroad(){
         InputMethodManager imm = ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE));
        imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            mGetPagesResponse.onPhoneNumber((String) obj);
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
