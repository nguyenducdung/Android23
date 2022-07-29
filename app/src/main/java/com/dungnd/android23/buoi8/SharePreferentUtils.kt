package com.dungnd.android23.buoi8

import android.content.Context
import android.content.Context.MODE_PRIVATE

object SharePreferentUtils {

    fun saveName(name: String, context: Context) {
        //Lệnh lấy preferences bằng context
        val preferences = context.getSharedPreferences("abc", MODE_PRIVATE)
        //lưu dữ liệu string bằng key "name"
        preferences.edit().putString("name", name).apply()
    }

    fun getName(context: Context): String {
        //Lệnh lấy preferences bằng context
        val preferences = context.getSharedPreferences("abc", MODE_PRIVATE)
        //lay dữ liệu
        return preferences.getString("name", "") ?:""
    }
}