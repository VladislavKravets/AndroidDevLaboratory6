package com.example.lab6;

import static java.lang.Thread.sleep;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ShowDataFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_data, container, false);
    }

    // обновление фрагмента
    public void setSelectedObject(Car car) {
        TextView brandView = getView().findViewById(R.id.brandView);
        TextView modelView = getView().findViewById(R.id.modelView);
        TextView countryView = getView().findViewById(R.id.countryView);
        TextView driveView = getView().findViewById(R.id.driveView);
        TextView horsepower = getView().findViewById(R.id.horsepowerView);
        TextView engine = getView().findViewById(R.id.engineView);
        ProgressBar mProgressBar = (ProgressBar) getView().findViewById(R.id.progressBar);

        ConstraintLayout dataLayout = getView().findViewById(R.id.data_layout);
        dataLayout.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);

        /* Емуляцый загрузки */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataLayout.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.INVISIBLE);
                brandView.setText(car.getBrand());
                modelView.setText(car.getModel());
                countryView.setText(car.getCountry());
                driveView.setText(car.getDrive());
                horsepower.setText(String.valueOf(car.getHorsepower()));
                engine.setText(String.valueOf(car.getEngine()));
            }
        }, 500);
    }
}