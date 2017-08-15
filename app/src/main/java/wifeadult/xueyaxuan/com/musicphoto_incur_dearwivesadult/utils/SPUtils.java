package wifeadult.xueyaxuan.com.musicphoto_incur_dearwivesadult.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * @author xueyaxuan
 * @desc    SharedPreferences的封装类，
 * @date 2017/6/9.
 */
public class SPUtils {
    private static SharedPreferences mSharedPreferences;
    private static Editor mEditor;

    /**
     * 单例
     */
    public static SPUtils getSharedPreferencesUtil(Context context) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager
                    .getDefaultSharedPreferences(context);
            mEditor = mSharedPreferences.edit();
        }

        return new SPUtils();
    }

    /*** set value ***/
    // String
    public void setValue(String key, String value) {
        remove(key);
        mEditor.putString(key, value);
        mEditor.commit();
    }

    // Boolean
    public void setValue(String key, boolean value) {
        remove(key);
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    // Integer
    public void setValue(String key, int value) {
        remove(key);
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    // Long
    public void setValue(String key, long value) {
        remove(key);
        mEditor.putLong(key, value);
        mEditor.commit();
    }

    /*** get value ***/
    // Boolean
    public boolean getBoolean(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    // Integer
    public int getInt(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    public int getInt(String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    //Long
    public long getLong(String key) {
        return mSharedPreferences.getLong(key, 0);
    }

    // String
    public String getString(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public String getString(String key) {
        return mSharedPreferences.getString(key, "");
    }

    // Delete
    public void remove(String key) {
        if (mSharedPreferences.contains(key)) {
            mEditor.remove(key);
            mEditor.commit();
        }
    }

    public void clear() {
        mEditor.clear();
        mEditor.commit();
    }
}
