package com.example.week2weekend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class DrawableActivity extends BaseActivity {
    ImageView ivImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        ivImage=findViewById(R.id.imageView);

    }
    public void OnClickRed(View v){
        Drawable unwrappedDrawable = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            unwrappedDrawable = getDrawable(R.drawable.drawable);

        }
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, Color.RED);

        ivImage.setImageDrawable(wrappedDrawable);
    }
    public void OnClickBlue(View v){
        Drawable unwrappedDrawable = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            unwrappedDrawable = getDrawable(R.drawable.drawable);
        }
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, Color.BLUE);
        ivImage.setImageDrawable(wrappedDrawable);
    }

}
