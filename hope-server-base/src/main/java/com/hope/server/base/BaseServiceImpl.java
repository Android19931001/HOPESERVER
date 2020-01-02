package com.hope.server.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class BaseServiceImpl<M extends BaseFrameMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {

}
