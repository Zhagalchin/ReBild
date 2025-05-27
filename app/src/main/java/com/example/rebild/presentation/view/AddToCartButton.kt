package com.example.rebild.presentation.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.rebild.R

class AddToCartButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private val paintBlue = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = resources.getColor(R.color.blueOzon)
        style = Paint.Style.FILL
    }
    private val paintCheckMark = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = 8f
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    private val paintWhite = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        textSize = 40f
        strokeWidth = 20f
    }
    private val paintGreen = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GREEN
        style = Paint.Style.FILL
    }

    private var minusRect = RectF()
    private var plusRect = RectF()
    private var circleRadius = 0f
        set(value) {
            field = value
            invalidate()
        }

    private var circleCenterX = 0f
    private var circleCenterY = 0f
    private var circleMaxRadius = 30f
    private val handler = Handler(Looper.getMainLooper())
    private var plusRunnable: Runnable? = null
    private var minusRunnable: Runnable? = null

    var inCartCount = 0
        set(value) {
            field = value
            invalidate()
        }

    var onCountChanged: ((Int) -> Unit)? = null

    init {
        isClickable = true
        isFocusable = true
    }

    private fun animateToCounterState(canvas: Canvas) {
        canvas.drawCircle(circleCenterX, circleCenterY, circleRadius, paintGreen)
        if (circleRadius > 0) {
            val path = Path().apply {
                moveTo(circleCenterX - 10, circleCenterY)
                lineTo(circleCenterX - 2, circleCenterY + 8)
                lineTo(circleCenterX + 12, circleCenterY - 10)
            }
            canvas.drawPath(path, paintWhite)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = 300
        val desiredHeight = 100
        val measuredWidth = resolveSize(desiredWidth, widthMeasureSpec)
        val measuredHeight = resolveSize(desiredHeight, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, measuredHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (inCartCount > 0) {
            drawCounter(canvas)
            animateToCounterState(canvas)
        } else {

            drawAddButton(canvas)

        }
    }


    private fun drawAddButton(canvas: Canvas) {
        // Рисуем синий фон
        val buttonRect = RectF(0f, 0f, width.toFloat(), height.toFloat())

        canvas.drawRoundRect(buttonRect, 30f, 30f, paintBlue)


        val text = "В корзину"
        val textWidth = paintWhite.measureText(text)
        val x = (width - textWidth) / 2
        val y = (height / 2) - ((paintWhite.descent() + paintWhite.ascent()) / 2)
        canvas.drawText(text, x, y, paintWhite)
    }

    private fun drawCounter(canvas: Canvas) {
        paintBlue.alpha = 200
        val buttonRect = RectF(0f, 0f, width.toFloat(), height.toFloat())

        canvas.drawRoundRect(buttonRect, 30f, 30f, paintBlue)
        paintBlue.alpha = 255 // возвращаем прозрачность

        // Рисуем текстовый счётчик
        val text = inCartCount.toString()
        val textWidth = paintWhite.measureText(text)
        val x = (width - textWidth) / 2
        val y = (height / 2) - ((paintWhite.descent() + paintWhite.ascent()) / 2)
        canvas.drawText(text, x, y, paintWhite)

        // Для упрощения сделаем зоны +/- слева и справа
        val buttonWidth = width / 4f
        minusRect = RectF(0f, 0f, buttonWidth, height.toFloat())
        plusRect = RectF(width - buttonWidth, 0f, width.toFloat(), height.toFloat())

        // Рисуем минус — пусть это просто полоска
        val centerY = height / 2f
        val centerXMinus = buttonWidth / 2f
        canvas.drawRoundRect(
            centerXMinus - 30, centerY - 8,
            centerXMinus + 30, centerY + 8,
            20f, 20f, paintWhite
        )

        // Рисуем плюс
        val centerXPlus = width - buttonWidth / 2
        // Горизонталь
        canvas.drawRoundRect(
            centerXPlus - 30, centerY - 8,
            centerXPlus + 30, centerY + 8,
            20f, 20f, paintWhite
        )
        // Вертикаль
        canvas.drawRoundRect(
            centerXPlus - 10, centerY - 30,
            centerXPlus + 10, centerY + 30,
            20f, 20f, paintWhite
        )
        val circleRadius = 30f

        canvas.drawCircle(circleCenterX, circleCenterY, circleRadius, paintGreen)

        val checkPath = Path().apply {
            moveTo(circleCenterX - circleRadius * 0.4f, circleCenterY + circleRadius * 0.1f)
            lineTo(circleCenterX - circleRadius * 0.1f, circleCenterY + circleRadius * 0.4f)
            lineTo(circleCenterX + circleRadius * 0.4f, circleCenterY - circleRadius * 0.3f)
        }

        canvas.drawPath(checkPath, paintCheckMark)


    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (inCartCount > 0) {
                    if (minusRect.contains(event.x, event.y)) {
                        if (inCartCount > 0) {
                            inCartCount--
                            onCountChanged?.invoke(inCartCount)
                            invalidate()
                        }
                        startMinus()
                    } else if (plusRect.contains(event.x, event.y)) {
                        inCartCount++
                        onCountChanged?.invoke(inCartCount)
                        invalidate()
                        startPlus()
                    }
                } else {
                    inCartCount = 1
                    onCountChanged?.invoke(inCartCount)
                    invalidate()
                }
                return true
            }

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                stopPlus()
                stopMinus()
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    private fun startPlus() {
        plusRunnable = object : Runnable {
            override fun run() {
                inCartCount++
                onCountChanged?.invoke(inCartCount)
                invalidate()
                handler.postDelayed(this, 200)
            }
        }
        handler.postDelayed(plusRunnable!!, 250)
    }

    private fun startMinus() {
        minusRunnable = object : Runnable {
            override fun run() {
                if (inCartCount > 0) {
                    inCartCount--
                    onCountChanged?.invoke(inCartCount)
                    invalidate()
                    handler.postDelayed(this, 200)
                } else {
                    stopMinus()
                }
            }
        }
        handler.postDelayed(minusRunnable!!, 250)
    }


    private fun stopPlus() {
        plusRunnable?.let {
            handler.removeCallbacks(it)
            plusRunnable = null
        }
    }

    private fun stopMinus() {
        minusRunnable?.let {
            handler.removeCallbacks(it)
            minusRunnable = null
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        circleMaxRadius = 30f
        circleCenterX = w - circleMaxRadius + 18
        circleCenterY = circleMaxRadius - 18

    }
}


