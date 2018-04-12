package com.example.admin.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 12/04/2018.
 */

public class FitAppAdapter extends RecyclerView.Adapter<FitAppAdapter.FitAppViewHolder>{




    private Context mCtx;
    private List<Exercice> exerciceList;

    public FitAppAdapter(Context mCtx, List<Exercice> exerciceList) {
        this.mCtx = mCtx;
        this.exerciceList = exerciceList;
    }

    @Override
    public FitAppViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.rv_fitapp, null);
        FitAppViewHolder holder = new FitAppViewHolder(view);
        return holder;
    }
    class FitAppViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_name;
        TextView tv_date;
        TextView tv_desc;

        public FitAppViewHolder(View itemView) {
            super(itemView);
            ArrayList<Exercice> exer = new ArrayList<>();
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_desc = itemView.findViewById(R.id.tv_desc);
        }

    }

    @Override
    public void onBindViewHolder(FitAppViewHolder holder, int position)
    {
        Exercice exe = exerciceList.get(position);
        holder.tv_name.setText(exe.getName());
        holder.tv_date.setText(exe.getCreation_date());
        holder.tv_desc.setText(exe.getDescription());

    }
    @Override
    public int getItemCount() {
        Log.d("logtest",""+exerciceList.size());
        return exerciceList.size();
    }



}

