package friendo.mtel.loyalty.fragment;

import android.bluetooth.BluetoothAdapter;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.adapter.MoreAdapter;
import friendo.mtel.loyalty.data.DataCache;
import friendo.mtel.loyalty.utility.Utilitys;

/**
 * Created by MTel on 2015/6/24.
 */
public class MoreFragment extends Fragment implements View.OnClickListener{
    private String TAG = MoreFragment.class.getSimpleName();

    private TextView mName;
    private TextView mSex;
    private TextView mBirthday;
    private TextView mPhoneNumber;
    private TextView mStatusPhoneNumber;
    private TextView mStatuPhone;
    private TextView mStatusLoation;
    private TextView mBluetooth;
    private TextView mPush;
    private ImageView mPersonPhoto;
    private ImageView mFacebook;
    private RecyclerView mListView;

    private View mView;

    public MoreFragment() {
        super();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_more,container,false);
        findView(mView);
        initView();
        showStatus();
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
        mName = (TextView) v.findViewById(R.id.txt_Name);
        mSex = (TextView) v.findViewById(R.id.txt_sex);
        mBirthday = (TextView) v.findViewById(R.id.txt_birthday);
        mPhoneNumber = (TextView) v.findViewById(R.id.txt_phonenumber);
        mStatusPhoneNumber = (TextView) v.findViewById(R.id.phone);
        mStatuPhone = (TextView) v.findViewById(R.id.phonestatus);
        mStatusLoation = (TextView) v.findViewById(R.id.locationstatus);
        mBluetooth = (TextView) v.findViewById(R.id.bluetoothstatus);
        mPush = (TextView) v.findViewById(R.id.pushstatus);
        mPersonPhoto = (ImageView) v.findViewById(R.id.img_photo);
        mFacebook = (ImageView) v.findViewById(R.id.btn_facebook);
    }

    private void initView(){
        mListView = (RecyclerView) mView.findViewById(R.id.listView);
        String[] data = getResources().getStringArray(R.array.more_List);
        MoreAdapter moreAdapter = new MoreAdapter(getActivity(),data,listener);
        mListView.setAdapter(moreAdapter);
        mListView.setItemAnimator(new DefaultItemAnimator());
        mListView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void showStatus(){
        bluetoothStatus();
        GPSStatus();
        numberStatus();
        pushStatus();
    }

    private void bluetoothStatus(){
        Drawable icon;
        if(Utilitys.isBluetooth()){
            mBluetooth.setText(getResources().getString(R.string.more_serverstatus_alreadyopen));
            icon = getResources().getDrawable(R.mipmap.ic_common_green_ok);
        }else{
            mBluetooth.setText(getResources().getString(R.string.more_serverstatus_notopen));
            icon = getResources().getDrawable(R.mipmap.ic_common_red_warning);
            mBluetooth.setOnClickListener(this);
        }
        icon.setBounds(0, 0, icon.getMinimumWidth(), icon.getMinimumHeight());
        mBluetooth.setCompoundDrawables(icon, null, null, null);
    }

    private void GPSStatus(){
        Drawable icon;
        if(Utilitys.isGPS(getActivity())){
            mStatusLoation.setText(getResources().getString(R.string.more_serverstatus_alreadyopen));
            icon = getResources().getDrawable(R.mipmap.ic_common_green_ok);
        }else{
            mStatusLoation.setText(getResources().getString(R.string.more_serverstatus_notopen));
            icon = getResources().getDrawable(R.mipmap.ic_common_red_warning);
            mStatusLoation.setOnClickListener(this);
        }
        icon.setBounds(0, 0, icon.getMinimumWidth(), icon.getMinimumHeight());
        mStatusLoation.setCompoundDrawables(icon, null, null, null);
    }

    private void numberStatus(){
        Drawable icon;
        String number = DataCache.cacheVersionControlData.getProtitle().getNumber();
        if(DataCache.cacheVersionControlData != null && !number.equals("")){
            mStatusPhoneNumber.setText(number);
            mStatuPhone.setText(getResources().getString(R.string.more_serverstatus_alreadyopen));
            icon = getResources().getDrawable(R.mipmap.ic_common_green_ok);
        }else{
            mStatuPhone.setText(getResources().getString(R.string.more_serverstatus_notopen));
            icon = getResources().getDrawable(R.mipmap.ic_common_red_warning);
        }
        icon.setBounds(0, 0, icon.getMinimumWidth(), icon.getMinimumHeight());
        mStatuPhone.setCompoundDrawables(icon, null, null, null);
    }

    private void pushStatus(){
        Drawable icon;
        if(DataCache.cacheVersionControlData != null && DataCache.cacheVersionControlData.getProtitle().isPushService()){
            mPush.setText(getResources().getString(R.string.more_serverstatus_alreadyopen));
            icon = getResources().getDrawable(R.mipmap.ic_common_green_ok);
        }else{
            mPush.setText(getResources().getString(R.string.more_serverstatus_notopen));
            icon = getResources().getDrawable(R.mipmap.ic_common_red_warning);
        }
        icon.setBounds(0, 0, icon.getMinimumWidth(), icon.getMinimumHeight());
        mStatuPhone.setCompoundDrawables(icon, null, null, null);
    }

    private void intentGPSControl(){
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
    }

    private void intentBluetoothControl(){
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_photo:
                break;
            case R.id.bluetoothstatus:
                intentBluetoothControl();
                break;
            case R.id.locationstatus:
                intentGPSControl();
                break;
        }
    }

    private MoreAdapter.ViewHolder.ClickListener listener = new MoreAdapter.ViewHolder.ClickListener() {
        @Override
        public void onClickPage(int position) {

        }
    };
}
