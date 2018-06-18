package com.rs.dao;

import java.util.List;

import com.rs.bean.CustomerBean;
import com.rs.bean.RechargePlanBean;
import com.rs.exception.RechargeSystemException;

/**
 * @author gowthc
 *
 */
public interface IRechargeDAO {
	public String addCustomerDetails(CustomerBean bean) throws RechargeSystemException;
	public CustomerBean viewCustomerDetails(int rechId) throws RechargeSystemException;
	public List<RechargePlanBean> retrivePlanDetails() throws RechargeSystemException;
	public String getSequence();
}
