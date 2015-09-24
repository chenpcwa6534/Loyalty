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
        if(db_firmCoupons[position].isType()){
            holder.mTag.setVisibility(View.VISIBLE);
            holder.mfirst.setVisibility(View.VISIBLE);

            PicassoUtility.load(mContext, holder.mPhoto_first, db_firmCoupons[position].getPicture());
            holder.mCouponName_first.setText(db_firmCoupons[position].getTitle());
            holder.mContent_first.setText(db_firmCoupons[position].getDescription());
            holder.mExpireday_first.setText(String.format(mContext.getResources().getString(R.string.store_reciprocal),db_firmCoupons[position].getExpireday()));
        }else{
            holder.mGeneral.setVisibility(View.VISIBLE);

            PicassoUtility.load(mContext, holder.mPhoto_general, db_firmCoupons[position].getPicture());
            holder.mCouponName_general.setText(db_firmCoupons[position].getTitle());
            holder.mContent_general.setText(db_firmCoupons[position].getDescription());
            holder.mExpireday_general.setText(String.format(mContext.getResources().getString(R.string.store_reciprocal), db_firmCoupons[position].getExpireday()));
        }
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

        private View mfirst;
        private View mGeneral;
        private ImageView mPhoto_first;
        private ImageView mPhoto_general;
        private TextView mCouponName_first;
        private TextView mCouponName_general;
        private TextView mContent_first;
        private TextView mContent_general;
        private TextView mExpireday_first;
        private TextView mExpireday_general;
        private TextView mTag;

        private ClickListener mListener;
        private FirmCouponsData[] db_firmCoupons;

        public ViewHolder(View itemView, FirmCouponsData[] data,ClickListener listener) {
            super(itemView);
            this.db_firmCoupons = data;
            this.mListener = listener;
            mfirst = (View) itemView.findViewById(R.id.first);
            mGeneral = (View) itemView.findViewById(R.id.general);

            mPhoto_first = (ImageView) itemView.findViewById(R.id.img_first_photo);
            mPhoto_general = (ImageView) itemView.findViewById(R.id.img_general_photo);

            mCouponName_first = (TextView) itemView.findViewById(R.id.txt_first_couponname);
            mCouponName_general = (TextView) itemView.findViewById(R.id.txt_general_couponname);

            mContent_first = (TextView) itemView.findViewById(R.id.txt_first_content);
            mContent_general = (TextView) itemView.findViewById(R.id.txt_general_content);

            mExpireday_first = (TextView) itemView.findViewById(R.id.txt_first_expireday);
            mExpireday_general = (TextView) itemView.findViewById(R.id.txt_general_expireday);

            mTag = (TextView) itemView.findViewById(R.id.txt_tag);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mListener != null){
                mListener.onClick(db_firmCoupons[getPosition()].getCoupons_id());
            }
        }

        public interface ClickListener {
            void onClick(int couponID);
        }
    }
}
