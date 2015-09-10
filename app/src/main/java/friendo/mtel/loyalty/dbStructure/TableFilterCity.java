package friendo.mtel.loyalty.dbStructure;

/**
 * Created by MTel on 2015/9/4.
 */
public class TableFilterCity extends Table {

    /** Table Name */
    private final static String TAB_Filter_city = "Filter_city_data";

    /** Column Name */
    private final static String COL_cityid = "cityid";
    private final static String COL_cityname = "cityname";

    /** Create Table String */
    public static final String DATABASE_CREATE_TABLE_city =
            "create table if not exists" + TAB_Filter_city + " ("
                    +COL_keyid + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +COL_cityid + TEXT + Comma
                    +COL_cityname + TEXT +Comma
                    +" );";
}
