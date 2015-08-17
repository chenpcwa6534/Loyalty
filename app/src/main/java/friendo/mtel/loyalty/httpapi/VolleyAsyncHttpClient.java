package friendo.mtel.loyalty.httpapi;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import friendo.mtel.loyalty.common.Env;

/**
 * Created by MTel on 2015/7/16.
 */
public class VolleyAsyncHttpClient {
    private static final String TAG = VolleyAsyncHttpClient.class.getSimpleName();

    static RequestQueue mVolleyQueue;
    static VolleyAsyncHttpClient volleyAsyncHttpClient;

    final static int MAX_RETRIES = 3;

    int MATHOD = Request.Method.GET;
    public static int MATHOD_GET = Request.Method.GET;
    public static int MATHOD_POST = Request.Method.POST;

    public interface VolleyAsyncHttpClientCallback{
        void onStart();
        void onFinish();
        void onFailure(String msg);
        void onSuccess(JSONObject response);
    }

    public static VolleyAsyncHttpClient getInstance(Context context){
        if(volleyAsyncHttpClient==null){
            volleyAsyncHttpClient = new VolleyAsyncHttpClient(context);
        }
        return volleyAsyncHttpClient;
    }

    public VolleyAsyncHttpClient(Context context) {
        mVolleyQueue = Volley.newRequestQueue(context);
    }

    public void post(int mathod, String serviceURL, JSONObject jsonObject,final VolleyAsyncHttpClientCallback callback){
        postVolley(mathod,serviceURL,jsonObject, "",callback);
    }

    public void post(String serviceURL, JSONObject jsonObject,final VolleyAsyncHttpClientCallback callback) {
        postVolley(0,serviceURL,jsonObject, "",callback);
    }

    public void post(int mathod, String serviceURL, JSONObject jsonObject,  String body ,final VolleyAsyncHttpClientCallback callback){
        postVolley(mathod,serviceURL,jsonObject, body,callback);
    }

    private void postVolley(int mathod, String serviceURL, JSONObject jsonObject, String body, final VolleyAsyncHttpClientCallback callback){

        if(mathod != 0){
            MATHOD = mathod;
        }else{
            MATHOD = MATHOD_GET;
        }

        Response.Listener<JSONObject> responseListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(callback!=null){
                    callback.onFinish();//onFinish
                    callback.onSuccess(response);//onSuccess
                }
            }
        };

        Response.ErrorListener responseErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try {
                    final int httpStatusCode = error.networkResponse.statusCode;

                    String retmsg = "";
                    if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                        retmsg = "連線逾時";
                    } else if (error instanceof ServerError) {
                        retmsg = "伺服器錯誤";
                    } else if (error instanceof NetworkError) {
                        retmsg = "網路錯誤";
                    } else if (error instanceof ParseError) {
                        retmsg = "解析錯誤";
                    }else{
                        retmsg = "未知錯誤";
                    }

                    if(callback!=null && error!=null){
                        callback.onFinish();//onFinish
                        callback.onFailure(retmsg);//onFailure
                    }
                } catch (Exception e) {

                }
            }
        };


        CustomRequest customRequest =  new CustomRequest(serviceURL,jsonObject, body, responseListener, responseErrorListener);
        //set retry
        customRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS , MAX_RETRIES , DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mVolleyQueue.add(customRequest);
//
        callback.onStart();//onStart
    }

    /**
     * !!! ATTENTION !!!  Volley JsonObjectRequest getHeaders() getParams() override not work
     *
     *  The getParams() doesn't invoke because JsonObjectRequest extended JsonRequest
     *  which invoke getBody() directly to encoding the constructor second parameter
     *  (call requestBody) as contentType, that's why it ignore your getParam() method.
     *
     *  #link:http://stackoverflow.com/questions/19837820/volley-jsonobjectrequest-post-request-not-working
     */
    class CustomRequest extends Request<JSONObject> {

        private Response.Listener<JSONObject> listener;
        private Map<String, String> params;
        private String body;

        @Override
        public byte[] getBody() throws AuthFailureError {
           // String body = "{\"latitude\":\"\",\"longitude\":\"\",\"search\":\"\",\"userfilter\":{\"subarea_id\":\"\",\"cat_id\":0,\"city_id\":0,\"order_id\":2,\"subcat_id\":0}}";
            String HttpRequestbody = body;
            try{
                HttpRequestbody = HttpRequestbody+"&randomFieldFilledWithAwkwardCharacters="+ URLEncoder.encode("{{%stuffToBe Escaped/", "UTF-8");
            }catch (UnsupportedEncodingException e){
                return null;
            }
            return body.getBytes();
        }

        public CustomRequest(String url, JSONObject jsonObject,String body, Response.Listener<JSONObject> reponseListener, Response.ErrorListener errorListener) {
            super(MATHOD, url, errorListener);
            this.listener = reponseListener;
            this.body = body;

            Iterator<?> keys = jsonObject.keys();
            Map<String, String> params = new HashMap<String, String>();
            try{
                while( keys.hasNext() ) {
                    String key = (String)keys.next();
                    String value = jsonObject.getString(key);
                    params.put(key,value);
                }
            }catch (Exception e){

            }
            this.params = params;
        }

        protected Map<String, String> getParams()
                throws com.android.volley.AuthFailureError {
            HashMap<String, String> params = new HashMap<String, String>();

            return params;
        }

        @Override
        public String getBodyContentType() {
            return "application/JSON";
        }

        ;

        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put(Env.ApiKEY, Env.ApiValue);
            //headers.put("Content_Type","applocation/JSON");
            return headers;
        }

        @Override
        protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
            try {
                String jsonString = new String(response.data,
                        HttpHeaderParser.parseCharset(response.headers));
                return Response.success(new JSONObject(jsonString),
                        HttpHeaderParser.parseCacheHeaders(response));
            } catch (UnsupportedEncodingException e) {
                return Response.error(new ParseError(e));
            } catch (JSONException je) {
                return Response.error(new ParseError(je));
            }
        }

        @Override
        protected void deliverResponse(JSONObject response) {
            listener.onResponse(response);
        }
    }
}

