package com.guidovezzoni.bingeworthyshow2.utils.extension

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


fun Context.getProviderAuthority(providerName: String): String {
    val componentName = ComponentName(this, providerName)
    val providerInfo = this.packageManager.getProviderInfo(componentName, 0)
    return providerInfo.authority
}

fun Activity.hasPermission(permission: String): Boolean =
    ContextCompat.checkSelfPermission(baseContext, permission) == PackageManager.PERMISSION_GRANTED

fun Activity.hasPermissions(permissions: Array<String>): Boolean =
    permissions.all { hasPermission(it) }


fun Fragment.hasPermission(permission: String): Boolean =
    ContextCompat.checkSelfPermission(
        requireContext(),
        permission
    ) == PackageManager.PERMISSION_GRANTED

fun Fragment.hasPermissions(permissions: Array<String>): Boolean =
    permissions.all { hasPermission(it) }


fun Activity.showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
fun Fragment.showToast(msg: String) =
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()


fun Window.setSystemUiColor(
    navigationBarColor: Int,
    statusBarIconsDark: Boolean,
    navigationBarIconsDark: Boolean
) {
    this.navigationBarColor = navigationBarColor
    setStatusBarIconsDark(statusBarIconsDark)
    setNavigationBarIconsDark(navigationBarIconsDark)
}

fun Window.setStatusBarIconsDark(iconsDark: Boolean) {
    setSystemUiFlag(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR, iconsDark)
}

fun Window.setNavigationBarIconsDark(iconsDark: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        setSystemUiFlag(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR, iconsDark)
    }
}

fun Window.setSystemUiFlag(flag: Int, add: Boolean) {
    val visibility = this.decorView.systemUiVisibility
    this.decorView.systemUiVisibility = if (add) visibility or flag else visibility and flag.inv()
}
