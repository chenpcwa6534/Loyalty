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
import friendo.mtel.loyalty.component.LimitCouponsData;

/**
 * Created by MTel on 2015/7/14.
 */
public class PreferentialAdapter extends RecyclerView.Adapter<PreferentialAdapter.ViewHolder> {
    private  String TAG = PreferentialAdapter.class.getSimpleName();

    private Context mContext;
    private LimitCouponsData[] db_LimitCouponsData;

    private ViewHolder.ClickListener mListener;

    public PreferentialAdapter(Context context, LimitCouponsData[] data, ViewHolder.ClickListener listener){
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
        holder.title.setText(db_LimitCouponsData[position].getName());
        holder.content.setText(db_LimitCouponsData[position].getDesc());
        holder.QTY.setText(String.format(mContext.getResources().getString(R.string.subpreferential_qty), db_LimitCouponsData[position].getCount()));
        PicassoUtility.load(mContext,holder.photo,db_LimitCouponsData[position].getPicture());
    }

    @Override
    public int getItemCount() {
        return db_LimitCouponsData.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Context mContext;

        private ImageView photo;
        private TextView QTY;
        private View itemView;
        private TextView title;
        private TextView content;
        private TextView time;

        private LimitCouponsData[] db_LimitCouponsData;

        private ClickListener mListener;
        public ViewHolder(LimitCouponsData[] data, View itemView,ClickListener listener) {
            super(itemView);
            this.mListener = listener;
            this.db_LimitCouponsData = data;
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
            mListener.onClick(db_LimitCouponsData[getPosition()].getCouponID());
        }

        public interface ClickListener {
            void onClick(int couponID);
        }
    }
}
