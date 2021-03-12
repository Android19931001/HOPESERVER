package com.hope.server.business.artcomment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hope.server.api.longArtComment.dto.LongArtComment;
import com.hope.server.api.longArtComment.service.LongArtCommentService;
import com.hope.server.api.longUserInfo.domain.LongUserInfo;
import com.hope.server.api.longUserInfo.service.LongUserInfoService;
import com.hope.server.business.artcomment.dto.ArtCommentDTO;
import com.hope.server.business.artcomment.service.ArtCommentService;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangning
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class ArtCommentServiceImpl implements ArtCommentService {

    @Autowired
    LongArtCommentService longArtCommentService;

    @Autowired
    LongUserInfoService longUserInfoService;


    /**
     * 根据作品ID获取评论列表
     *
     * @param artCommentDTO
     * @param page
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.hope.server.business.artcomment.dto.ArtCommentDTO>
     * @author wangning
     * @date 2020/12/3
     */
    @Override
    public Page<ArtCommentDTO> queryCommentByArtId(ArtCommentDTO artCommentDTO, Page<ArtCommentDTO> page) {


        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("comment_art_id", artCommentDTO.getId());
        Page<LongArtComment> origin = new Page<>();
        BeanUtils.copyProperties(page, origin);
        origin = longArtCommentService.page(origin, queryWrapper);
        Page<ArtCommentDTO> target = new Page<>();
        BeanUtils.copyProperties(origin, target);
        List<ArtCommentDTO> resultArtComments = new ArrayList<>();
        origin.getRecords().forEach(item -> {
            ArtCommentDTO resultArtComment = new ArtCommentDTO();
            LongUserInfo longUserInfo = longUserInfoService.getById(item.getCommentUserId());
            if (null != longUserInfo) {
                resultArtComment.setHeadPortraitUrl(longUserInfo.getHeadPortraitUrl());
            }
            resultArtComment.setCommentContent(item.getCommentContent());
            resultArtComment.setCommentUserId(item.getCommentUserId());
            resultArtComment.setCommentUserName(item.getCommentUserName());
            resultArtComment.setId(item.getId());
            resultArtComment.setIsAuthor(item.getIsAuthor());
            resultArtComments.add(resultArtComment);
        });
        target.setRecords(resultArtComments);
        return target;
    }

    /**
     * 用户发表评论
     *
     * @param artCommentDTO
     * @return com.server.service.base.Result
     * @author wangnin
     * @date
     */
    @Override
    public Result releaseComment(ArtCommentDTO artCommentDTO) {
        if (StringUtils.isEmpty(artCommentDTO.getCommentUserId())) {
            return Res.error("评论用户id不能为空");
        }
        if (StringUtils.isEmpty(artCommentDTO.getCommentArtId())) {
            return Res.error("作品Id不能为空");
        }
        if (StringUtils.isEmpty(artCommentDTO.getCommentContent())) {
            return Res.error("评论内容不能为空");
        }
        LongUserInfo longUserInfo = longUserInfoService.getById(artCommentDTO.getCommentUserId());
        if (null == longUserInfo) {
            return Res.error("当前用户不存在");
        }
        LongArtComment longArtComment = new LongArtComment();
        longArtComment.setCommentUserId(artCommentDTO.getCommentUserId());
        longArtComment.setCommentUserName(longUserInfo.getUserName());
        longArtComment.setCommentContent(artCommentDTO.getCommentContent());
        longArtComment.setIsAuthor(artCommentDTO.getIsAuthor());
        longArtCommentService.saveOrUpdate(longArtComment);
        return Res.ok("评论成功");
    }


}
