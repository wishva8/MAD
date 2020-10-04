package com.example.mad;

public class details {
    private String Name;
    private  String NIC;
    private  String Eddress;
    private  String Age;
    private  Integer CNo;

    public details() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getEddress() {
        return Eddress;
    }

    public void setEddress(String eddress) {
        Eddress = eddress;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public Integer getCNo() {
        return CNo;
    }

    public void setCNo(Integer CNo) {
        this.CNo = CNo;
    }
}
