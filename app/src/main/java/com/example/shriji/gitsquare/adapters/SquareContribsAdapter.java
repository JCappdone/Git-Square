package com.example.shriji.gitsquare.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shriji.gitsquare.R;
import com.example.shriji.gitsquare.models.SquareContribsModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SquareContribsAdapter extends RecyclerView.Adapter<SquareContribsAdapter.MyViewHolder> {

    private Context mContext;
    private List<SquareContribsModel> mList;

    public SquareContribsAdapter(Context context, List<SquareContribsModel> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_squarecontribs, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SquareContribsModel model = mList.get(position);
        holder.mTxtUserName.setText(model.getLogin());
        holder.mTxtReposUrl.setText(model.getReposUrl());
        holder.mTxtContributions.setText("Contributions: "+String.valueOf(model.getContributions()));
        //use glide library to load image in our image view
        Glide.with(mContext)
                .load(model.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mImgAvatar);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgAvatar)
        ImageView mImgAvatar;
        @BindView(R.id.txtUserName)
        TextView mTxtUserName;
        @BindView(R.id.txtReposUrl)
        TextView mTxtReposUrl;
        @BindView(R.id.txtContributions)
        TextView mTxtContributions;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
