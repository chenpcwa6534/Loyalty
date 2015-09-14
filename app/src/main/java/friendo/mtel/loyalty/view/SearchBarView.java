package friendo.mtel.loyalty.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import friendo.mtel.loyalty.HttpsParams.FrontPageInParams;
import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.adapter.SearchMainAdapter;
import friendo.mtel.loyalty.common.DeviceInformation;
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.data.DataCache;
import friendo.mtel.loyalty.data.GetSearchResponse;
import friendo.mtel.loyalty.utility.Utilitys;

/**
 * Created by MTel on 2015/8/18.
 */
public class SearchBarView extends RelativeLayout implements View.OnClickListener{
    private String TAG = SearchBarView.class.getSimpleName();

    private Context mContext;
    private FilterData db_filter;
    private View SubView;       //下拉區塊
    private View PreviousOnClickSelect;  //紀錄上次按下的搜尋條件類別(分類，地區，排序)
    public static TextView mPreviousOnClickTextView;


    private RecyclerView mMainListView;
    private RecyclerView mSubListView;
    private EditText mSearchKey;
    private TextView mCats;
    private TextView mCitys;
    private TextView mOrders;
    private Button mMode;

    private GetSearchResponse mListener;

    private int Attr_OrderType; //default = 0,  0 is firmlist, 1 is limitlist
    private boolean Attr_SearchKeyOpen;  //手 key 欄位是否顯示
    private boolean Attr_Mode;      // mode 切換功能扭 default is true
    private int DURATIONTIME =300;  //動畫時間
    private boolean isOpen_SubView = false; //確認下拉選單是否已被打開

