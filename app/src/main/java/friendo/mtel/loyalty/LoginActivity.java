package friendo.mtel.loyalty;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import friendo.mtel.loyalty.activity.CommonActionBarActivity;
import friendo.mtel.loyalty.data.GetPagesResponse;
import friendo.mtel.loyalty.fragment.LoginNumberFragment;
import friendo.mtel.loyalty.fragment.LoginVerificationFragment;

/**
 * Created by MTel on 2015/7/23.
 */
public class LoginActivity extends CommonActionBarActivity implements View.OnClickListener{
    private String TAG = LoginActivity.class.getSimpleName();

    private Button mReg;
    private Button mAppStart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
                fragmentTransactionAdd(R.id.pages, LoginNumberFragment.newInstance(getPagesResponse));
                break;
            case R.id.btn_startApp:
                intentActivity();
                break;
        }
    }

    private void findView(){
        mReg = (Button) findViewById(R.id.btn_register);
        mAppStart = (Button) findViewById(R.id.btn_startApp);
    }

    private void initView(){
        mReg.setOnClickListener(this);
        mAppStart.setOnClickListener(this);
    }

    private void intentActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private GetPagesResponse getPagesResponse = new GetPagesResponse() {

        @Override
        public void onPhoneNumber(String phonenumber) {
            fragmentTransactionReplace(R.id.pages, LoginVerificationFragment.newInstance(getPagesResponse, phonenumber));
        }

        @Override
        public void onVerification() {
            intentActivity();
        }

        @Override
        public void onSkip() {
            intentActivity();
        }
    };
}
