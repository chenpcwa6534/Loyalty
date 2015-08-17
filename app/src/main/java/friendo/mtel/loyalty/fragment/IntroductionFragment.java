package friendo.mtel.loyalty.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.astuetz.page.sliding.PageSlidingPagerView;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.data.GetPagesResponse;

/**
 * Created by MTel on 2015/7/1.
 */
public class IntroductionFragment extends Fragment implements View.OnClickListener{

    private ImageView mUse_btn;
    private PageSlidingPagerView mCarousel;

    private boolean db_isFirst = true;

    private int[] pageView;

    private GetPagesResponse getPagesResponse;

    public IntroductionFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_explanation,container,false);
        initData();
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
        if(getPagesResponse != null) {
        }
    }

    private void initData(){
        pageView = new int[]{R.mipmap.tutorial_p1,R.mipmap.tutorial_p2,R.mipmap.tutorial_p3,R.mipmap.tutorial_p4,R.mipmap.tutorial_p5};
    }

    public void setCallback(GetPagesResponse getPagesResponse){
        this.getPagesResponse = getPagesResponse;
    }

    private void initView(View v){
        mUse_btn = (ImageView) v.findViewById(R.id.useApp);
        mCarousel = (PageSlidingPagerView) v.findViewById(R.id.Carousel);
        mCarousel.setViewPagerData(pageView);
        mCarousel.setPagerSelectedCallBack(callback);
        mCarousel.show();
    }

    private void initOnClick(){
        mUse_btn.setOnClickListener(this);
    }

    private PageSlidingPagerView.PagerSlidingCallBack callback= new PageSlidingPagerView.PagerSlidingCallBack() {
        @Override
        public void CurrentItem(int position) {
            if(position == pageView.length-1) {
                mUse_btn.setVisibility(View.VISIBLE);
            }else{
                mUse_btn.setVisibility(View.GONE);
            }
        }

        @Override
        public void onClick(int position) {

        }
    };
}
