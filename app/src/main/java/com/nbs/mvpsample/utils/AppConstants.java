package com.nbs.mvpsample.utils;


/**
 * Created by ghiyatshanif on 2/21/17.
 * purpose : put all constant variable here
 * note : separate all keys of classes by enter
 */

public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "myapp_prefs";
    public static final String PREF_NAME = "myapp_prefs";

    public static final long NULL_INDEX = -1L;

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}