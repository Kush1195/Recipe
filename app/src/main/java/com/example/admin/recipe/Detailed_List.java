package com.example.admin.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.io.IOException;

public class Detailed_List extends AppCompatActivity
{
    TextView food_name,food_desc;
    ImageView imageView;
    String[] Description;
    String[] PunjabiDishes;
    String[] SouthIndianDishes;
    String[] ChineseDishes;
    String[] KathiyawadiDishes;
    String[] images;
    Bundle b;
    int maindishes;
    Button btn_next,btn_prev,btn_fav;
    String imagePath = "";
    int limit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed__list);
        b = getIntent().getExtras();

        maindishes = b.getInt("itemClicked",0);

        try
        {
            images = getAssets().list("images");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        init();
        initDetail();

        btn_next.setOnClickListener(new View. OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                maindishes++;
               if (maindishes >= limit)
               {
                   maindishes = 0;
               }
               callback();
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                maindishes--;
                if (maindishes < 0)
                {
                    maindishes = limit-1;
                }
                callback();
            }
        });
    }

    private void callback()
    {
        if (MainActivity.variableClick == 0)
        {
            limit = PunjabiDishes.length;
            food_name.setText(PunjabiDishes[maindishes]);
            imagePath = "file:///android_asset/images/" + maindishes + ".jpg";
            Glide.with(Detailed_List.this).load(imagePath).into(imageView);
            food_desc.setText(Description[maindishes]);
        }
        else if (MainActivity.variableClick == 1)
        {
            limit = SouthIndianDishes.length;
            int size = 3+maindishes;
            food_name.setText(SouthIndianDishes[maindishes]);
            imagePath = "file:///android_asset/images/" + size + ".jpg";
            Glide.with(Detailed_List.this).load(imagePath).into(imageView);
            food_desc.setText(Description[size]);
        }
        else if (MainActivity.variableClick == 2)
        {
            limit = ChineseDishes.length;
            int size = 6+maindishes;
            food_name.setText(ChineseDishes[maindishes]);
            imagePath = "file:///android_asset/images/" +  size + ".jpg";
            Glide.with(Detailed_List.this).load(imagePath).into(imageView);
            food_desc.setText(Description[size]);
        }
        else if (MainActivity.variableClick == 3)
        {
            limit = KathiyawadiDishes.length;
            int size = 9+maindishes;
            food_name.setText(KathiyawadiDishes[maindishes]);
            food_desc.setText(Description[size]);
            imagePath = "file:///android_asset/images/" +  size + ".jpg";
            Glide.with(Detailed_List.this).load(imagePath).into(imageView);
        }
    }

    private void initDetail()
    {
        if (b != null)
        {
            callback();
        }
    }

    private void init()
    {
        food_name = (TextView)findViewById(R.id.food_text);
        food_desc = (TextView)findViewById(R.id.food_description);
        food_desc.setMovementMethod(new ScrollingMovementMethod());
        imageView = (ImageView)findViewById(R.id.food_image);
        btn_next = (Button)findViewById(R.id.button_next);
        btn_prev = (Button)findViewById(R.id.button_prev);
        btn_fav = (Button)findViewById(R.id.button_fav);

        Description = getResources().getStringArray(R.array.Description);
        PunjabiDishes = getResources().getStringArray(R.array.PunjabiDishes);
        SouthIndianDishes = getResources().getStringArray(R.array.SouthIndianDishes);
        ChineseDishes = getResources().getStringArray(R.array.ChineseDishes);
        KathiyawadiDishes = getResources().getStringArray(R.array.KathiyawadiDishes);
    }
}
