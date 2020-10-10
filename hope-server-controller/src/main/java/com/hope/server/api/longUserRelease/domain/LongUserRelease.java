package com.hope.server.api.longUserRelease.domain;

import com.server.service.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author wangning
 */

@Data
@TableName("long_user_release")
public class LongUserRelease extends BaseEntity{

    /**
     * 主键id
     */
    private String id;
    /**
     * 用户id
     */
    private String reUserId;
    /**
     * 发布的内容
     */
    private String reText;
    /**
     * 作品图片地址
     */
    private String reImgUrl;
    /**
     * 作品视频地址
     */
    private String reVideoUrl;
    /**
     * 发布时间
     */
    private String reDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReUserId() {
        return reUserId;
    }

    public void setReUserId(String reUserId) {
        this.reUserId = reUserId;
    }

    public String getReText() {
        return reText;
    }

    public void setReText(String reText) {
        this.reText = reText;
    }

    public String getReImgUrl() {
        return reImgUrl;
    }

    public void setReImgUrl(String reImgUrl) {
        this.reImgUrl = reImgUrl;
    }

    public String getReVideoUrl() {
        return reVideoUrl;
    }

    public void setReVideoUrl(String reVideoUrl) {
        this.reVideoUrl = reVideoUrl;
    }

    public String getReDate() {
        return reDate;
    }

    public void setReDate(String reDate) {
        this.reDate = reDate;
    }
}
