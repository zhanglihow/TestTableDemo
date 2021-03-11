package com.example.testtabledemo

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.math.ceil


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class TableView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var mWidth = 0

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER
    }
    //初始化屏幕宽度
    fun initWidth(width: Int) {
        mWidth = width
    }

    fun addTables(vararg datas: List<String>) {
        if (datas.isEmpty() || mWidth == 0) {
            return
        }
        //表格宽度
        val width = (mWidth-20) / datas[0].size

        when (datas.size) {
            //只有一层表格
            1 -> {
                val layout = LinearLayout(context)
                layout.orientation = HORIZONTAL
                layout.gravity = Gravity.CENTER

                val maxHeight = getMaxHeight(datas[0], width)

                val names = datas[0]
                for (index in names.indices) {
                    val tv = getTv(names[index])
                    if (index == names.size - 1) {
                        tv.background = context.getDrawable(R.drawable.shape_center_end)
                    } else {
                        tv.background = context.getDrawable(R.drawable.shape_center_start)
                    }
                    layout.addView(
                        tv,
                        LayoutParams(width, maxHeight)
                    )
                }

                addView(
                    layout,
                    LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
                )

            }
            //两层以上
            else -> {
                for (indexData in datas.indices) {
                    when (indexData) {
                        //画最后层
                        datas.size - 1 -> {
                            val maxHeight = getMaxHeight(datas[indexData], width)

                            val layout = LinearLayout(context)
                            layout.orientation = HORIZONTAL
                            layout.gravity = Gravity.CENTER

                            val names1 = datas[datas.size - 1]
                            for (index in names1.indices) {
                                val tv = getTv(names1[index])
                                if (index == names1.size - 1) {
                                    tv.background = context.getDrawable(R.drawable.shape_bottom_end)
                                } else {
                                    tv.background =
                                        context.getDrawable(R.drawable.shape_bottom_start)
                                }
                                layout.addView(
                                    tv,
                                    LayoutParams(width, maxHeight)
                                )
                            }
                            addView(
                                layout,
                                    LayoutParams(
                                        LayoutParams.MATCH_PARENT,
                                        LayoutParams.WRAP_CONTENT
                                    )
                            )
                        }
                        //画第一层和其他层
                        else -> {
                            val maxHeight = getMaxHeight(datas[indexData], width)

                            val layout = LinearLayout(context)
                            layout.orientation = HORIZONTAL
                            layout.gravity = Gravity.CENTER

                            val names1 = datas[indexData]
                            for (index in names1.indices) {
                                val tv = getTv(names1[index])
                                if (index == names1.size - 1) {
                                    tv.background = context.getDrawable(R.drawable.shape_top_end)
                                } else {
                                    tv.background = context.getDrawable(R.drawable.shape_top_start)
                                }
                                layout.addView(
                                    tv,
                                    LayoutParams(width, maxHeight)
                                )
                            }
                            addView(
                                layout,
                                    LayoutParams(
                                        LayoutParams.MATCH_PARENT,
                                        LayoutParams.WRAP_CONTENT
                                    )
                            )
                        }
                    }
                }
            }
        }
    }

    /**
     * 统一处理TextView
     */
    private fun getTv(str: String): TextView {
        val textView = SDAdaptiveTextView(context)
        textView.post { textView.setAdaptiveText(str) }
        textView.setTextColor(context.getColor(R.color.black))
        textView.gravity = Gravity.CENTER
        return textView
    }

    /**
     * 获取最高的高度
     */
    private fun getMaxHeight(names: List<String>, width: Int): Int {
        var maxName = ""
        for (name in names) {
            if (name.length > maxName.length) {
                maxName = name
            }
        }
        val tv = getTv(maxName)
        addView(tv, LayoutParams(width, LayoutParams.WRAP_CONTENT))
        //有多少行
        val line = tv.paint.measureText(maxName) / width
        removeView(tv)

        return sp2px(context,25f) * ceil(line).toInt()
    }

    private fun sp2px(context: Context, spValue: Float) :Int{
        val fontScale = context.resources.displayMetrics.scaledDensity;
        return (spValue * fontScale + 0.5f).toInt()
    }

}