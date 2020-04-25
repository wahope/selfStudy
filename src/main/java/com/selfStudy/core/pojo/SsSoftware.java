package com.selfStudy.core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.selfStudy.common.DateUtil;

import java.sql.Timestamp;
import java.util.Date;

public class SsSoftware {
    private Integer id;

    private String softwareName;

    private Integer stageId;

    private String dowsoftUrl;

    private String sofinstallUrl;

    private String envconfigUrl;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String  createTime;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String updateTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName == null ? null : softwareName.trim();
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getDowsoftUrl() {
        return dowsoftUrl;
    }

    public void setDowsoftUrl(String dowsoftUrl) {
        this.dowsoftUrl = dowsoftUrl == null ? null : dowsoftUrl.trim();
    }

    public String getSofinstallUrl() {
        return sofinstallUrl;
    }

    public void setSofinstallUrl(String sofinstallUrl) {
        this.sofinstallUrl = sofinstallUrl == null ? null : sofinstallUrl.trim();
    }

    public String getEnvconfigUrl() {
        return envconfigUrl;
    }

    public void setEnvconfigUrl(String envconfigUrl) {
        this.envconfigUrl = envconfigUrl == null ? null : envconfigUrl.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = DateUtil.dateToString(createTime);
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = DateUtil.dateToString(updateTime);
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}