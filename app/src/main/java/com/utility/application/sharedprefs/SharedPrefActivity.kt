package com.utility.application.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.utility.application.R
import kotlinx.android.synthetic.main.activity_shared_pref.*


class SharedPrefActivity : AppCompatActivity() {
    // Current count
    private var mCount = 0

    // Current background color
    private var mColor = 0

    // Key for current count
    private val COUNT_KEY = "count"

    // Key for current color
    private val COLOR_KEY = "color"

    private var mPreferences: SharedPreferences? = null
    private val sharedPrefFile = "com.utility.application.sharedprefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        // Initialize views, color
        mColor = ContextCompat.getColor(
            this,
            R.color.default_background
        )

        mPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        // Restore the saved instance state.
        mPreferences?.let {
            mCount = it.getInt(COUNT_KEY, 0)
            if (mCount != 0) {
                count_textview?.text = String.format("%s", mCount)
            }
            mColor = it.getInt(COLOR_KEY, mColor)
            count_textview?.setBackgroundColor(mColor)
        }
    }

    /**
     * Handles the onClick for the background color buttons. Gets background
     * color of the button that was clicked, and sets the TextView background
     * to that color.
     *
     * @param view The view (Button) that was clicked.
     */
    fun changeBackground(view: View) {
        val color = (view.getBackground() as ColorDrawable).color
        count_textview!!.setBackgroundColor(color)
        mColor = color
    }

    /**
     * Handles the onClick for the Count button. Increments the value of the
     * mCount global and updates the TextView.
     *
     * @param view The view (Button) that was clicked.
     */
    fun countUp(view: View?) {
        mCount++
        count_textview!!.text = String.format("%s", mCount)
    }

    /**
     * Saves the instance state if the activity is restarted (for example,
     * on device rotation.) Here you save the values for the count and the
     * background color.
     *
     * @param outState The state data.
     */

    override fun onPause() {
        super.onPause()
        mPreferences?.edit()?.apply {
            this.putInt(COUNT_KEY, mCount)
            this.putInt(COLOR_KEY, mColor)
            this.apply()
        }
    }

    /**
     * Handles the onClick for the Reset button. Resets the global count and
     * background variables to the defaults and resets the views to those
     * default values.
     *
     * @param view The view (Button) that was clicked.
     */
    fun reset(view: View?) {
        // Reset count
        mCount = 0
        count_textview!!.text = String.format("%s", mCount)

        // Reset color
        mColor = ContextCompat.getColor(
            this,
            R.color.default_background
        )
        count_textview!!.setBackgroundColor(mColor)

        mPreferences?.edit()?.apply {
            this.clear()
            this.apply()
        }
    }
}