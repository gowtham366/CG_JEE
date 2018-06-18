package com.rs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.rs.bean.CustomerBean;
import com.rs.bean.RechargePlanBean;
import com.rs.dao.IRechargeDAO;
import com.rs.dao.RechargeDAOImpl;
import com.rs.exception.RechargeSystemException;

public class RechargeServiceImpl implements IRechargeService {
	
	IRechargeDAO iRechargeDAO;
	Logger logger=Logger.getRootLogger();
	CustomerBean bean = new CustomerBean();
	private int custAmount;
	public RechargeServiceImpl() {
		// TODO Auto-generated constructor stub
		PropertyConfigurator.configure("resources//log4j.properties");
	}
	
	//adding customet to database calls dao method addCustomerDetails(CustomerBean bean)
	
	@Override
	public String addCustomerDetails(CustomerBean bean)
			throws RechargeSystemException {
		// TODO Auto-generated method stub
		iRechargeDAO = new RechargeDAOImpl();
		String custSeq;
		custSeq = iRechargeDAO.addCustomerDetails(bean);		
		return custSeq;
	}

	//calls dao method viewCustomerDetails(int rechId)
	@Override
	public CustomerBean viewCustomerDetails(int rechId)
			throws RechargeSystemException {
		// TODO Auto-generated method stub
		iRechargeDAO = new RechargeDAOImpl();
		CustomerBean bean=null;
		bean = iRechargeDAO.viewCustomerDetails(rechId);
		return bean;
	}

	//calls dao method retrivePlanDetails()
	@Override
	public List<RechargePlanBean> retrivePlanDetails()
			throws RechargeSystemException {
		// TODO Auto-generated method stub
		iRechargeDAO = new RechargeDAOImpl();
		List<RechargePlanBean> planList = null;
		planList = iRechargeDAO.retrivePlanDetails();
		return planList;
	}
	

	@Override
	public boolean isValidName(String custName){
		Pattern namePattern=Pattern.compile("[A-Z]{1}[A-Za-z]\\D*{3}");
		Matcher nameMatcher=namePattern.matcher(custName);
		boolean result=nameMatcher.matches();
		if(!result)
			System.err.println("Enter the valid name");
		return result;
	}
		
	@Override
	public boolean isValidEmail(String email){
		Pattern emailPattern = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");
		Matcher emailMatcher = emailPattern.matcher(email);
		boolean result=emailMatcher.matches();
		if(!result)
			System.err.println("Enter the valid email");
		return result;
	}

	@Override
	public boolean isValidMobile(long custMobile) {
		// TODO Auto-generated method stub
		String mobile = String.valueOf(custMobile);
		Pattern phonePattern=Pattern.compile("[6-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(mobile);
		boolean result=phoneMatcher.matches();
		if(!result)
			System.err.println("Enter the valid mobile number");
		return result;
	}
	
	@Override
	public boolean isValidPlan(String plan){
		// TODO Auto-generated method stub
		boolean result=false;
		List<RechargePlanBean> planList;
		try {
			planList = retrivePlanDetails();
			if(!planList.isEmpty()){
				for(RechargePlanBean list: planList){
					if(list.getPlanName().equalsIgnoreCase(plan)){
						result=true;
						custAmount=list.getPlanAmount();
					//	bean.setCustAmount(list.getPlanAmount());
						break;
					}
				}
				if(!result){
					System.err.println("Enter the valid plan name");	
				}
			}			
			
		} catch (RechargeSystemException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public int getPlanAmount() {
		// TODO Auto-generated method stub
		return custAmount;
	}

}
