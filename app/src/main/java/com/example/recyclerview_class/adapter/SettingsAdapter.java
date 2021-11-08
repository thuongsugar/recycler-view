package com.example.recyclerview_class.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview_class.R;
import com.example.recyclerview_class.model.Setting;


import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolderSetting> {
    private final List<Setting> settingList;
    private final int layoutRes;
    private iOnClickItem ionClickItem;
    private static int defaultPosition = 0;

    public SettingsAdapter(List<Setting> settingList, int layoutRes){
        this.settingList = settingList;
        this.layoutRes = layoutRes;
        if(this.settingList.size() >= 0){
            this.settingList.get(0).setChecked(true);
        }
    }
    @NonNull
    @Override
    public ViewHolderSetting onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(this.layoutRes,parent,false);
        return new ViewHolderSetting(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSetting holder, @SuppressLint("RecyclerView") int position) {
//        int pos = position;
        Setting setting = settingList.get(position);
        Setting settingOld = settingList.get(defaultPosition);

        if(setting == null){ return;}
        holder.imv.setImageResource(setting.getImvRes());
        holder.txtTitle.setText(setting.getTitle());

        holder.txtDetail.setText(setting.getDetail());

        if(setting.isChecked()){
            holder.layOutItem.setBackgroundColor(Color.RED);
        }else {
            holder.layOutItem.setBackgroundColor(Color.WHITE);
        }
        holder.layOutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ionClickItem != null){
                    settingOld.setChecked(false);
                    setting.setChecked(true);
                    notifyDataSetChanged();
                    defaultPosition = position;
//                    notifyDataSetChanged();
//                    ionClickItem.onClickedItem(position);
                }
            }
        });
//        if(position == 0){
//            setting.setChecked(true);
//
//        }


    }

    @Override
    public int getItemCount() {
        if(settingList == null) {
            return 0;
        }
        return settingList.size();
    }


    static class ViewHolderSetting extends RecyclerView.ViewHolder {
        private final ImageView imv;
        private final TextView txtTitle;
        private final TextView txtDetail;
        private final ConstraintLayout layOutItem;


        public ViewHolderSetting(@NonNull View itemView) {
            super(itemView);
            imv = itemView.findViewById(R.id.imv_);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDetail = itemView.findViewById(R.id.txt_detail);
            layOutItem = itemView.findViewById(R.id.layout_item);
        }
    }

    public void setOnItemClick(iOnClickItem iOnClickItem){
        this.ionClickItem = iOnClickItem;
    }
    public  interface iOnClickItem{
        void onClickedItem(int position);
    }
}
