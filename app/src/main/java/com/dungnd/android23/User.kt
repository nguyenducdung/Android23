package com.dungnd.android23

import java.io.Serializable

data class User(var id : Int, var name : String, var address : String, var phone : String) : Serializable{
}