package com.activity_fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout outerLayout = (RelativeLayout) findViewById(R.id.layout);
        final TextView titleText = (TextView) findViewById(R.id.title);
        final TextView bodyText = (TextView) findViewById(R.id.body_text);

        Bitmap image = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Palette.from(image).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                if (vibrantSwatch != null) {
                    outerLayout.setBackgroundColor(vibrantSwatch.getRgb());
                    titleText.setTextColor(vibrantSwatch.getTitleTextColor());
                    bodyText.setTextColor(vibrantSwatch.getBodyTextColor());
                }
            }
        });
    }
}
