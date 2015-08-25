package friendo.mtel.loyalty.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.components.SubAreaData;
import friendo.mtel.loyalty.components.SubCatData;

/**
 * Created by MTel on 2015/7/26.
 */
public class SeachThirdAdapter extends RecyclerView.Adapter<SeachThirdAdapter.ViewHolder> {
    private String TAG = SeachThirdAdapter.class.getSimpleName();

    private Context mContext;
    private Object[] mData;
    private ViewHolder.ClickListener mListener;


    public SeachThirdAdapter(Context context, Object[] data,ViewHolder.ClickListener onListener){
        super();
        this.mContext = context;
        this.mData = data;
        this.mListener = onListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayout,mData,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(mData != null){
            if(mData[position] instanceof SubAreaData){
                SubAreaData data = (SubAreaData) mData[position];
                holder.mSubCatName.setText(data.getSubarea_name());
            }else if(mData[position] instanceof SubCatData){
                SubCatData data = (SubCatData) mData[position];
                holder.mSubCatName.setText(data.getSubcat_name());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ClickListener mListener;
        private TextView mSubCatName;
        private Object[] mData;

        public ViewHolder(View itemView, Object[] data,ClickListener clickListener) {
            super(itemView);
            this.mListener = clickListener;
            this.mData = data;
            mSubCatName = (TextView) itemView.findViewById(R.id.txt_Name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mData[getPosition()] instanceof SubAreaData){
                SubAreaData data = (SubAreaData) mData[getPosition()];
                mListener.onSubArea(data.getSubarea_id());
            }else if(mData[getPosition()] instanceof SubCatData){
                SubCatData data = (SubCatData) mData[getPosition()];
                mListener.onSubCat(data.getSubcat_id());
            }

        }

        public interface ClickListener {
            void onSubArea(String subareaID);
            void onSubCat(int subcatID);
        }
    }

}
