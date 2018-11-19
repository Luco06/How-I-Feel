package com.example.luc_olivier.howifeel.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.luc_olivier.howifeel.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton mBtnhistory;
    private ImageButton mBtncomment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtncomment = (ImageButton) findViewById(R.id.comment_main);
        mBtnhistory = (ImageButton) findViewById(R.id.history_main);

        /*
         *@mBtnComment
         * Button to the left side, which open an Alert dialog on click
         */
        mBtncomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();
            }
        });
    }

    private void addComment() {
    }
}
