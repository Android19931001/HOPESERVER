package com.hope.server.api.longHopeFile.service.impl;

import com.server.service.base.BaseServiceImpl;
import com.hope.server.api.longHopeFile.dto.LongHopeFile;
import com.hope.server.api.longHopeFile.mapper.LongHopeFileMapper;
import com.hope.server.api.longHopeFile.service.LongHopeFileService;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class LongHopeFileServiceImpl extends BaseServiceImpl<LongHopeFileMapper, LongHopeFile> implements LongHopeFileService {

    private LongHopeFileMapper longHopeFileMapper;

    public LongHopeFileServiceImpl(LongHopeFileMapper longHopeFileMapper) {
        this.longHopeFileMapper = longHopeFileMapper;
    }
}
