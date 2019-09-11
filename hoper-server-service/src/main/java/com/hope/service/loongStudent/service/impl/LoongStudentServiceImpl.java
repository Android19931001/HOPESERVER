package com.hope.service.loongStudent.service.impl;

import base.BaseServiceImpl;
import com.hope.service.loongStudent.domain.LoongStudentEntity;
import com.hope.service.loongStudent.mapper.LoongStudentMapper;
import com.hope.service.loongStudent.service.LoongStudentService;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class LoongStudentServiceImpl extends BaseServiceImpl<LoongStudentMapper, LoongStudentEntity> implements LoongStudentService {

    private LoongStudentMapper loongStudentMapper;

    public LoongStudentServiceImpl(LoongStudentMapper loongStudentMapper) {
        this.loongStudentMapper = loongStudentMapper;
    }
}
