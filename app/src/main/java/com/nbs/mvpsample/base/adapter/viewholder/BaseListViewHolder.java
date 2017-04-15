package com.nbs.mvpsample.base.adapter.viewholder;

import android.content.Context;
import android.view.View;

import butterknife.ButterKnife;


public abstract class BaseListViewHolder<Data> {
    protected Context mContext;

    public BaseListViewHolder(Context context, View itemView) {
        this.mContext =  context;
        ButterKnife.bind(this, itemView);
    }

//    all view binding here e.g set text for textview
    public abstract void bind(Data data);
}
