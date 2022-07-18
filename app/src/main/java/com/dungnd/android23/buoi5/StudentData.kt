package com.dungnd.android23.buoi5

//Thường sử dụng khi các bạn tạo model từ api trả về
data class StudentData(
    var name: String,
    var age: String
) {
    var high: Int = 0

    fun inraChieuCao() {
        println("$name: $high")
    }
}
