package com.example.datasense.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datasense.databinding.ItemBinding;
import com.example.datasense.room.DataModel;

import java.util.ArrayList;

public class MatrixDataAdapter extends RecyclerView.Adapter<MatrixDataAdapter.MatrixDataViewHolder> {
    private final ArrayList<DataModel> matrixArrayList;
    Context context;

    public MatrixDataAdapter(Context context, ArrayList<DataModel> matrixArrayList) {
        this.context = context;
        this.matrixArrayList = matrixArrayList;
    }

    @NonNull
    @Override
    public MatrixDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MatrixDataViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MatrixDataViewHolder holder, int position) {
        DataModel model = matrixArrayList.get(position);
        holder.binding.tvScore.setText(model.getScore());
        holder.binding.tvStatus.setText(model.getStatus());
        holder.binding.tvTime.setText(model.getTime());
/*
        holder.binding.tvScore.setText(matrixArrayList.get(position).getScore());
        holder.binding.tvStatus.setText(matrixArrayList.get(position).getStatus());
        holder.binding.tvTime.setText(matrixArrayList.get(position).getTime());*/

    }

    @Override
    public int getItemCount() {
        return matrixArrayList.size();
    }

    public static class MatrixDataViewHolder extends RecyclerView.ViewHolder {
        ItemBinding binding;

        public MatrixDataViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemBinding.bind(itemView);
        }
    }
}
