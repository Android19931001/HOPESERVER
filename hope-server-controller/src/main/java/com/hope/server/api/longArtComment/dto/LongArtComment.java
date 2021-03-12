package com.hope.server.api.longArtComment.dto;

import com.server.service.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wangning
 */

@Data
@TableName("long_art_comment")
public class LongArtComment extends BaseEntity{

    /**
     * 评论id
     */
    private String id;
    /**
     * 评论者的用户ID
     */
    private String commentUserId;
    /**
     *作品id
     */
    public String commentArtId;
    /**
     * 评论者用户名
     */
    private String commentUserName;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 1：作者本人；0：其他
     */
    private int isAuthor;

}
