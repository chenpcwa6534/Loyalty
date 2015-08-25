package friendo.mtel.loyalty.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.component.CatsData;
import friendo.mtel.loyalty.component.CitysData;
import friendo.mtel.loyalty.component.OrderData;
import friendo.mtel.loyalty.component.SubAreaData;
import friendo.mtel.loyalty.component.SubCatsData;

/**
 * Created by MTel on 2015/8/18.
 */
public class SearchMainAdapter extends RecyclerView.Adapter<SearchMainAdapter.ViewHolder> {

    private Context mContext;
    private Object[] db_data;
    private ViewHolder.ClickListener mListener;


    public SearchMainAdapter(Context context, Object[] data ,ViewHolder.ClickListener listener) {
        super();
        this.mContext = context;
        this.mListener = listener;
        this.db_data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayout, db_data, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = "";
        if(db_data instanceof CatsData[]){
            text = ((CatsData[]) db_data)[position].getCatName();
        }else if(db_data instanceof CitysData[]){
            text = ((CitysData[]) db_data)[position].getCityName();
        }else if(db_data instanceof SubCatsData[]){
            text = ((SubCatsData[]) db_data)[position].getSubcatName();
        }else if(db_data instanceof SubAreaData[]){
            text = ((SubAreaData[]) db_data)[position].getSubareaName();
        }else if(db_data instanceof OrderData[]){
            text = ((OrderData[]) db_data)[position].getOrderName();
        }
        holder.mText.setText(text);
    }

    @Override
    public int getItemCount() {
        return db_data.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mText;
        private ClickListener mListener;
        private Object[] db_data;

        public ViewHolder(View itemView,Object[] data, ClickListener listener) {
            super(itemView);
            this.mListener = listener;
            this.db_data = data;
            mText = (TextView) itemView.findViewById(R.id.txt_Name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(db_data instanceof CatsData[]){
                mListener.onCats(getPosition());
            }else if(db_data instanceof CitysData[]){
                mListener.onCitys(getPosition());
            }else if(db_data instanceof SubCatsData[]){
                SubCatsData[] subCatsData = (SubCatsData[]) db_data;
                mListener.onSubCats(getPosition(), subCatsData[getPosition()].getSubcatID(),subCatsData[getPosition()].getSubcatName());
            }else if(db_data instanceof SubAreaData[]){
                SubAreaData[] subAreaDatas = (SubAreaData[]) db_data;
                mListener.onSubAreas(getPosition(), subAreaDatas[getPosition()].getSubareaID(),subAreaDatas[getPosition()].getSubareaName());
            }else if(db_data instanceof OrderData[]){
                mListener.onOrders(getPosition());
            }
        }

        public interface ClickListener {
            void onCitys(int position);
            void onSubAreas(int position, String subareaID, String subareaName);
            void onCats(int position);
            void onSubCats(int position, int subcatID, String subcatName);
            void onOrders(int position);
        }
    }
}
