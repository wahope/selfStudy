package com.selfStudy.core.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ：凌文
 * @ClassName SsSoftwareVo
 * @date ：Created in 2019/2/19 16:29
 * @description：SsSoftware的vo类
 * @modified By：
 * @version: $
 * @Class:
 */
public class SsSoftwareVo {
    private Integer id;

    private String softwareName;

    private Integer stageId;

    private String stageName;

    private String dowsoftUrl;

    private String sofinstallUrl;

    private String envconfigUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

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
        this.softwareName = softwareName;
    }

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getDowsoftUrl() {
        return dowsoftUrl;
    }

    public void setDowsoftUrl(String dowsoftUrl) {
        this.dowsoftUrl = dowsoftUrl;
    }

    public String getSofinstallUrl() {
        return sofinstallUrl;
    }

    public void setSofinstallUrl(String sofinstallUrl) {
        this.sofinstallUrl = sofinstallUrl;
    }

    public String getEnvconfigUrl() {
        return envconfigUrl;
    }

    public void setEnvconfigUrl(String envconfigUrl) {
        this.envconfigUrl = envconfigUrl;
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
        this.remark = remark;
    }
}
