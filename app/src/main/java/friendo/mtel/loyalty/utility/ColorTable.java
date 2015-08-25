package friendo.mtel.loyalty.utility;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import friendo.mtel.loyalty.R;

/**
 * Created by MTel on 2015/8/20.
 */
public class ColorTable {
    private static Context mContext;

    private static ColorTable colorTable = null;


    public static ColorTable getInstance(Context context){
        if(colorTable == null){
            colorTable = new ColorTable(context);
        }
        return colorTable;
    }

    public ColorTable(Context context){
        this.mContext = context;
    }

    public Drawable getBackgroudDrawable(int catid){
        Drawable background = null;
        switch (catid){
            case 1:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_a);
                break;
            case 2:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_b);
                break;
            case 3:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_c);
                break;
            case 4:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_d);
                break;
            case 5:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_e);
                break;
            case 6:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_f);
                break;
            case 7:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_g);
                break;
            case 8:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_h);
                break;
            case 9:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_i);
                break;
            case 10:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_j);
                break;
            case 11:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_k);
                break;
            case 12:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_l);
                break;
            case 13:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_m);
                break;
            case 14:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_n);
                break;
            case 15:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_o);
                break;
            case 16:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_p);
                break;
            case 17:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_q);
                break;
            case 18:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_r);
                break;
            default:
                background = mContext.getResources().getDrawable(R.mipmap.bg_common_a);

        }
        return background;
    }

    public int getTextColor(int catid){
        int color = 0;
        switch (catid){
            case 1:
                color = mContext.getResources().getColor(R.color.Brand_ColorB);
                break;
            case 2:
                color = mContext.getResources().getColor(R.color.Exhibition_ColorB);
                break;
            case 3:
                color = mContext.getResources().getColor(R.color.CateringTrade_ColorB);
                break;
            case 4:
                color = mContext.getResources().getColor(R.color.Beverage_ColorB);
                break;
            case 5:
                color = mContext.getResources().getColor(R.color.CoffeeShop_ColorB);
                break;
            case 6:
                color = mContext.getResources().getColor(R.color.DepartmentStore_ColorB);
                break;
            case 7:
                color = mContext.getResources().getColor(R.color.Cure_ColorB);
                break;
            case 8:
                color = mContext.getResources().getColor(R.color.FacialBeautifiers_ColorB);
                break;
            case 9:
                color = mContext.getResources().getColor(R.color.Sport_ColorB);
                break;
            case 10:
                color = mContext.getResources().getColor(R.color.Shoe_ColorB);
                break;
            case 11:
                color = mContext.getResources().getColor(R.color.ApparelStore_ColorB);
                break;
            case 12:
                color = mContext.getResources().getColor(R.color.Glasses_ColorB);
                break;
            case 13:
                color = mContext.getResources().getColor(R.color.HairSalon_ColorB);
                break;
            case 14:
                color = mContext.getResources().getColor(R.color.Pet_ColorB);
                break;
            case 15:
                color = mContext.getResources().getColor(R.color.SPA_ColorB);
                break;
            case 16:
                color = mContext.getResources().getColor(R.color.Cuisine_ColorB);
                break;
            case 17:
                color = mContext.getResources().getColor(R.color.ECommerce_ColorB);
                break;
            case 18:
                color = mContext.getResources().getColor(R.color.Shopping_ColorB);
                break;
            default:
                color = mContext.getResources().getColor(R.color.Brand_ColorB);

        }
        return color;
    }
}
