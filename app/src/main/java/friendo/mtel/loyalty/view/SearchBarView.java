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
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.data.DataCache;
import friendo.mtel.loyalty.data.GetSearchResponse;

/**
 * Created by MTel on 2015/8/18.
 */
public class SearchBarView extends RelativeLayout implements View.OnClickListener{
    private String TAG = SearchBarView.class.getSimpleName();

    private Context mContext;
    private FilterData db_filter;
    private View SubView;
    private boolean isOpen_SubView = false;
    private View CurrentEvent;
    private int DURATIONTIME =300;

    private RecyclerView mMainListView;
    private RecyclerView mSubListView;
    private EditText mSearchKey;
    private TextView mCats;
    private TextView mCitys;
    private TextView mOrders;
    private Button mMode;

    private GetSearchResponse mListener;

    private int OrderTypeAttr; //default = 0,  0 is firmlist, 1 is limitlist
    private boolean SearchKeyOpen;
    private boolean Mode;      // mode 切換功能扭 default is true


//    public interface ClickListener{
//        void onSearch(String userFilter);
//    }

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
        OrderTypeAttr = typedArray.getInt(R.styleable.SearchBarAttr_OrderType,0);
        SearchKeyOpen = typedArray.getBoolean(R.styleable.SearchBarAttr_SearchKey, true);
        Mode = typedArray.getBoolean(R.styleable.SearchBarAttr_Mode,true);
    }

    private void initView(){
        db_filter = DataCache.cacheFilterData;
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

        if(SearchKeyOpen){
            mSearchKey.setVisibility(View.VISIBLE);
        }else{
            mSearchKey.setVisibility(View.GONE);
        }

        if(Mode){
            mMode.setVisibility(View.VISIBLE);
        }else{
            mMode.setVisibility(View.GONE);
        }

        initValue();
    }

    private void initValue(){
        mCats.setText(db_filter.getCats()[0].getCatName());
        mCitys.setText(db_filter.getCitys()[0].getCityName());

        if(OrderTypeAttr == 0){
            mOrders.setText(db_filter.getOrder().getPoint()[0].getOrderName());
        }else{
            mOrders.setText(db_filter.getOrder().getLimit()[0].getOrderName());
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
        if(OrderTypeAttr == 0){
            String userFilter = gson.toJson(DataCache.cacheFrontPageInParams);
            mListener.onFirmSearch(userFilter);
        }else if(OrderTypeAttr == 1){
            String userFilter = gson.toJson(DataCache.cacheFrontPageInParamsLimit);
            mListener.onLimitSearch(userFilter);
        }
    }

    private SearchMainAdapter.ViewHolder.ClickListener onClickListener = new SearchMainAdapter.ViewHolder.ClickListener() {
        @Override
        public void onCitys(int position) {
            int CityID = db_filter.getCitys()[position].getCityID();
            String CityName = db_filter.getCitys()[position].getCityName();
            setCityText(CityName);
            DataCache.cacheFrontPageInParams.getUserfilter().setCity_id(CityID);
            if(CityID == 0){
                HiddenAction();
                reSearch();
                return;
            }
            initSubList(db_filter.getCitys()[position].getSubareas());
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
            int CatID = db_filter.getCats()[position].getCatID();
            String CatName = db_filter.getCats()[position].getCatName();
            setCatsText(CatName);
            DataCache.cacheFrontPageInParams.getUserfilter().setCat_id(CatID);
            if(CatID == 0){
                HiddenAction();
                reSearch();
                return;
            }
            initSubList(db_filter.getCats()[position].getSubcats());
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
            if(OrderTypeAttr == 0){
                OrderName = db_filter.getOrder().getPoint()[position].getOrderName();
            }else{
                OrderName = db_filter.getOrder().getLimit()[position].getOrderName();
            }
            setOrderText(OrderName);
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
                break;
            case R.id.txt_Citys:
                SearchMainAdapter catAdapter = new SearchMainAdapter(getContext(),db_filter.getCitys(),onClickListener);
                mMainListView.setAdapter(catAdapter);
                break;
            case R.id.txt_Orders:
                SearchMainAdapter orderAdapter;
                if(OrderTypeAttr == 0){
                    orderAdapter = new SearchMainAdapter(getContext(),db_filter.getOrder().getPoint(),onClickListener);
                }else{
                    orderAdapter = new SearchMainAdapter(getContext(),db_filter.getOrder().getLimit(),onClickListener);
                }
                mMainListView.setAdapter(orderAdapter);
                mSubListView.setVisibility(View.INVISIBLE);
                break;
            case R.id.btn_mode:
                modeOnClickEvent();
                break;
        }
        openControl(v);
        mMainListView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mMainListView.setLayoutManager(linearLayoutManager);
        mMainListView.setVisibility(View.VISIBLE);
    }

    private void openControl(View NowEvent){
        if(isOpen_SubView){
            HiddenAction();
            if(NowEvent != CurrentEvent){
                ShowAction();
            }
        }else{
            ShowAction();
        }
        CurrentEvent = NowEvent;
    }

    private void HiddenAction(){
        TranslateAnimation hidden = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,-1.0f);
        hidden.setDuration(DURATIONTIME);
        SubView.startAnimation(hidden);
        SubView.setVisibility(View.GONE);
        mSubListView.setVisibility(View.INVISIBLE);
        isOpen_SubView = false;
    }

    private void ShowAction(){
        TranslateAnimation show = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,-1.0f,Animation.RELATIVE_TO_SELF,0.0f);
        show.setDuration(DURATIONTIME);
        SubView.startAnimation(show);
        SubView.setVisibility(View.VISIBLE);
        isOpen_SubView = true;
    }
}
