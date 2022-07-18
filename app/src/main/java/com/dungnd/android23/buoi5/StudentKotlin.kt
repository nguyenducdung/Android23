package com.dungnd.android23.buoi5

class StudentKotlin constructor(var high: Int,
                                gender: String = "name"): StudentBase() {

    var name: String = ""
    var age: Int = 0

    init {
        //Đây là hàm được gọi khi bắt đầu khởi tạo đối tượng
        age = 100
    }

}