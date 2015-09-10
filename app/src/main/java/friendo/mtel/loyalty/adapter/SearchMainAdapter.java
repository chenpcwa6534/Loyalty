package friendo.mtel.loyalty.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.component.CatsData;
import friendo.mtel.loyalty.component.AreaData;
import friendo.mtel.loyalty.component.OrderData;
import friendo.mtel.loyalty.component.SubAreaData;
import friendo.mtel.loyalty.component.SubCatsData;
import friendo.mtel.loyalty.view.SearchBarView;

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
        ViewHolder viewHolder = new ViewHolder(mContext, itemLayout, db_data, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = "";
        int background = -1;
        if(db_data instanceof CatsData[]){
            text = ((CatsData[]) db_data)[position].getCat_name();
            background = R.mipmap.bg_common_gary_small;
        }else if(db_data instanceof AreaData[]){
            text = ((AreaData[]) db_data)[position].getCity_name();
            background = R.mipmap.bg_common_gary_small;
        }else if(db_data instanceof SubCatsData[]){
            text = ((SubCatsData[]) db_data)[position].getSubcat_name();
        }else if(db_data instanceof SubAreaData[]){
            text = ((SubAreaData[]) db_data)[position].getSubarea_name();
        }else if(db_data instanceof OrderData[]){
            text = ((OrderData[]) db_data)[position].getOrder_name();
            background = R.mipmap.bg_common_gary_small;
        }
        holder.mText.setText(text);
        if(background != -1) holder.mText.setBackgroundResource(background);
    }

    @Override
    public int getItemCount() {
        return db_data.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Context mContext;
        private TextView mText;
        private ClickListener mListener;
        private Object[] db_data;

        public ViewHolder(Context context, View itemView,Object[] data, ClickListener listener) {
            super(itemView);
            this.mContext = context;
            this.mListener = listener;
            this.db_data = data;
            mText = (TextView) itemView.findViewById(R.id.txt_Name);
            mText.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            TextView txt = (TextView) v;
            if(db_data instanceof CatsData[]){
                eventDisplay(txt);
                mListener.onCats(getPosition());
            }else if(db_data instanceof AreaData[]){
                eventDisplay(txt);
                mListener.onCitys(getPosition());
            }else if(db_data instanceof SubCatsData[]){
                SubCatsData[] subCatsData = (SubCatsData[]) db_data;
                mListener.onSubCats(getPosition(), subCatsData[getPosition()].getSubcat_id(),subCatsData[getPosition()].getSubcat_name());
            }else if(db_data instanceof SubAreaData[]){
                SubAreaData[] subAreaDatas = (SubAreaData[]) db_data;
                mListener.onSubAreas(getPosition(), subAreaDatas[getPosition()].getSubarea_id(),subAreaDatas[getPosition()].getSubarea_name());
            }else if(db_data instanceof OrderData[]){
                eventDisplay(txt);
                mListener.onOrders(getPosition());
            }
        }

        private void eventDisplay(TextView txt){
            txt.setBackgroundResource(R.drawable.bg_listitem);
            if(SearchBarView.mCurrentTextView != null) SearchBarView.mCurrentTextView.setBackgroundResource(R.mipmap.bg_common_gary_small);
            SearchBarView.mCurrentTextView = txt;
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
