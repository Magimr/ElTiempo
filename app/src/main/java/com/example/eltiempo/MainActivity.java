package com.example.eltiempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.RecursiveAction;

public class MainActivity extends AppCompatActivity implements Controller.ServerResponse {

    WeatherAdapter adapter;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Controller controller = new Controller(this);
        controller.start();

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        adapter = new WeatherAdapter(this,null);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        txtTitle = findViewById(R.id.txtTitle);

    }

    @Override
    public void onResponse(Weather weather) {
        adapter.setData(weather.getConsolidated_weather());
        txtTitle.setText(weather.getTitle());

    }
}
