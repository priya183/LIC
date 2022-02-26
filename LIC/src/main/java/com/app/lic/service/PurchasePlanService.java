package com.app.lic.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lic.constants.CommonConstantPlan;
import com.app.lic.constants.CommonConstantPurchase;
import com.app.lic.dto.ErrorMessageDetails;
import com.app.lic.dto.PurchasePlanDto;
import com.app.lic.dto.PurchasePlanResponse;
import com.app.lic.dto.UserDto;
import com.app.lic.model.AppUsers;
import com.app.lic.model.Plan;
import com.app.lic.model.PurchasePlan;
import com.app.lic.repository.AppUsersRepo;
import com.app.lic.repository.PlanRepository;
import com.app.lic.repository.PurchasePlanRepository;

@Service
public class PurchasePlanService {

	@Autowired
	PurchasePlanRepository purchasePlanRepo;

	@Autowired
	PlanRepository planRepository;

	@Autowired
	AppUsersRepo appUsersRepo;

	public PurchasePlanResponse addPurchasePlan(PurchasePlanDto purchasePlanDto) {

		ErrorMessageDetails emd = new ErrorMessageDetails();
		PurchasePlanResponse res = new PurchasePlanResponse();

		try {

			Plan p = planRepository.findByPanId(purchasePlanDto.getPanId());
			AppUsers appUsers = appUsersRepo.findByAppUserId(purchasePlanDto.getAppUserId());

			if (Objects.nonNull(p) && Objects.nonNull(appUsers)) {
				PurchasePlan pp = new PurchasePlan();
				pp.setPanId(p);
				pp.setAppUserId(appUsers);
				pp.setCreateDate(new Date());

				purchasePlanRepo.save(pp);

				emd.setErrorCode(101);
				emd.setErrorMessage("Plan Successfully Purchased.");

			} else {

				emd.setErrorCode(102);
				emd.setErrorMessage("Plan OR User are not available.");

			}

		} catch (Exception e) {

			emd.setErrorCode(103);
			emd.setErrorMessage(e.getMessage());

		}

		res.setErrorMessageDetails(emd);

		return res;
	}

	public PurchasePlanResponse showAllPurchasePlan(PurchasePlanDto purchasePlanDto) {

		ErrorMessageDetails emd = new ErrorMessageDetails();
		PurchasePlanResponse res = new PurchasePlanResponse();
		PurchasePlanDto purchasePlanDto1=null;
		
		try {
			PurchasePlan purchasePlan= toEntity(purchasePlanDto);

			List<PurchasePlan> purchaseplan = (List<PurchasePlan>) purchasePlanRepo.findAll();

			if (Objects.isNull(purchaseplan)) {

				emd.setErrorCode(CommonConstantPlan.NO_RECORD_FOUND.getValue());
				emd.setErrorMessage(CommonConstantPlan.NO_RECORD_FOUND.getKey());
				res.setErrorMessageDetails(emd);
res.setPurchasePlanDto(purchasePlanDto1);
				
				return res;
			} 
			
				Iterable<PurchasePlan> itr = purchasePlanRepo.findAll();
				itr.forEach(purchasePlan1 -> System.out.println(purchasePlan1));

			
		     
					PurchasePlan purchasePlanDB = (PurchasePlan) purchasePlanRepo.findAll();

					purchasePlanDto1 = toDto(purchasePlanDB);
			

		} catch (Exception e) {
			emd.setErrorCode(CommonConstantPurchase.PURCHASEPLAN_FAILES_TO_GET.getValue());
			emd.setErrorMessage(CommonConstantPurchase.PURCHASEPLAN_FAILES_TO_GET.getKey());
			e.printStackTrace();
		}

		emd.setErrorCode(CommonConstantPurchase.PURCHASEPLAN_GET_SUCCESSFULLY.getValue());
		emd.setErrorMessage(CommonConstantPurchase.PURCHASEPLAN_GET_SUCCESSFULLY.getKey());
		res.setErrorMessageDetails(emd);
         res.setPurchasePlanDto(purchasePlanDto1);
		return res;
	}

	public PurchasePlanResponse showPurchasePlanById(Long purchasePlanId) {

		ErrorMessageDetails emd = new ErrorMessageDetails();
		PurchasePlanResponse res = new PurchasePlanResponse();
		PurchasePlanDto purchasePlanDto1 = null;

		try {

			System.out.println("data" + purchasePlanId);
			PurchasePlan purchasePlans = purchasePlanRepo.findByPurchasePlanId(purchasePlanId);

			if (Objects.isNull(purchasePlans)) {

				emd.setErrorCode(CommonConstantPlan.NO_RECORD_FOUND.getValue());
				emd.setErrorMessage(CommonConstantPlan.NO_RECORD_FOUND.getKey());
				res.setErrorMessageDetails(emd);
                
				return res;
			} else {

				Optional<PurchasePlan> optional = purchasePlanRepo.findById(purchasePlanId);
				PurchasePlan p = optional.get();
				System.out.println(p);
			}

		} catch (Exception e) {
			emd.setErrorCode(CommonConstantPurchase.PURCHASEPLAN_FAILES_TO_GET.getValue());
			emd.setErrorMessage(CommonConstantPurchase.PURCHASEPLAN_FAILES_TO_GET.getKey());
			e.printStackTrace();
		}

		emd.setErrorCode(CommonConstantPurchase.PURCHASEPLAN_GET_SUCCESSFULLY.getValue());
		emd.setErrorMessage(CommonConstantPurchase.PURCHASEPLAN_GET_SUCCESSFULLY.getKey());
		res.setErrorMessageDetails(emd);

		return res;
	}
	private PurchasePlan toEntity(PurchasePlanDto purchasePlanDto) {

		PurchasePlan purchasePlan = new PurchasePlan();
		purchasePlan.setAppUserId(new AppUsers());
		purchasePlan.setPanId(new Plan());
		purchasePlan.setCreateDate(new Date());
		

		return purchasePlan;
	}

	private PurchasePlanDto toDto(PurchasePlan purchasePlan) {

		PurchasePlanDto purchasePlanDto = new PurchasePlanDto();
		purchasePlanDto.setAppUserId(purchasePlan.getPurchasePlanId());
		purchasePlanDto.setPanId(purchasePlan.getPurchasePlanId());
		
		
		return purchasePlanDto;
	}
	
	


//
}
/*
 * {"panId": {++++++++++++++++++++++++++++++ //"panId":2 }, "appUsersId": {
 * "appUsersId":2 } }
 */
