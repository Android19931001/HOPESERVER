package com.hope.server.business.userRelease.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hope.server.api.longUserInfo.domain.LongUserInfo;
import com.hope.server.api.longUserInfo.service.LongUserInfoService;
import com.hope.server.api.longUserRelease.domain.LongUserRelease;
import com.hope.server.api.longUserRelease.service.LongUserReleaseService;
import com.hope.server.business.userRelease.dto.UserReleaseDTO;
import com.hope.server.business.userRelease.mapper.UserReleaseMapper;
import com.hope.server.business.userRelease.service.UserReleaseService;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangning
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserReleaseServiceImpl implements UserReleaseService {

    @Autowired
    LongUserReleaseService longUserReleaseService;


    @Autowired
    LongUserInfoService longUserInfoService;


    private UserReleaseMapper userReleaseMapper;


    public UserReleaseServiceImpl(UserReleaseMapper userReleaseMapper) {
        this.userReleaseMapper = userReleaseMapper;
    }

    /**
     * 查询用户发布的作品
     *
     * @param *    @param userReleaseDTO
     * @param page
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/9/2
     */
    @Override
    public Result queryUserRelease(UserReleaseDTO userReleaseDTO, Page<LongUserRelease> page) {
        QueryWrapper wrapper = new QueryWrapper();
        if (StringUtils.isNotEmpty(userReleaseDTO.getReUserId())) {
            wrapper.eq("re_user_id", userReleaseDTO.getReUserId());
        }
        Page result = longUserReleaseService.page(page, wrapper);
        if (null == result || null == result.getRecords() || result.getRecords().size() == 0) {
            return Res.error("没有用户发布过作品");
        }
        List<UserReleaseDTO> resultList = new ArrayList<>();
        for (LongUserRelease item :
                page.getRecords()) {
            UserReleaseDTO target = new UserReleaseDTO();
            BeanUtils.copyProperties(item, target);
            QueryWrapper userWrapper = new QueryWrapper();
            userWrapper.eq("id", target.getReUserId());
            userWrapper.last(" limit 1");
            LongUserInfo longUserInfo = longUserInfoService.getOne(userWrapper);
            if (null != longUserInfo) {
                target.setReUserName(longUserInfo.getUserName());
                target.setHeadPortraitUrl(longUserInfo.getHeadPortraitUrl());
            }
            resultList.add(target);
        }
        Page<UserReleaseDTO> resultPage = new Page<>();
        BeanUtils.copyProperties(result, resultPage);
        resultPage.setRecords(resultList);
        return Res.ok(resultPage);
    }

    /**
     * 用户发布作品
     *
     * @param * @param userReleaseDTO
     * @return com.server.service.base.Result
     * @author wangning
     * @date 2020/9/2
     */
    @Override
    public Result userRelease(LongUserRelease longUserRelease) {
        if (StringUtils.isEmpty(longUserRelease.getReUserId())) {
            return Res.error("用户id为空");
        }
        if (StringUtils.isEmpty(longUserRelease.getReText())) {
            return Res.error("发布内容为空");
        }
        LongUserInfo longUserInfo = longUserInfoService.getById(longUserRelease.getReUserId());
        if (null == longUserInfo || StringUtils.isEmpty(longUserInfo.getId())) {
            return Res.error("用户不存在");
        }
        if (!longUserReleaseService.saveOrUpdate(longUserRelease)) {
            return Res.error("作品发布失败");
        }
        return Res.error("作品发布成功");
    }
}
