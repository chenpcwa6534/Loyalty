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
import friendo.mtel.loyalty.data.GetListResponse;
import friendo.mtel.loyalty.utility.ColorTable;
import friendo.mtel.loyalty.utility.Utilitys;

/**
 * Created by MTel on 2015/7/20.
 */
public class FirmsAdapter extends RecyclerView.Adapter<FirmsAdapter.ViewHolder>{
    private String TAG = FirmsAdapter.class.getSimpleName();

    private Context mContext;

    private FirmListData[] db_firmListData;
    private GetListResponse mListener;


    public FirmsAdapter(Context context, FirmListData[] datas, GetListResponse onListener) {
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
        holder.mDistance.setText(data.getDistance() + mContext.getResources().getString(R.string.substore_distanceUtil));
        PicassoUtility.load(mContext, holder.mPhoto, data.getPicture());
        holder.mPointContent.setText(data.getPointDesc());
        holder.mExperiences.setText(data.getFirstDesc());
        holder.mTitleView.setBackground(ColorTable.getInstance(mContext).getBackgroudDrawable(data.getCatID()));
        holder.mExperiencesTitle.setTextColor(ColorTable.getInstance(mContext).getTextColor(data.getCatID()));
        holder.mPointTitle.setTextColor(ColorTable.getInstance(mContext).getTextColor(data.getCatID()));
    }

    @Override
    public int getItemCount() {
        return db_firmListData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private View mItemView;
        private RelativeLayout mTitleView;
        private TextView mDistance;
        private ImageView mPhoto;
        private TextView mPointTitle;
        private TextView mExperiencesTitle;
        private TextView mPointContent;
        private TextView mExperiences;
        private TextView mStoreName;

        private GetListResponse mListener;

        public ViewHolder(Context context,View itemView, GetListResponse listener) {
            super(itemView);
            this.mListener = listener;
            mItemView = (View) itemView.findViewById(R.id.ly_itemView);
            mTitleView = (RelativeLayout) itemView.findViewById(R.id.TitleView);
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
            mListener.onFirmResponse(getPosition());
        }

        public interface ClickListener {
            void onClick(int position);
        }
    }
}
