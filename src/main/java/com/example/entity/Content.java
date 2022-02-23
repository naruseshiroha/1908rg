package com.example.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 文档内容
 * </p>
 *
 * @author lixun
 * @since 2022-02-23
 */
@ApiModel(value = "Content对象", description = "文档内容")
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文档id")
    private Long id;

    @ApiModelProperty("内容")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Content{" +
            "id=" + id +
            ", content=" + content +
        "}";
    }
}
