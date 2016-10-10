package com.shzlabs.collapsingtoolbartest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shzlabs.collapsingtoolbartest.data.MyData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyRecyclerAdapter adapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init views
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Setup toolbar
        setSupportActionBar(toolbar);

        // Setup RecyclerView
        adapter = new MyRecyclerAdapter(this, MyData.getData());

        recyclerView.setAdapter(adapter);

    }

    public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder>{

        Context context;
        List<String> itemList;

        public MyRecyclerAdapter(Context context, List<String> itemList) {
            this.context = context;
            this.itemList = itemList;
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.list_item, null);

            CustomViewHolder viewHolder = new CustomViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            holder.textView.setText(itemList.get(position));
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder{
            private TextView textView;
            public CustomViewHolder(View itemView) {
                super(itemView);
                this.textView = (TextView) itemView.findViewById(R.id.title);
            }
        }

    }
}
