package com.fengzi.dubbo.platform.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * User
 * 用户信息(user)
 * @author fujian
 * @version : Ver 1.0
 */
@TableName("user")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**
	 * 备注:主键id
	 * 字段:id BIGINT(19)
	 */
	@TableId(type = IdType.AUTO, value = "id")
	private Long id;

	/**
	 * 备注:用户头像
	 * 字段:user_icon VARCHAR(500)
	 */
	private String userIcon;

	/**
	 * 备注:用户OpenId
	 * 字段:open_id VARCHAR(100)
	 */
	private String openId;

	/**
	 * 备注:微信昵称
	 * 字段:nick_name VARCHAR(50)
	 */
	private String nickName;

	/**
	 * 备注:绑定手机号
	 * 字段:bind_phone VARCHAR(20)
	 */
	private String bindPhone;

	/**
	 * 备注:最后登录时间
	 * 字段:last_login_time DATETIME(19)
	 */
	private java.util.Date lastLoginTime;

	/**
	 * 备注:注册时间
	 * 字段:create_time DATETIME(19)
	 */
	private java.util.Date createTime;

	/**
	 * 备注:更新时间
	 * 字段:update_time DATETIME(19)
	 */
	private java.util.Date updateTime;

	/**
	 * 备注:注册渠道id：0=模拟数据；1=小程序
	 * 字段:channel_id BIGINT(19)
	 */
	private Long channelId;

	/**
	 * 备注:交易密码
	 * 字段:pay_pwd VARCHAR(70)
	 */
	private String payPwd;

	/**
	 * 备注:可用余额
	 * 字段:balance DECIMAL(10)
	 */
	private java.math.BigDecimal balance;

	/**
	 * 备注:冻结余额
	 * 字段:blocked_balance DECIMAL(10)
	 */
	private java.math.BigDecimal blockedBalance;

	/**
	 * 备注:免费额度
	 * 字段:free_quota DECIMAL(10)
	 */
	private java.math.BigDecimal freeQuota;

	/**
	 * 备注:状态：0=正常；1=禁用
	 * 字段:state INT(10)
	 */
	private Integer state;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
