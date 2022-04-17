package com.ashutosh1234ojha.download

import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.ashutosh1234ojha.jetpackcompose.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlin.random.Random

/**
 * Created by Ashutosh Ojha on 26,March,2022
 */
class DownloadWorker(val context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {

        startForegroundService()
        delay(5000L)
        val res = RetrofitClient.getClient().downloadImage()
        res.body()?.let { responseBody ->
            return withContext(Dispatchers.IO) {
                val file = File(context.cacheDir,"image.jpeg")
                val outputStream = FileOutputStream(file.toString())
                outputStream.use { stream ->
                    try {
                        stream.write(responseBody.bytes())
                    } catch (io: IOException) {
                        return@withContext Result.failure(
                            workDataOf("errorMsg" to io.toString())
                        )
                    }
                    return@withContext Result.success(
                        workDataOf("imageUrl" to  file.toURI().toString())
                    )
                }
            }
        }

        if(!res.isSuccessful){
            if(res.code().toString().startsWith("500")){
                return Result.retry()
            }
            return Result.failure(
                workDataOf("errorMsg" to "Network error")
            )
        }
        return Result.failure(
            workDataOf("errorMsg" to "Unknown error")
        )

    }

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