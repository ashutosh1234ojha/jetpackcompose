package com.ashutosh1234ojha.download

import android.content.Context
import android.os.CountDownTimer
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.ashutosh1234ojha.download.room.CourseDatabase
import com.ashutosh1234ojha.download.room.CourseModal
import com.ashutosh1234ojha.jetpackcompose.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

/**
 * Created by Ashutosh Ojha on 26,March,2022
 */
class DownloadWorkerLight(val context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
      //  startForegroundService()
//        val timer = object : CountDownTimer(60 * 1000L, 60 * 60 * 1000L) {
//            override fun onTick(millisUntilFinished: Long) {
//                val db = CourseDatabase.getInstance(context = context) as CourseDatabase
//                val s = SimpleDateFormat("dd/MM/yyyy/hh:mm:ss", Locale.ENGLISH)
//                val format: String = s.format(Date())
//                val ob = CourseModal(data = format)
//                db.Dao().insert(ob)
//            }
//
//            override fun onFinish() {
//            }
//        }
//        timer.start()
        val count = System.currentTimeMillis();
        var newCount = System.currentTimeMillis();
        Log.d("count", count.toString())



        while (newCount - count < 60 * 60 * 1000) {
            val db = CourseDatabase.getInstance(context = context) as CourseDatabase
            val s = SimpleDateFormat("dd/MM/yyyy/hh:mm:ss", Locale.ENGLISH)
            val format: String = s.format(Date())
            val ob = CourseModal(data = format)
            db.Dao().insert(ob)

            delay(60 * 1000L)
            newCount = System.currentTimeMillis()
            Log.d("NewCount", newCount.toString())
        }

        delay(60 * 60 * 1000L)
        return Result.success(
            workDataOf("imageUrl" to "Done")
        )
    }
//    override suspend fun doWork(): Result {
//
//     //   startForegroundService()
//        delay(50000L)
//        val res = RetrofitClient.getClient().downloadImage()
//        res.body()?.let { responseBody ->
//            try {
//                val file = File(context.cacheDir, "image.jpeg")
//                val outputStream = FileOutputStream(file.toString())
//                outputStream.write(responseBody.bytes())
//                return Result.success(
//                    workDataOf("imageUrl" to file.toURI().toString())
//                )
//            } catch (io: IOException) {
//                return Result.failure(
//                    workDataOf("errorMsg" to io.toString())
//                )
//            }
//
////            return withContext(Dispatchers.IO) {
////                val file = File(context.cacheDir,"image.jpeg")
////                val outputStream = FileOutputStream(file.toString())
////                outputStream.use { stream ->
////                    try {
////                        stream.write(responseBody.bytes())
////                    } catch (io: IOException) {
////                        return@withContext Result.failure(
////                            workDataOf("errorMsg" to io.toString())
////                        )
////                    }
////                    return@withContext Result.success(
////                        workDataOf("imageUrl" to  file.toURI().toString())
////                    )
////                }
////            }
//        }
//
//        if (!res.isSuccessful) {
//            if (res.code().toString().startsWith("500")) {
//                return Result.retry()
//            }
//            return Result.failure(
//                workDataOf("errorMsg" to "Network error")
//            )
//        }
//        return Result.failure(
//            workDataOf("errorMsg" to "Unknown error")
//        )
//
//    }

    private suspend fun startForegroundService() {
        setForeground(
            ForegroundInfo(
                Random.nextInt(),
                NotificationCompat.Builder(applicationContext, "download_change")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentText("Downloading...").setContentTitle("Download In Progress")
                    .build()
            )
        )
    }
}