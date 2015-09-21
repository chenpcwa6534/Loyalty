package friendo.mtel.loyalty.preferences;

import android.content.Context;
import android.util.Log;

/**
 * Created by MTel on 2015/8/12.
 */
public class LoyaltyPreference extends BasePreferences {
    private static String TAG = LoyaltyPreference.class.getSimpleName();


    public interface sharedPreferenceChangeListener{
        void onSharedPreferenceChange(String key, Object value);
    }



    public static final String DEVICE_TOKEN = "DEVICETOKEN";
    private static final String DEFAULT_DEVICE_TOKEN = "";
    private static String PAR_DEVICE_TOKEN = DEFAULT_DEVICE_TOKEN;
    public static void setDeviceToken(Context context, String token){
        try{
            if(editor == null) load(context);
            editor.putString(DEVICE_TOKEN, token);
            PAR_DEVICE_TOKEN = token;
            save();

        }catch (Exception e){
            Log.e(TAG,"set device token fail Exception:"+e);
        }
    }

    public static String getDeviceToken(Context context){
        try{
            if(settings == null) load(context);
            if(settings != null) {
                String token = settings.getString(DEVICE_TOKEN, DEFAULT_DEVICE_TOKEN);
                PAR_DEVICE_TOKEN = token;
                return token;
            }
        }catch (Exception e){
            Log.e(TAG,"get memberiD fail Exception:"+e);
        }
        return DEFAULT_PERSON_MEMBERID;
    }

    public static final String PERSON_MEMBERID = "MEMBERID";
    public static final String DEFAULT_PERSON_MEMBERID = "00000000-0000-0000-0000-000000000000";
    private static String PAR_PERSON_MEMBER = DEFAULT_PERSON_MEMBERID;
    public static void setMemberID(Context context,String memberID){
        try{
            if(editor == null) load(context);
            editor.putString(PERSON_MEMBERID, memberID);
            PAR_PERSON_MEMBER = memberID;
            save();

        }catch (Exception e){
            Log.e(TAG,"set memberID fail Exception:"+e);
        }
    }

    public static String getMemberID(Context context){
        try{
            if(settings == null) load(context);
            if(settings != null) {
                String memberID = settings.getString(PERSON_MEMBERID, DEFAULT_PERSON_MEMBERID);
                PAR_PERSON_MEMBER = memberID;
                return memberID;
            }
        }catch (Exception e){
            Log.e(TAG,"get memberiD fail Exception:"+e);
        }
        return DEFAULT_PERSON_MEMBERID;
    }

    public static final String PERSON_Name = "NAME";
    public static final String PERSON_Bithday = "BIRTHDAY";
    public static final String PERSON_Gender = "GENDER";
    public static final String PERSON_Photo = "PHOTO";
    private static final String DEFAULT_PERSON_NAME = "";
    private static final String DEFAULT_PERSON_BIRTHDAY = "";
    private static final String DEFAULT_PERSON_GENDER = "";
    private static final String DEFAULT_PERSON_PHOTO = "";
    private static String PAR_PERSON_NAME = DEFAULT_PERSON_NAME;
    private static String PAR_PERSON_BIRTHDAY = DEFAULT_PERSON_BIRTHDAY;
    private static String PAR_PERSON_GENDER = DEFAULT_PERSON_GENDER;
    private static String PAR_PERSON_PHOTO = DEFAULT_PERSON_PHOTO;
    public static void setPersonInformation(Context context, String name, String birthday,String gender,String picture){
        try{
            if(editor == null) load(context);
            editor.putString(PERSON_Name, name);
            PAR_PERSON_NAME = name;
            editor.putString(PERSON_Bithday, birthday);
            PAR_PERSON_BIRTHDAY = birthday;
            editor.putString(PERSON_Gender, gender);
            PAR_PERSON_GENDER = gender;
            editor.putString(PERSON_Photo, picture);
            PAR_PERSON_PHOTO = picture;
            save();

        }catch (Exception e){
            Log.e(TAG,"Exception:"+e);
        }
    }

    public static String getPersonName(Context context){
        try{
            if(settings == null) load(context);
            if(settings != null) {
                String name = settings.getString(PERSON_Name, DEFAULT_PERSON_NAME);
                PAR_PERSON_NAME = name;
                return name;
            }
        }catch (Exception e){
            Log.e(TAG,"Exception:"+e);
        }
        return DEFAULT_PERSON_NAME;
    }

    public static String getPersonBirthday(Context context){
        try{
            if(settings == null) load(context);
            if(settings != null) {
                String birthday = settings.getString(PERSON_Bithday, DEFAULT_PERSON_BIRTHDAY);
                PAR_PERSON_BIRTHDAY = birthday;
                return birthday;
            }
        }catch (Exception e){
            Log.e(TAG,"Exception:"+e);
        }
        return DEFAULT_PERSON_BIRTHDAY;
    }

    public static String getPersonGender(Context context){
        try{
            if(settings == null) load(context);
            if(settings != null) {
                String gender = settings.getString(PERSON_Gender, DEFAULT_PERSON_GENDER);
                PAR_PERSON_GENDER = gender;
                return gender;
            }
        }catch (Exception e){
            Log.e(TAG,"Exception:"+e);
        }
        return DEFAULT_PERSON_GENDER;
    }

    public static String getPersonPhoto(Context context){
        try{
            if(settings == null) load(context);
            if(settings != null) {
                String photo = settings.getString(PERSON_Photo, DEFAULT_PERSON_PHOTO);
                PAR_PERSON_PHOTO = photo;
                return photo;
            }
        }catch (Exception e){
            Log.e(TAG,"Exception:"+e);
        }
        return DEFAULT_PERSON_PHOTO;
    }


    public enum API{
        VersionControl,Filter,Filter_Order
    }

    public static final String API_REQUESTTIME = "";
    private static final String DEFAULT_API_REQUESTTIME = "";
    private static String PAR_API_REQUESTTIME = DEFAULT_API_REQUESTTIME;
    public static void setAPIRequestTime(Context context, API ApiName, String UpdateTime){
        try{
            if(editor == null) load(context);
            editor.putString(ApiName.toString(), UpdateTime);
            PAR_API_REQUESTTIME = UpdateTime;
            save();

        }catch (Exception e){
            Log.e(TAG,"set Api updateTime fail (LoyaltyPreference.class line 177) Exception:"+e);
        }
    }

    public static String getAPIRequestTime(Context context, API ApiName){
        try{
            if(settings == null) load(context);
            if(settings != null) {
                String UpdateTime = settings.getString(ApiName.toString(), DEFAULT_API_REQUESTTIME);
                PAR_API_REQUESTTIME = UpdateTime;
                return UpdateTime;
            }
        }catch (Exception e){
            Log.e(TAG,"get Api updateTime fail (LoyaltyPreference.class line 190) Exception:"+e);
        }
        return DEFAULT_API_REQUESTTIME;
    }
}
