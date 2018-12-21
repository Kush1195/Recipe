package com.example.admin.recipe;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity
{
    ImageButton start;
    static int variableClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (ImageButton)findViewById(R.id.StartButton);
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
        start.startAnimation(animation);

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });

    }

}
