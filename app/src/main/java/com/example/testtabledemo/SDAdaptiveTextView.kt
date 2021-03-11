package com.example.testtabledemo

import android.content.Context
import android.graphics.Paint
import android.widget.TextView


/**
 *
 * @author zhangli
 * @email zhanglihow@gmail.com
 * @time
 */
class SDAdaptiveTextView(context: Context) : androidx.appcompat.widget.AppCompatTextView(context) {

    /**
     * 使用该方法设置TextView的文本内容,改方法不能再主线程中执行
     * @param text
     */
    fun setAdaptiveText(str: String?) {
        text = str
        text = adaptiveText(this)
    }

    private fun adaptiveText(textView: TextView): String {
        val originalText = textView.text.toString() //原始文本
        val tvPaint: Paint = textView.paint //获取TextView的Paint
        val tvWidth =
            textView.width - textView.paddingLeft - textView.paddingRight
                .toFloat() //TextView的可用宽度
        //将原始文本按行拆分
        val originalTextLines =
            originalText.replace("\r".toRegex(), "").split("\n".toRegex()).toTypedArray()
        val newTextBuilder = StringBuilder()
        for (originalTextLine in originalTextLines) {
            //文本内容小于TextView宽度，即不换行，不作处理
            if (tvPaint.measureText(originalTextLine) <= tvWidth) {
                newTextBuilder.append(originalTextLine)
            } else {
                //如果整行宽度超过控件可用宽度，则按字符测量，在超过可用宽度的前一个字符处手动换行
                var lineWidth = 0f
                var i = 0
                while (i != originalTextLine.length) {
                    val charAt = originalTextLine[i]
                    lineWidth += tvPaint.measureText(charAt.toString())
                    if (lineWidth <= tvWidth) {
                        newTextBuilder.append(charAt)
                    } else {
                        //单行超过TextView可用宽度，换行
                        newTextBuilder.append("\n")
                        lineWidth = 0f
                        --i //该代码作用是将本轮循环回滚，在新的一行重新循环判断该字符
                    }
                    ++i
                }
            }
        }
        return newTextBuilder.toString()
    }
}