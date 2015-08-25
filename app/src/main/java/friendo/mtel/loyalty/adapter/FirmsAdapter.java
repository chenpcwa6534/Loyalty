package friendo.mtel.loyalty.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astuetz.utility.PicassoUtility;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.component.FirmListData;
import friendo.mtel.loyalty.utility.ColorTable;

/**
 * Created by MTel on 2015/7/20.
 */
public class FirmsAdapter extends RecyclerView.Adapter<FirmsAdapter.ViewHolder>{
    private String TAG = FirmsAdapter.class.getSimpleName();

    private Context mContext;

    private FirmListData[] db_firmListData;
    private ViewHolder.ClickListener mListener;


    public FirmsAdapter(Context context, FirmListData[] datas, ViewHolder.ClickListener onListener) {
        super();
        this.mContext = context;
        this.mListener = onListener;
        this.db_firmListData = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, parent, false);
        ViewHolder viewHolder = new ViewHolder(mContext,itemLayout,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FirmListData data = db_firmListData[position];
        holder.mStoreName.setText(data.getFirmName());
        holder.mDistance.setText(data.getDistance()+mContext.getResources().getString(R.string.substore_distanceUtil));
        PicassoUtility.load(mContext, holder.mPhoto, data.getPicture());
        holder.mPointContent.setText(data.getPointDesc());
        holder.mExperiences.setText(data.getFirstDesc());
        holder.mTitleView.setBackground(getBackgroudDrawable(data.getCatID()));
        holder.mExperiencesTitle.setTextColor(ColorTable.getInstance(mContext).getTextColor(data.getCatID()));
        holder.mPointTitle.setTextColor(ColorTable.getInstance(mContext).getTextColor(data.getCatID()));
    }

    @Override
    public int getItemCount() {
        return db_firmListData.length;
    }

    private Drawable getBackgroudDrawable(int catid){
        Drawable background = null;
        switch (catid){
            case 1:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_a);
                break;
            case 2:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_b);
                break;
            case 3:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_c);
                break;
            case 4:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_d);
                break;
            case 5:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_e);
                break;
            case 6:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_f);
                break;
            case 7:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_g);
                break;
            case 8:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_h);
                break;
            case 9:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_i);
                break;
            case 10:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_j);
                break;
            case 11:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_k);
                break;
            case 12:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_l);
                break;
            case 13:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_m);
                break;
            case 14:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_n);
                break;
            case 15:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_o);
                break;
            case 16:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_p);
                break;
            case 17:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_q);
                break;
            case 18:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_r);
                break;
            default:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_a);

        }
        return background;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private View mItemView;
        private RelativeLayout mTitleView;
        //private ImageView mTitleView;
        private TextView mDistance;
        private ImageView mPhoto;
        private TextView mPointTitle;
        private TextView mExperiencesTitle;
        private TextView mPointContent;
        private TextView mExperiences;
        private TextView mStoreName;

        private ClickListener mListener;

        public ViewHolder(Context context,View itemView, ClickListener listener) {
            super(itemView);
            this.mListener = listener;
            mItemView = (View) itemView.findViewById(R.id.ly_itemView);
            mTitleView = (RelativeLayout) itemView.findViewById(R.id.TitleView);
            //mTitleView = (ImageView) itemView.findViewById(R.id.img_titleView);
            mDistance = (TextView) itemView.findViewById(R.id.txt_distance);
            mPhoto = (ImageView) itemView.findViewById(R.id.img_photo);
            mPointContent = (TextView) itemView.findViewById(R.id.txt_pointContent);
            mExperiences = (TextView) itemView.findViewById(R.id.txt_experiencecontent);
            mStoreName = (TextView) itemView.findViewById(R.id.txt_storeName);
            mPointTitle = (TextView) itemView.findViewById(R.id.txt_pointtitle);
            mExperiencesTitle = (TextView) itemView.findViewById(R.id.txt_experienceTitle);

            mItemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getPosition());
        }

        public interface ClickListener {
            void onClick(int position);
        }
    }
}
