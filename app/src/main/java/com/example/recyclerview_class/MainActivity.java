package com.example.recyclerview_class;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.example.recyclerview_class.adapter.SettingsAdapter;
import com.example.recyclerview_class.model.Setting;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvSettings;
    private List<Setting> settingList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
//        actionBar.setTitle("Chinh la day");


        rcvSettings = findViewById(R.id.rcvSettings);
//        Setting setting = new Setting(R.drawable.n,"Menu", "Bluetooth");
        settingList.add(new Setting(R.drawable.n,"Menu1", "Bluetooth"));
        settingList.add(new Setting(R.drawable.n,"Menu2", "aaa"));
        settingList.add(new Setting(R.drawable.n,"Menu3", "bbb"));
        settingList.add(new Setting(R.drawable.n,"Menu4", "ccc"));
        settingList.add(new Setting(R.drawable.n,"Menu5", "ddd"));


        SettingsAdapter settingsAdapter = new SettingsAdapter(settingList, R.layout.item_setting);

        //tao kieu hien thi
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvSettings.setLayoutManager(linearLayoutManager);
        rcvSettings.setItemAnimator(null);



        //tao phan cach item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvSettings.addItemDecoration(itemDecoration);


        rcvSettings.setAdapter(settingsAdapter);
        rcvSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        settingsAdapter.setOnItemClick(new SettingsAdapter.iOnClickItem() {
            @Override
            public void onClickedItem(int position) {
//                settingList.remove(position);

//                settingsAdapter.notifyItemChanged(position);
            }
        });

    }
}