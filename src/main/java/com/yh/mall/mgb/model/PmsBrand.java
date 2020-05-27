package com.yh.mall.mgb.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author YangHao
 * @ClassName: PmsBrand
 * @Description: TODO
 * @date 2020/5/26 17:02
 * @Version V1.0
 */
public class PmsBrand {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
    @ApiModelProperty("首字母")
    private String firstLetter;

    private Integer sort;
    @ApiModelProperty("是否为品牌制造商: 0->不是；1->是")
    private Integer factoryStatus;

    private Integer showStatus;
    @ApiModelProperty("产品数量")
    private Integer productCount;
    @ApiModelProperty("产品评论数量")
    private Integer productCommentCount;
    @ApiModelProperty("品牌logo")
    private String logo;
    @ApiModelProperty("专区大图")
    private String bigpic;
    @ApiModelProperty("品牌故事")
    private String brandStory;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getProductCommentCount() {
        return productCommentCount;
    }

    public void setProductCommentCount(Integer productCommentCount) {
        this.productCommentCount = productCommentCount;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigpic() {
        return bigpic;
    }

    public void setBigpic(String bigpic) {
        this.bigpic = bigpic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }
}
