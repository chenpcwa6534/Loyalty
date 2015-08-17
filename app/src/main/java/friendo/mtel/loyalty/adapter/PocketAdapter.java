package friendo.mtel.loyalty.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import friendo.mtel.loyalty.R;

/**
 * Created by MTel on 2015/7/13.
 */
public class PocketAdapter extends RecyclerView.Adapter<PocketAdapter.ViewHolder> {

    public static int ADAPTER_POINT = 0x45364;
    public static int ADAPTER_PREFERENTIAL = 0x45365;
    public static int ADAPTER_EXCHANGE = 0x45366;

    private Context mContext;
    private String[] db_Data;
    private int adapter_status;

    public PocketAdapter(Context context, String[] data,int adapterStatus){
        this.mContext = context;
        this.db_Data = data;
        this.adapter_status = adapterStatus;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mypoint, parent, false);
        ViewHolder viewHolder = new ViewHolder(mContext,itemLayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PocketAdapter.ViewHolder holder, int position) {
        String c= db_Data[position];
        if(adapter_status == ADAPTER_POINT){
            holder.mNO.setText(String.valueOf(position+1));
            holder.mTag.setVisibility(View.GONE);
        }else if(adapter_status == ADAPTER_PREFERENTIAL){
            holder.mNO.setVisibility(View.GONE);
            holder.mTag.setVisibility(View.VISIBLE);
        }else if(adapter_status == ADAPTER_EXCHANGE){
            holder.mNO.setVisibility(View.GONE);
            holder.mTag.setVisibility(View.GONE);
        }

        holder.mTitle.setText("Square's 格子美式餐廳");
        holder.mContent.setText("已累積九點，可以換炸薯條");
        holder.mTime.setText("2015/05/27 23:37");
    }

    @Override
    public int getItemCount() {
        return db_Data.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Context mContext;

        private ImageView mImage;
        private ImageView mTag;
        private TextView mNO;
        private TextView mTitle;
        private TextView mContent;
        private TextView mTime;
        private View mView;

        public ViewHolder(Context context,View itemView) {
            super(itemView);

            mImage = (ImageView) itemView.findViewById(R.id.img_itemimage);
            mTag = (ImageView) itemView.findViewById(R.id.img_itemtag);
            mNO = (TextView) itemView.findViewById(R.id.txt_No);
            mTitle = (TextView) itemView.findViewById(R.id.txt_itemtitle);
            mContent = (TextView) itemView.findViewById(R.id.txt_itemcontent);
            mTime = (TextView) itemView.findViewById(R.id.txt_itemtime);

            mView = (View) itemView.findViewById(R.id.ly_itemView_point);
            mView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }
    }
}
