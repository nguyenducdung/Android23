package com.dungnd.android23;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dungnd.android23.buoi4.RecycleViewGridActivity;
import com.dungnd.android23.buoi4.RecycleViewHorizontalActivity;
import com.dungnd.android23.buoi4.RecycleViewMergeAdapterActivity;
import com.dungnd.android23.recycleview.RecycleViewActivity;

public class MainActivity extends AppCompatActivity {
    //Khi tạo biến trong activity thì chúng ta nên để private
    private Button btnClickMe;
    private TextView tvName;

    //Sự khác nhau giữa int và Integer là gì không?
    int position = 0; //kiểu số nguyên, không có trường hợp null (k có gì)
    Integer index = null; // có trường hợp null (rất dễ xảy ra crash khi sử dụng)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        debug();
        //Tên hàm sai,
//        TinhGiaTri();
        //Tên chuẩn
//        tinhGiaTri();
        //Link biến đến button ở giao diện xml
        btnClickMe = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        //Link biến đến textView ở giao diện xml
        tvName = findViewById(R.id.tvName);

        //1 button - nút bấm, sự kiện bấm
//        btnClickMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        btnClickMe.setOnClickListener(view -> {
            //Khi bấm button, anh muốn set tên mình vào text view
            //Khi bấm button, các sự kiện mà mình muốn sẽ đc xử lý ở đây
            //Sử dụng settext để ghi dữ liệu vào textView
//            tvName.setText("Nguyễn Đức dũng đang học android");


            //Khi bấm button, tăng position lên 1 đơn vị
//            position = position + 1;
//            //Khi các biến float, int, double, long + với 1 string -> kết quả sẽ ra là một string
//            tvName.setText("Đây là lần bấm thứ: " + position);

            //Xem các lỗi ở logcat: Verbose(hiển thị tất cả các log), error(hiển thị các log lỗi)

            //Một số bạn viết code không đẹp : chọn tất cả (Ctrl + A) -> Format code(Ctrl + Alt + L)

            //Khi bấm button, thì mở ra màn hình số 2
            // để mở ra màn hình mới thì chúng ta intent
//            Log.d("hihi", "hihi");
            Intent intent = new Intent(this, RecycleViewActivity.class);
            startActivity(intent);
            debug();
        });
        btn2.setOnClickListener(v -> {

            Intent intent = new Intent(this, RecycleViewHorizontalActivity.class);
            startActivity(intent);
        });
        btn3.setOnClickListener(v -> {

            Intent intent = new Intent(this, RecycleViewMergeAdapterActivity.class);
            startActivity(intent);
        });
    }

    private void debug() {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = result + i;
        }
        Log.d("hihiabc", result + "");
        Log.e("hihiabc", result + "");
    }
}