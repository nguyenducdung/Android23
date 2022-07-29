package com.dungnd.android23.buoi8

import android.view.View
import android.widget.Toast
import com.dungnd.android23.SingleClickListener
import com.dungnd.android23.SingleClickListenerKotlin

//findViewById(R.id.btnKotlin).setOnClickListener(new SingleClickListener() {
//    @Override
//    public void onClick(View view) {
//        super.onClick(view);
//
//        startActivity(new Intent(MainActivity.this, KotlinActivity.class));
//    }
//});

fun View.setOnSingleClick(onClick: ((View?) -> Unit)) {
    setOnClickListener(object : SingleClickListener() {
        override fun onClick(view: View?) {
            super.onClick(view)
            onClick.invoke(view)
        }
    })
}

fun View.toastLinhTinh() {
    Toast.makeText(context, "Hihi", Toast.LENGTH_LONG).show()
}