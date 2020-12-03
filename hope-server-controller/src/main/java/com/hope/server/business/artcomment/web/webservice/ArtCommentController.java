package com.hope.server.business.artcomment.web.webservice;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codahale.metrics.annotation.Timed;
import com.hope.server.business.artcomment.dto.ArtCommentDTO;
import com.hope.server.business.artcomment.service.ArtCommentService;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangning
 */
@Slf4j
@RestController
@RequestMapping("/webservice")
public class ArtCommentController {

    @Autowired
    ArtCommentService artCommentService;

    /**
     * 根据作品ID获取评论列表
     *
     * @param artCommentDTO
     * @param page
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/12/3
     */
    @Timed
    @GetMapping("/artComment/queryCommentByArtId")
    public Result queryCommentByArtId(ArtCommentDTO artCommentDTO, Page<ArtCommentDTO> page) {
        log.info("根据作品ID获取评论列表入参-------->{},{}", artCommentDTO, page);
        if (StringUtils.isEmpty(artCommentDTO.getId())) {
            return Res.error("作品id不能为空");
        }
        try {
            return Res.ok(artCommentService.queryCommentByArtId(artCommentDTO, page));
        } catch (Exception e) {
            log.error("根据作品ID获取评论列表异常------>{}", e);
            return Res.error("根据作品ID获取评论列表异常");
        }
    }


    /**
     * 用户发表评论
     *
     * @param artCommentDTO
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/12/3
     */
    @Timed
    @PostMapping("artComment/releaseComment")
    public Result releaseComment(@RequestBody ArtCommentDTO artCommentDTO) {
        log.error("用户发表用户评论入参------>{}", artCommentDTO);
        try {
            return artCommentService.releaseComment(artCommentDTO);
        } catch (Exception e) {
            log.error("用户发表用户评论异常------>{}", e);
            return Res.error("用户发表用户评论异常");
        }

    }
}
