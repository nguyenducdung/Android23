package com.dungnd.android23.buoi7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.dungnd.android23.R

/**
 * A simple [Fragment] subclass.
 * Use the [Buoi7Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Buoi7Fragment : Fragment() {

    companion object {
        //Viết các key, các hằng
        const val NAME = "Nguyễn Dức Dũng"

        //Viết trong đây dễ maintain code
        fun newFragment(data: String): Buoi7Fragment {
            val fragment = Buoi7Fragment()
            val bundle = Bundle()
            bundle.putString("key5", data)
            bundle.putString("key6", data)
            bundle.putString("key7", data)
            bundle.putString("key8", data)
            bundle.putString("key9", data)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var btnClickMe: Button? = null

    //Khởi tạo 1 fragment đc gọi 1 lần
    //set Style, theme cho từng fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //Tạo view cho fragment
    //Chỉ được gọi 1 lần
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buoi7, container, false)
    }

    //KHi view đc khởi tạo xong
    //Khởi tạo các dữ liệu, gọi api, findViewbyId
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Muốn gọi activity cha, sau đó ép kiểu về activty mà chúng ta muốn
        //Bị lỗi khi cái activity đó ép kiểu về bị null
//        (activity as Buoi7Activity) ép kiểu từ activity về Buoi7Activity,

        //Trong trường hợp ép kiểu thất bại thì kết quả trả về là null
        (activity as? Buoi7Activity)?.toastLinhTinh("hihi")

        btnClickMe = view.findViewById(R.id.btnClickMe)
        btnClickMe?.setOnClickListener {
            (activity as? Buoi7Activity)?.toastLinhTinh("Đây là truyền dữ liệu")
            (activity as? Buoi7Activity)?.so = "2"
        }
        val text = arguments?.getString("key5", "")
        btnClickMe?.text = text
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    //Phải huỷ view trước huỷ fragment
    //Các bạn cần lấy 1 số dữ liệu từ trên view trước khi chúng bị huỷ
    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    //Detach khỏi activity
    override fun onDetach() {
        super.onDetach()
    }

}