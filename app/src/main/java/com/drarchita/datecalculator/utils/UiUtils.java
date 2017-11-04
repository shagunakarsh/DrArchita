package com.drarchita.datecalculator.utils;

import android.app.Activity;
import android.view.View;

/**
 * Created by Shagun on 03-11-2017.
 */

public class UiUtils {

    public static <T extends View> T findView(View root, int id) {
        return (T) root.findViewById(id);
    }

    public static <T extends View> T findView(Activity activity, int id) {
        return (T) activity.getWindow().getDecorView().getRootView().findViewById(id);
    }
}
