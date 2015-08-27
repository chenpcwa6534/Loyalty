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
import friendo.mtel.loyalty.component.FirmCouponsData;

/**
 * Created by MTel on 2015/7/22.
 */
public class StorePreferentialAdapter  extends RecyclerView.Adapter<StorePreferentialAdapter.ViewHolder>{
    private String TAG = StorePreferentialAdapter.class.getSimpleName();

    private Context mContext;
    private FirmCouponsData[] db_firmCoupons;
    private ViewHolder.ClickListener mListener;

    public StorePreferentialAdapter(Context context, FirmCouponsData[] data,ViewHolder.ClickListener onListener){
        this.mContext = context;
        this.mListener = onListener;
        this.db_firmCoupons = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_generalpreferential, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayout,db_firmCoupons,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(db_firmCoupons[position].getDescription());
        PicassoUtility.load(mContext, holder.mPhoto, db_firmCoupons[position].getPicture());
        holder.mSheet.setText(String .format(mContext.getResources().getString(R.string.subpreferential_qty),db_firmCoupons[position].getExpireDay()));


//        if(db_firmCoupons[position].getCoupon_rule_type().equals("latest")){
//            holder.mBackgroundView.setBackgroundResource(R.mipmap.bg_common_orange_big);
//        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return db_firmCoupons.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mPhoto;
        private TextView mSheet;
        private View mBackgroundView;
        private TextView mTitle;
        private TextView mContent;
        private TextView mTime;

        private ClickListener mListener;
        private FirmCouponsData[] db_firmCoupons;

        public ViewHolder(View itemView, FirmCouponsData[] data,ClickListener listener) {
            super(itemView);
            this.db_firmCoupons = data;
            this.mListener = listener;
            mPhoto = (ImageView) itemView.findViewById(R.id.img_photo);
            mSheet = (TextView) itemView.findViewById(R.id.txt_QTY);
            mBackgroundView = (View) itemView.findViewById(R.id.itemView);
            mTitle = (TextView) itemView.findViewById(R.id.txt_title);
            mContent = (TextView) itemView.findViewById(R.id.txt_content);
            mTime = (TextView) itemView.findViewById(R.id.txt_time);
            mBackgroundView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mListener != null){
                switch (v.getId()){
                    case R.id.itemView:
                        mListener.onClick(db_firmCoupons[getPosition()].getCouponID());
                        break;
                }
            }
        }

        public interface ClickListener {
            void onClick(int couponID);
        }
    }
}