    public SearchBarView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public SearchBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        getAttr(context , attrs);
        initView();
    }

    public void setCallback(GetSearchResponse clickListener){
        this.mListener = clickListener;
    }

    private void getAttr(Context context , AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.SearchBarAttr);
        Attr_OrderType = typedArray.getInt(R.styleable.SearchBarAttr_OrderType,0);
        Attr_SearchKeyOpen = typedArray.getBoolean(R.styleable.SearchBarAttr_SearchKey, true);
        Attr_Mode = typedArray.getBoolean(R.styleable.SearchBarAttr_Mode,true);
    }

    private void initView(){
        db_filter = DataCache.cacheFilterData;
        if(db_filter == null) db_filter = new FilterData();
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View mView = layoutInflater.inflate(R.layout.custom_searchbar, null);

        SubView = (LinearLayout) mView.findViewById(R.id.subView);
        mSearchKey = (EditText) mView.findViewById(R.id.edt_searchKey);
        mCats = (TextView) mView.findViewById(R.id.txt_Cats);
        mCitys = (TextView) mView.findViewById(R.id.txt_Citys);
        mOrders = (TextView) mView.findViewById(R.id.txt_Orders);
        mMainListView = (RecyclerView) mView.findViewById(R.id.mainlistView);
        mSubListView = (RecyclerView) mView.findViewById(R.id.sublistView);
        mMode = (Button) mView.findViewById(R.id.btn_mode);

        mCats.setOnClickListener(this);
        mCitys.setOnClickListener(this);
        mOrders.setOnClickListener(this);
        mMode.setOnClickListener(this);


        mMode.setTag(0);
        //Tag value is check open status
        // 0 is not open ; 1 is open
        mCats.setTag(0);
        mCitys.setTag(0);
        mOrders.setTag(0);
        addView(mView);

        if(Attr_SearchKeyOpen){
            mSearchKey.setVisibility(View.VISIBLE);
        }else{
            mSearchKey.setVisibility(View.GONE);
        }

        if(Attr_Mode){
            mMode.setVisibility(View.VISIBLE);
        }else{
            mMode.setVisibility(View.GONE);
        }

        initValue();
    }

    /**
     * SearchBar initialzation
     * if gps is open show data index = 0, 附近店家 跟 依距離排序
     * if gps is close show data index = 1, 台北市 跟 依優惠排序
     */
    private void initValue(){
        mCats.setText(db_filter.getCats()[0].getCat_name());
        if(Utilitys.isGPS(mContext)){
            mCitys.setText(db_filter.getArea()[0].getCity_name());
            mOrders.setText(db_filter.getOrder()[0].getOrder_name());
        }else{
            mCitys.setText(db_filter.getArea()[1].getCity_name());
            mOrders.setText(db_filter.getOrder()[1].getOrder_name());
        }
    }

    private void setCatsText(String str){
        mCats.setText(str);
    }

    private void setCityText(String str){
        mCitys.setText(str);
    }

    private void setOrderText(String str){
        mOrders.setText(str);
    }

    private void reSearch(){
        Gson gson = new Gson();
        if(Attr_OrderType == 0){
            String userFilter = gson.toJson(DataCache.cacheFrontPageInParams);
            mListener.onFirmSearch(userFilter);
        }else if(Attr_OrderType == 1){
            String userFilter = gson.toJson(DataCache.cacheFrontPageInParamsLimit);
            mListener.onLimitSearch(userFilter);
        }
    }

    private SearchMainAdapter.ViewHolder.ClickListener onClickListener = new SearchMainAdapter.ViewHolder.ClickListener() {
        @Override
        public void onCitys(int position) {
            int CityID = db_filter.getArea()[position].getCity_id();
            String CityName = db_filter.getArea()[position].getCity_name();
            setCityText(CityName);
            DataCache.cacheFrontPageInParams.getUserfilter().setCity_id(CityID);
            if(CityID == 0  || db_filter.getArea()[position].getSubarea().length == 0){
                HiddenAction();
                reSearch();
                return;
            }else {
                initSubList(db_filter.getArea()[position].getSubarea());
            }
        }

        @Override
        public void onSubAreas(int position, String subareaID, String subareaName) {
            setCityText(subareaName);
            DataCache.cacheFrontPageInParams.getUserfilter().setSubarea_id(subareaID);
            HiddenAction();
            reSearch();
        }

        @Override
        public void onCats(int position) {
            int CatID = db_filter.getCats()[position].getCat_id();
            String CatName = db_filter.getCats()[position].getCat_name();
            setCatsText(CatName);
            DataCache.cacheFrontPageInParams.getUserfilter().setCat_id(CatID);
            if(CatID == 0 || db_filter.getCats()[position].getSubcat().length == 0){
                HiddenAction();
                reSearch();
                return;
            }else {
                initSubList(db_filter.getCats()[position].getSubcat());
            }
        }

        @Override
        public void onSubCats(int position, int subcatID, String subcatName) {
            setCatsText(subcatName);
            DataCache.cacheFrontPageInParams.getUserfilter().setSubcat_id(subcatID);
            HiddenAction();
            reSearch();
        }

        @Override
        public void onOrders(int position) {
            String OrderName;
            int orderID = db_filter.getOrder()[position].getOrder_id();
            String orderName = db_filter.getOrder()[position].getOrder_name();
            setOrderText(orderName);
            HiddenAction();
            reSearch();
        }
    };

    private void initSubList(Object[] data){
        SearchMainAdapter adapter = new SearchMainAdapter(getContext(),data,onClickListener);
        mSubListView.setAdapter(adapter);
        mSubListView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSubListView.setLayoutManager(linearLayoutManager);
        mSubListView.setVisibility(View.VISIBLE);
    }

    /**
     * 0 : 代表清單模式 1 : 代表地圖模式
     */
    private void modeOnClickEvent(){
        if((int) mMode.getTag() == 0){
            mMode.setBackground(mContext.getResources().getDrawable(R.mipmap.btn_common_red_list_normal));
            mMode.setTag(1);
        }else if((int) mMode.getTag() == 1){
            mMode.setBackground(mContext.getResources().getDrawable(R.mipmap.btn_common_red_location_normal));
            mMode.setTag(0);
        }
        mListener.onModeChange((int) mMode.getTag());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_Cats:
                SearchMainAdapter cityAdapter = new SearchMainAdapter(getContext(),db_filter.getCats(),onClickListener);
                mMainListView.setAdapter(cityAdapter);
                openControl(v);
                break;
            case R.id.txt_Citys:
                SearchMainAdapter catAdapter = new SearchMainAdapter(getContext(),db_filter.getArea(),onClickListener);
                mMainListView.setAdapter(catAdapter);
                openControl(v);
                break;
            case R.id.txt_Orders:
                SearchMainAdapter orderAdapter = new SearchMainAdapter(getContext(),db_filter.getOrder(),onClickListener);

                mMainListView.setAdapter(orderAdapter);
                mSubListView.setVisibility(View.INVISIBLE);
                openControl(v);
                break;
            case R.id.btn_mode:
                modeOnClickEvent();
                break;
        }

        mMainListView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMainListView.setLayoutManager(linearLayoutManager);
        mMainListView.setVisibility(View.VISIBLE);
    }

    /**
     * 下拉區塊顯示控制
     * @param NowOnClickSelect
     */
    private void openControl(View NowOnClickSelect){
        if(isOpen_SubView){
            HiddenAction();
            if(NowOnClickSelect != PreviousOnClickSelect){
                ShowAction(NowOnClickSelect);
            }
        }else{
            ShowAction(NowOnClickSelect);
        }
        PreviousOnClickSelect = NowOnClickSelect;
    }

    /**
     * list push on style
     * @param btn
     */
    private void setBtnPress(TextView btn){
        if(btn != null){
            btn.setTextColor(mContext.getResources().getColor(R.color.str_Text_Pressed));
            btn.setBackgroundResource(R.mipmap.bg_common_gary_small);
            btn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_common_red_category_normal, 0);
        }
    }

    /**
     * list push off style
     * @param btn
     */
    private void setBtnUnPress(TextView btn){
        if(btn != null){
            btn.setTextColor(mContext.getResources().getColor(R.color.white));
            btn.setBackgroundResource(R.mipmap.btn_common_red_category_normal);
            btn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_common_white_category_normal, 0);
        }
    }

    /**
     * invisible 動畫設定
     */
    private void HiddenAction(){
        TranslateAnimation hidden = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,-1.0f);
        hidden.setDuration(DURATIONTIME);
        SubView.startAnimation(hidden);
        SubView.setVisibility(View.GONE);
        mSubListView.setVisibility(View.INVISIBLE);
        setBtnUnPress((TextView) PreviousOnClickSelect);
        isOpen_SubView = false;
    }


    /**
     * visible 動畫設定
     * @param v
     */
    private void ShowAction(View v){
        TranslateAnimation show = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,-1.0f,Animation.RELATIVE_TO_SELF,0.0f);
        show.setDuration(DURATIONTIME);
        SubView.startAnimation(show);
        SubView.setVisibility(View.VISIBLE);
        setBtnPress((TextView) v);
        isOpen_SubView = true;
    }
}
