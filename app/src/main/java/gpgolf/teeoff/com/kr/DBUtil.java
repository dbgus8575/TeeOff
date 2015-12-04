package gpgolf.teeoff.com.kr;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by T on 2015-12-03.
 */
public class DBUtil {
    public static void close(SQLiteDatabase c){
        if(c != null) {
            try{
                c.close();
            }catch (Exception e) {
            }
        }
    }
}
