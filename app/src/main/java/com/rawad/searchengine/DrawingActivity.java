package com.rawad.searchengine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.content.Context;

/**
 * Created by Rawad on 02/04/2015.
 */
public class DrawingActivity extends View {
	
	private Paint paint;
	
	public DrawingActivity(Context context) {
		super(context);

		paint = new Paint();

	}
	
	@Override
	public void onDraw(Canvas canvas) {
		
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);
		
		int x = getWidth()/2;
		int y = getHeight()/2;
		
        canvas.drawRect(x, y, x+50, y+50, paint);

	}

}
