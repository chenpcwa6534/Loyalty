package friendo.mtel.loyalty.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import friendo.mtel.loyalty.R;

/**
 * Created by MTel on 2015/8/18.
 */
public class SuccessDialog extends Dialog {
    private String TAG = SuccessDialog.class.getSimpleName();

    private Context mContext;
    private static int mTheme = R.style.SuccessDialog;

    public SuccessDialog(Context context) {
        super(context, mTheme);
    }

    public SuccessDialog(Context context, int theme) {
        super(context, theme);
    }

    protected SuccessDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
