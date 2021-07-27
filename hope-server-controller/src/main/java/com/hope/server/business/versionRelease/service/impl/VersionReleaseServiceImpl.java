package com.hope.server.business.versionRelease.service.impl;

import com.alibaba.fastjson.JSON;
import com.hope.server.api.longHopeFile.dto.LongHopeFile;
import com.hope.server.api.longHopeFile.service.LongHopeFileService;
import com.hope.server.api.longVersionRelease.dto.LongVersionRelease;
import com.hope.server.api.longVersionRelease.service.LongVersionReleaseService;
import com.hope.server.business.versionRelease.dto.VersionReleaseDTO;
import com.hope.server.business.versionRelease.service.VersionReleaseService;
import com.server.service.base.Result;
import com.server.service.utils.Res;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author wangning
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class VersionReleaseServiceImpl implements VersionReleaseService {

    @Autowired
    LongVersionReleaseService longVersionReleaseService;

    @Autowired
    LongHopeFileService longHopeFileService;

    @Override
    public boolean isShowFaceCredit(String versionName) {

        LongVersionRelease longVersionRelease = longVersionReleaseService.getById("1323232");
        if (null == longVersionRelease) {
            return false;
        }
        if (longVersionRelease.getVersionName().equals(versionName)) {
            return true;
        }
        return false;
    }

    /**
     * 查询APP更新信息
     *
     * @param * @param id
     * @return void
     * @author wangning
     * @date 2020/11/12
     */
    @Override
    public Result queryUpdateInfo(LongVersionRelease versionReleaseDTO) {
        if (StringUtils.isEmpty(versionReleaseDTO.getId())) {
            return Res.error("APP的id为空");
        }
        if (StringUtils.isEmpty(versionReleaseDTO.getVersionName())) {
            return Res.error("APP的版本名为空");
        }
        if (StringUtils.isEmpty(versionReleaseDTO.getVersionCode())) {
            return Res.error("APP的版本号为空");
        }
        LongVersionRelease cacheVersion = longVersionReleaseService.getById(versionReleaseDTO.getId());
        if (null == cacheVersion) {
            return Res.error("未查询到APP相关的版本信息");
        }
        if (!cacheVersion.getVersionCode().equals(versionReleaseDTO.getVersionCode()) ||
                !cacheVersion.getVersionName().equals(versionReleaseDTO.getVersionName())) {
            LongHopeFile longHopeFile = longHopeFileService.getById(versionReleaseDTO.getId());
            if (null == longHopeFile) {
                return Res.error("未查到源文件,请上传apk文件");
            }
            VersionReleaseDTO releaseDTO = new VersionReleaseDTO();
            BeanUtils.copyProperties(cacheVersion, releaseDTO);
            releaseDTO.setDownloadPath("http://121.36.66.235/webservice/fileHandler/download-hope-file/" + versionReleaseDTO.getId());
            return Res.ok(releaseDTO);
        }
        return Res.error("当前版本无需更新!");
    }


//    orderType=1&initCustId=CUST201914323147894Ek2&factdate=2021-07-27&

//    INSERT INTO `custom_uat`.`t_trade_record`(`order_no`, `contact_no`, `pay_money`, `poundage_rate`, `poundage`, `p_money`, `truely_pay`, `local_serial_no`, `serial_no_status`, `pay_serial_no`, `trade_status`, `periods`, `trade_type`, `pay_type`, `bu_or_pa`, `is_penalty`, `announce_result`, `is_push`, `is_handled`, `init_cust_id`, `user_id`, `created_date`, `updated_date`, `created_by`, `updated_by`, `margin_step`) VALUES ('FTAUMAN2021116954', 'ZCOM2021116954', 100.00, 0.0060, 0.00, 100.00, 0.00, 'uGRqlpO5zeRotfYd9vTEag==_1626165460704', 4, '5abd66f3-5f89-4561-998b-1905df2340f4', 2, '3', 1, 2, 'bu', 2, 0, 1, 1, 'CUST202033808344302lu5', 119841, '2021-07-13 16:37:40', '2021-07-13 16:38:02', 0, 0, NULL);

    /**
     * 格式化成sql
     *
     * @param str
     * @return
     */
    @Override
    public String formatToSql(String str) {
        String targetStr = "{\"" + str.replaceAll("&", "\",\"").replaceAll("=", "\":\"") + "\"}";
        log.info("格式化后的字符串为：{}", targetStr);
        Map<String, String> map = ((Map<String, String>) JSON.parse(targetStr));
        String sql = "INSERT INTO `custom_uat`.`t_trade_record`" +
                "(`order_no`, `contact_no`, `pay_money`, `poundage_rate`, `poundage`, `p_money`, `truely_pay`, `local_serial_no`, `serial_no_status`, `pay_serial_no`, `trade_status`, `periods`, `trade_type`, `pay_type`, `bu_or_pa`, `is_penalty`, `announce_result`, `is_push`, `is_handled`, `init_cust_id`, `user_id`, `created_date`, `updated_date`, `created_by`, `updated_by`, `margin_step`) VALUES " +
                "('%s', 'ZCOM2021116954', %s, %s, %s, %s, 0.00, 'uGRqlpO5zeRotfYd9vTEag==_1626165460704', 4, '%s', 1, '%s', 1, %s, 'bu', 2, 0, 1, 1, '%s', 119841, '%s 16:37:40', '%s 16:38:02', 0, 0, NULL);";
        String resultStr = String.format(sql, map.get("orderNo"), map.get("pMoney"),
                map.get("poundageRate"), map.get("poundage"), map.get("pMoney"), map.get("tradeSerialNo"), map.get("periods"), map.get("payType"), map.get("initCustId"), map.get("factdate"), map.get("factdate"));
        return resultStr;
    }
}
