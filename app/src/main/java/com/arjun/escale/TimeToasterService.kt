package com.arjun.escale

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.widget.Toast
import androidx.core.app.JobIntentService
import java.util.*

class TimeToasterService : JobIntentService() {

    private val handler = Handler()
    private val timer by lazy { Timer() }

    inner class TimeToaster : TimerTask() {
        override fun run() {
            handler.post {
                Toast.makeText(this@TimeToasterService, "", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onHandleWork(intent: Intent) {
        timer.scheduleAtFixedRate(TimeToaster(), 0, INTERVAL)
    }

    companion object {
        private const val JOB_ID = 1001
        private const val INTERVAL = 60_000L
        fun enqueue(context: Context, intent: Intent) {
            enqueueWork(context, TimeToasterService::class.java, JOB_ID, intent)
        }
    }

}