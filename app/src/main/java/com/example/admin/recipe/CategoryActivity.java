package com.example.admin.recipe;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity
{
    ListView category_listView;
    String[] entries;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category_listView = (ListView)findViewById(R.id.Category_list);

        entries = getResources().getStringArray(R.array.Category);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,entries);
        category_listView.setAdapter(adapter);

        category_listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                MainActivity.variableClick = position;
                Intent intent = new Intent(CategoryActivity.this,DishesActivity.class);
                intent.putExtra("clickedItem",position);
                startActivity(intent);
            }
        });
    }
}
