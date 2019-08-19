package com.hope.service.omCustCashBase.service.impl;

import base.BaseServiceImpl;
import com.hope.service.omCustCashBase.domain.OmCustCashBaseEntity;
import com.hope.service.omCustCashBase.mapper.OmCustCashBaseMapper;
import com.hope.service.omCustCashBase.service.OmCustCashBaseService;
import org.springframework.stereotype.Service;

/**
 * @author wangning
 */
@Service
public class OmCustCashBaseServiceImpl extends BaseServiceImpl<OmCustCashBaseMapper, OmCustCashBaseEntity> implements OmCustCashBaseService {

    private OmCustCashBaseMapper omCustCashBaseMapper;

    public OmCustCashBaseServiceImpl(OmCustCashBaseMapper omCustCashBaseMapper) {
        this.omCustCashBaseMapper = omCustCashBaseMapper;
    }
}
