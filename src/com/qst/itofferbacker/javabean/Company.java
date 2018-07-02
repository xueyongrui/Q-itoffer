package com.qst.itofferbacker.javabean;

import javax.servlet.http.Part;

public class Company {

    private int companyId;
    private String companyName;
    private String companyArea;
    private String companySize;
    private String companyType;
    private int companyState;
    private String companyBrief;
    private int companySort;
    private String companyPicpathName;
    private Part companyPic;
    private int companyViewnum;


    public Company() {

    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyArea() {
        return companyArea;
    }

    public void setCompanyArea(String companyArea) {
        this.companyArea = companyArea;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public int getCompanyState() {
        return companyState;
    }

    public void setCompanyState(int companyState) {
        this.companyState = companyState;
    }

    public String getCompanyBrief() {
        return companyBrief;
    }

    public void setCompanyBrief(String companyBrief) {
        this.companyBrief = companyBrief;
    }

    public int getCompanySort() {
        return companySort;
    }

    public void setCompanySort(int companySort) {
        this.companySort = companySort;
    }

    public void setCompanyPic(Part companyPic) {
        this.companyPic = companyPic;
    }

    public Part getCompanyPic() {
        return companyPic;
    }

    public String getcompanyPicpathName() {
        return companyPicpathName;
    }

    public void setcompanyPicpathName(String companyPicpath) {
        this.companyPicpathName = companyPicpath;
    }

    public int getCompanyViewnum() {
        return companyViewnum;
    }

    public void setCompanyViewnum(int companyViewnum) {
        this.companyViewnum = companyViewnum;
    }
}
