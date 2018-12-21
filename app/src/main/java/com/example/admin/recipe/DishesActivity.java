package com.example.admin.recipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DishesActivity extends AppCompatActivity
{
    ListView Dishes_listview;
    String[] punjabidishes;
    String[] southdishes;
    String[] chinesedishes;
    String[] kathiyawadidishes;
    Bundle b;
    int mainCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);

        b = getIntent().getExtras();
        initData();
        initSubCategory();
    }

    private void initData()
    {
        punjabidishes = getResources().getStringArray(R.array.PunjabiDishes);
        southdishes = getResources().getStringArray(R.array.SouthIndianDishes);
        chinesedishes = getResources().getStringArray(R.array.ChineseDishes);
        kathiyawadidishes = getResources().getStringArray(R.array.KathiyawadiDishes);
        Dishes_listview = (ListView) findViewById(R.id.Dishes_list);
    }
    private void initSubCategory()
    {
        if (b != null)
        {
            mainCategory = b.getInt("clickedItem",0);

            if (mainCategory == 0)
            {
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, punjabidishes);
                Dishes_listview.setAdapter(stringArrayAdapter);
            }
            else if (mainCategory == 1)
            {
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, southdishes);
                Dishes_listview.setAdapter(stringArrayAdapter);
            }

            else if (mainCategory == 2)
            {
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chinesedishes);
                Dishes_listview.setAdapter(stringArrayAdapter);
            }
            else if (mainCategory == 3)
            {
                ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kathiyawadidishes);
                Dishes_listview.setAdapter(stringArrayAdapter);
            }
        }

        Dishes_listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
               Intent intent = new Intent(DishesActivity.this,Detailed_List.class);
               intent.putExtra("itemClicked",position);
               startActivity(intent);
            }
        });
    }
}
