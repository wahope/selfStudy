package com.selfStudy.core.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/2/27 8:06
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
public class SsWebsitesVo {
    private Integer id;

    private String websitesName;

    private String websitesUrl;

    private Integer stageId;

    private String stageName;

    //date转换成String
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
        this.websitesName = websitesName;
    }

    public String getWebsitesUrl() {
        return websitesUrl;
    }

    public void setWebsitesUrl(String websitesUrl) {
        this.websitesUrl = websitesUrl;
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
