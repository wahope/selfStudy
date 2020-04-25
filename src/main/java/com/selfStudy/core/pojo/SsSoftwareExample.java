package com.selfStudy.core.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SsSoftwareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SsSoftwareExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameIsNull() {
            addCriterion("software_name is null");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameIsNotNull() {
            addCriterion("software_name is not null");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameEqualTo(String value) {
            addCriterion("software_name =", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameNotEqualTo(String value) {
            addCriterion("software_name <>", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameGreaterThan(String value) {
            addCriterion("software_name >", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameGreaterThanOrEqualTo(String value) {
            addCriterion("software_name >=", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameLessThan(String value) {
            addCriterion("software_name <", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameLessThanOrEqualTo(String value) {
            addCriterion("software_name <=", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameLike(String value) {
            addCriterion("software_name like", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameNotLike(String value) {
            addCriterion("software_name not like", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameIn(List<String> values) {
            addCriterion("software_name in", values, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameNotIn(List<String> values) {
            addCriterion("software_name not in", values, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameBetween(String value1, String value2) {
            addCriterion("software_name between", value1, value2, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameNotBetween(String value1, String value2) {
            addCriterion("software_name not between", value1, value2, "softwareName");
            return (Criteria) this;
        }

        public Criteria andStageIdIsNull() {
            addCriterion("stage_id is null");
            return (Criteria) this;
        }

        public Criteria andStageIdIsNotNull() {
            addCriterion("stage_id is not null");
            return (Criteria) this;
        }

        public Criteria andStageIdEqualTo(Integer value) {
            addCriterion("stage_id =", value, "stageId");
            return (Criteria) this;
        }

        public Criteria andStageIdNotEqualTo(Integer value) {
            addCriterion("stage_id <>", value, "stageId");
            return (Criteria) this;
        }

        public Criteria andStageIdGreaterThan(Integer value) {
            addCriterion("stage_id >", value, "stageId");
            return (Criteria) this;
        }

        public Criteria andStageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stage_id >=", value, "stageId");
            return (Criteria) this;
        }

        public Criteria andStageIdLessThan(Integer value) {
            addCriterion("stage_id <", value, "stageId");
            return (Criteria) this;
        }

        public Criteria andStageIdLessThanOrEqualTo(Integer value) {
            addCriterion("stage_id <=", value, "stageId");
            return (Criteria) this;
        }

        public Criteria andStageIdIn(List<Integer> values) {
            addCriterion("stage_id in", values, "stageId");
            return (Criteria) this;
        }

        public Criteria andStageIdNotIn(List<Integer> values) {
            addCriterion("stage_id not in", values, "stageId");
            return (Criteria) this;
        }

        public Criteria andStageIdBetween(Integer value1, Integer value2) {
            addCriterion("stage_id between", value1, value2, "stageId");
            return (Criteria) this;
        }

        public Criteria andStageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stage_id not between", value1, value2, "stageId");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlIsNull() {
            addCriterion("dowsoft_url is null");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlIsNotNull() {
            addCriterion("dowsoft_url is not null");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlEqualTo(String value) {
            addCriterion("dowsoft_url =", value, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlNotEqualTo(String value) {
            addCriterion("dowsoft_url <>", value, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlGreaterThan(String value) {
            addCriterion("dowsoft_url >", value, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlGreaterThanOrEqualTo(String value) {
            addCriterion("dowsoft_url >=", value, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlLessThan(String value) {
            addCriterion("dowsoft_url <", value, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlLessThanOrEqualTo(String value) {
            addCriterion("dowsoft_url <=", value, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlLike(String value) {
            addCriterion("dowsoft_url like", value, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlNotLike(String value) {
            addCriterion("dowsoft_url not like", value, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlIn(List<String> values) {
            addCriterion("dowsoft_url in", values, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlNotIn(List<String> values) {
            addCriterion("dowsoft_url not in", values, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlBetween(String value1, String value2) {
            addCriterion("dowsoft_url between", value1, value2, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andDowsoftUrlNotBetween(String value1, String value2) {
            addCriterion("dowsoft_url not between", value1, value2, "dowsoftUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlIsNull() {
            addCriterion("sofinstall_url is null");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlIsNotNull() {
            addCriterion("sofinstall_url is not null");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlEqualTo(String value) {
            addCriterion("sofinstall_url =", value, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlNotEqualTo(String value) {
            addCriterion("sofinstall_url <>", value, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlGreaterThan(String value) {
            addCriterion("sofinstall_url >", value, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sofinstall_url >=", value, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlLessThan(String value) {
            addCriterion("sofinstall_url <", value, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlLessThanOrEqualTo(String value) {
            addCriterion("sofinstall_url <=", value, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlLike(String value) {
            addCriterion("sofinstall_url like", value, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlNotLike(String value) {
            addCriterion("sofinstall_url not like", value, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlIn(List<String> values) {
            addCriterion("sofinstall_url in", values, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlNotIn(List<String> values) {
            addCriterion("sofinstall_url not in", values, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlBetween(String value1, String value2) {
            addCriterion("sofinstall_url between", value1, value2, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andSofinstallUrlNotBetween(String value1, String value2) {
            addCriterion("sofinstall_url not between", value1, value2, "sofinstallUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlIsNull() {
            addCriterion("envconfig_url is null");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlIsNotNull() {
            addCriterion("envconfig_url is not null");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlEqualTo(String value) {
            addCriterion("envconfig_url =", value, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlNotEqualTo(String value) {
            addCriterion("envconfig_url <>", value, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlGreaterThan(String value) {
            addCriterion("envconfig_url >", value, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlGreaterThanOrEqualTo(String value) {
            addCriterion("envconfig_url >=", value, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlLessThan(String value) {
            addCriterion("envconfig_url <", value, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlLessThanOrEqualTo(String value) {
            addCriterion("envconfig_url <=", value, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlLike(String value) {
            addCriterion("envconfig_url like", value, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlNotLike(String value) {
            addCriterion("envconfig_url not like", value, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlIn(List<String> values) {
            addCriterion("envconfig_url in", values, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlNotIn(List<String> values) {
            addCriterion("envconfig_url not in", values, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlBetween(String value1, String value2) {
            addCriterion("envconfig_url between", value1, value2, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andEnvconfigUrlNotBetween(String value1, String value2) {
            addCriterion("envconfig_url not between", value1, value2, "envconfigUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}