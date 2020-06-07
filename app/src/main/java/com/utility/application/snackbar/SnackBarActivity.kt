package com.utility.application.snackbar

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.utility.application.R
import com.utility.application.databinding.ActivitySnackbarBinding

class SnackBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val snackBarBinding: ActivitySnackbarBinding =
            DataBindingUtil.setContentView(this,
                R.layout.activity_snackbar
            )
        snackBarBinding.snackBar = this
    }

    fun onShowSnackBar(view: View) {
        Snackbar
            .make(
                findViewById(R.id.snackbarLayout),
                "hello this is a default snackbar",
                Snackbar.LENGTH_LONG
            ).show()
    }

    fun onShowToast(view: View) {
        Toast.makeText(
            this,
            "hello this is a default snackbar",
            Toast.LENGTH_LONG
        ).show()
    }

    fun onShowSnackBarWithAction(view: View) {
        Snackbar
            .make(
                findViewById(R.id.snackbarLayout),
                "hello this is a default snackbar",
                Snackbar.LENGTH_LONG
            ).let {
                it.setAction("undo") {
                    Toast.makeText(
                        this,
                        "undo successful",
                        Toast.LENGTH_LONG
                    ).show()
                }
                it.show()
            }
    }

    fun onShowSnackBarWithTextColor(view: View) {
        Snackbar
            .make(
                findViewById(R.id.snackbarLayout),
                "hello this is a default snackbar",
                Snackbar.LENGTH_LONG
            ).let {
                it.setAction("undo") {
                    Toast.makeText(
                        this,
                        "undo successful",
                        Toast.LENGTH_LONG
                    ).show()
                }
                it.setActionTextColor(Color.RED)
                it.setTextColor(Color.BLACK)
                it.setBackgroundTint(Color.YELLOW)
                it.show()
            }
    }
}