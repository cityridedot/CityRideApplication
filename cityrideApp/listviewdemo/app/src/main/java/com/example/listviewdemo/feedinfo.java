package com.example.listviewdemo;

public class feedinfo {
    private String  fname,femail,fdescription;

    public feedinfo() {

    }

    /*public feedinfo(String fname, String femail, String fdescription) {
        this.fname = fname;
        this.femail = femail;
        this.fdescription = fdescription;
    }*/

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFemail() {
        return femail;
    }

    public void setFemail(String femail) {
        this.femail = femail;
    }

    public String getFdescription() {
        return fdescription;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }
}
