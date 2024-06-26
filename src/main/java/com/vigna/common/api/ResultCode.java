package com.vigna.common.api;

/**
 * 常用API操作码
 */
public enum ResultCode implements IErrorCode {

	/**
	 * 操作成功
	 */
	SUCCESS(200, "操作成功"),
	FAILED(500, "操作失败"),
	VALIDATE_FAILED(400, "参数检验失败"),
	UNAUTHORIZED(401, "暂未登录或token已经过期"),
	FORBIDDEN(403, "暂未登录或token已经过期,没有相关权限"),

	ERROR_NAME_REPEAT(600, "姓名重复"),
	ERROR_USER_NAME_REPEAT(601, "用户名重复");
	private final int code;

	private final String message;

	ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

}