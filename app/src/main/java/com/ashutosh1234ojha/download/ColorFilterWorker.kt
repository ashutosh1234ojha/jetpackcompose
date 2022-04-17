package com.ashutosh1234ojha.download

import android.content.Context
import android.graphics.*
import androidx.core.net.toFile
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

/**
 * Created by Ashutosh Ojha on 26,March,2022
 */
class ColorFilterWorker(private val context: Context, private val workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        val imageFile = workerParams.inputData.getString("ImageUrl")?.toUri()?.toFile()

        delay(5000L)

        return imageFile?.let { file ->
            val bmp = BitmapFactory.decodeFile(file.absolutePath)
            val result = bmp.copy(bmp.config, true)
            val paint = Paint()
            paint.colorFilter = LightingColorFilter(0x08ff04, 1)
            val canvas = Canvas(result)
            canvas.drawBitmap(result, 0f, 0f, paint)

            withContext(Dispatchers.IO) {
                val resultImageFile = File(context.cacheDir, "newImage.jpg")
                val opsTREAM = FileOutputStream(resultImageFile)

                val successful = result.compress(Bitmap.CompressFormat.JPEG, 90, opsTREAM)

                if (successful) {
                    Result.success(
                        workDataOf("FilterUri" to imageFile.toUri().toString())
                    )
                } else {
                    Result.failure(
                        workDataOf("errorMsg" to "Failure")
                    )
                }
            }

        } ?: Result.failure(
            workDataOf("errorMsg" to "Failure")
        )
    }

}