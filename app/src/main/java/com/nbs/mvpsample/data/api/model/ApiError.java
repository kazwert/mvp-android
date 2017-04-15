package com.nbs.mvpsample.data.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ghiyatshanif on 2/20/17.
 */

public class ApiError {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
