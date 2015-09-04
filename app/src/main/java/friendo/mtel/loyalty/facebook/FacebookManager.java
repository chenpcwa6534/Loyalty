package friendo.mtel.loyalty.facebook;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by MTel on 2015/9/2.
 */
public class FacebookManager {
    private String TAG = FacebookManager.class.getSimpleName();

    private static FacebookManager mFacebookManager = null;
    private Context mContext;
    private CallbackManager callbackManager;

    private FacebookManager(Context context){
        this.mContext = context;
    }

    public static FacebookManager newInstance(Context context){
        if(mFacebookManager == null){
            mFacebookManager = new FacebookManager(context);
            mFacebookManager.Initialize();
        }
        return mFacebookManager;
    }

    private void Initialize(){
        FacebookSdk.sdkInitialize(mContext.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    public void login(){
        LoginManager.getInstance().logInWithReadPermissions((Activity) mContext, Arrays.asList("public_profile", "user_friends"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = AccessToken.getCurrentAccessToken();
                Log.d(TAG, "get fb accesstoken success");
                GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        String name = object.optString("name");
                        String id = object.optString("id");
                    }
                });
            }

            @Override
            public void onCancel() {
                Log.d(TAG,"cancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG,"fb login fail (FacebookManager.class line 65) Exception:" + error.getMessage());
            }
        });
    }
}
