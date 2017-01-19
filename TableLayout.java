package com.example.sub.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TableLayout extends AppCompatActivity {


    ImageView imgview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);


        Paint redpaint=new Paint();
        redpaint.setColor(Color.RED);
        redpaint.setStyle(Paint.Style.FILL);

        Paint greenpaint=new Paint();
        greenpaint.setColor(Color.GREEN);
        greenpaint.setStyle(Paint.Style.FILL);

        Bitmap bmi=Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        Canvas cv=new Canvas(bmi);
        cv.drawRect(0,0,500,500,redpaint);
        drawTable(cv,1.0f,3.0f,greenpaint);
        drawTable(cv,6.0f,7.0f,greenpaint);
        drawTable(cv,3.0f,3.0f,greenpaint);


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        Toast.makeText(getApplicationContext(),height+" "+width,Toast.LENGTH_SHORT).show();

        LinearLayout ll=(LinearLayout)findViewById(R.id.linear);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN  ) {
            ll.setBackground(new BitmapDrawable(bmi));
        }

    }

    // Method to draw table
    public void drawTable(Canvas cv,float x,float y,Paint paint){

        x=50*x;
        y=50*y;
        float left,top,right,bottom;
        left=x-(x/2);
        top=y-(y/2);
        right=x+(x/2);
        bottom=y+(y/2);
        cv.drawRect(left,top,right,bottom,paint);
    }
}
