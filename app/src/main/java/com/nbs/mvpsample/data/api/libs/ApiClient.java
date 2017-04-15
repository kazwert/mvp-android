package com.nbs.mvpsample.data.api.libs;

import com.nbs.mvpsample.data.sharedmodel.Email;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ghiyatshanif on 2/23/17.
 * purpose: put all api calls here
 */

public interface ApiClient {

    @GET("inbox.json")
    Call<ArrayList<Email>> loadEmails();
}
