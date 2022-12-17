package com.example.datasense.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datasense.R;
import com.example.datasense.adapter.MatrixDataAdapter;
import com.example.datasense.databinding.ActivitySelectMatrixBinding;
import com.example.datasense.room.DataModel;
import com.example.datasense.room.ViewModal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectMatrixActivity extends AppCompatActivity implements View.OnClickListener {
    ActivitySelectMatrixBinding binding;
    boolean set_one, set_two, set_three, set_four, set_five, set_six, set_seven, set_eight,
            set_nine, set_ten, set_eleven, set_twelve, set_thriteen, set_fourteen, set_fifteen, set_sixteen;
    Drawable color_a;
    Drawable color_b;
    String a = "#FF0000";
    String b = "#FFFF00";
    String c = "#0000FF";
    String d = "#00FF00";
    String time;
    int get_final_time;
    CountDownTimer countDownTimer;
    String[] colorArray = {a, b, c, d};
    String room_time, room_status, room_score;
    ViewModal viewModal;
    ArrayList<DataModel> matrixDataModel = new ArrayList<>();
    MatrixDataAdapter matrixDataAdapter;
    LinearLayoutManager linearLayoutManager;
    DataModel model;

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectMatrixBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        initUI();

    }

    @SuppressLint("ResourceType")
    private void initUI() {
        binding.view1.setOnClickListener(this);
        binding.view2.setOnClickListener(this);
        binding.view3.setOnClickListener(this);
        binding.view4.setOnClickListener(this);
        binding.view5.setOnClickListener(this);
        binding.view6.setOnClickListener(this);
        binding.view7.setOnClickListener(this);
        binding.view8.setOnClickListener(this);
        binding.view9.setOnClickListener(this);
        binding.view10.setOnClickListener(this);
        binding.view11.setOnClickListener(this);
        binding.view12.setOnClickListener(this);
        binding.view13.setOnClickListener(this);
        binding.view14.setOnClickListener(this);
        binding.view15.setOnClickListener(this);
        binding.view16.setOnClickListener(this);
        binding.btnScramble.setOnClickListener(this);
        binding.btnStartTimer.setOnClickListener(this);
        binding.btnGoToLogin.setOnClickListener(this);
        binding.successMsg.setVisibility(View.GONE);

        setDisableAllViews();
        viewModal = ViewModelProviders.of(this).get(ViewModal.class);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_1:

                if (set_two) {
                    color_b = binding.view1.getBackground();
                    binding.view2.setBackground(color_b);
                    binding.view1.setBackground(color_a);
                    binding.view2.setImageDrawable(null);
                    set_two = false;
                    setEnabledAllViews();

                } else if (set_five) {
                    color_b = binding.view1.getBackground();
                    binding.view5.setBackground(color_b);
                    binding.view1.setBackground(color_a);
                    binding.view5.setImageDrawable(null);
                    set_five = false;
                    setEnabledAllViews();
                    checkStatus();
                } else if (set_six) {
                    color_b = binding.view1.getBackground();
                    binding.view6.setBackground(color_b);
                    binding.view1.setBackground(color_a);
                    binding.view6.setImageDrawable(null);
                    set_six = false;
                    setEnabledAllViews();

                } else {
                    binding.view1.setImageResource(R.drawable.ic_check_24);
                    set_one = true;
                    set_two = false;
                    color_a = binding.view1.getBackground();

                    binding.view2.setEnabled(true);
                    binding.view5.setEnabled(true);
                    binding.view6.setEnabled(true);

                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view7.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view10.setEnabled(false);
                    binding.view11.setEnabled(false);
                    binding.view12.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);
                }
                checkStatus();

                break;

            case R.id.view_2:

                if (set_one) {
                    color_b = binding.view2.getBackground();
                    binding.view1.setBackground(color_b);
                    binding.view2.setBackground(color_a);
                    binding.view1.setImageDrawable(null);
                    set_one = false;
                    setEnabledAllViews();
                    checkStatus();

                } else if (set_three) {
                    color_b = binding.view2.getBackground();
                    binding.view3.setBackground(color_b);
                    binding.view2.setBackground(color_a);
                    binding.view3.setImageDrawable(null);
                    set_three = false;
                    setEnabledAllViews();

                } else if (set_five) {
                    color_b = binding.view2.getBackground();
                    binding.view5.setBackground(color_b);
                    binding.view2.setBackground(color_a);
                    binding.view5.setImageDrawable(null);
                    set_five = false;
                    setEnabledAllViews();

                } else if (set_six) {
                    color_b = binding.view2.getBackground();
                    binding.view6.setBackground(color_b);
                    binding.view2.setBackground(color_a);
                    binding.view6.setImageDrawable(null);
                    set_six = false;
                    setEnabledAllViews();

                } else if (set_seven) {
                    color_b = binding.view2.getBackground();
                    binding.view7.setBackground(color_b);
                    binding.view2.setBackground(color_a);
                    binding.view7.setImageDrawable(null);
                    set_seven = false;
                    setEnabledAllViews();

                } else {
                    binding.view2.setImageResource(R.drawable.ic_check_24);
                    set_two = true;
                    color_a = binding.view2.getBackground();

                    binding.view1.setEnabled(true);
                    binding.view3.setEnabled(true);
                    binding.view5.setEnabled(true);
                    binding.view6.setEnabled(true);
                    binding.view7.setEnabled(true);

                    binding.view4.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view10.setEnabled(false);
                    binding.view11.setEnabled(false);
                    binding.view12.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);

                }
                checkStatus();
                break;

            case R.id.view_3:

                if (set_two) {
                    color_b = binding.view3.getBackground();
                    binding.view2.setBackground(color_b);
                    binding.view3.setBackground(color_a);
                    binding.view2.setImageDrawable(null);
                    set_two = false;
                    setEnabledAllViews();

                } else if (set_four) {
                    color_b = binding.view3.getBackground();
                    binding.view4.setBackground(color_b);
                    binding.view3.setBackground(color_a);
                    binding.view4.setImageDrawable(null);
                    set_four = false;
                    setEnabledAllViews();

                } else if (set_six) {
                    color_b = binding.view3.getBackground();
                    binding.view6.setBackground(color_b);
                    binding.view3.setBackground(color_a);
                    binding.view6.setImageDrawable(null);
                    set_six = false;
                    setEnabledAllViews();

                } else if (set_seven) {
                    color_b = binding.view3.getBackground();
                    binding.view7.setBackground(color_b);
                    binding.view3.setBackground(color_a);
                    binding.view7.setImageDrawable(null);
                    set_seven = false;
                    setEnabledAllViews();

                } else if (set_eight) {
                    color_b = binding.view3.getBackground();
                    binding.view8.setBackground(color_b);
                    binding.view3.setBackground(color_a);
                    binding.view8.setImageDrawable(null);
                    set_eight = false;
                    setEnabledAllViews();

                } else {
                    binding.view3.setImageResource(R.drawable.ic_check_24);
                    set_three = true;
                    color_a = binding.view3.getBackground();

                    binding.view2.setEnabled(true);
                    binding.view4.setEnabled(true);
                    binding.view6.setEnabled(true);
                    binding.view7.setEnabled(true);
                    binding.view8.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view10.setEnabled(false);
                    binding.view11.setEnabled(false);
                    binding.view12.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_4:
                if (set_three) {
                    color_b = binding.view4.getBackground();
                    binding.view3.setBackground(color_b);
                    binding.view4.setBackground(color_a);
                    binding.view3.setImageDrawable(null);
                    set_three = false;
                    setEnabledAllViews();

                } else if (set_seven) {
                    color_b = binding.view4.getBackground();
                    binding.view7.setBackground(color_b);
                    binding.view4.setBackground(color_a);
                    binding.view7.setImageDrawable(null);
                    set_seven = false;
                    setEnabledAllViews();

                } else if (set_eight) {
                    color_b = binding.view4.getBackground();
                    binding.view8.setBackground(color_b);
                    binding.view4.setBackground(color_a);
                    binding.view8.setImageDrawable(null);
                    set_eight = false;
                    setEnabledAllViews();

                } else {
                    binding.view4.setImageResource(R.drawable.ic_check_24);
                    set_four = true;
                    color_a = binding.view4.getBackground();

                    binding.view3.setEnabled(true);
                    binding.view7.setEnabled(true);
                    binding.view8.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view6.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view10.setEnabled(false);
                    binding.view11.setEnabled(false);
                    binding.view12.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_5:

                if (set_one) {
                    color_b = binding.view5.getBackground();
                    binding.view1.setBackground(color_b);
                    binding.view5.setBackground(color_a);
                    binding.view1.setImageDrawable(null);
                    set_one = false;
                    setEnabledAllViews();
                } else if (set_two) {
                    color_b = binding.view5.getBackground();
                    binding.view2.setBackground(color_b);
                    binding.view5.setBackground(color_a);
                    binding.view2.setImageDrawable(null);
                    set_two = false;
                    setEnabledAllViews();
                } else if (set_six) {
                    color_b = binding.view5.getBackground();
                    binding.view6.setBackground(color_b);
                    binding.view5.setBackground(color_a);
                    binding.view6.setImageDrawable(null);
                    set_six = false;
                    setEnabledAllViews();
                } else if (set_nine) {
                    color_b = binding.view5.getBackground();
                    binding.view9.setBackground(color_b);
                    binding.view5.setBackground(color_a);
                    binding.view9.setImageDrawable(null);
                    set_nine = false;
                    setEnabledAllViews();
                } else if (set_ten) {
                    color_b = binding.view5.getBackground();
                    binding.view10.setBackground(color_b);
                    binding.view5.setBackground(color_a);
                    binding.view10.setImageDrawable(null);
                    set_ten = false;
                    setEnabledAllViews();
                } else {
                    binding.view5.setImageResource(R.drawable.ic_check_24);
                    set_five = true;
                    color_a = binding.view5.getBackground();

                    binding.view1.setEnabled(true);
                    binding.view2.setEnabled(true);
                    binding.view6.setEnabled(true);
                    binding.view9.setEnabled(true);
                    binding.view10.setEnabled(true);

                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view7.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view11.setEnabled(false);
                    binding.view12.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);

                }
                checkStatus();
                break;

            case R.id.view_6:

                if (set_one) {
                    color_b = binding.view6.getBackground();
                    binding.view1.setBackground(color_b);
                    binding.view6.setBackground(color_a);
                    binding.view1.setImageDrawable(null);
                    set_one = false;
                    setEnabledAllViews();
                } else if (set_two) {
                    color_b = binding.view6.getBackground();
                    binding.view2.setBackground(color_b);
                    binding.view6.setBackground(color_a);
                    binding.view2.setImageDrawable(null);
                    set_two = false;
                    setEnabledAllViews();
                } else if (set_three) {
                    color_b = binding.view6.getBackground();
                    binding.view3.setBackground(color_b);
                    binding.view6.setBackground(color_a);
                    binding.view3.setImageDrawable(null);
                    set_three = false;
                    setEnabledAllViews();
                } else if (set_five) {
                    color_b = binding.view6.getBackground();
                    binding.view5.setBackground(color_b);
                    binding.view6.setBackground(color_a);
                    binding.view5.setImageDrawable(null);
                    set_five = false;
                    setEnabledAllViews();
                } else if (set_seven) {
                    color_b = binding.view6.getBackground();
                    binding.view7.setBackground(color_b);
                    binding.view6.setBackground(color_a);
                    binding.view7.setImageDrawable(null);
                    set_seven = false;
                    setEnabledAllViews();
                } else if (set_nine) {
                    color_b = binding.view6.getBackground();
                    binding.view9.setBackground(color_b);
                    binding.view6.setBackground(color_a);
                    binding.view9.setImageDrawable(null);
                    set_nine = false;
                    setEnabledAllViews();
                } else if (set_ten) {
                    color_b = binding.view6.getBackground();
                    binding.view10.setBackground(color_b);
                    binding.view6.setBackground(color_a);
                    binding.view10.setImageDrawable(null);
                    set_ten = false;
                    setEnabledAllViews();
                } else if (set_eleven) {
                    color_b = binding.view6.getBackground();
                    binding.view11.setBackground(color_b);
                    binding.view6.setBackground(color_a);
                    binding.view11.setImageDrawable(null);
                    set_eleven = false;
                    setEnabledAllViews();
                } else {
                    binding.view6.setImageResource(R.drawable.ic_check_24);
                    set_six = true;
                    color_a = binding.view6.getBackground();

                    binding.view1.setEnabled(true);
                    binding.view2.setEnabled(true);
                    binding.view3.setEnabled(true);
                    binding.view5.setEnabled(true);
                    binding.view7.setEnabled(true);
                    binding.view9.setEnabled(true);
                    binding.view10.setEnabled(true);
                    binding.view11.setEnabled(true);

                    binding.view4.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view12.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_7:
                if (set_two) {
                    color_b = binding.view7.getBackground();
                    binding.view2.setBackground(color_b);
                    binding.view7.setBackground(color_a);
                    binding.view2.setImageDrawable(null);
                    set_two = false;
                    setEnabledAllViews();
                } else if (set_three) {
                    color_b = binding.view7.getBackground();
                    binding.view3.setBackground(color_b);
                    binding.view7.setBackground(color_a);
                    binding.view3.setImageDrawable(null);
                    set_three = false;
                    setEnabledAllViews();
                } else if (set_four) {
                    color_b = binding.view7.getBackground();
                    binding.view4.setBackground(color_b);
                    binding.view7.setBackground(color_a);
                    binding.view4.setImageDrawable(null);
                    set_four = false;
                    setEnabledAllViews();
                } else if (set_six) {
                    color_b = binding.view7.getBackground();
                    binding.view6.setBackground(color_b);
                    binding.view7.setBackground(color_a);
                    binding.view6.setImageDrawable(null);
                    set_six = false;
                    setEnabledAllViews();
                } else if (set_eight) {
                    color_b = binding.view7.getBackground();
                    binding.view8.setBackground(color_b);
                    binding.view7.setBackground(color_a);
                    binding.view8.setImageDrawable(null);
                    set_eight = false;
                    setEnabledAllViews();
                } else if (set_ten) {
                    color_b = binding.view7.getBackground();
                    binding.view10.setBackground(color_b);
                    binding.view7.setBackground(color_a);
                    binding.view10.setImageDrawable(null);
                    set_ten = false;
                    setEnabledAllViews();
                } else if (set_eleven) {
                    color_b = binding.view7.getBackground();
                    binding.view11.setBackground(color_b);
                    binding.view7.setBackground(color_a);
                    binding.view11.setImageDrawable(null);
                    set_eleven = false;
                    setEnabledAllViews();
                } else if (set_twelve) {
                    color_b = binding.view7.getBackground();
                    binding.view12.setBackground(color_b);
                    binding.view7.setBackground(color_a);
                    binding.view12.setImageDrawable(null);
                    set_twelve = false;
                    setEnabledAllViews();
                } else {
                    binding.view7.setImageResource(R.drawable.ic_check_24);
                    set_seven = true;
                    color_a = binding.view7.getBackground();

                    binding.view2.setEnabled(true);
                    binding.view3.setEnabled(true);
                    binding.view4.setEnabled(true);
                    binding.view6.setEnabled(true);
                    binding.view8.setEnabled(true);
                    binding.view10.setEnabled(true);
                    binding.view11.setEnabled(true);
                    binding.view12.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);
                }
                checkStatus();
                break;

            case R.id.view_8:
                if (set_three) {
                    color_b = binding.view8.getBackground();
                    binding.view3.setBackground(color_b);
                    binding.view8.setBackground(color_a);
                    binding.view3.setImageDrawable(null);
                    set_three = false;
                    setEnabledAllViews();
                } else if (set_four) {
                    color_b = binding.view8.getBackground();
                    binding.view4.setBackground(color_b);
                    binding.view8.setBackground(color_a);
                    binding.view4.setImageDrawable(null);
                    set_four = false;
                    setEnabledAllViews();
                } else if (set_seven) {
                    color_b = binding.view8.getBackground();
                    binding.view7.setBackground(color_b);
                    binding.view8.setBackground(color_a);
                    binding.view7.setImageDrawable(null);
                    set_seven = false;
                    setEnabledAllViews();
                } else if (set_eleven) {
                    color_b = binding.view8.getBackground();
                    binding.view11.setBackground(color_b);
                    binding.view8.setBackground(color_a);
                    binding.view11.setImageDrawable(null);
                    set_eleven = false;
                    setEnabledAllViews();
                } else if (set_twelve) {
                    color_b = binding.view8.getBackground();
                    binding.view12.setBackground(color_b);
                    binding.view8.setBackground(color_a);
                    binding.view12.setImageDrawable(null);
                    set_twelve = false;
                    setEnabledAllViews();
                } else {
                    binding.view8.setImageResource(R.drawable.ic_check_24);
                    set_eight = true;
                    color_a = binding.view8.getBackground();

                    binding.view3.setEnabled(true);
                    binding.view4.setEnabled(true);
                    binding.view7.setEnabled(true);
                    binding.view11.setEnabled(true);
                    binding.view12.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view6.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view10.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_9:
                if (set_five) {
                    color_b = binding.view9.getBackground();
                    binding.view5.setBackground(color_b);
                    binding.view9.setBackground(color_a);
                    binding.view5.setImageDrawable(null);
                    set_five = false;
                    setEnabledAllViews();
                } else if (set_six) {
                    color_b = binding.view9.getBackground();
                    binding.view6.setBackground(color_b);
                    binding.view9.setBackground(color_a);
                    binding.view6.setImageDrawable(null);
                    set_six = false;
                    setEnabledAllViews();
                } else if (set_ten) {
                    color_b = binding.view9.getBackground();
                    binding.view10.setBackground(color_b);
                    binding.view9.setBackground(color_a);
                    binding.view10.setImageDrawable(null);
                    set_ten = false;
                    setEnabledAllViews();
                } else if (set_thriteen) {
                    color_b = binding.view9.getBackground();
                    binding.view13.setBackground(color_b);
                    binding.view9.setBackground(color_a);
                    binding.view13.setImageDrawable(null);
                    set_thriteen = false;
                    setEnabledAllViews();
                } else if (set_fourteen) {
                    color_b = binding.view9.getBackground();
                    binding.view14.setBackground(color_b);
                    binding.view9.setBackground(color_a);
                    binding.view14.setImageDrawable(null);
                    set_fourteen = false;
                    setEnabledAllViews();
                } else {
                    binding.view9.setImageResource(R.drawable.ic_check_24);
                    set_nine = true;
                    color_a = binding.view9.getBackground();

                    binding.view5.setEnabled(true);
                    binding.view6.setEnabled(true);
                    binding.view10.setEnabled(true);
                    binding.view13.setEnabled(true);
                    binding.view14.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view7.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view11.setEnabled(false);
                    binding.view12.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);
                }
                checkStatus();
                break;

            case R.id.view_10:
                if (set_five) {
                    color_b = binding.view10.getBackground();
                    binding.view5.setBackground(color_b);
                    binding.view10.setBackground(color_a);
                    binding.view5.setImageDrawable(null);
                    set_five = false;
                    setEnabledAllViews();
                } else if (set_six) {
                    color_b = binding.view10.getBackground();
                    binding.view6.setBackground(color_b);
                    binding.view10.setBackground(color_a);
                    binding.view6.setImageDrawable(null);
                    set_six = false;
                    setEnabledAllViews();
                } else if (set_seven) {
                    color_b = binding.view10.getBackground();
                    binding.view7.setBackground(color_b);
                    binding.view10.setBackground(color_a);
                    binding.view7.setImageDrawable(null);
                    set_seven = false;
                    setEnabledAllViews();
                } else if (set_nine) {
                    color_b = binding.view10.getBackground();
                    binding.view9.setBackground(color_b);
                    binding.view10.setBackground(color_a);
                    binding.view9.setImageDrawable(null);
                    set_nine = false;
                    setEnabledAllViews();
                } else if (set_eleven) {
                    color_b = binding.view10.getBackground();
                    binding.view11.setBackground(color_b);
                    binding.view10.setBackground(color_a);
                    binding.view11.setImageDrawable(null);
                    set_eleven = false;
                    setEnabledAllViews();
                } else if (set_thriteen) {
                    color_b = binding.view10.getBackground();
                    binding.view13.setBackground(color_b);
                    binding.view10.setBackground(color_a);
                    binding.view13.setImageDrawable(null);
                    set_thriteen = false;
                    setEnabledAllViews();
                } else if (set_fourteen) {
                    color_b = binding.view10.getBackground();
                    binding.view14.setBackground(color_b);
                    binding.view10.setBackground(color_a);
                    binding.view14.setImageDrawable(null);
                    set_fourteen = false;
                    setEnabledAllViews();
                } else if (set_fifteen) {
                    color_b = binding.view10.getBackground();
                    binding.view15.setBackground(color_b);
                    binding.view10.setBackground(color_a);
                    binding.view15.setImageDrawable(null);
                    set_fifteen = false;
                    setEnabledAllViews();
                } else {
                    binding.view10.setImageResource(R.drawable.ic_check_24);
                    set_ten = true;
                    color_a = binding.view10.getBackground();

                    binding.view9.setEnabled(true);
                    binding.view11.setEnabled(true);
                    binding.view5.setEnabled(true);
                    binding.view6.setEnabled(true);
                    binding.view7.setEnabled(true);
                    binding.view13.setEnabled(true);
                    binding.view14.setEnabled(true);
                    binding.view15.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view12.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_11:
                if (set_six) {
                    color_b = binding.view11.getBackground();
                    binding.view6.setBackground(color_b);
                    binding.view11.setBackground(color_a);
                    binding.view6.setImageDrawable(null);
                    set_six = false;
                    setEnabledAllViews();
                } else if (set_seven) {
                    color_b = binding.view11.getBackground();
                    binding.view7.setBackground(color_b);
                    binding.view11.setBackground(color_a);
                    binding.view7.setImageDrawable(null);
                    set_seven = false;
                    setEnabledAllViews();
                } else if (set_eight) {
                    color_b = binding.view11.getBackground();
                    binding.view8.setBackground(color_b);
                    binding.view11.setBackground(color_a);
                    binding.view8.setImageDrawable(null);
                    set_eight = false;
                    setEnabledAllViews();
                } else if (set_ten) {
                    color_b = binding.view11.getBackground();
                    binding.view10.setBackground(color_b);
                    binding.view11.setBackground(color_a);
                    binding.view10.setImageDrawable(null);
                    set_ten = false;
                    setEnabledAllViews();
                } else if (set_twelve) {
                    color_b = binding.view11.getBackground();
                    binding.view12.setBackground(color_b);
                    binding.view11.setBackground(color_a);
                    binding.view12.setImageDrawable(null);
                    set_twelve = false;
                    setEnabledAllViews();
                } else if (set_fourteen) {
                    color_b = binding.view11.getBackground();
                    binding.view14.setBackground(color_b);
                    binding.view11.setBackground(color_a);
                    binding.view14.setImageDrawable(null);
                    set_fourteen = false;
                    setEnabledAllViews();
                } else if (set_fifteen) {
                    color_b = binding.view11.getBackground();
                    binding.view15.setBackground(color_b);
                    binding.view11.setBackground(color_a);
                    binding.view15.setImageDrawable(null);
                    set_fifteen = false;
                    setEnabledAllViews();
                } else if (set_sixteen) {
                    color_b = binding.view11.getBackground();
                    binding.view16.setBackground(color_b);
                    binding.view11.setBackground(color_a);
                    binding.view16.setImageDrawable(null);
                    set_sixteen = false;
                    setEnabledAllViews();
                } else {
                    binding.view11.setImageResource(R.drawable.ic_check_24);
                    set_eleven = true;
                    color_a = binding.view11.getBackground();

                    binding.view6.setEnabled(true);
                    binding.view7.setEnabled(true);
                    binding.view8.setEnabled(true);
                    binding.view10.setEnabled(true);
                    binding.view12.setEnabled(true);
                    binding.view14.setEnabled(true);
                    binding.view15.setEnabled(true);
                    binding.view16.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view13.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_12:
                if (set_seven) {
                    color_b = binding.view12.getBackground();
                    binding.view7.setBackground(color_b);
                    binding.view12.setBackground(color_a);
                    binding.view7.setImageDrawable(null);
                    set_seven = false;
                    setEnabledAllViews();
                } else if (set_eight) {
                    color_b = binding.view12.getBackground();
                    binding.view8.setBackground(color_b);
                    binding.view12.setBackground(color_a);
                    binding.view8.setImageDrawable(null);
                    set_eight = false;
                    setEnabledAllViews();
                } else if (set_eleven) {
                    color_b = binding.view12.getBackground();
                    binding.view11.setBackground(color_b);
                    binding.view12.setBackground(color_a);
                    binding.view11.setImageDrawable(null);
                    set_eleven = false;
                    setEnabledAllViews();
                } else if (set_fifteen) {
                    color_b = binding.view12.getBackground();
                    binding.view15.setBackground(color_b);
                    binding.view12.setBackground(color_a);
                    binding.view15.setImageDrawable(null);
                    set_fifteen = false;
                    setEnabledAllViews();
                } else if (set_sixteen) {
                    color_b = binding.view12.getBackground();
                    binding.view16.setBackground(color_b);
                    binding.view12.setBackground(color_a);
                    binding.view16.setImageDrawable(null);
                    set_sixteen = false;
                    setEnabledAllViews();
                } else {
                    binding.view12.setImageResource(R.drawable.ic_check_24);
                    set_twelve = true;
                    color_a = binding.view12.getBackground();

                    binding.view7.setEnabled(true);
                    binding.view8.setEnabled(true);
                    binding.view11.setEnabled(true);
                    binding.view15.setEnabled(true);
                    binding.view16.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view6.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view10.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_13:
                if (set_nine) {
                    color_b = binding.view13.getBackground();
                    binding.view9.setBackground(color_b);
                    binding.view13.setBackground(color_a);
                    binding.view9.setImageDrawable(null);
                    set_nine = false;
                    setEnabledAllViews();
                } else if (set_ten) {
                    color_b = binding.view13.getBackground();
                    binding.view10.setBackground(color_b);
                    binding.view13.setBackground(color_a);
                    binding.view10.setImageDrawable(null);
                    set_ten = false;
                    setEnabledAllViews();
                } else if (set_fourteen) {
                    color_b = binding.view13.getBackground();
                    binding.view14.setBackground(color_b);
                    binding.view13.setBackground(color_a);
                    binding.view14.setImageDrawable(null);
                    set_fourteen = false;
                    setEnabledAllViews();
                } else {
                    binding.view13.setImageResource(R.drawable.ic_check_24);
                    set_thriteen = true;
                    color_a = binding.view13.getBackground();

                    binding.view9.setEnabled(true);
                    binding.view10.setEnabled(true);
                    binding.view14.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view6.setEnabled(false);
                    binding.view7.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view11.setEnabled(false);
                    binding.view12.setEnabled(false);
                    binding.view15.setEnabled(false);
                    binding.view16.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_14:
                if (set_nine) {
                    color_b = binding.view14.getBackground();
                    binding.view9.setBackground(color_b);
                    binding.view14.setBackground(color_a);
                    binding.view9.setImageDrawable(null);
                    set_nine = false;
                    setEnabledAllViews();
                } else if (set_ten) {
                    color_b = binding.view14.getBackground();
                    binding.view10.setBackground(color_b);
                    binding.view14.setBackground(color_a);
                    binding.view10.setImageDrawable(null);
                    set_ten = false;
                    setEnabledAllViews();
                } else if (set_eleven) {
                    color_b = binding.view14.getBackground();
                    binding.view11.setBackground(color_b);
                    binding.view14.setBackground(color_a);
                    binding.view11.setImageDrawable(null);
                    set_eleven = false;
                    setEnabledAllViews();
                } else if (set_thriteen) {
                    color_b = binding.view14.getBackground();
                    binding.view13.setBackground(color_b);
                    binding.view14.setBackground(color_a);
                    binding.view13.setImageDrawable(null);
                    set_thriteen = false;
                    setEnabledAllViews();
                } else if (set_fifteen) {
                    color_b = binding.view14.getBackground();
                    binding.view15.setBackground(color_b);
                    binding.view14.setBackground(color_a);
                    binding.view15.setImageDrawable(null);
                    set_fifteen = false;
                    setEnabledAllViews();
                } else {
                    binding.view14.setImageResource(R.drawable.ic_check_24);
                    set_fourteen = true;
                    color_a = binding.view14.getBackground();

                    binding.view9.setEnabled(true);
                    binding.view10.setEnabled(true);
                    binding.view11.setEnabled(true);
                    binding.view13.setEnabled(true);
                    binding.view15.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view6.setEnabled(false);
                    binding.view7.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view12.setEnabled(false);
                    binding.view16.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_15:
                if (set_ten) {
                    color_b = binding.view15.getBackground();
                    binding.view10.setBackground(color_b);
                    binding.view15.setBackground(color_a);
                    binding.view10.setImageDrawable(null);
                    set_ten = false;
                    setEnabledAllViews();
                } else if (set_eleven) {
                    color_b = binding.view15.getBackground();
                    binding.view11.setBackground(color_b);
                    binding.view15.setBackground(color_a);
                    binding.view11.setImageDrawable(null);
                    set_eleven = false;
                    setEnabledAllViews();
                } else if (set_twelve) {
                    color_b = binding.view15.getBackground();
                    binding.view12.setBackground(color_b);
                    binding.view15.setBackground(color_a);
                    binding.view12.setImageDrawable(null);
                    set_twelve = false;
                    setEnabledAllViews();
                } else if (set_fourteen) {
                    color_b = binding.view15.getBackground();
                    binding.view14.setBackground(color_b);
                    binding.view15.setBackground(color_a);
                    binding.view14.setImageDrawable(null);
                    set_fourteen = false;
                    setEnabledAllViews();
                } else if (set_sixteen) {
                    color_b = binding.view15.getBackground();
                    binding.view16.setBackground(color_b);
                    binding.view15.setBackground(color_a);
                    binding.view16.setImageDrawable(null);
                    set_sixteen = false;
                    setEnabledAllViews();
                } else {
                    binding.view15.setImageResource(R.drawable.ic_check_24);
                    set_fifteen = true;
                    color_a = binding.view15.getBackground();

                    binding.view10.setEnabled(true);
                    binding.view11.setEnabled(true);
                    binding.view12.setEnabled(true);
                    binding.view14.setEnabled(true);
                    binding.view16.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view6.setEnabled(false);
                    binding.view7.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view13.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.view_16:
                if (set_eleven) {
                    color_b = binding.view16.getBackground();
                    binding.view11.setBackground(color_b);
                    binding.view16.setBackground(color_a);
                    binding.view11.setImageDrawable(null);
                    set_eleven = false;
                    setEnabledAllViews();
                } else if (set_twelve) {
                    color_b = binding.view16.getBackground();
                    binding.view12.setBackground(color_b);
                    binding.view16.setBackground(color_a);
                    binding.view12.setImageDrawable(null);
                    set_twelve = false;
                    setEnabledAllViews();
                } else if (set_fifteen) {
                    color_b = binding.view16.getBackground();
                    binding.view15.setBackground(color_b);
                    binding.view16.setBackground(color_a);
                    binding.view15.setImageDrawable(null);
                    set_fifteen = false;
                    setEnabledAllViews();
                } else {
                    binding.view16.setImageResource(R.drawable.ic_check_24);
                    set_sixteen = true;
                    color_a = binding.view16.getBackground();

                    binding.view11.setEnabled(true);
                    binding.view12.setEnabled(true);
                    binding.view15.setEnabled(true);

                    binding.view1.setEnabled(false);
                    binding.view2.setEnabled(false);
                    binding.view3.setEnabled(false);
                    binding.view4.setEnabled(false);
                    binding.view5.setEnabled(false);
                    binding.view6.setEnabled(false);
                    binding.view7.setEnabled(false);
                    binding.view8.setEnabled(false);
                    binding.view9.setEnabled(false);
                    binding.view10.setEnabled(false);
                    binding.view13.setEnabled(false);
                    binding.view14.setEnabled(false);
                }
                checkStatus();
                break;
            case R.id.btn_scramble:
                cellScrambled();
                break;
            case R.id.btn_start_timer:
                setEnabledAllViews();
                binding.successMsg.setVisibility(View.GONE);
                binding.timer.setVisibility(View.VISIBLE);
                binding.btnScramble.setEnabled(false);
                binding.btnStartTimer.setEnabled(false);
                countDownTimer = new CountDownTimer(45000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        binding.timer.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        binding.timer.setVisibility(View.GONE);
                        binding.successMsg.setVisibility(View.VISIBLE);
                        binding.successMsg.setText("Failed");
                        cellScrambled();
                        setDisableAllViews();
                        binding.btnScramble.setEnabled(true);
                        binding.btnStartTimer.setEnabled(true);
                        setBackgroundAllNull();
                        room_status = "Failure";
                        room_time = "-";
                        room_score = "0";
                        saveData(room_status, room_time, room_score);
                    }
                }.start();
                break;
            case R.id.btn_go_to_login:
                Intent intent = new Intent(SelectMatrixActivity.this, LoginActivity.class);
                startActivity(intent);
        }
    }

    private void checkStatus() {
        ColorDrawable drawable_1 = (ColorDrawable) binding.view1.getBackground();
        ColorDrawable drawable_2 = (ColorDrawable) binding.view2.getBackground();
        ColorDrawable drawable_3 = (ColorDrawable) binding.view3.getBackground();
        ColorDrawable drawable_4 = (ColorDrawable) binding.view4.getBackground();
        ColorDrawable drawable_5 = (ColorDrawable) binding.view5.getBackground();
        ColorDrawable drawable_6 = (ColorDrawable) binding.view6.getBackground();
        ColorDrawable drawable_7 = (ColorDrawable) binding.view7.getBackground();
        ColorDrawable drawable_8 = (ColorDrawable) binding.view8.getBackground();
        ColorDrawable drawable_9 = (ColorDrawable) binding.view9.getBackground();
        ColorDrawable drawable_10 = (ColorDrawable) binding.view10.getBackground();
        ColorDrawable drawable_11 = (ColorDrawable) binding.view11.getBackground();
        ColorDrawable drawable_12 = (ColorDrawable) binding.view12.getBackground();
        ColorDrawable drawable_13 = (ColorDrawable) binding.view13.getBackground();
        ColorDrawable drawable_14 = (ColorDrawable) binding.view14.getBackground();
        ColorDrawable drawable_15 = (ColorDrawable) binding.view15.getBackground();
        ColorDrawable drawable_16 = (ColorDrawable) binding.view16.getBackground();

        int color_1 = drawable_1.getColor();
        int color_2 = drawable_2.getColor();
        int color_3 = drawable_3.getColor();
        int color_4 = drawable_4.getColor();
        int color_5 = drawable_5.getColor();
        int color_6 = drawable_6.getColor();
        int color_7 = drawable_7.getColor();
        int color_8 = drawable_8.getColor();
        int color_9 = drawable_9.getColor();
        int color_10 = drawable_10.getColor();
        int color_11 = drawable_11.getColor();
        int color_12 = drawable_12.getColor();
        int color_13 = drawable_13.getColor();
        int color_14 = drawable_14.getColor();
        int color_15 = drawable_15.getColor();
        int color_16 = drawable_16.getColor();

        if (color_1 == color_2 && color_3 == color_4
                && color_5 == color_6 && color_7 == color_8 && color_9 == color_10
                && color_11 == color_12 && color_13 == color_14 && color_15 == color_16) {
            binding.timer.setVisibility(View.GONE);
            binding.successMsg.setVisibility(View.VISIBLE);
            time = binding.timer.getText().toString().trim();
            get_final_time = 45 - Integer.parseInt(time);
            binding.successMsg.setText("Successfully Finsihed in" + " " + get_final_time + " " + "Seconds");
            binding.btnScramble.setEnabled(true);
            binding.btnStartTimer.setEnabled(true);
            setDisableAllViews();
            countDownTimer.cancel();
            room_status = "Success";
            room_time = String.valueOf(get_final_time);
            room_score = String.valueOf(Math.max(0, 45 - Integer.parseInt(room_time)) * 50);

            saveData(room_status, room_time, String.valueOf(Math.round(Float.parseFloat(room_score))));
        } else if (color_1 == color_5 && color_9 == color_13
                && color_2 == color_6 && color_10 == color_14
                && color_3 == color_7 && color_11 == color_15
                && color_4 == color_8 && color_12 == color_16) {
            binding.timer.setVisibility(View.GONE);
            binding.successMsg.setVisibility(View.VISIBLE);
            time = binding.timer.getText().toString().trim();
            get_final_time = 45 - Integer.parseInt(time);
            binding.successMsg.setText("Successfully Finsihed in" + " " + get_final_time + " " + "Seconds");
            binding.btnScramble.setEnabled(true);
            binding.btnStartTimer.setEnabled(true);
            setDisableAllViews();
            countDownTimer.cancel();
            room_status = "Success";
            room_time = String.valueOf(get_final_time);
            room_score = String.valueOf(Math.max(0, 45 - Integer.parseInt(room_time)) * 2.2);
            saveData(room_status, room_time, String.valueOf(Math.round(Float.parseFloat(room_score))));
        }
    }

    private void saveData(String room_status, String room_time, String room_score) {
        get_final_time = 0;
        model = new DataModel(room_status, room_time, room_score);
        matrixDataModel.add(model);
        viewModal.insert(model);
        matrixDataAdapter = new MatrixDataAdapter(this, matrixDataModel);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.recycleData.setLayoutManager(linearLayoutManager);
        binding.recycleData.setAdapter(matrixDataAdapter);
        matrixDataAdapter.notifyDataSetChanged();

        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
        viewModal.getAllMatrixes().observe(this, new Observer<List<DataModel>>() {
            @Override
            public void onChanged(List<DataModel> models) {
            }
        });
    }


    private void cellScrambled() {
        binding.timer.setVisibility(View.GONE);
        Random i = new Random();
        int a = i.nextInt(4 - 1) + 1;

        int b, c, d, e;
        if (a == 1) {
            b = 0;
            c = 1;
            d = 2;
            e = 3;
            binding.view1.setBackgroundColor(Color.parseColor(colorArray[e]));
            binding.view2.setBackgroundColor(Color.parseColor(colorArray[b]));
            binding.view3.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view4.setBackgroundColor(Color.parseColor(colorArray[d]));

            binding.view5.setBackgroundColor(Color.parseColor(colorArray[d]));
            binding.view6.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view7.setBackgroundColor(Color.parseColor(colorArray[e]));
            binding.view8.setBackgroundColor(Color.parseColor(colorArray[b]));

            binding.view9.setBackgroundColor(Color.parseColor(colorArray[b]));
            binding.view10.setBackgroundColor(Color.parseColor(colorArray[d]));
            binding.view11.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view12.setBackgroundColor(Color.parseColor(colorArray[e]));

            binding.view13.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view14.setBackgroundColor(Color.parseColor(colorArray[e]));
            binding.view15.setBackgroundColor(Color.parseColor(colorArray[d]));
            binding.view16.setBackgroundColor(Color.parseColor(colorArray[b]));
        } else if (a == 2) {
            b = 1;
            c = 0;
            d = 3;
            e = 2;
            binding.view1.setBackgroundColor(Color.parseColor(colorArray[e]));
            binding.view2.setBackgroundColor(Color.parseColor(colorArray[b]));
            binding.view3.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view4.setBackgroundColor(Color.parseColor(colorArray[d]));

            binding.view5.setBackgroundColor(Color.parseColor(colorArray[d]));
            binding.view6.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view7.setBackgroundColor(Color.parseColor(colorArray[e]));
            binding.view8.setBackgroundColor(Color.parseColor(colorArray[b]));

            binding.view9.setBackgroundColor(Color.parseColor(colorArray[b]));
            binding.view10.setBackgroundColor(Color.parseColor(colorArray[d]));
            binding.view11.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view12.setBackgroundColor(Color.parseColor(colorArray[e]));

            binding.view13.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view14.setBackgroundColor(Color.parseColor(colorArray[e]));
            binding.view15.setBackgroundColor(Color.parseColor(colorArray[d]));
            binding.view16.setBackgroundColor(Color.parseColor(colorArray[b]));
        } else {
            b = 3;
            c = 2;
            d = 1;
            e = 0;
            binding.view1.setBackgroundColor(Color.parseColor(colorArray[e]));
            binding.view2.setBackgroundColor(Color.parseColor(colorArray[b]));
            binding.view3.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view4.setBackgroundColor(Color.parseColor(colorArray[d]));

            binding.view5.setBackgroundColor(Color.parseColor(colorArray[d]));
            binding.view6.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view7.setBackgroundColor(Color.parseColor(colorArray[e]));
            binding.view8.setBackgroundColor(Color.parseColor(colorArray[b]));

            binding.view9.setBackgroundColor(Color.parseColor(colorArray[b]));
            binding.view10.setBackgroundColor(Color.parseColor(colorArray[d]));
            binding.view11.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view12.setBackgroundColor(Color.parseColor(colorArray[e]));

            binding.view13.setBackgroundColor(Color.parseColor(colorArray[c]));
            binding.view14.setBackgroundColor(Color.parseColor(colorArray[e]));
            binding.view15.setBackgroundColor(Color.parseColor(colorArray[d]));
            binding.view16.setBackgroundColor(Color.parseColor(colorArray[b]));
        }
    }

    private void setEnabledAllViews() {
        binding.view1.setEnabled(true);
        binding.view2.setEnabled(true);
        binding.view3.setEnabled(true);
        binding.view4.setEnabled(true);
        binding.view5.setEnabled(true);
        binding.view6.setEnabled(true);
        binding.view7.setEnabled(true);
        binding.view8.setEnabled(true);
        binding.view9.setEnabled(true);
        binding.view10.setEnabled(true);
        binding.view11.setEnabled(true);
        binding.view12.setEnabled(true);
        binding.view13.setEnabled(true);
        binding.view14.setEnabled(true);
        binding.view15.setEnabled(true);
        binding.view16.setEnabled(true);
    }

    private void setDisableAllViews() {
        binding.view1.setEnabled(false);
        binding.view2.setEnabled(false);
        binding.view3.setEnabled(false);
        binding.view4.setEnabled(false);
        binding.view5.setEnabled(false);
        binding.view6.setEnabled(false);
        binding.view7.setEnabled(false);
        binding.view8.setEnabled(false);
        binding.view9.setEnabled(false);
        binding.view10.setEnabled(false);
        binding.view11.setEnabled(false);
        binding.view12.setEnabled(false);
        binding.view13.setEnabled(false);
        binding.view14.setEnabled(false);
        binding.view15.setEnabled(false);
        binding.view16.setEnabled(false);
    }

    private void setBackgroundAllNull() {
        binding.view1.setImageDrawable(null);
        binding.view2.setImageDrawable(null);
        binding.view3.setImageDrawable(null);
        binding.view4.setImageDrawable(null);
        binding.view5.setImageDrawable(null);
        binding.view6.setImageDrawable(null);
        binding.view7.setImageDrawable(null);
        binding.view8.setImageDrawable(null);
        binding.view9.setImageDrawable(null);
        binding.view10.setImageDrawable(null);
        binding.view11.setImageDrawable(null);
        binding.view12.setImageDrawable(null);
        binding.view13.setImageDrawable(null);
        binding.view14.setImageDrawable(null);
        binding.view15.setImageDrawable(null);
        binding.view16.setImageDrawable(null);
    }
}