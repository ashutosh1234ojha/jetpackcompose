package com.ashutosh1234ojha.download

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.work.*
import coil.compose.rememberImagePainter
import com.ashutosh1234ojha.download.room.CourseDatabase

/**
 * Created by Ashutosh Ojha on 26,March,2022
 */
class WorkerActivityLight : AppCompatActivity() {
    private val DarkColorPalette = darkColors(
        primary = Color.Red,
        primaryVariant = Color.Red,
        secondary = Color.Red
    )

    private val LightColorPalette = lightColors(
        primary = Color.Red,
        primaryVariant = Color.Red,
        secondary = Color.Red

        /* Other default colors to override
        background = Color.White,
        surface = Color.White,
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black,
        */
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val downloadRequest =
            OneTimeWorkRequestBuilder<DownloadWorkerLight>().setConstraints(
                Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            ).build()

//        val colorRequest =
//            OneTimeWorkRequestBuilder<ColorFilterWorker>().build()

        val workManager = WorkManager.getInstance(applicationContext)
        setContent {
            WorkManagerGuideTheme(false) {

                val workInfo =
                    workManager.getWorkInfosForUniqueWorkLiveData("download")
                        .observeAsState().value

                val downloadInfo = remember(key1 = workInfo) {
                    workInfo?.find { it.id == downloadRequest.id }
                }

//                val filterInfo = remember(key1 = workInfo) {
//                    workInfo?.find { it.id == colorRequest.id }
//                }

                val imageUri by derivedStateOf {
                    val downloadUri = downloadInfo?.outputData?.getString("imageUrl")?.toUri()
                    //   val filterUri = filterInfo?.outputData?.getString("FilterUri")?.toUri()

//                    filterUri ?: downloadUri
                    downloadUri

                }




                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    imageUri?.let {
                        Image(
                            painter = rememberImagePainter(data = it),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                    Spacer(modifier = Modifier.height(100.dp))

                    Button(
                        onClick = {
                            workManager.beginUniqueWork(
                                "download",
                                ExistingWorkPolicy.KEEP, downloadRequest
                            )
//                                .then(colorRequest)
                                .enqueue()
                        },
                    ) {
                        Text(text = "Download")
                    }
                    Spacer(modifier = Modifier.height(100.dp))

                    Button(
                        onClick = {
                            val dbb = CourseDatabase.getInstance(this@WorkerActivityLight)?.Dao()
                                ?.getAllCourses()?.observe(this@WorkerActivityLight, Observer { list->

                                    for(dd in list!!){

                                        Log.d("Vadasfd",dd!!.data!!)

                                    }
                                })


                        },
                    ) {
                        Text(text = "Get")
                    }
                    Spacer(modifier = Modifier.height(100.dp))

                    when (downloadInfo?.state) {

                        WorkInfo.State.RUNNING -> Text(text = "Downloading...")
                        WorkInfo.State.SUCCEEDED -> Text(text = "Download Succeeded")
                        WorkInfo.State.FAILED -> Text(text = "Download Failed")
                        WorkInfo.State.CANCELLED -> Text(text = "Download CANCELLED")
                        WorkInfo.State.ENQUEUED -> Text(text = "Download Enqueued")
                        WorkInfo.State.BLOCKED -> Text(text = "Download BLOCKED")

                    }

                    Spacer(modifier = Modifier.height(100.dp))


//                    when (filterInfo?.state) {
//
//                        WorkInfo.State.RUNNING -> Text(text = "Applying filter...")
//                        WorkInfo.State.SUCCEEDED -> Text(text = "Filter Succeeded")
//                        WorkInfo.State.FAILED -> Text(text = "Filter Failed")
//                        WorkInfo.State.CANCELLED -> Text(text = "Filter CANCELLED")
//                        WorkInfo.State.ENQUEUED -> Text(text = "Filter Enqueued")
//                        WorkInfo.State.BLOCKED -> Text(text = "Filter BLOCKED")
//
//                    }

                }
            }
        }
    }

    @Composable
    fun WorkManagerGuideTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {
        val colors = if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

        MaterialTheme(
            colors = colors,
//            typography = Typography,
//            shapes = Shapes,
            content = content
        )
    }
}