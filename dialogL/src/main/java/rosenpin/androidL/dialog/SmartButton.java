package rosenpin.androidL.dialog;

/**
 * Created by tomer on 21/08/14.
 */
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Region;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

public class SmartButton extends Button {

    private float mDownX;
    private float mDownY;

    private float mRadius;

    private Paint mPaint;

    public SmartButton(final Context context) {
        super(context);
        init();
    }

    public SmartButton(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SmartButton(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAlpha(100);
    }

    @Override
    public boolean onTouchEvent(@NonNull final MotionEvent event) {
        if(Build.VERSION.SDK_INT >= 11) {
            final ObjectAnimator animator = ObjectAnimator.ofFloat(this, "radius", 0, getWidth() * 3.0f);
            if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                mDownX = event.getX();
                mDownY = event.getY();

                animator.setInterpolator(new AccelerateInterpolator());
                animator.setDuration(1000);
                animator.start();
            }
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                mDownX = event.getX();
                mDownY = event.getY();

                animator.setInterpolator(new AccelerateInterpolator());
                animator.setDuration(1000);
                animator.start();

            }
        }
            return super.onTouchEvent(event);
    }

    public void setRadius(final float radius) {
        mRadius = radius;
        if (mRadius > 0) {
            RadialGradient radialGradient = new RadialGradient(
                    mDownX,
                    mDownY,
                    mRadius * 3,
                    Color.TRANSPARENT,
                    Color.BLACK,
                    Shader.TileMode.MIRROR
            );
            mPaint.setShader(radialGradient);
        }
        invalidate();
    }

    private Path mPath = new Path();
    private Path mPath2 = new Path();

    @Override
    protected void onDraw(@NonNull final Canvas canvas) {
        super.onDraw(canvas);

        mPath2.reset();
        mPath2.addCircle(mDownX, mDownY, mRadius, Path.Direction.CW);

        canvas.clipPath(mPath2);

        mPath.reset();
        mPath.addCircle(mDownX, mDownY, mRadius / 3, Path.Direction.CW);

        canvas.clipPath(mPath, Region.Op.DIFFERENCE);

        canvas.drawCircle(mDownX, mDownY, mRadius, mPaint);
    }

}