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
import friendo.mtel.loyalty.component.MemberExChangeData;
import friendo.mtel.loyalty.components.MemberCouponsData;
import friendo.mtel.loyalty.components.MemberRedeemLogData;
import friendo.mtel.loyalty.data.GetListResponse;

/**
 * Created by MTel on 2015/7/29.
 */
public class PocketExchangeAdapter  extends RecyclerView.Adapter<PocketExchangeAdapter.ViewHolder>{
    private String TAG = PocketExchangeAdapter.class.getSimpleName();

    private Context mContext;
    private MemberExChangeData[] db_data;
    private GetListResponse mGetListResponse;

    public PocketExchangeAdapter(Context context, MemberExChangeData[] data, GetListResponse getListResponse) {
        super();
        this.mContext = context;
        this.db_data = data;
        this.mGetListResponse = getListResponse;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pocketexchange, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayout,db_data,mGetListResponse);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PicassoUtility.load(mContext,holder.mImage,db_data[position].getPicture());
        holder.mTitle.setText(db_data[position].getName());
        holder.mContent.setText(db_data[position].getDescription());
        holder.mTime.setText(db_data[position].getConvertdate());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mImage;
        private ImageView mTag;
        private TextView mTitle;
        private TextView mContent;
        private TextView mTime;
        private View mView;

        private MemberExChangeData[] db_data;
        private GetListResponse mGetListResponse;

        public ViewHolder(View itemView, MemberExChangeData[] data, GetListResponse getListResponse) {
            super(itemView);
            this.mGetListResponse = getListResponse;
            this.db_data = data;
            mImage = (ImageView) itemView.findViewById(R.id.img_itemimage);
            mTag = (ImageView) itemView.findViewById(R.id.img_itemtag);
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
