package com.example.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 文档
 * </p>
 *
 * @author lixun
 * @since 2022-02-23
 */
@ApiModel(value = "Doc对象", description = "文档")
public class Doc implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("电子书id")
    private Long ebookId;

    @ApiModelProperty("父id")
    private Long parent;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("顺序")
    private Integer sort;

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
    public Long getEbookId() {
        return ebookId;
    }

    public void setEbookId(Long ebookId) {
        this.ebookId = ebookId;
    }
    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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
        return "Doc{" +
            "id=" + id +
            ", ebookId=" + ebookId +
            ", parent=" + parent +
            ", name=" + name +
            ", sort=" + sort +
            ", viewCount=" + viewCount +
            ", voteCount=" + voteCount +
        "}";
    }
}
