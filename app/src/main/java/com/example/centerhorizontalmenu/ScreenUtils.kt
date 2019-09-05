package com.example.centerhorizontalmenu

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.WindowManager

/**
 * Created by Rayaane Abdessmad on 04/09/19.
 */
class ScreenUtils {
    companion object {

        fun getScreenWidth(context: Context): Int {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val dm = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(dm)
            return dm.widthPixels
        }

        fun dpToPx(context: Context, value: Int) : Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value.toFloat(), context.resources.displayMetrics).toInt()
        }
    }
}