package com.example.datasense.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.datasense.repository.MatrixRepository;

import java.util.List;

public class ViewModal extends AndroidViewModel {
    private final MatrixRepository repository;
    private final LiveData<List<DataModel>> allMatrixes;

    public ViewModal(@NonNull Application application) {
        super(application);
        repository = new MatrixRepository(application);
        allMatrixes = repository.getAllMatrixes();
    }

    public void insert(DataModel model) {
        repository.insert(model);
    }

    public LiveData<List<DataModel>> getAllMatrixes() {
        return allMatrixes;
    }
}
