package com.ecan.constant;

public class Constant {

	public static String SOLES = "soles";
	public static String PERMS = "perms";
	
	/**
	 * dic_code
	 */
	public static String DIC_CODE_PAY_STATE = "pay_state";
	public static String DIC_CODE_ORDER_STATE = "order_state";
	public static String DIC_CODE_ORDER_TYPE = "order_type";
	
	/**
	 * order_state
	 */
	public static String ORDER_STATE_NEW_ORDER = "new_order";//新订
	public static String ORDER_STATE_ON_ORDER = "on_order";//进行中
	public static String ORDER_STATE_CANCEL_ORDER = "cancel_order";//取消
	public static String ORDER_STATE_DONE_ORDER = "done_order";//已完成
	
	/**
	 * pay_state
	 */
	public static String PAY_STATE_NO_PAY = "no_pay";//新订
	public static String PAY_STATE_HAS_PAY = "has_pay";//进行中
	public static String PAY_STATE_ON_RETURN_PAY = "on_return_pay";//取消
	public static String PAY_STATE_RETURN_PAY = "return_pay";//已完成
	
	/**
	 * order_type
	 */
	public static String ORDER_TYPE_CHOOSE_TOPIC = "choose_topic";//选题
	public static String ORDER_TYPE_START_TOPIC = "start_topic";//开题
	public static String ORDER_TYPE_FIRST_TOPIC = "fisrt_topic";//初稿
	public static String ORDER_TYPE_DECISION_TOPIC = "decision_topic";//定稿
	public static String ORDER_TYPE_CHECK_TOPIC = "check_topic";//盲审
	public static String ORDER_TYPE_ANSWER_TOPIC = "answer_topic";//答辩
}
