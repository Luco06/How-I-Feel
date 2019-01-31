package com.example.luc_olivier.howifeel.Controller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.luc_olivier.howifeel.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private float rawY = 0.0f;
    public static final int[][] LIST_COLOR_IMG = {
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
    public static int indexMood = 3;
    private ImageButton mBtnComment;
    private ImageButton mBtnHistory;
    private ImageView mSmiley;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mBtnComment = (ImageButton) findViewById(R.id.comment_main);
        mBtnHistory = (ImageButton) findViewById(R.id.history_main);
        mSmiley = (ImageView) findViewById(R.id.smiley);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.main_activity_background);

        /*
         *@mBtnComment
         * Button to the left side, which open an Alert dialog on click
         */
        mBtnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addComment();
            }
        });
    }

    private void addComment() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        EditText editText = new EditText(this);
        builder.setMessage("Ajoutez un commentaire");
        builder.setView(editText);
        builder.setPositiveButton("Confirmer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float dist = 0;
        int height;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                rawY = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                dist = event.getY() - rawY;

                if (indexMood < LIST_COLOR_IMG[0].length + 1  && dist < 0) {
                    indexMood--;
                    moodChange();
                } else if (indexMood < LIST_COLOR_IMG[0].length - 1 && dist > 0) {
                    indexMood++;
                    moodChange();
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    private void moodChange() {
        mSmiley.setImageResource(LIST_COLOR_IMG[1][indexMood]);
        mRelativeLayout.setBackgroundColor(getResources().getColor(LIST_COLOR_IMG[0][indexMood]));
    }
}
