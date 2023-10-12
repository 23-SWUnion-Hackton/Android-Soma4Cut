package com.staker4wapper.android_soma4cut.utils

import android.content.Context
import android.widget.Toast

fun makeToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}