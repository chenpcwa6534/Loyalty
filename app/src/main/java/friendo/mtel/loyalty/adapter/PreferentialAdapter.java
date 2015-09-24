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

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.component.LimitCouponsData;
import friendo.mtel.loyalty.utility.ColorTable;

/**
 * Created by MTel on 2015/7/14.
 */
public class PreferentialAdapter extends RecyclerView.Adapter<PreferentialAdapter.ViewHolder> {
    private  String TAG = PreferentialAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<LimitCouponsData> db_LimitCouponsData;

    private ViewHolder.ClickListener mListener;

    public PreferentialAdapter(Context context, ArrayList<LimitCouponsData> data, ViewHolder.ClickListener listener){
        this.mContext = context;
        this.db_LimitCouponsData = data;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_limitpreferential, parent, false);
        ViewHolder viewHolder = new ViewHolder(db_LimitCouponsData,itemLayout,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int colorA = ColorTable.getInstance(mContext).getTextColor(db_LimitCouponsData.get(position).getCat_id(), ColorTable.colorType.colorA);
        int colorB = ColorTable.getInstance(mContext).getTextColor(db_LimitCouponsData.get(position).getCat_id(), ColorTable.colorType.colorB);
        holder.mFirmName.setText(db_LimitCouponsData.get(position).getFirm_name());
        holder.mCouponTitle.setText(db_LimitCouponsData.get(position).getTitle());
        holder.mCouponContent.setText(db_LimitCouponsData.get(position).getDescription());
        holder.mExpireDay.setText(String.format(mContext.getResources().getString(R.string.store_reciprocal), db_LimitCouponsData.get(position).getExpireday()));
        holder.mRenCnt.setText(String.format(mContext.getResources().getString(R.string.subpreferential_qty), db_LimitCouponsData.get(position).getRem_cnt()));
        holder.mRenCnt.setTextColor(colorA);
        PicassoUtility.load(mContext, holder.mPhoto, db_LimitCouponsData.get(position).getPicture());

        holder.mBackgroundColor.setBackgroundColor(colorB);
    }

    @Override
    public int getItemCount() {
        return db_LimitCouponsData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mPhoto;
        private TextView mFirmName;
        private TextView mCouponTitle;
        private TextView mCouponContent;
        private TextView mExpireDay;
        private TextView mRenCnt;

        private View mBackgroundColor;

        private ArrayList<LimitCouponsData> db_LimitCouponsData;

        private ClickListener mListener;
        public ViewHolder(ArrayList<LimitCouponsData> data, View itemView,ClickListener listener) {
            super(itemView);
            this.mListener = listener;
            this.db_LimitCouponsData = data;
            mPhoto = (ImageView) itemView.findViewById(R.id.img_photo);
            mFirmName = (TextView) itemView.findViewById(R.id.txt_firm_name);
            mCouponTitle = (TextView) itemView.findViewById(R.id.txt_coupon_title);
            mCouponContent = (TextView) itemView.findViewById(R.id.txt_coupon_content);
            mExpireDay = (TextView) itemView.findViewById(R.id.txt_coupon_expireday);
            mRenCnt = (TextView) itemView.findViewById(R.id.txt_remcnt);
            mBackgroundColor = (View) itemView.findViewById(R.id.color_background);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(db_LimitCouponsData.get(getPosition()).getCoupons_id());
        }

        public interface ClickListener {
            void onClick(int couponID);
        }
    }
}
