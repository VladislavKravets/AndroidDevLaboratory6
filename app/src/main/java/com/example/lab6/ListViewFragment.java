package com.example.lab6;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListViewFragment extends Fragment {
    private OnFragmentSendDataListener fragmentSendDataListener;

    List<Car> cars = new ArrayList<>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cars.add(new Car("Audi", "A1", "Германія", "Передній", 95, 1));
        cars.add(new Car("Audi", "Q3", "Германія", "Повний", 180, 2));
        cars.add(new Car("BMW", "M1", "Германія", "Задній", 340, 3));
        cars.add(new Car("BMW", "X5", "Германія", "Повний", 462, 4.4f));
        cars.add(new Car("Volkswagen", "Golf R", "Германія", "Повний", 319, 2));
        cars.add(new Car("Volkswagen", "Jetta", "Германія", "Передній", 150, 1.4f));
        cars.add(new Car("Chevrolet", "Lanos", "США", "Передній", 86, 1.5f));
        cars.add(new Car("Chevrolet", "Lacetti", "США", "Передній", 109, 1.6f));

        View view = inflater.inflate(R.layout.fragment_list_view, container, false);

        ListView countriesList = view.findViewById(R.id.countriesList);

        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, getBrandAndModeFromList(cars));

        countriesList.setAdapter(adapter);

        countriesList.setOnItemClickListener((parent, v, position, id) -> {
            fragmentSendDataListener.onSendData(cars.get(position));
        });
        return view;
    }

    private List<String> getBrandAndModeFromList(List<Car> cars){
        List<String> result = new ArrayList<>();
        for (Car car : cars)
            result.add(car.getBrand() + " " + car.getModel());
        return result;

    }
}