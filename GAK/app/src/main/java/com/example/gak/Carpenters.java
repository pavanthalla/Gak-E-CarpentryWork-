package com.example.gak;

public class Carpenters {
    public String name;
    public String price,price2,price3,price4;
    public String age,ordrecv,email,area,phn;

    public Carpenters(){}
    public Carpenters(String name,String phn,String price,String age,String price2,String price3,String price4,String ordrecv,String email,String area){
        this.name=name;
        this.price=price;
        this.price2=price2;
        this.price3=price3;
        this.price4=price4;
        this.age=age;
        this.ordrecv=ordrecv;
        this.email=email;
        this.area=area;
        this.phn=phn;
    }
    public String  getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPrice2() {
        return price2;
    }

    public String getPrice3() {
        return price3;
    }

    public String getPrice4() {
        return price4;
    }

    public void setPrice4(String price4) {
        this.price4 = price4;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
    }

    public void setOrdrecv(String ordrecv) {
        this.ordrecv = ordrecv;
    }

    public String getOrdrecv() {
        return ordrecv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getPhn() {
        return phn;
    }
}
