package com.nbs.mvpsample.base;

import com.nbs.mvpsample.data.api.model.ApiError;

public interface IBasePresenter<T extends IBaseView> {

    void onAttach(T view);

    void onDetach();

    void handleApiError(ApiError error);

}