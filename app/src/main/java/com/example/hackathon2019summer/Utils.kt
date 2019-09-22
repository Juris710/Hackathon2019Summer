package com.example.hackathon2019summer

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException

fun openImageFromAssets(context:Context, imagePath: String): Bitmap? {
    val assets = context.assets
    try {
        assets.open(imagePath).use { `is` -> return BitmapFactory.decodeStream(`is`) }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return null
}
fun openResultOnClick(button: Button, extraValue: String){
    button.setOnClickListener {
        val i = Intent(button.context, ResultActivity::class.java).apply{
            putExtra(EXTRA_PERCENTAGE, extraValue)
        }
        button.context.startActivity(i)
    }
}
fun openActivityOnClick(button: Button, activityClass: Class<out AppCompatActivity>){
    button.setOnClickListener {
        val i = Intent(button.context, activityClass)
        button.context.startActivity(i)
    }
}
