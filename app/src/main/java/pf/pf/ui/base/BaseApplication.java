package pf.pf.ui.base;

import android.app.Application;

import pf.pf.rxjava.utils.CrashHandler;


/**
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(this);
    }
}
