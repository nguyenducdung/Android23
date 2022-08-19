package com.dungnd.android23.buoi4;

class Product {
   private String name;
   private Long money;

   public Product(String name, Long money) {
      this.name = name;
      this.money = money;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Long getMoney() {
      return money;
   }

   public void setMoney(Long money) {
      this.money = money;
   }
}
