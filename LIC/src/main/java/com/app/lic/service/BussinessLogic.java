package com.app.lic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.lic.dto.TransactionDto;
import com.app.lic.model.AppUsers;
import com.app.lic.model.Plan;
import com.app.lic.model.Transaction;
import com.app.lic.repository.PlanRepository;
import com.app.lic.repository.TransactionRepository;

@Component
public class BussinessLogic {

	@Autowired
	TransactionRepository transactionRepo;

	@Autowired
	PlanRepository planRepository;

	public Long calculateTotalAmountPaid(Long appUserId, Long panId) {
		List<Transaction> list =  transactionRepo.findByAppUserIdAndPanId(appUserId, panId);
		Long amountPaid = 0L;
		for (Transaction  transaction: list) {
			amountPaid = (Long) (amountPaid + transaction.getAmountPaid());

		}
		
		return amountPaid;
	}

	

	public Integer getTotalAmount(Long panId, long monthlyInstallment1, Integer duration_period) {
		Plan plan = planRepository.findByPanId(panId);
		Long monthlyInstallment = plan.getMonthyInstallment();
		Integer durationPeriod = plan.getDurationPeriod();
		Integer totalAmountPaid = (int) (12 * monthlyInstallment * durationPeriod);

		return totalAmountPaid;
	}

	public Long getRemainingAmount(Long appUserId,Long panId) {
		Plan plan = planRepository.findByPanId(panId);
		Long paidAmount = calculateTotalAmountPaid(appUserId, panId);
		Integer amountToPaid = getTotalAmount(panId, plan.getMonthyInstallment(), plan.getDurationPeriod());
		Long remainingAmount = (long) (amountToPaid - paidAmount);
		return remainingAmount;
	}
	public Long getTotalInstallmentCount(Long panId,Long monthly_insallment,Integer duration_period)
	{
		Plan plan = planRepository.findByPanId(panId);
		Integer durationPeriod=plan.getDurationPeriod();
		Long monthlyInstallment = plan.getMonthyInstallment();
		Long totalInsallmentCount=0L;
		if(monthlyInstallment!=0L)
		{
			totalInsallmentCount = (Long) ((monthlyInstallment * 12 * durationPeriod) / monthlyInstallment);
		}
		return totalInsallmentCount;
	}
	public Long getPaidInstallmentCount( Long appUserId,Long panId)
	{
		Plan p=planRepository.findByPanId(panId);
		Long monthlyInstallment=p.getMonthyInstallment();
		Long amountPaid=calculateTotalAmountPaid(appUserId, panId);
		Long paidInstallmentCount=0L;
		
		if (amountPaid != null && amountPaid != 0) {

			if (amountPaid != 0L && amountPaid != null && monthlyInstallment != 0L) {

				paidInstallmentCount =amountPaid / monthlyInstallment;
			}
			
		}
		return paidInstallmentCount;
	}
	public Long remainingInstallmentCount( Long appUserId,Long panId)
	{
		Plan plan = planRepository.findByPanId(panId);
		Long TotalInsallmentCount = getTotalInstallmentCount(panId,plan.getMonthyInstallment(),plan.getDurationPeriod());
		Long paidInstallmentCount = getPaidInstallmentCount(panId,appUserId);
		Long remainingInstallmentCount=TotalInsallmentCount-paidInstallmentCount;
		return remainingInstallmentCount;
	}
}
            
