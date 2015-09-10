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

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.component.FirmListData;
import friendo.mtel.loyalty.data.GetListResponse;
import friendo.mtel.loyalty.utility.ColorTable;
import friendo.mtel.loyalty.utility.Utilitys;

/**
 * Created by MTel on 2015/8/26.
 */
public class FirmsMapAdapter extends RecyclerView.Adapter<FirmsMapAdapter.ViewHolder> {
    private String TAG = FirmsMapAdapter.class.getSimpleName();

    private FirmListData[] db_firmListDatas;
    private GetListResponse mListener;
    private Context mContext;

    public FirmsMapAdapter(Context context, FirmListData[] data,GetListResponse listener) {
        super();
        this.mContext = context;
        this.db_firmListDatas = data;
        this.mListener = listener;
    }

    @Override
    public FirmsMapAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_storemap, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayout,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FirmsMapAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "firmsMap position:" + position + " picture:" + db_firmListDatas[position].getPicture());
        holder.mName.setText(db_firmListDatas[position].getFirm_name());
        holder.mName.setTextColor(ColorTable.getInstance(mContext).getTextColor(db_firmListDatas[position].getCat_id(), ColorTable.colorType.colorB));
//        holder.mAddress.setText(db_firmListDatas[position].getAddress());
        holder.mNumber.setText(db_firmListDatas[position].getFirm_tel());
        holder.mAddress.setText("新竹市勝利路112號");
        holder.mDistance.setText(mContext.getResources().getString(R.string.subpreferential_dis) + Utilitys.distanceConversion(mContext,db_firmListDatas[position].getDistance()));
        String picture = db_firmListDatas[position].getPicture();
        PicassoUtility.load(mContext,holder.mPicture,db_firmListDatas[position].getPicture());
    }

    @Override
    public int getItemCount() {
        return db_firmListDatas.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private GetListResponse mListener;

        private TextView mName;
        private TextView mAddress;
        private TextView mNumber;
        private TextView mDistance;
        private ImageView mPicture;

        public ViewHolder(View itemView,GetListResponse listener) {
            super(itemView);
            this.mListener = listener;
            mName = (TextView) itemView.findViewById(R.id.txt_StoreName);
            mAddress = (TextView) itemView.findViewById(R.id.txt_StoreAddress);
            mNumber = (TextView) itemView.findViewById(R.id.txt_Storenumber);
            mDistance = (TextView) itemView.findViewById(R.id.txt_StoreDistance);
            mPicture = (ImageView) itemView.findViewById(R.id.img_StorePicture);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onFirmResponse(getPosition());
        }
    }
}
