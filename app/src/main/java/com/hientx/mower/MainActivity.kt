package com.hientx.mower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "LogDestinationMower"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mower = Mower()
        val position = Position(1, 2, Orientation.N)
        Log.d(TAG, "Input position: $position")
        var log = "Input position: $position\n"

        val steps = listOf(Moving.L, Moving.F, Moving.L, Moving.F, Moving.L, Moving.F, Moving.L, Moving.F, Moving.F)
        Log.d(TAG, "Steps: $steps")
        log += "Steps: $steps\n"

        val newPosition = mower.getDestinationMower(position, steps)
        Log.d(TAG, "Destination position: $newPosition")
        log += "Destination position: $newPosition\n"

        findViewById<TextView>(R.id.log_textview).text = log
    }
}