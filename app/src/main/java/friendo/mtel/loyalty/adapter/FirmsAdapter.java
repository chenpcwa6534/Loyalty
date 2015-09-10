package friendo.mtel.loyalty.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        ViewHolder viewHolder = new ViewHolder(itemLayout,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FirmListData data = db_firmListData[position];
        holder.mTitleView.setBackgroundColor(ColorTable.getInstance(mContext).getTextColor(data.getCat_id(), ColorTable.colorType.colorA));
        holder.mStoreName.setText(data.getFirm_name());
        holder.mDistance.setText(Utilitys.distanceConversion(mContext, data.getDistance()));
        holder.mLabelView.setBackground(ColorTable.getInstance(mContext).getBackgroudDrawable(data.getCat_id()));
        PicassoUtility.load(mContext, holder.mPhoto, data.getPicture());
        holder.mPointContent.setText(data.getPointDesc());
        holder.mExperiences.setText(data.getDescription());
        holder.mExperiencesTitle.setTextColor(ColorTable.getInstance(mContext).getTextColor(data.getCat_id(), ColorTable.colorType.colorB));
        holder.mPointTitle.setTextColor(ColorTable.getInstance(mContext).getTextColor(data.getCat_id(),ColorTable.colorType.colorB));
    }

    @Override
    public int getItemCount() {
        return db_firmListData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //private View mItemView;
        private RelativeLayout mTitleView;
        private LinearLayout mLabelView;
        private TextView mStoreName;
        private ImageView mPhoto;
        private TextView mDistance;

        private TextView mPointTitle;
        private TextView mExperiencesTitle;
        private TextView mPointContent;
        private TextView mExperiences;


        private GetListResponse mListener;

        public ViewHolder(View itemView, GetListResponse listener) {
            super(itemView);
            this.mListener = listener;
            //mItemView = (View) itemView.findViewById(R.id.ly_itemView);
            mTitleView = (RelativeLayout) itemView.findViewById(R.id.TitleView);
            mStoreName = (TextView) itemView.findViewById(R.id.txt_storeName);
            mPhoto = (ImageView) itemView.findViewById(R.id.img_photo);
            mDistance = (TextView) itemView.findViewById(R.id.txt_distance);
            mLabelView = (LinearLayout) itemView.findViewById(R.id.labelView);

            mPointContent = (TextView) itemView.findViewById(R.id.txt_pointContent);
            mExperiences = (TextView) itemView.findViewById(R.id.txt_experiencecontent);

            mPointTitle = (TextView) itemView.findViewById(R.id.txt_pointtitle);
            mExperiencesTitle = (TextView) itemView.findViewById(R.id.txt_experienceTitle);

            itemView.setOnClickListener(this);
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
