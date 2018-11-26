package com.example.luc_olivier.howifeel.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.luc_olivier.howifeel.R;

public class MainActivity extends AppCompatActivity {
    public static final int [][] LIST_COLOR_IMG = {
            {R.color.faded_red,
                    R.color.warm_grey,
                    R.color.cornflower_blue_65,
                    R.color.light_sage,
                    R.color.banana_yellow,},

            {R.drawable.smiley_sad,
                    R.drawable.smiley_disappointed,
                    R.drawable.smiley_normal,
                    R.drawable.smiley_happy,
                    R.drawable.smiley_super_happy}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnComment = (ImageButton) findViewById(R.id.comment_main);
        ImageButton btnHistory = (ImageButton) findViewById(R.id.history_main);

        /*
         *@mBtnComment
         * Button to the left side, which open an Alert dialog on click
         */
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();
            }
        });
    }

    private void addComment() {
    }
}
