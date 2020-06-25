package com.example.gak;

public class Orders {
    public String len,wid,num,color,gtype,gsize,mesh;
    public Orders(){}
    public Orders(String len,String wid,String num,String color,String gtype,String gsize,String mesh){
        this.len=len;
        this.wid=wid;
        this.num=num;
        this.color=color;
        this.gtype=gtype;
        this.gsize=gsize;
        this.mesh=mesh;
       // this.ordrecv=ordrecv;

    }

    public String getLen() {
        return len;
    }

    public void setLen(String len) {
        this.len = len;
    }

    public String getMesh() {
        return mesh;
    }

    public void setMesh(String mesh) {
        this.mesh = mesh;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public String getGsize() {
        return gsize;
    }

    public void setGsize(String gsize) {
        this.gsize = gsize;
    }


}
