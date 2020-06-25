package com.example.gak;

public class CarpOrders {

    public String cname,mbl,items,bill,flag,id;

    public CarpOrders(){}
    public CarpOrders(String cname, String mbl, String items, String bill,String flag,String id){
        this.cname=cname;
        this.mbl=mbl;
        this.items=items;
        this.bill=bill;
        this.id=id;
        this.flag=flag;
    }

    public String getCname() {
        return cname;
    }

    public String getBill() {
        return bill;
    }

    public String getItems() {
        return items;
    }

    public String getMbl() {
        return mbl;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public void setMbl(String mbl) {
        this.mbl = mbl;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
