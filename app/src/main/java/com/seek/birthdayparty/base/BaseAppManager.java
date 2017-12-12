package com.seek.birthdayparty.base;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 2017/12/8.
 */

public class BaseAppManager {

    private static BaseAppManager instance = null;
    private static List<Activity> mActivitys = new LinkedList<>();

    public static BaseAppManager getInstance(){
        if (instance == null){
            instance = new BaseAppManager();
        }
        return instance;
    }

    public int size(){
        return mActivitys.size();
    }

    public synchronized void addActivity(Activity activity){
        mActivitys.add(activity);
    }

    public synchronized Activity getForwardActivity(){
        return size() > 0 ? mActivitys.get(size() - 1) : null;
    }

    public synchronized void removeActivity(Activity activity){
        if (mActivitys.contains(activity)){
            mActivitys.remove(activity);
        }
    }

    public synchronized void clear(){
        for (int i = mActivitys.size() - 1; i>-1; i--){
            Activity activity = mActivitys.get(i);
            removeActivity(activity);
            activity.finish();
             i = mActivitys.size();
        }
    }

    public synchronized void clearToTop(){
        for (int i = mActivitys.size() - 2; i > -1; i--){
            Activity activity = mActivitys.get(i);
            removeActivity(activity);
            activity.finish();
            i = mActivitys.size() - 1;
        }
    }

}
