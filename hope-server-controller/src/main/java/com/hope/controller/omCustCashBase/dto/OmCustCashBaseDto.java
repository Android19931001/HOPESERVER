package com.hope.controller.omCustCashBase.dto;

import base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @author wangning
 */
@Data
@ToString
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class OmCustCashBaseDto extends BaseEntity{

    /**
     * 提款合同号
     */
    private String id;
    /**
     * 身份证号
     */
    @NotNull
    private String idNumber;
    /**
     * 客户名称
     */
    private String custName;
    /**
     * 授信编号
     */
    private String creditId;
    /**
     * 产品编码
     */
    private String prodId;
    /**
     * 产品名称
     */
    private String prodName;
    /**
     * 资源编码
     */
    private String resId;
    /**
     * 资源名称
     */
    private String resName;
    /**
     * 额度编码
     */
    private String resLimitId;
    /**
     * 申请金额
     */
    private double applyAmt;
    /**
     * 申请时间
     */
    private String applyDate;
    /**
     * 申请期限
     */
    private int applyTerm;
    /**
     * 提款金额
     */
    private double drawAmt;
    /**
     * 提款时间
     */
    private String drawDate;
    /**
     * 可用金额
     */
    private double useAmt;
    /**
     * 借款期限（天）
     */
    private int leaseTerm;
    /**
     * 借款开始日
     */
    private String leaseStartDate;
    /**
     * 借款结束日
     */
    private String leaseEndDate;
    /**
     * 利率
     */
    private double productRatio;
    /**
     * 还款方式
     */
    private String calTypeId;
    /**
     * 放款时间
     */
    private String loanDate;
    /**
     * 签约状态
     */
    private String signStatusId;
    /**
     * 签约地址
     */
    private String signUrl;
    /**
     * 签约序列号
     */
    private String serial;
    /**
     * 合同编号
     */
    private String contpaperNo;
    /**
     * 合同签订时间
     */
    private String contractDate;
    /**
     * 合同地址
     */
    private String contUrl;
    /**
     * 收款账号
     */
    private String grantToAccount;
    /**
     * 收款户名
     */
    private String grantToName;
    /**
     * 借据编号
     */
    private String loanNo;
    /**
     * 是否分次放款
     */
    private String partreleFlagId;
    /**
     * 本次放款金额
     */
    private double retCapi;
    /**
     * 贷款期限类型
     */
    private String tTermTypeId;
    /**
     * 是否分账
     */
    private String isSplitId;
    /**
     * 放款金额分账比例（分账部分）
     */
    private double releScale;
    /**
     * 分账金额
     */
    private double releAmount;
    /**
     * 服务费计算方式
     */
    private String chargeMethodId;
    /**
     * 服务费金额
     */
    private double chargeAmt;
    /**
     * 是否需要补件
     */
    private String isAdditionalId;
    /**
     * 补件类型
     */
    private String addTypeId;
    /**
     * 需补件内容
     */
    private String addInfo;
    /**
     * 资源方业务状态
     */
    private String resApprStatusId;
    /**
     * 资源方审批结果
     */
    private String resCreditStatusId;
    /**
     * 资源方放款状态
     */
    private String resPayStatusId;
    /**
     * 资源方响应消息
     */
    private String resMsg;
    /**
     * 是否可转换为企业进件
     */
    private String isCorpconvertId;
    /**
     * 代付返回信息
     */
    private String payMsg;
    /**
     * 用户提款流程状态（默认为30020001）
     */
    private String cashSpeedId;
    /**
     * 下户状态
     */
    private String visitStatusId;
    /**
     * 订单状态
     */
    private String cashStatusId;
    /**
     * 结清方式
     */
    private String cashFinishTypeId;
    /**
     * 用户提款流程下一状态
     */
    private String nextCashSpeedId;
    /**
     * 授信编号
     */
    private String haierCreditId;
    /**
     * 海尔回传业务编号
     */
    private String haierBizNo;
    /**
     * 每月还款日
     */
    private int repayDate;
    /**
     * 借款用途
     */
    private String loadPurpose;
    /**
     * 经销商名称
     */
    private String agentName;
    /**
     * 经销商编码
     */
    private String agentCode;

}
