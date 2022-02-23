package com.example.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 电子书
 * </p>
 *
 * @author lixun
 * @since 2022-02-23
 */
@ApiModel(value = "Ebook对象", description = "电子书")
public class Ebook implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("分类1")
    private Long category1Id;

    @ApiModelProperty("分类2")
    private Long category2Id;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("封面")
    private String cover;

    @ApiModelProperty("文档数")
    private Integer docCount;

    @ApiModelProperty("阅读数")
    private Integer viewCount;

    @ApiModelProperty("点赞数")
    private Integer voteCount;

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
    public Long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }
    public Long getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    public Integer getDocCount() {
        return docCount;
    }

    public void setDocCount(Integer docCount) {
        this.docCount = docCount;
    }
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public String toString() {
        return "Ebook{" +
            "id=" + id +
            ", name=" + name +
            ", category1Id=" + category1Id +
            ", category2Id=" + category2Id +
            ", description=" + description +
            ", cover=" + cover +
            ", docCount=" + docCount +
            ", viewCount=" + viewCount +
            ", voteCount=" + voteCount +
        "}";
    }
}
