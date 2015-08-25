package friendo.mtel.loyalty.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.utility.PicassoUtility;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.component.FirmPointData;
import friendo.mtel.loyalty.component.RedeemData;
import friendo.mtel.loyalty.components.MemberPointData;

/**
 * Created by MTel on 2015/8/4.
 */
public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder>{
    private String TAG = PointAdapter.class.getSimpleName();

    private Context mContext;
    private ViewHolder.ClickListener mListener;
    private FirmPointData db_memberPointData;

    public PointAdapter(Context context, FirmPointData data,ViewHolder.ClickListener onListener) {
        super();
        this.mContext = context;
        this.mListener = onListener;
        this.db_memberPointData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_point, parent, false);
        ViewHolder viewHolder = new ViewHolder(mContext,itemLayout, db_memberPointData.getRedeem(),mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position < db_memberPointData.getCurrentPoint()){
            holder.mStamp.setVisibility(View.VISIBLE);
        }else{
            holder.mStamp.setVisibility(View.INVISIBLE);
        }
        if(db_memberPointData.getRedeem() != null  || db_memberPointData.getRedeem().length != 0){
            for(int i=0; i<db_memberPointData.getRedeem().length; i++){
                if(position+1 == db_memberPointData.getRedeem()[i].getPoint()){
                    holder.mBackground.setVisibility(View.VISIBLE);
                    PicassoUtility.load(mContext,holder.mBackground,db_memberPointData.getRedeem()[i].getAdpicture());
                }else{
                    holder.mBackground.setVisibility(View.GONE);
                }
            }
       }
        holder.mNo.setText(position+1+"");
    }

    @Override
    public int getItemCount() {
        return db_memberPointData.getMaxPoint();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Context mContext;
        private ClickListener mListener;

        private View mView;
        private ImageView mStamp;
        private ImageView mBackground;
        private TextView mNo;
        private RedeemData[] mRedeem;

        public ViewHolder(Context context, View itemView, RedeemData[] redeem, ClickListener listener) {
            super(itemView);
            this.mContext = context;
            this.mListener = listener;
            this.mRedeem = redeem;

            mView = (View) itemView.findViewById(R.id.point);
            mStamp = (ImageView) itemView.findViewById(R.id.img_stamp);
            mNo = (TextView) itemView.findViewById(R.id.txt_no);
            mBackground = (ImageView) itemView.findViewById(R.id.img_background);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.point:
                    for(int i=0; i<mRedeem.length; i++){
                        if(getPosition()+1 == mRedeem[i].getPoint()){
                            int[] couponsID = new int[mRedeem[i].getConvertlist().length];
                            for(int ii= 0; ii<mRedeem[i].getConvertlist().length; i++){
                                couponsID[ii] = mRedeem[i].getConvertlist()[ii].getCouponID();
                            }
                            mListener.onClick(couponsID);
                        }
                    }
                    break;
            }
        }

        public interface ClickListener {
            void onClick(int[] couponsID);
        }
    }
}