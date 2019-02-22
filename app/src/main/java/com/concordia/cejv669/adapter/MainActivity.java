package com.concordia.cejv669.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.btn_addnum);

        final List<String> myList = new ArrayList<>();

//        myList.add("One");
//        myList.add("Two");
//        myList.add("Tree");

        final ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.add(String.valueOf((int)(Math.random()*100+1)));
                itemsAdapter.notifyDataSetChanged();
            }
        });

        Button b2 = findViewById(R.id.btn_addchar);
         b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random ();
                char c = (char)(r.nextInt(26) + 'a');
                itemsAdapter.add(String.valueOf(c));
            }
        });

        Button b3 = findViewById(R.id.btn_sort);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemsAdapter.sort(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                });
            }
        });

        ListView lv = findViewById(R.id.listview_results);
        lv.setAdapter(itemsAdapter);
    }
}
