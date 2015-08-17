package friendo.mtel.loyalty.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.utility.PicassoUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.components.CollectibleCoupon;
import friendo.mtel.loyalty.components.DeluxeCoupon;

/**
 * Created by MTel on 2015/7/14.
 */
public class PreferentialAdapter extends RecyclerView.Adapter<PreferentialAdapter.ViewHolder> {
    private  String TAG = PreferentialAdapter.class.getSimpleName();

    private Context mContext;
    private CollectibleCoupon[] db_CollectibleCoupons;

    private ViewHolder.ClickListener mListener;

    public PreferentialAdapter(Context context, CollectibleCoupon[] data, ViewHolder.ClickListener listener){
        this.mContext = context;
        this.db_CollectibleCoupons = data;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_limitpreferential, parent, false);
        ViewHolder viewHolder = new ViewHolder(db_CollectibleCoupons,itemLayout,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(db_CollectibleCoupons[position].getFirm_name());
        holder.content.setText(db_CollectibleCoupons[position].getDescription());
        holder.QTY.setText(String.format(mContext.getResources().getString(R.string.subpreferential_qty), db_CollectibleCoupons[position].getRem_cnt()));
        PicassoUtility.load(mContext,holder.photo,db_CollectibleCoupons[position].getPicture());
    }

    @Override
    public int getItemCount() {
        return db_CollectibleCoupons.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Context mContext;

        private ImageView photo;
        private TextView QTY;
        private View itemView;
        private TextView title;
        private TextView content;
        private TextView time;

        private CollectibleCoupon[] db_CollectibleCoupons;

        private ClickListener mListener;
        public ViewHolder(CollectibleCoupon[] data, View itemView,ClickListener listener) {
            super(itemView);
            this.mListener = listener;
            this.db_CollectibleCoupons = data;
            photo = (ImageView) itemView.findViewById(R.id.img_photo);
            QTY = (TextView) itemView.findViewById(R.id.txt_QTY);
            itemView = (View) itemView.findViewById(R.id.preferentail);
            title = (TextView) itemView.findViewById(R.id.txt_title);
            content = (TextView) itemView.findViewById(R.id.txt_content);
            time = (TextView) itemView.findViewById(R.id.txt_time);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(db_CollectibleCoupons[getPosition()]);
        }

        public interface ClickListener {
            void onClick(CollectibleCoupon data);
        }
    }
}
