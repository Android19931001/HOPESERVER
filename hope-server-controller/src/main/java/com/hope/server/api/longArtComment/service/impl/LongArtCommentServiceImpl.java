package com.hope.server.api.longArtComment.service.impl;

import com.server.service.base.BaseServiceImpl;
import com.hope.server.api.longArtComment.dto.LongArtComment;
import com.hope.server.api.longArtComment.mapper.LongArtCommentMapper;
import com.hope.server.api.longArtComment.service.LongArtCommentService;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class LongArtCommentServiceImpl extends BaseServiceImpl<LongArtCommentMapper, LongArtComment> implements LongArtCommentService {

    private LongArtCommentMapper longArtCommentMapper;

    public LongArtCommentServiceImpl(LongArtCommentMapper longArtCommentMapper) {
        this.longArtCommentMapper = longArtCommentMapper;
    }
}
