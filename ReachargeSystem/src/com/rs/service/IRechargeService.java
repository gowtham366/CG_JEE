package com.rs.service;

import java.util.List;

import com.rs.bean.CustomerBean;
import com.rs.bean.RechargePlanBean;
import com.rs.exception.RechargeSystemException;

/**
 * @author gowthc
 *
 */
public interface IRechargeService {
	public String addCustomerDetails(CustomerBean bean) throws RechargeSystemException;
	public CustomerBean viewCustomerDetails(int rechId) throws RechargeSystemException;
	public List<RechargePlanBean> retrivePlanDetails() throws RechargeSystemException;
	public boolean isValidName(String custName);
	public boolean isValidEmail(String custEmail);
	public boolean isValidMobile(long custMobile);
	public boolean isValidPlan(String plan);
	public int getPlanAmount();
}
