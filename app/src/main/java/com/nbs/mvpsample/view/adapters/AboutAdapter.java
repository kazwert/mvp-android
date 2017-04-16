package com.nbs.mvpsample.view.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nbs.mvpsample.R;
import com.nbs.mvpsample.base.adapter.BaseListAdapter;
import com.nbs.mvpsample.base.adapter.viewholder.BaseListViewHolder;
import com.nbs.mvpsample.data.sharedmodel.Email;
import com.nbs.mvpsample.utils.ImageUtils;
import com.nbs.mvpsample.view.custom.CircleImageView;

import java.util.List;

import butterknife.BindView;

import static android.support.v4.content.ContextCompat.getColor;

/**
 * Created by User on 16-Apr-17.
 */

public class AboutAdapter extends BaseListAdapter<Email, AboutAdapter.AboutViewHolder> {


    public AboutAdapter(Context context, List<Email> data) {
        super(context, data);

        if (mContext == null) {
            throw new NullPointerException("ANJJING NULLLLLL");
        }
    }

    @Override
    protected int getItemView() {
        return R.layout.item_about;
    }

    @Override
    public AboutViewHolder onCreateViewHolder(View itemView) {
        return new AboutViewHolder(mContext, itemView);
    }

    public class AboutViewHolder extends BaseListViewHolder<Email> {
        @BindView(R.id.tv_from)
        TextView tvFrom;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_message_preview)
        TextView tvMessagePreview;
        @BindView(R.id.message_container)
        LinearLayout messageContainer;
        @BindView(R.id.icon_back)
        RelativeLayout iconBack;
        @BindView(R.id.img_profile)
        CircleImageView imgProfile;
        @BindView(R.id.tv_indicator)
        TextView tvIndicator;
        @BindView(R.id.icon_front)
        RelativeLayout iconFront;
        @BindView(R.id.icon_container)
        RelativeLayout iconContainer;
        @BindView(R.id.tv_timestamp)
        TextView tvTimestamp;
        @BindView(R.id.img_favorite)
        ImageView imgFavorite;

        public AboutViewHolder(Context context, View itemView) {
            super(context, itemView);
        }

        @Override
        public void bind(Email email) {
            tvFrom.setText(email.getFrom());
            tvTitle.setText(email.getSubject());
            tvMessagePreview.setText(email.getMessage());
            tvTimestamp.setText(email.getTimestamp());

            tvIndicator.setText(email.getFrom().substring(0,1));


            applyProfilePicture(email);

            applyImportant(email);

            applyReadStatus(email);
        }




        private void applyProfilePicture(Email email) {
            if (!TextUtils.isEmpty(email.getPicture())) {
                ImageUtils.setImageUrl(email.getPicture(),imgProfile);

                imgProfile.setColorFilter(null);
                tvIndicator.setVisibility(View.GONE);
            } else {
                imgProfile.setImageResource(R.drawable.bg_circle);
                imgProfile.setColorFilter(email.getColor());
                tvIndicator.setVisibility(View.VISIBLE);
            }
        }

        private void applyImportant(Email email) {
            if (email.isImportant()) {
                ImageUtils.setImage(R.drawable.ic_star_black_24dp,imgFavorite);
                imgFavorite.setColorFilter(getColor(mContext,R.color.icon_tint_selected));
            } else {
                ImageUtils.setImage(R.drawable.ic_star_border_black_24dp,imgFavorite);
                imgFavorite.setColorFilter(getColor(mContext, R.color.icon_tint_normal));
            }
        }

        private void applyReadStatus(Email email) {
            if (email.isRead()) {
                tvFrom.setTypeface(null, Typeface.NORMAL);
                tvTitle.setTypeface(null, Typeface.NORMAL);
                tvFrom.setTextColor(getColor(mContext, R.color.subject));
                tvTitle.setTextColor(getColor(mContext, R.color.message));
            } else {
                tvFrom.setTypeface(null, Typeface.BOLD);
                tvTitle.setTypeface(null, Typeface.BOLD);
                tvFrom.setTextColor(getColor(mContext, R.color.from));
                tvTitle.setTextColor(getColor(mContext, R.color.subject));
            }
        }


    }
}
