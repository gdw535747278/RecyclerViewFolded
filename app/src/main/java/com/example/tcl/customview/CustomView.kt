package com.example.tcl.customview


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View

import com.example.tcl.customview.util.DensityUtils

/**
 * Created by TCL on 2018/1/12.
 */

class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {
    private var mDataCenterX: Int = 0
    private var mDataCenterY: Int = 0
    private var mDataCircleRadiusOuter: Int = 0
    private var mContext: Context? = null
    private var mDataCircleMargin: Any? = null
    private var mOutCirclePainter: Paint? = null
    private var mLinePainter: Paint? = null

    var BANJING = DensityUtils.dp2px(mContext, 5f)

    init {
        init(context)
    }

    private fun init(pContext: Context) {
        this.mContext = pContext

        //clipPath with hardware acceleration is only supported in API level 18 and higher, on API levels from 11 to 17 it needs to be turned off.
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            //用于硬件加速  View层的硬件加速设置如下
            setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        }

        mOutCirclePainter = Paint()

        mOutCirclePainter!!.isAntiAlias = true
        mOutCirclePainter!!.isDither = true
        mOutCirclePainter!!.style = Paint.Style.STROKE
        mOutCirclePainter!!.strokeWidth = BANJING.toFloat()
        mOutCirclePainter!!.color = Color.parseColor("#565656")



        mLinePainter = Paint()
        mLinePainter!!.strokeWidth = DensityUtils.dp2px(pContext, 5f).toFloat()
        mLinePainter!!.color = Color.parseColor("#ff0000")

        //       Path mPath = new Path();
        //       Paint mBezier = new Paint();
        //        mPath.reset();
        //        mPath.moveTo(mDataCenterX,mDataCenterY-mDataCircleRadiusOuter);
        //        mPath.quadTo(mDataCenterX-mDataCircleRadiusOuter/2,mDataCenterY-mDataCircleRadiusOuter/2,mDataCenterX,mDataCenterY);
        //        mPath.quadTo(mDataCenterX+mDataCircleRadiusOuter/2,mDataCenterY+mDataCircleRadiusOuter/2,mDataCenterX,mDataCenterY+mDataCircleRadiusOuter);

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        initDataIfNeed()

        canvas.drawCircle(mDataCenterX.toFloat(), mDataCenterY.toFloat(), mDataCircleRadiusOuter.toFloat(), mOutCirclePainter!!)
        canvas.drawLine(mDataCenterX.toFloat(), mDataCenterY.toFloat(), (mDataCenterX - mDataCircleRadiusOuter).toFloat(), mDataCenterY.toFloat(), mLinePainter!!)
        //        canvas.rotate(mAngle, mDataCenterX, mDataCenterY);
        //        canvas.drawPath(mPath,mBezier);

    }

    private fun initDataIfNeed() {
        if (mDataCenterX == 0) {
            val visibleWidth = width - paddingLeft - paddingRight
            val visibleHeight = height - paddingTop - paddingBottom
            mDataCenterX = paddingLeft + visibleWidth / 2
            mDataCenterY = paddingTop + visibleHeight / 2
            mDataCircleRadiusOuter = Math.min(visibleWidth / 2, visibleHeight / 2) - DensityUtils.dp2px(mContext, 5f)
            mDataCircleMargin = (mDataCircleRadiusOuter - DensityUtils.dp2px(mContext, 16f)) / (2 - 1)
        }
    }

    fun startAnim() {


        //        Animation vAnimation = new RotateAnimation(0f, 360f,mDataCenterX,mDataCenterY);
        //        vAnimation.setDuration(1000);
        //        vAnimation.setRepeatCount(10);
        //        vAnimation.setRepeatMode(Animation.RESTART);
        //        startAnimation(vAnimation);
    }

    companion object {
        private val ARC_DURATION = 1500
    }

    annotation class JvmOverloads
}//    private float mAngle = 20;
//    public Path mPath;
//    public Paint mBezier;
