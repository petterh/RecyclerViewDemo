package com.contoso.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String[] ITEMS = { "One", "Two", "Three", "Four", "Five" };

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        MyViewHolder(TextView itemView) {
            super(itemView); // Set breakpoint here
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView textView = new TextView(MainActivity.this);
                return new MyViewHolder(textView);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                MyViewHolder viewHolder = (MyViewHolder) holder;
                TextView itemView = (TextView) viewHolder.itemView;
                itemView.setText(ITEMS[position]);
                if (position % 2 != 0) {
                    //noinspection deprecation
                    itemView.setBackgroundColor(getResources().getColor(R.color.lightGray));
                }
            }

            @Override
            public int getItemCount() {
                return ITEMS.length;
            }
        });
    }
}
