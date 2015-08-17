package friendo.mtel.loyalty.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.data.GetPagesResponse;

/**
 * Created by MTel on 2015/7/2.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private String TAG = HomeFragment.class.getSimpleName();

    private Button mRegister;
    private Button mGuest;

    private GetPagesResponse getPagesResponse;
    public HomeFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        initView(v);
        initOnClick();
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
        if(getPagesResponse == null){ return; }
        switch (v.getId()){
            case R.id.welcome_reg:
                break;
            case R.id.welcome_guest:
                break;
        }
    }

    public void setCallback(GetPagesResponse getPagesResponse){
        this.getPagesResponse = getPagesResponse;
    }

    private void initView(View v){
        mRegister = (Button) v.findViewById(R.id.welcome_reg);
        mGuest = (Button) v.findViewById(R.id.welcome_guest);
    }

    private void initOnClick(){
        mRegister.setOnClickListener(this);
        mGuest.setOnClickListener(this);
    }
}
