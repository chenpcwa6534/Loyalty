package friendo.mtel.loyalty.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.adapter.PointAdapter;
import friendo.mtel.loyalty.adapter.SeachThirdAdapter;
import friendo.mtel.loyalty.components.FilterData;
import friendo.mtel.loyalty.HttpsParams.FrontPageInParams;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;

/**
 * Created by MTel on 2015/7/15.
 */
public class ConditionsSearchView extends LinearLayout implements View.OnClickListener{
    private String TAG = ConditionsSearchView.class.getSimpleName();

    private Context mContext;
    private View mView;
    private TextView storeType;
    private TextView area;
    private TextView order;
    private HorizontalScrollView mSecondView;
    private ScrollView mThirdView;
    private LinearLayout mSecond;
    private RecyclerView mThird;
    private EditText mSearch;

    private Drawable Bg_pressed = getResources().getDrawable(R.mipmap.btn_common_white_kind_pressed);
    private Drawable Bg_press = getResources().getDrawable(R.mipmap.btn_common_red_category_normal);
    private int text_pressed = getResources().getColor(R.color.str_search_pressed);
    private int text_press = getResources().getColor(R.color.str_search_press);


    private FilterData db_Data;
    private int CATS = 0x12345;
    private int AREAS = 0x12346;
    private int ORDER = 0x12347;

    private TextView currentSecondText;
    private TextView currentThirdText;

    private FrontPageInParams responseData = new FrontPageInParams();

    private String KEY = "Text";
    private int GridWidth = 270;

    private SearchResponse mCallback;

    public interface SearchResponse{
        void onSearch(FrontPageInParams data);
    }

    public ConditionsSearchView(Context context) {
        super(context);
        this.mContext = context;
        setCondition();
    }

