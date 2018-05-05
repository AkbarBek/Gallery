package uz.xsoft.viewpagersample.adapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import uz.xsoft.viewpagersample.R;
import uz.xsoft.viewpagersample.fragments.ShowImageFragment;
import uz.xsoft.viewpagersample.activities.MainActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Integer> data;
    int i = 0;

    public MyAdapter(List<Integer> data, int i) {
        this.data = data;
        this.i = i;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragment1, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.set(data.get(position),position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        Integer integer;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }

        public void set(Integer integer, final int position) {
            this.integer = integer;

            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((MainActivity)itemView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // show
//                    ShowImageFragment fragment = new ShowImageFragment();



                    FragmentTransaction ft = ((MainActivity)v.getContext()).getSupportFragmentManager().beginTransaction();
                    DialogFragment newFragment = new ShowImageFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("position",position);
                    bundle.putIntegerArrayList("data", (ArrayList<Integer>) data);
                    newFragment.setArguments(bundle);
                    newFragment.show(ft,"dialog");
//                    ft.add(R.id., newFragment);
//                    ft.commit();

                }
            });


            if (i == 1)
                Picasso.get().load(integer).resize(width/2,height/5).into(img);
            if (i == 2)
                Picasso.get().load(integer).resize(width,height/6).into(img);
            if (i == 3)
                Picasso.get().load(integer).resize(width/3,height).into(img);

        }
    }
}
