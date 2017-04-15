package com.nbs.mvpsample.base.adapter.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.nbs.mvpsample.base.adapter.BaseRecyclerAdapter;


public abstract class BaseHeaderViewHolder extends BaseItemViewHolder {
    protected Bundle mBundle;

    public BaseHeaderViewHolder(Context context, View itemView, BaseRecyclerAdapter.OnItemClickListener itemClickListener, BaseRecyclerAdapter.OnLongItemClickListener longItemClickListener, Bundle mBundle) {
        super(context, itemView, itemClickListener, longItemClickListener);
        this.mBundle = mBundle;
    }

    @Override
    public void bind(Object o) {

    }

    public abstract void show();

    public void saveState(Bundle bundle) {
        this.mBundle = bundle;
    }
}
