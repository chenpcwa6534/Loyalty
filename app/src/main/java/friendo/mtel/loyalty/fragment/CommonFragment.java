package friendo.mtel.loyalty.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by MTel on 2015/7/3.
 */
public class CommonFragment extends Fragment implements View.OnKeyListener{
    private String TAG = CommonFragment.class.getSimpleName();

    public void intentGoogleSearch(String str){
        Uri uri = Uri.parse("http://www.google.com/#q="+str);
        intentStart(uri);
    }

    public void intentMapStreetView(String lat,String lon){
        Uri uri = Uri.parse("google.streetview:cbll="+lat+","+lon);
        intentStart(uri);
    }

    public void intentMap(String lat,String lon){
        Uri uri = Uri.parse("geo:0,0?q="+Uri.encode(lat+","+lon)); //google map
        intentStart(uri);
    }

    public void intentMap(String address){
        Uri uri = Uri.parse("geo:0,0?q="+Uri.encode(address));
        intentStart(uri);
    }

    private void intentStart(Uri uri){
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        getActivity().startActivity(intent);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }

}
