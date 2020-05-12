package com.example.fragment_demo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class SingleListFragment extends ListFragment {

    final String[] catNames = new String[]{"Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка",
            "Кузя", "Китти", "Масяня", "Симба"};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListAdapter adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,catNames);
        setListAdapter(adapter);

    }
}
