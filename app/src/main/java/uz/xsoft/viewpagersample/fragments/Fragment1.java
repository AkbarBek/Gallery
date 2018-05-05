package uz.xsoft.viewpagersample.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uz.xsoft.viewpagersample.adapters.MyAdapter;
import uz.xsoft.viewpagersample.R;

public class Fragment1 extends Fragment implements View.OnClickListener {


    public int i=0;

    private List<Integer> data;

    private RecyclerView list;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1,container,false);

        loadData();

        list = view.findViewById(R.id.list);

        MyAdapter adapter = new MyAdapter(data,i);

        list.setAdapter(adapter);
        if (i==1) {
            list.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }else if (i==2){
            list.setLayoutManager(new GridLayoutManager(getContext(), 1));
        }else {
            list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        }


        return view;
    }

    private void loadData() {
        data = new ArrayList<>();
        for (int i = 0; i < 20 ; i++) {
            data.add(R.drawable.a);
        }
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Hello", Toast.LENGTH_SHORT).show();
    }
}
