package com.example.datasense.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.datasense.room.MatrixDatabase;
import com.example.datasense.room.Dao;
import com.example.datasense.room.DataModel;

import java.util.List;

public class MatrixRepository {
    private final Dao dao;
    private final LiveData<List<DataModel>> allMatrixes;

    // creating a constructor for our variables
    // and passing the variables to it.
    public MatrixRepository(Application application) {
        MatrixDatabase database = MatrixDatabase.getInstance(application);
        dao = database.Dao();
        allMatrixes = dao.getAllData();
    }

    // creating a method to insert the data to our database.
    public void insert(DataModel model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }

    // below method is to read all the courses.
    public LiveData<List<DataModel>> getAllMatrixes() {
        return allMatrixes;
    }

    // we are creating a async task method to insert new course.
    private static class InsertCourseAsyncTask extends AsyncTask<DataModel, Void, Void> {
        private final Dao dao;

        private InsertCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(DataModel... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

}
