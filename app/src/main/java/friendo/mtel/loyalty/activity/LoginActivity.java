package friendo.mtel.loyalty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.data.GetPagesResponse;
import friendo.mtel.loyalty.fragment.LoginNumberFragment;
import friendo.mtel.loyalty.fragment.LoginVerificationFragment;
import friendo.mtel.loyalty.view.MessageDialog;

/**
 * Created by MTel on 2015/7/23.
 */
public class LoginActivity extends CommonActionBarActivity implements View.OnClickListener{
    private String TAG = LoginActivity.class.getSimpleName();

    private Button mReg;
    private Button mAppStart;
    private String[] mResMsg;



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

    private void showMessage(String[] msg){
        MessageDialog msgDialog = new MessageDialog(LoginActivity.this);
        msgDialog.setTitle(getResources().getString(R.string.rsg_success));
        msgDialog.setContent(msg);
        msgDialog.setLogo(MessageDialog.LogoType.Success);
        msgDialog.setCallback(dialogCallback);
        String[] button = new String[2];
        button[0] = getResources().getString(R.string.login_btn_fbbuding);
        button[1] = getResources().getString(R.string.login_btn_dialog);
        msgDialog.setButton(button);
        msgDialog.show();
    }

    private GetPagesResponse getPagesResponse = new GetPagesResponse() {

        @Override
        public void onPhoneNumber(String phonenumber) {
            fragmentTransactionReplace(R.id.pages, LoginVerificationFragment.newInstance(getPagesResponse, phonenumber));
        }

        @Override
        public void onVerification(String[] msg) {
            mResMsg = msg;
            showMessage(msg);
        }

        @Override
        public void onSkip() {
            intentActivity();
        }
    };

    private MessageDialog.DialogCallback dialogCallback = new MessageDialog.DialogCallback() {
        @Override
        public void onClick(int position, String btnStr) {
            switch (position){
                case 0:
                    break;
                case 1:
                    intentActivity();
                    break;
            }
        }
    };
}
