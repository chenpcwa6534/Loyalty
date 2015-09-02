package friendo.mtel.loyalty.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import friendo.mtel.loyalty.R;

/**
 * Created by MTel on 2015/9/2.
 */
public class MessageDialog extends Dialog implements Button.OnClickListener{
    private Context mContext;
    private DialogCallback mCallback;

    private ImageView mLogo;
    private TextView mTitle;
    private TextView mContent;
    private LinearLayout mButtonArea;

    @Override
    public void onClick(View v) {
        int position = (int) v.getId();
        String btnStr = ((Button) v).getText().toString();
        mCallback.onClick(position,btnStr);
    }

    public enum LogoType{
        Success,Fail,Ticket,Question;
    }

    public interface DialogCallback{
        void onClick(int position, String btnStr);
    }

    public MessageDialog(Context context) {
        super(context, R.style.DialogStyle);
        this.mContext = context;
        onCreate();
    }

    public MessageDialog(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
        onCreate();
    }

    private void onCreate(){
        setContentView(R.layout.dialog_message);
        setCancelable(false);
        mLogo = (ImageView) this.findViewById(R.id.img_msglogo);
        mTitle = (TextView) this.findViewById(R.id.txt_title);
        mContent = (TextView) this.findViewById(R.id.txt_content);
        mButtonArea = (LinearLayout) this.findViewById(R.id.areabutton);
    }

    public void setTitle(String title){
        mTitle.setText(title);
    }

    public void setContent(String content){
        mContent.setText(content);
    }

    public void setContent(String[] content){
        String cont = "";
        for (int i=0; i<content.length; i++){
            if(i != 0){
                cont +="\n";
            }
            cont += content[i];
        }
        setContent(cont);
    }

    public void setLogo(LogoType logo){
        int imageresource =0;
        if(logo == LogoType.Success){
            imageresource = R.mipmap.ic_dialog_success;
        }else if(logo == LogoType.Fail){
            imageresource = R.mipmap.ic_dialog_success;
        }else if(logo == LogoType.Question){
            imageresource = R.mipmap.ic_dialog_question;
        }else if(logo == LogoType.Ticket){
            imageresource = R.mipmap.ic_dialog_ticket;
        }
        mLogo.setImageResource(imageresource);
    }

    public void setCallback(DialogCallback callback){
        mCallback = callback;
    }

    public void setButton(String button){
        Button btn = createButton(button);
        btn.setId(0);
        mButtonArea.addView(btn);
    }

    public void setButton(String[] button){
        for(int i=0; i<button.length; i++){
            Button btn = createButton(button[i]);
            btn.setId(i);
            mButtonArea.addView(btn);
        }
    }

    private Button createButton(String str){
        ViewGroup.LayoutParams  params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        Button button = new Button(mContext);
        button.setText(str);
        button.setTextSize(16);
        button.setTextColor(mContext.getResources().getColor(R.color.white));
        button.setBackgroundResource(R.mipmap.btn_dialog_red);
        button.setLayoutParams(params);
        button.setOnClickListener(this);
        return button;
    }

}
