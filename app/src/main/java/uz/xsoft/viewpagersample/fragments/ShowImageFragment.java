package uz.xsoft.viewpagersample.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import uz.xsoft.viewpagersample.R;
import uz.xsoft.viewpagersample.adapters.ShowImageAdapter;

public class ShowImageFragment extends DialogFragment {


    private RecyclerView list;
    private List<Integer> data;
    private int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.showimagedialog_layout, container, false);
        Bundle bundle = getArguments();
        data = bundle.getIntegerArrayList("data");
        position = bundle.getInt("position");

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.edit){

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("dialog test");
                    builder.setNegativeButton("cansel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "canceled", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setMessage("Edit");
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }else if (item.getItemId()==R.id.settings){

                } else if (item.getItemId() == R.id.share){

                }
                Toast.makeText(getContext(), "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        list = view.findViewById(R.id.list);

        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(list);

        list.setHasFixedSize(true);
        list.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ShowImageAdapter showImageAdapter = new ShowImageAdapter(data);
        list.setAdapter(showImageAdapter);
        list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        list.scrollToPosition(position);


        return view;
    }



}
