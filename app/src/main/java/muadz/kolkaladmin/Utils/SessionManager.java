package muadz.kolkaladmin.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Mu'adz on 8/3/2018.
 */

public class SessionManager {
    private SharedPreferences prefs, pref;
    private SharedPreferences.Editor editor;

    public SessionManager(Context ctx){
        prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        pref = ctx.getSharedPreferences("androidhive-welcome", 0);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime){
        editor.putBoolean("IsFirstTimeLaunch", isFirstTime);
        editor.commit();
    }
}
