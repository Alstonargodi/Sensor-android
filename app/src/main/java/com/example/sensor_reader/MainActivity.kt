package com.example.sensor_reader

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sensor_reader.ui.theme.SensorreaderTheme

class MainActivity : ComponentActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var mAccelerometer: Sensor? = null
    private var sensorEvent : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        setContent {
            SensorreaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Layout(name = sensorEvent.toString())
                }
            }
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            sensorEvent = event.values[0].toString()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }
}

@Composable
fun Layout(name: String, modifier: Modifier = Modifier) {
    Column(){
        Text(text = "sensor test:")
        Text(
            text = "Sensor $name!",
            modifier = modifier
        )
    }
}

@Composable
fun SetSensor(sensorManager : SensorManager){
    Button(
        onClick = { /*TODO*/ }
    ) {
        Text(text = "button click")
    }
}



@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun GreetingPreview() {
    SensorreaderTheme {
        Layout("Android")
    }
}