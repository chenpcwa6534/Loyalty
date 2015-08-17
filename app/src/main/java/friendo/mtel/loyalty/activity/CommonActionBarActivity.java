package friendo.mtel.loyalty.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import friendo.mtel.loyalty.R;

/**
 * Created by MTel on 2015/7/1.
 */
public class CommonActionBarActivity extends ActionBarActivity {

    private Activity mactivity = null;

    FragmentManager fragmentManager = getFragmentManager();;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mactivity = this;
    }

    @Override
    protected void onDestroy() {
        clearObj();
        super.onDestroy();
    }

    /**
     *
     * @param cls
     */
    public void openActivity(Class<?> cls){
        Intent intent = new Intent(mactivity, cls);
        startActivity(intent);
    }

    /**
     *
     * @param cls
     * @param bundle
     */
    public void openActivity(Class<?> cls, Bundle bundle){
        Intent intent= new Intent(mactivity, cls);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void clearObj(){

    }

    /**
     *
     * @param page
     * @param fragment
     */
    public void fragmentTransactionAdd(int page,Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(page, fragment);
        fragmentTransaction.commit();
    }

    /**
     *
     * @param page
     * @param fragment
     */
    public void fragmentTransactionReplace(int page,Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(page, fragment);
        fragmentTransaction.commit();
    }


}
