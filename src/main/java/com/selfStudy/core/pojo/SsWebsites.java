package com.selfStudy.core.pojo;

import java.util.Date;

public class SsWebsites {
    private Integer id;

    private String websitesName;

    private String websitesUrl;

    private Integer stageId;

    private Date createTime;

    private Date updateTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebsitesName() {
        return websitesName;
    }

    public void setWebsitesName(String websitesName) {
        this.websitesName = websitesName == null ? null : websitesName.trim();
    }

    public String getWebsitesUrl() {
        return websitesUrl;
    }

    public void setWebsitesUrl(String websitesUrl) {
        this.websitesUrl = websitesUrl == null ? null : websitesUrl.trim();
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}