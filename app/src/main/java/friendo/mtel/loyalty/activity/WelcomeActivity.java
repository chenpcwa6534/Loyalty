package friendo.mtel.loyalty.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.astuetz.page.sliding.PageSlidingPagerView;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.utility.UtilityInitial;
import friendo.mtel.loyalty.utility.Utilitys;

/**
 * Created by MTel on 2015/7/23.
 */
public class WelcomeActivity extends Activity implements View.OnClickListener{
    private String TAG = WelcomeActivity.class.getSimpleName();

    private PageSlidingPagerView mAdverising;
    private View mLoginView;
    private Button mAppStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        if(!Utilitys.isLogin(this)){
            findView();
            initAdverising();
            initLoginView();
        }else{
            intent(MainActivity.class);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void findView(){
        mAdverising = (PageSlidingPagerView) findViewById(R.id.csv_Advertising);
        mLoginView = (View) findViewById(R.id.loginview);
        mAppStart = (Button) findViewById(R.id.btn_appstart);
    }

    private void initAdverising(){
        mAdverising.setViewPagerData(UtilityInitial.welcomeDraw);
        mAdverising.setPagerSelectedCallBack(pagerSelectedCallBack);
        mAdverising.show();
    }

    private void initLoginView(){
        mAppStart.setOnClickListener(this);
    }

    private PageSlidingPagerView.PagerSlidingCallBack pagerSelectedCallBack = new PageSlidingPagerView.PagerSlidingCallBack() {
        @Override
        public void CurrentItem(int position) {
            if(position == UtilityInitial.welcomeDraw.length-1){
                mLoginView.setVisibility(View.VISIBLE);
            }else{
                mLoginView.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onClick(int position) {

        }
    };

    private void intent(Class<?> cls){
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_appstart:
                intent(LoginActivity.class);
                break;
        }
    }
}
