package com.contoso.recyclerviewdemo;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] ITEMS = {
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
    };

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        MyViewHolder(TextView itemView) {
            super(itemView); // Set breakpoint here
        }
    }

    private static final String[] COUNTRIES = new String[] {
            "Belgium",
            "Denmark",
            "Estonia",
            "Finland",
            "France",
            "Italy",
            "Germany",
            "Norway",
            "Russia",
            "Spain",
            "United Kingdom",
            "United States",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.auto_complete_text_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        autoCompleteTextView.setThreshold(0);
        autoCompleteTextView.setAdapter(adapter);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            @NonNull
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                TextView textView = new TextView(MainActivity.this);
                return new MyViewHolder(textView);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                MyViewHolder viewHolder = (MyViewHolder) holder;
                TextView itemView = (TextView) viewHolder.itemView;
                itemView.setText(ITEMS[position]);
                @ColorRes int backgroundColorId = position % 2 != 0 ? R.color.lightGray : R.color.white;
                itemView.setBackgroundColor(getResources().getColor(backgroundColorId));
            }

            @Override
            public int getItemCount() {
                return ITEMS.length;
            }
        });

        findViewById(R.id.custom_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
