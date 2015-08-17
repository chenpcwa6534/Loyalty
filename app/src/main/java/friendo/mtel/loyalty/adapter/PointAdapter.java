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
import friendo.mtel.loyalty.components.MemberPointData;

/**
 * Created by MTel on 2015/8/4.
 */
public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder>{
    private String TAG = PointAdapter.class.getSimpleName();

    private Context mContext;
    private ViewHolder.ClickListener mListener;
    private MemberPointData db_memberPointData;

    public PointAdapter(Context context, MemberPointData data,ViewHolder.ClickListener onListener) {
        super();
        this.mContext = context;
        this.mListener = onListener;
        this.db_memberPointData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_point, parent, false);
        ViewHolder viewHolder = new ViewHolder(mContext,itemLayout,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position < db_memberPointData.getPoint()){
            holder.mStamp.setVisibility(View.VISIBLE);
        }
        if(db_memberPointData.getPoint_redeem() != null){
            for(int i=0; i<db_memberPointData.getPoint_redeem().length; i++){
                if(position+1 == 5){
                    holder.mStamp.setImageResource(R.mipmap.ic_common_orange_stamp_small);
                    PicassoUtility.load(mContext,holder.mBackground,db_memberPointData.getPoint_redeem()[i].getPicture().getUrl());
                }
            }
        }
        holder.mNo.setText(position+1+"");
    }

    @Override
    public int getItemCount() {
        return 33;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Context mContext;
        private ClickListener mListener;

        private View mView;
        private ImageView mStamp;
        private ImageView mBackground;
        private TextView mNo;

        public ViewHolder(Context context, View itemView, ClickListener listener) {
            super(itemView);
            this.mContext = context;
            this.mListener = listener;

            mView = (View) itemView.findViewById(R.id.point);
            mStamp = (ImageView) itemView.findViewById(R.id.img_stamp);
            mNo = (TextView) itemView.findViewById(R.id.txt_no);
            mBackground = (ImageView) itemView.findViewById(R.id.img_background);

            mView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.point:
                    mListener.onClick(getPosition());
                    break;
            }
        }

        public interface ClickListener {
            void onClick(int position);
        }
    }
}