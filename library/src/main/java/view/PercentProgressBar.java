package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * description:
 * 圆弧型进度展示图
 *
 * @auther cuihai
 * @since 2017/4/12.
 */

public class PercentProgressBar extends View {
    private Paint mPaint;
    private Paint mProPaint;
    private Paint mTextPaint;
    private float x;
    private float y;
    private float startAngle = 90;
    private float orgSweepAngle = 360;
    private int orgColor = Color.GRAY;
    private int ProColor = Color.GREEN;
    private float pro = 0;
    private float percent = 0;

    public PercentProgressBar(Context context) {
        super(context);
        initView();
    }

    public PercentProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public PercentProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();//原始圆弧
        mPaint.setColor(orgColor);
        mPaint.setStrokeWidth(8);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mProPaint = new Paint();// 进度圆弧
        mProPaint.setColor(ProColor);
        mProPaint.setStrokeWidth(10);
        mProPaint.setAntiAlias(true);
        mProPaint.setStyle(Paint.Style.STROKE);
        mTextPaint = new Paint();//中间文字
        mTextPaint.setColor(Color.GREEN);
        mTextPaint.setTextSize(80);
        mTextPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        x = (getWidth() - getHeight() / 2) / 2;
        y = getHeight() / 4;
        RectF rectF = new RectF(x, y, getWidth() - x, getHeight() - y);
        canvas.drawArc(rectF, startAngle, orgSweepAngle, false, mPaint);
        canvas.drawArc(rectF, startAngle, pro, false, mProPaint);
        if (pro < (percent * orgSweepAngle) / 100) {
            pro = pro + 1;
            postInvalidateDelayed(10);
            String hah = String.valueOf((pro / orgSweepAngle) * 100 + "%");
            canvas.drawText(hah, getWidth() / 2, getHeight() / 2, mTextPaint);
        }else if (pro == (percent * orgSweepAngle) / 100){
            canvas.drawText(String.valueOf(percent)+"%", getWidth() / 2, getHeight() / 2+40, mTextPaint);
        }
    }

    public float setPercent(float percent) {
        this.percent = percent;
        return percent;
    }


    public float setStartAngle(float startAngle) {
        this.startAngle = startAngle;
        return startAngle;
    }


    public float setOrgSweepAngle(float orgSweepAngle) {
        this.orgSweepAngle = orgSweepAngle;
        return orgSweepAngle;
    }

    public int setOrgColor(int orgColor) {
        this.orgColor = orgColor;
        return orgColor;
    }

    public int setProColor(int ProColor) {
        this.ProColor = ProColor;
        return ProColor;
    }
}
