package com.hope.server.business.artcomment.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hope.server.business.artcomment.dto.ArtCommentDTO;
import com.server.service.base.Result;

/**
 * @author wangning
 */
public interface ArtCommentService {

    /**
     * 根据作品ID获取评论列表
     *
     * @param artCommentDTO
     * @param page
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.hope.server.business.artcomment.dto.ArtCommentDTO>
     * @author wangning
     * @date 2020/12/3
     */
    Page<ArtCommentDTO> queryCommentByArtId(ArtCommentDTO artCommentDTO, Page<ArtCommentDTO> page);


    /**
     * 用户发表评论
     *
     * @param artCommentDTO
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/12/3
     */
    Result releaseComment(ArtCommentDTO artCommentDTO);
}
