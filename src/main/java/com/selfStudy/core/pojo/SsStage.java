package com.selfStudy.core.pojo;

public class SsStage {
    private Integer id;

    private String stageName;

    private Integer specialtyId;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName == null ? null : stageName.trim();
    }

    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}