package com.server.service.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangning
 */
@Mapper
public interface BaseFrameMapper<T> extends BaseMapper<T> {
}
