package com.rizlee.sample

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rizlee.handler.PermissionHandler

private val PERMISSIONS = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestPermissions()
    }

    private fun requestPermissions() =
        PermissionHandler.requestPermission(this, { permissionsGranted() }, PERMISSIONS)

    private fun permissionsGranted() =
        Toast.makeText(applicationContext, "permissions granted", Toast.LENGTH_SHORT).show()

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        PermissionHandler.permissionsResult(
            this,
            PERMISSIONS,
            requestCode,
            grantResults,
            { permissionsGranted() },
            { Toast.makeText(applicationContext, "permissions unsuccess", Toast.LENGTH_SHORT).show() },
            { Toast.makeText(applicationContext, "permissions error", Toast.LENGTH_SHORT).show() }
        )
    }
}
