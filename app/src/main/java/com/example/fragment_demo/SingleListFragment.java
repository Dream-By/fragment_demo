package com.example.fragment_demo;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class SingleListFragment extends ListFragment {
    View mListContainer; // родительский контейнер (android.R.id.listContainer)
    ListAdapter mAdapter; // адаптер списка
    ListView mList; // список (android.R.id.list)
    TextView mEmptyView; // текстовое поле для пустого списка (android.R.id.empty)
    View mProgressContainer; // компонент для показа анимации загрузки

    final String[] catNames = new String[]{"Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Кристина", "Пушок", "Дымка",
            "Кузя", "Китти", "Масяня", "Симба"};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListAdapter adapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_multiple_choice, catNames);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listfragment, null);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String prompt = "Вы выбрали: "
                + getListView().getItemAtPosition(position).toString() + "\n";

        prompt += "Выбранные элементы: \n";
        int count = getListView().getCount();
        SparseBooleanArray sparseBooleanArray = getListView()
                .getCheckedItemPositions();
        for (int i = 0; i < count; i++) {
            if (sparseBooleanArray.get(i)) {
                prompt += getListView().getItemAtPosition(i).toString() + "\n";
            }
        }
        Toast.makeText(getActivity(), prompt, Toast.LENGTH_LONG).show();
    }
}
