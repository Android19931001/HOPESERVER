package com.server.service.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends Model> extends ServiceImpl<M, T> implements BaseService<T> {

}
