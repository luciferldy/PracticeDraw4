package com.hencoder.hencoderpracticedraw4.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

/**
 * Created by Lucifer on 2017/8/6.
 */

public class Sample15RTView extends View {

    Point point1 = new Point(200, 200);
    Bitmap bitmap;
    Paint paint = new Paint();

    public Sample15RTView(Context context) {
        super(context);
    }

    public Sample15RTView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample15RTView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.rotate(90, point1.x + bitmap.getWidth()/2, point1.y + bitmap.getHeight()/2);
        canvas.translate(200, 0);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
    }
}
