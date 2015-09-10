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

    public static enum colorType{
        colorA,colorB
    }

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
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_a);
                break;
            case 2:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_b);
                break;
            case 3:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_c);
                break;
            case 4:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_d);
                break;
            case 5:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_e);
                break;
            case 6:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_f);
                break;
            case 15:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_g);
                break;
            case 16:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_h);
                break;
            case 17:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_i);
                break;
            case 19:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_j);
                break;
            case 20:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_k);
                break;
            case 21:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_l);
                break;
            case 22:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_m);
                break;
            case 23:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_n);
                break;
            case 25:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_o);
                break;
            case 26:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_p);
                break;
            case 27:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_q);
                break;
            case 28:
                background = mContext.getResources().getDrawable(R.mipmap.bg_home_label_r);
                break;
            default:

        }
        return background;
    }

    public int getTextColor(int catid,colorType colortype){
        int color = 0;
        int colorA = 0;
        int colorB = 0;
        switch (catid){
            case 1:
                colorA = mContext.getResources().getColor(R.color.Brand_ColorA);
                colorB = mContext.getResources().getColor(R.color.Brand_ColorB);
                break;
            case 2:
                colorA = mContext.getResources().getColor(R.color.Exhibition_ColorA);
                colorB = mContext.getResources().getColor(R.color.Exhibition_ColorB);
                break;
            case 3:
                colorA = mContext.getResources().getColor(R.color.CateringTrade_ColorA);
                colorB = mContext.getResources().getColor(R.color.CateringTrade_ColorB);
                break;
            case 4:
                colorA = mContext.getResources().getColor(R.color.Beverage_ColorA);
                colorB = mContext.getResources().getColor(R.color.Beverage_ColorB);
                break;
            case 5:
                colorA = mContext.getResources().getColor(R.color.CoffeeShop_ColorA);
                colorB = mContext.getResources().getColor(R.color.CoffeeShop_ColorB);
                break;
            case 6:
                colorA = mContext.getResources().getColor(R.color.DepartmentStore_ColorA);
                colorB = mContext.getResources().getColor(R.color.DepartmentStore_ColorB);
                break;
            case 15:
                colorA = mContext.getResources().getColor(R.color.Cure_ColorA);
                colorB = mContext.getResources().getColor(R.color.Cure_ColorB);
                break;
            case 16:
                colorA = mContext.getResources().getColor(R.color.FacialBeautifiers_ColorA);
                colorB = mContext.getResources().getColor(R.color.FacialBeautifiers_ColorB);
                break;
            case 17:
                colorA = mContext.getResources().getColor(R.color.Sport_ColorA);
                colorB = mContext.getResources().getColor(R.color.Sport_ColorB);
                break;
            case 19:
                colorA = mContext.getResources().getColor(R.color.Shoe_ColorA);
                colorB = mContext.getResources().getColor(R.color.Shoe_ColorB);
                break;
            case 20:
                colorA = mContext.getResources().getColor(R.color.ApparelStore_ColorA);
                colorB = mContext.getResources().getColor(R.color.ApparelStore_ColorB);
                break;
            case 21:
                colorA = mContext.getResources().getColor(R.color.Glasses_ColorA);
                colorB = mContext.getResources().getColor(R.color.Glasses_ColorB);
                break;
            case 22:
                colorA = mContext.getResources().getColor(R.color.HairSalon_ColorA);
                colorB = mContext.getResources().getColor(R.color.HairSalon_ColorB);
                break;
            case 23:
                colorA = mContext.getResources().getColor(R.color.Pet_ColorA);
                colorB = mContext.getResources().getColor(R.color.Pet_ColorB);
                break;
            case 25:
                colorA = mContext.getResources().getColor(R.color.SPA_ColorA);
                colorB = mContext.getResources().getColor(R.color.SPA_ColorB);
                break;
            case 26:
                colorA = mContext.getResources().getColor(R.color.Cuisine_ColorA);
                colorB = mContext.getResources().getColor(R.color.Cuisine_ColorB);
                break;
            case 27:
                colorA = mContext.getResources().getColor(R.color.ECommerce_ColorA);
                colorB = mContext.getResources().getColor(R.color.ECommerce_ColorB);
                break;
            case 28:
                colorA = mContext.getResources().getColor(R.color.Shopping_ColorA);
                colorB = mContext.getResources().getColor(R.color.Shopping_ColorB);
                break;
            default:
                colorA = mContext.getResources().getColor(R.color.white);
                colorB = mContext.getResources().getColor(R.color.white);

        }
        if(colortype == colorType.colorA){
            color = colorA;
        }else if(colortype == colorType.colorB){
            color = colorB;
        }
        return color;
    }

    public int getLocationIcon(int catid){
        int index = -1;
        switch (catid) {
            case 0:
                index = 0;
                break;
            case 1:
                index = 1;
                break;
            case 2:
                index = 2;
                break;
            case 3:
                index = 3;
                break;
            case 4:
                index = 4;
                break;
            case 5:
                index = 5;
                break;
            case 6:
                index = 6;
                break;
            case 15:
                index = 7;
                break;
            case 16:
                index = 8;
                break;
            case 17:
                index = 9;
                break;
            case 19:
                index = 10;
                break;
            case 20:
                index = 11;
                break;
            case 21:
                index = 12;
                break;
            case 22:
                index = 13;
                break;
            case 23:
                index = 14;
                break;
            case 25:
                index = 15;
                break;
            case 26:
                index = 16;
                break;
            case 27:
                index = 17;
                break;
            case 28:
                index = 18;
                break;
            default:
        }
        return index;
    }
}
