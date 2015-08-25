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
import friendo.mtel.loyalty.component.MemberCouponsData;
import friendo.mtel.loyalty.data.GetListResponse;

/**
 * Created by MTel on 2015/7/29.
 */
public class PocketPreferentialAdapter extends RecyclerView.Adapter<PocketPreferentialAdapter.ViewHolder>{
    private String TAG = PocketPreferentialAdapter.class.getSimpleName();

    private Context mContext;
    private MemberCouponsData[] db_data;
    private GetListResponse mGetListResponse;

    public PocketPreferentialAdapter(Context context,MemberCouponsData[] data,GetListResponse getListResponse){
        this.mContext = context;
        this.db_data = data;
        this.mGetListResponse = getListResponse;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pocketpreferential, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayout,db_data,mGetListResponse);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PicassoUtility.load(mContext,holder.mImage,db_data[position].getPicture());
        holder.mTitle.setText(db_data[position].getName());
        holder.mContent.setText(db_data[position].getDescription());
        holder.mTime.setText(String.format(mContext.getResources().getString(R.string.subpreferential_day), db_data[position].getExpireDay()));
        holder.mNO.setText(""+(position+1));
    }

    @Override
    public int getItemCount() {
        return db_data.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private String TAG = PocketPreferentialAdapter.class.getSimpleName();

        private ImageView mImage;
        private TextView mNO;
        private TextView mTitle;
        private TextView mContent;
        private TextView mTime;
        private View mView;

        private MemberCouponsData[] db_data;

        private GetListResponse mGetListResponse;

        public ViewHolder(View itemView, MemberCouponsData[] data, GetListResponse getListResponse) {
            super(itemView);
            this.db_data = data;
            this.mGetListResponse = getListResponse;
            mImage = (ImageView) itemView.findViewById(R.id.img_itemimage);
            mTitle = (TextView) itemView.findViewById(R.id.txt_itemtitle);
            mContent = (TextView) itemView.findViewById(R.id.txt_itemcontent);
            mTime = (TextView) itemView.findViewById(R.id.txt_itemtime);
            mNO = (TextView) itemView.findViewById(R.id.txt_No);

            mView = (View) itemView.findViewById(R.id.ly_itemView_point);
            mView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mGetListResponse.onCouponResponse(db_data[getPosition()].getCouponID());
        }
    }
}
