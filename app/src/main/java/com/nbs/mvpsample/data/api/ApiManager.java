package com.nbs.mvpsample.data.api;

import com.nbs.mvpsample.data.api.libs.ApiClient;
import com.nbs.mvpsample.data.sharedmodel.Email;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ghiyatshanif on 2/23/17.
 */

public class ApiManager implements IApiManager {
    private ApiClient mApiClient;

    @Inject
    public ApiManager(ApiClient mApiClient) {
        this.mApiClient = mApiClient;
    }

    public interface LoadEmailListener{
        void onSuccess(ArrayList<Email> emails);
        void onFailure(String errorMessage);
    }

    @Override
    public void loadEmails(final LoadEmailListener listener) {
        Call<ArrayList<Email>> loadEmail =  mApiClient.loadEmails();

        // TODO: 3/2/17 Create a better response & error handling
        loadEmail.enqueue(new Callback<ArrayList<Email>>() {
            @Override
            public void onResponse(Call<ArrayList<Email>> call, Response<ArrayList<Email>> response) {
                if (response.isSuccessful() && response.body() != null && response.code() == 200){
                    listener.onSuccess(response.body());
                }else {
                    listener.onFailure("400 : Bad Request");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Email>> call, Throwable t) {
                listener.onFailure("404: not found");
            }
        });
    }
}
