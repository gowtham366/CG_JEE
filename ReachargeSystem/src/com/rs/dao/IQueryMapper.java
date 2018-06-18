/**
 * 
 */
package com.rs.dao;

/**
 * @author gowthc
 *
 */
public interface IQueryMapper {
	public static final String VIEW_CUSTOMER_DETAILS_QUERY = "SELECT rechid, name, email, mobile, status, plan_name, amount FROM recharge_history WHERE rechid = ?";
	public static final String VIEW_RECHARGE_PLANS_QUERY = "SELECT plan_name, amount FROM recharge_plans";
	public static final String INSERT_CUSTOMER_DETAILS_QUERY = "INSERT INTO recharge_history VALUES(rechid.NEXTVAL, ?,?,?,?,?,?)";
	public static final String CUSTOMER_QUERY_SEQUENCE = "SELECT rechid.CURRVAL FROM DUAL";

}
