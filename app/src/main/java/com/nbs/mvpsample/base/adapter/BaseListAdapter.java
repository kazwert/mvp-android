package com.nbs.mvpsample.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nbs.mvpsample.base.adapter.viewholder.BaseListViewHolder;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ghiyatshanif on 2/21/17.
 * purpose : base class for simple list adapter
 * note : create a class that extend this class, override the getItemView and onCreateViewHolder method
 */
public abstract class BaseListAdapter<T, H extends BaseListViewHolder> extends
        BaseAdapter {
    public static String PAGE = "BaseListAdapter.Page";
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<T> mDatas;

    public BaseListAdapter(Context context) {
        this.mContext = context;
        mDatas = new ArrayList<>();
    }

    public BaseListAdapter(Context context, List<T> data) {
        this.mContext = context;
        this.mDatas = data;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        try {
            return mDatas.size();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        H holder;
        if (itemView == null) {
            itemView = LayoutInflater.from(mContext).inflate(getItemView(), parent, false);
            holder = onCreateViewHolder(itemView);
            itemView.setTag(holder);
        } else {
            holder = (H) itemView.getTag();
        }

        holder.bind(mDatas.get(position));

        return itemView;
    }

//    return int type for layout resource int
    protected abstract int getItemView();

//    return the viewHolder, instantiate new related viewHolder
    public abstract H onCreateViewHolder(View itemView);

    public List<T> getDatas() {
        return mDatas;
    }

    public void add(T item) {
        mDatas.add(item);
        notifyDataSetChanged();
    }

    public void add(T item, int position) {
        mDatas.add(position, item);
        notifyDataSetChanged();
    }

    public void add(final List<T> items) {
        final int size = items.size();
        for (int i = 0; i < size; i++) {
            mDatas.add(items.get(i));
        }
        notifyDataSetChanged();
    }

    public void addOrUpdate(T item) {
        int i = mDatas.indexOf(item);
        if (i >= 0) {
            mDatas.set(i, item);
            notifyDataSetChanged();
        } else {
            add(item);
        }
    }

    public void addOrUpdate(final List<T> items) {
        final int size = items.size();
        for (int i = 0; i < size; i++) {
            T item = items.get(i);
            int x = mDatas.indexOf(item);
            if (x >= 0) {
                mDatas.set(x, item);
            } else {
                add(item);
            }
        }
        notifyDataSetChanged();
    }

    public void remove(int position) {
        if (position >= 0 && position < mDatas.size()) {
            mDatas.remove(position);
            notifyDataSetChanged();
        }
    }

    public void remove(T item) {
        int position = mDatas.indexOf(item);
        remove(position);
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }
}
