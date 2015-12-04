package gpgolf.teeoff.com.kr;

import android.app.Application;
import android.content.Context;

/**
 * Created by T on 2015-12-03.
 */
public class ScoreApplication extends Application {
    private static android.content.Context Context;

    @Override
    public void onCreate(){
        super.onCreate();
        Context = this;
    }

    public static Context getContext(){
        return Context;
    }
}
