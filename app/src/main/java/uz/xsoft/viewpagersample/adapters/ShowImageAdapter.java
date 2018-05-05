package uz.xsoft.viewpagersample.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import uz.xsoft.viewpagersample.R;

public class ShowImageAdapter extends RecyclerView.Adapter<ShowImageAdapter.MyViewHolder> {

    List<Integer> data;
    int i;

    public ShowImageAdapter(List<Integer> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_showimagefragment,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.set(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }

        public void set(Integer d){
            Picasso.get().load(d).into(img);
            setFadeAnimation(itemView);
        }
    }
    public void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(800);
        view.startAnimation(anim);
    }
}
