package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnFragmentSendDataListener {

    private ShowDataFragment showDataFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewFragment blankFragment = new ListViewFragment();
        FragmentTransaction ftListView = getSupportFragmentManager().beginTransaction();
        ftListView.replace(R.id.frame_list_layou, blankFragment);
        ftListView.commit();

        showDataFragment = new ShowDataFragment();
        FragmentTransaction ftShowData = getSupportFragmentManager().beginTransaction();
        ftShowData.replace(R.id.frame_show_layout, showDataFragment);
        ftShowData.commit();
    }
    
    @Override
    public void onSendData(Car car) {
        showDataFragment.setSelectedObject(car);
    }
}