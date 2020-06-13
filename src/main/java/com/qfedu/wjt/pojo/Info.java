package com.qfedu.wjt.pojo;

import java.util.Date;

public class Info {
    private int id;
    private String projectName;
    private String vested;
    private String idCard;
    private String housingTypes;
    private int usableArea;
    private Date constructionTime;

    public Info() {
    }

    public Info(int id, String projectName, String vested, String idCard, String housingTypes, int usableArea, Date constructionTime) {
        this.id = id;
        this.projectName = projectName;
        this.vested = vested;
        this.idCard = idCard;
        this.housingTypes = housingTypes;
        this.usableArea = usableArea;
        this.constructionTime = constructionTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getVested() {
        return vested;
    }

    public void setVested(String vested) {
        this.vested = vested;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getHousingTypes() {
        return housingTypes;
    }

    public void setHousingTypes(String housingTypes) {
        this.housingTypes = housingTypes;
    }

    public int getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(int usableArea) {
        this.usableArea = usableArea;
    }

    public Date getConstructionTime() {
        return constructionTime;
    }

    public void setConstructionTime(Date constructionTime) {
        this.constructionTime = constructionTime;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", vested='" + vested + '\'' +
                ", idCard='" + idCard + '\'' +
                ", housingTypes='" + housingTypes + '\'' +
                ", usableArea=" + usableArea +
                ", constructionTime=" + constructionTime +
                '}';
    }
}
