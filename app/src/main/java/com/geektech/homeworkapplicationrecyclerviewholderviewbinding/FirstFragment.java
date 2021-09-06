package com.geektech.homeworkapplicationrecyclerviewholderviewbinding;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.geektech.homeworkapplicationrecyclerviewholderviewbinding.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.Collections;


public class FirstFragment extends Fragment implements MainAdapter.OnItemClickListener {

    private FragmentFirstBinding binding;
    private ArrayList<Item> list = new ArrayList<>();
    private MainAdapter adapter = new MainAdapter();
    //private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
        initRecycler();

    }

    private void initRecycler() {

        adapter.setList(list);
        adapter.setListener(this);
        binding.rvMain.setAdapter(adapter);
    }

    private void createList() {

        list.add(new Item(0,"First Text"));
        list.add(new Item(1,"Second Text",R.drawable.ic_vampire2));
        list.add(new Item(0,"First Text"));
        list.add(new Item(1,"Second Text",R.drawable.ic_vampire2));
        list.add(new Item(0,"First Text"));
        list.add(new Item(1,"Second Text",R.drawable.ic_vampire2));
        list.add(new Item(0,"First Text"));
        list.add(new Item(1,"Second Text",R.drawable.ic_vampire2));
        list.add(new Item(0,"First Text"));
        list.add(new Item(1,"Second Text",R.drawable.ic_vampire2));
        //Collections.shuffle(list);


    }


    @Override
    public void onClick(String text) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onIvClick(int image) {
        Toast toast = Toast.makeText(requireContext(),"", Toast.LENGTH_LONG);
        View toastView = toast.getView();

        /* And now you can get the TextView of the default View of the Toast. */
        TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
        toastMessage.setCompoundDrawablesWithIntrinsicBounds(image, 0, 0, 0);
        toastMessage.setGravity(Gravity.CENTER);
        toastMessage.setCompoundDrawablePadding(16);
        toastView.setBackgroundColor(Color.GREEN);
        toastMessage.setWidth(100);
        toastMessage.setHeight(100);
        toast.show();
    }
}