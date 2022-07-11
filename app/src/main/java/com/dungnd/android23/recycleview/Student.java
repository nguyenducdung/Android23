package com.dungnd.android23.recycleview;

class Student {
   private String name;
   private int age;
   private String mssv;
   private String address;

   public Student(String name, int age, String mssv, String address) {
      this.name = name;
      this.age = age;
      this.mssv = mssv;
      this.address = address;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getMssv() {
      return mssv;
   }

   public void setMssv(String mssv) {
      this.mssv = mssv;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}
