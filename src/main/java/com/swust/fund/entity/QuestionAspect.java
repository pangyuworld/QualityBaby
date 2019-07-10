package com.swust.fund.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author pang
 * @version V1.0
 * @ClassName: QuestionAspect
 * @Package com.swust.fund.entity
 * @description: 返回的真实的问卷实例
 * @date 2019/7/9 9:48
 */
@ApiModel("问题和影响方面对应表，属于问题的子表")
public class QuestionAspect {

    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("影响方面ID")
    private Integer aspectId;
    @ApiModelProperty("影响方面名字")
    private String aspectName;
    @ApiModelProperty("是否是正面影响。即加分")
    private Boolean isWell;

    public Integer getAspectId() {
        return aspectId;
    }

    public void setAspectId(Integer aspectId) {
        this.aspectId = aspectId;
    }

    public String getAspectName() {
        return aspectName;
    }

    public void setAspectName(String aspectName) {
        this.aspectName = aspectName;
    }

    public Boolean getWell() {
        return isWell;
    }

    public void setWell(Boolean well) {
        isWell = well;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
