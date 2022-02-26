package com.app.lic.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lic.constants.CommonConstantPlan;
import com.app.lic.constants.CommonConstants;
import com.app.lic.dto.ErrorMessageDetails;
import com.app.lic.dto.PlanDto;
import com.app.lic.dto.PlanResponse;
import com.app.lic.dto.UserDto;
import com.app.lic.dto.UserResponse;
import com.app.lic.repository.PlanRepository;
import com.app.lic.model.*;
@Service
public class PlanService {
	
	@Autowired
	PlanRepository planRepository;

	
	public PlanResponse addPlan(PlanDto planDto)
	{
		ErrorMessageDetails emd= new ErrorMessageDetails();
		PlanResponse res=new PlanResponse();
		PlanDto planDto1=null;
		
		try
		{
			Plan plan= toEntity(planDto);
			
			Plan plans=planRepository.findByName(planDto.getName().trim());
			if(Objects.nonNull(plans))
			{
				emd.setErrorCode(CommonConstantPlan.PLAN_ALREADY_PRESENT_MESSAGE.getValue());
				emd.setErrorMessage(CommonConstantPlan.PLAN_ALREADY_PRESENT_MESSAGE.getKey());
				res.setErrorMessageDetails(emd);
				
				res.setPlanDto(planDto1);
			}
			Plan planDB= planRepository.save(plan);
			planDto1=toDto(planDB);
	
			} catch (Exception e) {
				emd.setErrorCode(CommonConstantPlan.PLAN_ADDED_MESSAGE_FAIL.getValue());
				emd.setErrorMessage(CommonConstantPlan.PLAN_ADDED_MESSAGE_FAIL.getKey());
				e.printStackTrace();
			}

			emd.setErrorCode(CommonConstantPlan.PLAN_ADDED_MESSAGE_SUCCESS.getValue());
			emd.setErrorMessage(CommonConstantPlan.PLAN_ADDED_MESSAGE_SUCCESS.getKey());
			res.setErrorMessageDetails(emd);

			res.setPlanDto(planDto1);

			return res;
		}
		
		
		
		public PlanResponse updateUser(PlanDto planDto) {

			ErrorMessageDetails emd = new ErrorMessageDetails();
			PlanResponse res = new PlanResponse();
			PlanDto planDto1 = null;

			try {
				Plan Plan = toEntity(planDto);

			  Plan plans=	planRepository.findByName(planDto.getName().trim());
			  
			  
			  if(Objects.isNull(plans)) {
				  
					emd.setErrorCode(CommonConstantPlan.NO_RECORD_FOUND.getValue());
					emd.setErrorMessage(CommonConstantPlan.NO_RECORD_FOUND.getKey());
					res.setErrorMessageDetails(emd);

					res.setPlanDto(planDto1);
					
					return res;
			  }     
			  
			  if (!planDto.getName().isEmpty()) {
				  plans.setName(planDto.getName());

			}
			  
			  if (!(planDto.getMonthyInstallment()==null)) {
				  plans.setMonthyInstallment(planDto.getMonthyInstallment());
				  
			}
			  if (!(planDto.getMaturityAmount()==null)) {
				  plans.setMaturityAmount(planDto.getMaturityAmount());

			}
			  
			  if (!(planDto.getDurationPeriod()==null)) {
				  plans.setDurationPeriod(planDto.getDurationPeriod());

			  if (!(planDto.getCreateDate()==null)) {
				  plans.setCreateDate(StringToDate(planDto.getCreateDate()));

			  }
			  if (!(planDto.getUpdateDate()==null)) {
				  plans.setUpdateDate(StringToDate(planDto.getUpdateDate()));

			
			  }
			
			
			
				Plan planDB = planRepository.save(plans);

				planDto1 = toDto(planDB);
			  }
			} catch (Exception e) {
				emd.setErrorCode(CommonConstantPlan.PLAN_ADDED_MESSAGE_FAIL.getValue());
				emd.setErrorMessage(CommonConstantPlan.PLAN_ADDED_MESSAGE_FAIL.getKey());
				e.printStackTrace();
			}

			emd.setErrorCode(CommonConstantPlan.PLAN_UPDATED_MESSAGE_SUCCESS.getValue());
			emd.setErrorMessage(CommonConstantPlan.PLAN_UPDATED_MESSAGE_SUCCESS.getKey());
			res.setErrorMessageDetails(emd);

			res.setPlanDto(planDto1);

			return res;
		}

		private Date StringToDate(String createDate) {
			// TODO Auto-generated method stub
			return null;
		}



		public PlanResponse deleteUser(String name) {

			ErrorMessageDetails emd = new ErrorMessageDetails();
			PlanResponse res = new PlanResponse();
			PlanDto planDto1 = null;

			try {
				System.out.println("data"+name.length());

	System.out.println("data"+name.trim().length());
			  Plan plan=	planRepository.findByName(name.trim());
			  
			  
			  if(Objects.isNull(plan)) {
				  
					emd.setErrorCode(CommonConstantPlan.NO_RECORD_FOUND.getValue());
					emd.setErrorMessage(CommonConstantPlan.NO_RECORD_FOUND.getKey());
					res.setErrorMessageDetails(emd);

					res.setPlanDto(planDto1);
					
					return res;
			  }     else {
				  
				  
				  planRepository.delete(plan);
			  }
			 

			 
			} catch (Exception e) {
				emd.setErrorCode(CommonConstants.USER_DELETE_MESSAGE_FAIL.getValue());
				emd.setErrorMessage(CommonConstants.USER_DELETE_MESSAGE_FAIL.getKey());
				e.printStackTrace();
			}

			emd.setErrorCode(CommonConstantPlan.PLAN_DELETED_MESSAGE_SUCCESS.getValue());
			emd.setErrorMessage(CommonConstantPlan.PLAN_DELETED_MESSAGE_SUCCESS.getKey());
			res.setErrorMessageDetails(emd);

			res.setPlanDto(planDto1);

			return res;
		}

		private Plan toEntity(PlanDto planDto) {

			Plan plan = new Plan();
			plan.setName(planDto.getName());
			plan.setMonthyInstallment(planDto.getMonthyInstallment());
			plan.setMaturityAmount(planDto.getMaturityAmount());
			plan.setDurationPeriod(planDto.getDurationPeriod());
			plan.setCreateDate(new Date());
		    plan.setUpdateDate(new Date());

			return plan;
		}

		private PlanDto toDto(Plan plan) {

			PlanDto planDto = new PlanDto();
			planDto.setPanId(plan.getPanId());
			planDto.setName(plan.getName().trim());
			planDto.setMonthyInstallment(plan.getMonthyInstallment());
			planDto.setMaturityAmount(plan.getMaturityAmount());
			planDto.setDurationPeriod(plan.getDurationPeriod());
			planDto.setCreateDate(dateTOString(plan.getCreateDate()));
            planDto.setUpdateDate(dateTOString(plan.getUpdateDate()));
			return planDto;
		}
		
		Date stringToDate(String date){
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
			Date date1 = null;
			try {
				date1 = sdf.parse(date);

			} catch (Exception e) {
				// TODO: handle exception
			}
			return date1;
			
		}
		String dateTOString(Date date){
				SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
                 String dateToString = sdf.format(date);
				return dateToString;
				
			}
			
	}

/*{"name":"LIC Bima",
 	"monthyInstallment":4000,
		"maturityAmount":1000000,
		"durationPeriod":10
        }*/
