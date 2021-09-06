package com.geektech.homeworkapplicationrecyclerviewholderviewbinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.homeworkapplicationrecyclerviewholderviewbinding.databinding.ItemIvBinding;
import com.geektech.homeworkapplicationrecyclerviewholderviewbinding.databinding.ItemTvBinding;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Item> list = new ArrayList<>();
    private ItemIvBinding ivBinding;
    private final int TYPE_WITH_TXT = 0, TYPE_WITH_IMG = 1;
    private ItemTvBinding tvBinding;
    private RecyclerView.ViewHolder holder;
    private int position;
    private OnItemClickListener listener;

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setList(ArrayList<Item> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int i = 0;

        if (list.get(position).getType() == 0) {
            i = TYPE_WITH_TXT;
        } else {
            i = TYPE_WITH_IMG;
        }
        return i;
    }

    @NonNull

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_WITH_TXT) {
            tvBinding = ItemTvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolderTV(tvBinding);
        } else {
            ivBinding = ItemIvBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolder(ivBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == TYPE_WITH_TXT) {
            ((ViewHolderTV) holder).onBindTV(list.get(position));
        } else {
            ((ViewHolder) holder).onBind(list.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemIvBinding ivBinding) {
            super(ivBinding.getRoot());
        }

        public void onBind(Item item) {
            ivBinding.ivImage.setImageResource(item.getImageView());
            ivBinding.tvText2.setText(item.getTextView());
            ivBinding.ivImage.setOnClickListener(v -> listener.onIvClick(item.getImageView()));
            ivBinding.tvText2.setOnClickListener(v -> listener.onClick(ivBinding.tvText2.getText().toString()));
        }
    }

    public class ViewHolderTV extends RecyclerView.ViewHolder {
        public ViewHolderTV(@NonNull ItemTvBinding tvBinding) {
            super(tvBinding.getRoot());
        }

        public void onBindTV(Item item) {
            tvBinding.tvText.setText(item.getTextView());
            tvBinding.tvText.setOnClickListener(v-> listener.onClick(tvBinding.tvText.getText().toString()));
        }
    }

    public interface OnItemClickListener {
        void onClick(String text);

        void onIvClick(int image);
    }
}
