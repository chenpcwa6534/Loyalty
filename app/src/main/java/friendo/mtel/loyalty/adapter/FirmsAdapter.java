package friendo.mtel.loyalty.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.utility.PicassoUtility;

import java.util.ArrayList;
import java.util.List;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.components.FrontPageFirmData;
import friendo.mtel.loyalty.data.DataCache;

/**
 * Created by MTel on 2015/7/20.
 */
public class FirmsAdapter extends RecyclerView.Adapter<FirmsAdapter.ViewHolder>{
    private String TAG = FirmsAdapter.class.getSimpleName();

    private Context mContext;

    private FrontPageFirmData[] db_frontPageFirmData;
    private ViewHolder.ClickListener mListener;


    public FirmsAdapter(Context context, FrontPageFirmData[] datas, ViewHolder.ClickListener onListener) {
        super();
        this.mContext = context;
        this.mListener = onListener;
        this.db_frontPageFirmData = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store, parent, false);
        ViewHolder viewHolder = new ViewHolder(mContext,itemLayout,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FrontPageFirmData data = db_frontPageFirmData[position];
        holder.mStoreName.setText(data.getFirm_name());
        holder.mDistance.setText(data.getDistance()+mContext.getResources().getString(R.string.substore_distanceUtil));
        PicassoUtility.load(mContext,holder.mPhoto,data.getPicture());
        holder.mPointContent.setText(data.getDescription());
    }

    @Override
    public int getItemCount() {
        return db_frontPageFirmData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private View mItemView;
        private ImageView mTitleView;
        private TextView mDistance;
        private ImageView mPhoto;
        private TextView mPointContent;
        private TextView mExperiences;
        private TextView mStoreName;

        private ClickListener mListener;

        public ViewHolder(Context context,View itemView, ClickListener listener) {
            super(itemView);
            this.mListener = listener;
            mItemView = (View) itemView.findViewById(R.id.ly_itemView);
            mTitleView = (ImageView) itemView.findViewById(R.id.img_TitleView);
            mDistance = (TextView) itemView.findViewById(R.id.txt_distance);
            mPhoto = (ImageView) itemView.findViewById(R.id.img_photo);
            mPointContent = (TextView) itemView.findViewById(R.id.txt_pointContent);
            mExperiences = (TextView) itemView.findViewById(R.id.txt_experiencecontent);
            mStoreName = (TextView) itemView.findViewById(R.id.txt_storeName);

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
