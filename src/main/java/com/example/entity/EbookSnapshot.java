package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 电子书快照表
 * </p>
 *
 * @author lixun
 * @since 2022-02-23
 */
@TableName("ebook_snapshot")
@ApiModel(value = "EbookSnapshot对象", description = "电子书快照表")
public class EbookSnapshot implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("电子书id")
    private Long ebookId;

    @ApiModelProperty("快照日期")
    private LocalDate date;

    @ApiModelProperty("阅读数")
    private Integer viewCount;

    @ApiModelProperty("点赞数")
    private Integer voteCount;

    @ApiModelProperty("阅读增长")
    private Integer viewIncrease;

    @ApiModelProperty("点赞增长")
    private Integer voteIncrease;

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
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
    public Integer getViewIncrease() {
        return viewIncrease;
    }

    public void setViewIncrease(Integer viewIncrease) {
        this.viewIncrease = viewIncrease;
    }
    public Integer getVoteIncrease() {
        return voteIncrease;
    }

    public void setVoteIncrease(Integer voteIncrease) {
        this.voteIncrease = voteIncrease;
    }

    @Override
    public String toString() {
        return "EbookSnapshot{" +
            "id=" + id +
            ", ebookId=" + ebookId +
            ", date=" + date +
            ", viewCount=" + viewCount +
            ", voteCount=" + voteCount +
            ", viewIncrease=" + viewIncrease +
            ", voteIncrease=" + voteIncrease +
        "}";
    }
}
