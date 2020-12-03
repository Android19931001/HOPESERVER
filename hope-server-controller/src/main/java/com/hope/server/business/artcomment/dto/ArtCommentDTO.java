package com.hope.server.business.artcomment.dto;

import com.server.service.base.BaseEntity;
import lombok.Data;


/**
 * @author wangning
 */

@Data
public class ArtCommentDTO extends BaseEntity{

    /**
     * 评论id
     */
    private String id;
    /**
     * 评论者的用户ID
     */
    private String commentUserId;
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
