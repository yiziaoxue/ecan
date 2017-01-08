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
	public static String DIC_CODE_BALANCE_STATE = "balance_state";
	
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
	public static String PAY_STATE_NO_PAY = "no_pay";//未支付
	public static String PAY_STATE_HAS_PAY_START = "has_pay_start";//开题已支付
	public static String PAY_STATE_HAS_PAY_DECISION = "has_pay_decision";//定稿已支付
	public static String PAY_STATE_HAS_PAY_ANSWER = "has_pay_answer";//定稿已支付
	public static String PAY_STATE_ON_RETURN_PAY = "on_return_pay";//退款中
	public static String PAY_STATE_RETURN_PAY = "return_pay";//已退款
	
	/**
	 * order_type
	 */
	public static String ORDER_TYPE_CHOOSE_TOPIC = "choose_topic";//选题
	public static String ORDER_TYPE_START_TOPIC = "start_topic";//开题
	public static String ORDER_TYPE_FIRST_TOPIC = "fisrt_topic";//初稿
	public static String ORDER_TYPE_DECISION_TOPIC = "decision_topic";//定稿
	public static String ORDER_TYPE_CHECK_TOPIC = "check_topic";//盲审
	public static String ORDER_TYPE_ANSWER_TOPIC = "answer_topic";//答辩
	
	/**
	 * 通用状态
	 */
	public static Short POP_STATE_TREU = 1;//通用状态：是
	public static Short POP_STATE_FALSE = 0;//通用状态：否
	
	/**
	 * 结算状态
	 */
	public static String BALANCE_STATE_NO_BALANCE = "has_no_balance";//未结算
	public static String BALANCE_STATE_HAS_START = "has_balance_start";//开题已结算
	public static String BALANCE_STATE_HAS_DECISION = "has_balance_decision";//定稿已结算
	public static String BALANCE_STATE_HAS_ANSWER = "has_balance_answer";//定稿已结算
}
