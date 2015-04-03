package com.rawad.searchengine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.view.View;

/**
 * Created by Rawad on 02/04/2015.
 */
public class DrawingActivity extends View {
	
	private Paint paint;
	
	private Picture picture;
	
	private Bitmap bm;
	
	public DrawingActivity(Context context) {
		super(context);
		
		paint = new Paint();
		
		picture = new Picture();
		
		bm = BitmapFactory.decodeFile("res/drawable/ic_launcher.png");
		
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);
		
		int x = getWidth()/2;
		int y = getHeight()/2;
		
		canvas.drawRect(x, y, x + 50, y + 50, paint);
		canvas.drawBitmap(bm, 0, 0, null);
		
	}
	
}
