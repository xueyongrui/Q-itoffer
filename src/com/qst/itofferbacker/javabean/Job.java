package com.qst.itofferbacker.javabean;

public class Job {
    private int jobId;
    private int companyId;
    private String jobName;
    private int jobHiringnum;
    private String jobSalary;
    private String jobArea;
    private String jobDesc;
    private String jobEndtime;
    private int jobState;
    private String jobBelongtoCompany;

    public Job(){

    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobHiringnum() {
        return jobHiringnum;
    }

    public void setJobHiringnum(int jobHiringnum) {
        this.jobHiringnum = jobHiringnum;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobArea() {
        return jobArea;
    }

    public void setJobArea(String jobArea) {
        this.jobArea = jobArea;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobEndtime() {
        return jobEndtime;
    }

    public void setJobEndtime(String jobEndtime) {
        this.jobEndtime = jobEndtime;
    }

    public int getJobState() {
        return jobState;
    }

    public void setJobState(int jobState) {
        this.jobState = jobState;
    }

    public String getJobBelongtoCompany() {
        return jobBelongtoCompany;
    }

    public void setJobBelongtoCompany(String jobBelongtoCompany) {
        this.jobBelongtoCompany = jobBelongtoCompany;
    }
}
