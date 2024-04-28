package com.politecnicomalaga.tmdbclient;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.politecnicomalaga.tmdbclient.control.MoviesSeriesRVAdapter;
import com.politecnicomalaga.tmdbclient.control.MoviesViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        //Init components. Main Buttons and RecyclerView

        //Buttons

        //Recycler trending movies or series
        MoviesViewModel vmodel = new ViewModelProvider(this).get(MoviesViewModel.class);
        vmodel.getResults().observe(this, movieSerieItems -> {
            // update UI
            // Get a handle to the RecyclerView.
            RecyclerView mRecyclerView = findViewById(R.id.rvMain);
            // Create an adapter and supply the data to be displayed.
            MoviesSeriesRVAdapter mAdapter = new MoviesSeriesRVAdapter(this, movieSerieItems);
            // Connect the adapter with the RecyclerView.
            mRecyclerView.setAdapter(mAdapter);
            // Give the RecyclerView a default layout manager.
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        });


    }
}