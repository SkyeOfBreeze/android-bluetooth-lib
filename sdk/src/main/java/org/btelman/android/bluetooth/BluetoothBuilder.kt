package org.btelman.android.bluetooth

import android.bluetooth.BluetoothDevice
import android.content.Context
import androidx.annotation.IntDef
import org.btelman.android.bluetooth.classic.BluetoothClassic
import org.btelman.android.bluetooth.le.BluetoothLESerial

/**
 * Created by Brendon on 12/22/2019.
 */
data class BluetoothBuilder(
    val context: Context,
    val device : BluetoothDevice,
    @Type
    val type : Int
){
    fun build() : BluetoothInterface {
        return when(type){
            TYPE_CLASSIC -> {
                BluetoothClassic(device.address)
            }
            TYPE_GATT_LE -> {
                BluetoothLESerial(context, device.address)
            }
            else -> throw ExceptionInInitializerError("type does not match!")
        }
    }

    companion object{
        const val TYPE_CLASSIC = 0
        const val TYPE_GATT_LE = 1
    }

    @IntDef(
        TYPE_CLASSIC,
        TYPE_GATT_LE
    )
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    annotation class Type
}

