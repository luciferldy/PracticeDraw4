package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

/**
 * Created by Lucifer on 2017/8/6.
 */

public class Practice15RTView extends View {

    Point point1 = new Point(200, 200);
    Point point2 = new Point(750, 200);
    Bitmap bitmap;
    Paint paint = new Paint();
    Paint paint2 = new Paint();
    Path path;

    public Practice15RTView(Context context) {
        super(context);
    }

    public Practice15RTView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice15RTView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        path = new Path();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        paint2.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        path.addRect(point2.x, point2.y, point2.x + bitmap.getWidth(), point2.y + bitmap.getHeight(), Path.Direction.CW);
        canvas.drawPath(path, paint2);
        canvas.restore();

        canvas.save();
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint2);
        canvas.restore();

        canvas.save();
        canvas.translate(200, 0);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(200, 0);
        canvas.rotate(90, point1.x + bitmap.getWidth()/2, point1.y + bitmap.getHeight()/2);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
    }
}
