package org.btelman.android.bluetooth.classic

import org.btelman.android.bluetooth.BluetoothInterface

/**
 * Created by Brendon on 12/23/2019.
 */
interface BluetoothClassicInterface : BluetoothInterface {
    fun writeBytes(bytes : ByteArray)

    /**
     * Lambda for receiving messages
     */
    fun onMessage(function : (bytes:ByteArray)->Unit)
}