    public ConditionsSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setCondition();
    }

    public void setCallback(SearchResponse callback){
        this.mCallback = callback;
    }

    private void setCondition(){
        DataManager.getInstance(mContext).qryFilterData(mContext, false, getDataResponse);
    }

    private void initView() {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        mView = layoutInflater.inflate(R.layout.custom_search,null);

        storeType = (TextView) mView.findViewById(R.id.txt_StoreType);
        area = (TextView) mView.findViewById(R.id.txt_Area);
        order = (TextView) mView.findViewById(R.id.txt_Order);

        mSecondView = (HorizontalScrollView) mView.findViewById(R.id.view_secondView);
        mSecond = (LinearLayout) mView.findViewById(R.id.ly_second);
        mSearch = (EditText) mView.findViewById(R.id.edt_sreach);

        defaultSearch();
        this.addView(mView);
    }

    private void defaultSearch(){
        storeType.setText(db_Data.getCats()[0].getCat_name());
        area.setText(db_Data.getAreas()[0].getCity_name());
        order.setText(db_Data.getOrders()[0].getOrder_name());

        storeType.setTag(0);
        area.setTag(0);
        order.setTag(0);

        storeType.setOnClickListener(this);
        area.setOnClickListener(this);
        order.setOnClickListener(this);
    }

    private void catsData(){
        for(int i=0; i<db_Data.getCats().length; i++){
            secondView(db_Data.getCats()[i].getCat_name(),i,CATS);
        }
    }

    private void areaData(){
        for(int i=0; i<db_Data.getAreas().length; i++){
            secondView(db_Data.getAreas()[i].getCity_name(),i,AREAS);
        }
    }

    private void orderData(){
        for(int i=0; i<db_Data.getOrders().length; i++){
            secondView(db_Data.getOrders()[i].getOrder_name(),i,ORDER);
        }
    }

    private void secondView(String catName,int poisition,int type){
        TextView textView = initSecondText();
        textView.setText(catName);
        textView.setId(poisition);
        textView.setTag(R.id.tag_frontPageStatus, type);
        textView.setTag(R.id.tag_isPress,false);
        textView.setPadding(15,0,15,5);
        textView.setOnClickListener(onClickListener_Second);
        mSecond.addView(textView);
    }

    private TextView initSecondText(){
        Resources res = getResources();
        TextView textView = new TextView(mContext);
        textView.setBackground(res.getDrawable(R.mipmap.btn_common_red_kind_normal));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(res.getColor(R.color.str_search_press));
        textView.setTextSize(18);
        return textView;
    }

    private void initThirdView(Object[] data){
        if(data.length != 0){
            mThird = (RecyclerView) mView.findViewById(R.id.listView);
            SeachThirdAdapter seachThirdAdapter = new SeachThirdAdapter(getContext(),data,onListener);
            mThird.setAdapter(seachThirdAdapter);
            mThird.setItemAnimator(new DefaultItemAnimator());

            GridLayoutManager manager = new GridLayoutManager(getContext(),getColumnsNumber());
            mThird.setLayoutManager(manager);
            mThird.setVisibility(View.VISIBLE);
        }else{
            mThird.setVisibility(View.GONE);
        }
    }

    GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            FilterData data = (FilterData) obj;
            db_Data = data;
            initView();
        }

        @Override
        public void onSuccess(Object[] obj) {

        }

        @Override
        public void onFailure(Object obj) {

        }

        @Override
        public void onFinish() {

        }
    };
    private int bg_textpressed = getResources().getColor(R.color.white);
    private int bg_textpress = getResources().getColor(R.color.transparent);

    private void setPressed(TextView v){
        int textcolor = getResources().getColor(R.color.str_Text_Pressed);
        v.setBackgroundColor(bg_textpressed);
        v.setTextColor(textcolor);
    }

    private void setPress(){
        int color = getResources().getColor(R.color.white);
        storeType.setBackgroundColor(bg_textpress);
        storeType.setTextColor(color);
        storeType.setTag(0);
        area.setBackgroundColor(bg_textpress);
        area.setTextColor(color);
        area.setTag(0);
        order.setBackgroundColor(bg_textpress);
        order.setTextColor(color);
        order.setTag(0);
    }

    private boolean isTextPressed(View v){
        boolean ispressed = false;
        if((int)(v.getTag()) == 0){
            setPress();
            v.setTag(1);
            ispressed = false;
        }else if((int)(v.getTag()) == 1){
            setPress();
            mSecondView.setVisibility(View.GONE);
            ispressed = true;
        }
        mSecond.removeAllViews();
        return ispressed;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.txt_StoreType:
                if(!isTextPressed(v)){
                    catsData();
                    setPressed((TextView) v);
                }
                break;
            case R.id.txt_Area:
                if(!isTextPressed(v)){
                    areaData();
                    setPressed((TextView) v);
                }
                break;
            case R.id.txt_Order:
                if(!isTextPressed(v)){
                    orderData();
                    setPressed((TextView) v);
                }
                break;
        }
        mSecondView.setVisibility(View.VISIBLE);
    }

    ViewGroup.OnClickListener onClickListener_Second = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            int tag = (int) v.getTag(R.id.tag_frontPageStatus);
            setSecondPressed((TextView) v );
            if(tag == CATS){
                    initThirdView(db_Data.getCats()[(int) v.getId()].getSubcats());
            }else if(tag == AREAS){

            }else if(tag == ORDER){

            }

            currentSecondText = (TextView) v;
        }
    };

    private boolean isSecondPressed(TextView v){
        return (boolean) v.getTag(R.id.tag_isPress);
    }

    private void setSecondPressed(TextView v){
        setSecondPress();
        Drawable drawable = getResources().getDrawable(R.mipmap.btn_common_red_kind_normal);
        int textColor = getResources().getColor(R.color.str_search_pressed);
        v.setBackground(drawable);
        v.setTextColor(textColor);
        v.setTag(R.id.tag_isPress, true);

        currentSecondText = v;
    }

    private void setSecondPress(){
        if(currentSecondText != null) {
            Drawable drawable = getResources().getDrawable(R.mipmap.btn_common_red_kind_normal);
            int textColor = getResources().getColor(R.color.str_search_press);
            currentSecondText.setBackground(drawable);
            currentSecondText.setTextColor(textColor);
            currentSecondText.setTag(R.id.tag_isPressed);
        }
    }

    private int getColumnsNumber(){
        DisplayMetrics  metrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels / GridWidth;
    }


    private SeachThirdAdapter.ViewHolder.ClickListener onListener = new SeachThirdAdapter.ViewHolder.ClickListener() {
        @Override
        public void onSubArea(String subareaID) {

        }

        @Override
        public void onSubCat(int subcatID) {

        }
    };

}

