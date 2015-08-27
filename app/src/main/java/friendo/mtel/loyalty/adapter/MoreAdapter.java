package friendo.mtel.loyalty.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import friendo.mtel.loyalty.R;

/**
 * Created by MTel on 2015/7/8.
 */
public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder>{

    private Context mContext;
    private String[] data;
    private ViewHolder.ClickListener mListener;


    public MoreAdapter(Context context,String[] data,ViewHolder.ClickListener listener) {
        this.mContext = context;
        this.data = data;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_morelayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayout,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mListItem.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mListItem;
        private View mListView;
        private ClickListener mListener;

        public ViewHolder(View itemView, ClickListener listener) {
            super(itemView);
            this.mListener = listener;

            mListItem = (TextView) itemView.findViewById(R.id.txt_funtion);
            mListView = (View) itemView.findViewById(R.id.ly_listView);

            mListView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClickPage(getPosition());
        }

        public interface ClickListener {
            void onClickPage(int position);
        }
    }
}