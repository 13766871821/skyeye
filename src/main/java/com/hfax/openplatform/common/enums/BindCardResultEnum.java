package com.hfax.openplatform.common.enums;

public enum BindCardResultEnum {
	BIND_CARD_FAIL_IDNO_IS_USED("9001", "身份证号已注册惠金所账号"), // 已使用
	BIND_CARD_FAIL_TENO_IS_USED("9002", "手机号已注册惠金所账号"), // 已使用
	BIND_CARD_FAIL_CARDNOSUPORT("9003", "该卡不支持，请更换惠金所支持的银行卡"), // 已使用
	BIND_CARD_FAIL_CARDNOSUPORT2("9003", "该卡为信用卡，请绑定借记卡"), // 已使用
	BIND_CARD_FAIL_IDCARDAUTH("9004", "该客户姓名和身份证不一致"), // 已使用
	BIND_CARD_FAIL_IDNOTSAME("9005", "客户身份信息与银行预留信息不一致"), // 已使用

	BIND_CARD_FAIL_SIGN1("1001", "解密异常"), // 已使用
	BIND_CARD_FAIL_SIGN2("1002", "解密异常"), // 已使用
	BIND_CARD_FAIL_USERTAG("1003", "增加用户标签失败"), // 已使用
	BIND_CARD_FAIL_REG("1004", "注册用户名失败"), // 已使用
	BIND_CARD_FAIL_OPEN("1005", "注册成功，但惠金所开户失败"), // 已使用
	BIND_CARD_FAIL_BIND("1006", "惠金所绑卡失败，未查询到渠道信息"), // 已使用
	BIND_CARD_FAIL_REQDATA("1007", "请求信息缺少必要参数"), // 已使用
	BIND_CARD_FAIL_IPERROR("1008", "IP不在白名单，不能注册"), // 已使用
	BIND_CARD_FAIL_CARDBIN("1009", "未查询到银行卡信息，请重试或检查卡号是否正确"), // 已使用

	BIND_CARD_FAIL_IDCARD_Q1("1010", "身份证号码输入有误，请重新输入"), // 已使用
	BIND_CARD_FAIL_IDCARD_Q2("1011", "身份证号码输入有误，请重新输入"), // 已使用
	BIND_CARD_FAIL_IDCARD_Q3("1012", "该客户未满18周岁，不能注册惠金所账户"), // 已使用
	BIND_CARD_FAIL_IDCARD_Q4("1013", "该客户未满18周岁，不能注册惠金所账户"), // 已使用
	BIND_CARD_FAIL_IDCARD_Q5("1014", "该客户未满18周岁，不能注册惠金所账户"), // 已使用
	BIND_CARD_FAIL_IDCARD_Q6("1015", "校验身份证：身份证为空"), // 已使用
	BIND_CARD_FAIL_IDNO_PARTTERN("1016", "手机号格式输入有误"), // 已使用

	BIND_CARD_FAIL_NOINFO("1017", "确认绑卡：未取到绑卡信息"), // 已使用
	BIND_CARD_FAIL_TRANSNO("1018", "确认绑卡：交易流水号校验未通过"), // 已使用
	BIND_CARD_FAIL_SMSCODE("1019", "确认绑卡：手机验证码不能为空"), // 已使用
	BIND_CARD_FAIL_AUTHCARD("1020", "确认绑卡：银行卡实名认证失败"), // 已使用

	BIND_CARD_SUC("0000", "绑卡成功"), // 已使用
	OPER_SUC("0000", "操作成功"), // 已使用
	BIND_CARD_FAIL_SYS("9999", "系统异常");// 已使用

	private String reCode;
	private String reMessge;

	private BindCardResultEnum(String reCode, String reMessge) {
		this.reCode = reCode;
		this.reMessge = reMessge;
	}

	public String getReCode() {
		return reCode;
	}

	public String getReMessge() {
		return reMessge;
	}

	public void setReCode(String reCode) {
		this.reCode = reCode;
	}

	public void setReMessge(String reMessge) {
		this.reMessge = reMessge;
	}
}