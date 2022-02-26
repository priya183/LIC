package com.app.lic.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.lic.dto.TransactionDetailsDto;
import com.app.lic.dto.TransactionDto;
import com.app.lic.dto.TransactionResponse;
import com.app.lic.model.AppUsers;
import com.app.lic.model.Plan;
import com.app.lic.model.Transaction;
import com.app.lic.repository.AppUsersRepo;
import com.app.lic.repository.PlanRepository;
import com.app.lic.repository.TransactionRepository;
import com.app.lic.service.BussinessLogic;
import com.app.lic.service.TransactionService;

import javassist.bytecode.Descriptor.Iterator;

@RestController
public class TestController {
	@Autowired
	TransactionService transactionService;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	PlanRepository planRepository;

	@Autowired
	AppUsersRepo appUsersRepo;

	@PostMapping("/testMe")
	public List<Transaction> testMe(@RequestBody TransactionDto transactionDto) {

		return transactionRepository.findByAppUserIdAndPanId(transactionDto.getAppUserId(), transactionDto.getPanId());

	}

	@PostMapping("/showCount")
	public TransactionDetailsDto showData(@RequestBody TransactionDto transactionDto) {
		
		BussinessLogic bussinessLogic = new BussinessLogic();
		TransactionDetailsDto tDto = new TransactionDetailsDto();
		Plan plan = planRepository.findByPanId(transactionDto.getPanId());
		AppUsers appusers = appUsersRepo.findByAppUserId(transactionDto.getAppUserId());
        Transaction tt=new Transaction();
		if (Objects.nonNull(plan) && Objects.nonNull(appusers)) {
			System.out.println("userId " +transactionDto.getAppUserId());
			
			System.out.println("planId " +transactionDto.getPanId());

			List<Transaction> t = transactionRepository.findByAppUserIdAndPanId(transactionDto.getAppUserId(),transactionDto.getPanId());
             System.out.println(t);
			Long remainingInstallmentCount = 0L;
			Long TotalInstallmetCount = 0L;
            Long paidInstallmetCount = 0L;

			Integer durationPeriod = plan.getDurationPeriod();
			Long monthlyInstallment = plan.getMonthyInstallment();
			Long amountPaid =0L;
		
			for (Transaction  transaction: t) {
				amountPaid = (Long) (amountPaid + transaction.getAmountPaid());
                }
			if (amountPaid != null && amountPaid != 0) {

				if (amountPaid != 0L && amountPaid != null && monthlyInstallment != 0L) {
					

					paidInstallmetCount =(amountPaid / monthlyInstallment);
				}
				tDto.setPaidInstallmetCount(paidInstallmetCount);
			}
			if (monthlyInstallment != 0L) {

				TotalInstallmetCount = (monthlyInstallment * 12 * durationPeriod) / monthlyInstallment;
			}

			remainingInstallmentCount = TotalInstallmetCount - paidInstallmetCount;
			tDto.setTotalInstallmetCount(TotalInstallmetCount);
			tDto.setRemainInstallmentCount(remainingInstallmentCount);
            
			tDto.setListTxn(t);

		}

		return tDto;
	}
	@PostMapping("/showCount2")
	public TransactionDetailsDto showData2(@RequestBody TransactionDto transactionDto)
	{
		BussinessLogic bussinessLogic = new BussinessLogic();
		TransactionDetailsDto tDto = new TransactionDetailsDto();
		Plan plan = planRepository.findByPanId(transactionDto.getPanId());
		AppUsers appusers = appUsersRepo.findByAppUserId(transactionDto.getAppUserId());

		if (Objects.nonNull(plan) && Objects.nonNull(appusers)) {
System.out.println("userId " +transactionDto.getAppUserId());
			
			System.out.println("planId " +transactionDto.getPanId());

			List<Transaction> t = transactionRepository.findByAppUserIdAndPanId(transactionDto.getAppUserId(),transactionDto.getPanId());
			System.out.println(t);
			Long totalInsallmentCount=bussinessLogic.getTotalInstallmentCount(transactionDto.getPanId(),plan.getMonthyInstallment(),plan.getDurationPeriod());
			tDto.setTotalInstallmetCount(totalInsallmentCount);
			
			Long paidInstallmentCount=bussinessLogic.getPaidInstallmentCount(transactionDto.getPanId(), transactionDto.getAppUserId());
			tDto.setRemainInstallmentCount(paidInstallmentCount);
			
			Long  reminaningInstallmentCount=bussinessLogic.getRemainingAmount(transactionDto.getPanId(), transactionDto.getAppUserId());
            tDto.setRemainInstallmentCount(reminaningInstallmentCount);
			tDto.setListTxn(t);
			
		}

		return tDto;
	}
	@PostMapping("/showAll")
	public TransactionDetailsDto showAll(@RequestBody TransactionDto transactionDto)
	{
		TransactionDetailsDto t=new TransactionDetailsDto();
		BussinessLogic bussinessLogic=new BussinessLogic();
		Long paidInstallmentCount=bussinessLogic.getPaidInstallmentCount(transactionDto.getPanId(), transactionDto.getAppUserId());
		
		return t;
	}
	@GetMapping("/user")
	    public String home() {
	        System.out.println("Going home...");
	        return "user";
	}

}










































/*
 * @GetMapping("/test") public List<Transaction> getData(@RequestBody
 * TransactionDto tDto) {
 * 
 * System.out.println("Data 0"+t);
 * 
 * List<Tra list =
 * 
 * for () {
 * 
 * planId
 * 
 * } TransactionDto tDto = new TransactionDto(); Plan p = new Plan(); Long
 * totalInstallmentPaid = 0L; tDto.setAmountPaid((long) 100000);
 * tDto.setRemainingAmount(t.getRemainingAmount()); Integer durationPeriod =
 * p.getDurationPeriod(); Long monthlyInstallment = p.getMonthyInstallment();
 * Long amountPaid = t.getAmountPaid();
 * 
 * if (amountPaid != null && amountPaid != 0) { Long totalInstallment = null; if
 * (amountPaid != 0L && amountPaid != null && monthlyInstallment != 0L) {
 * 
 * totalInstallmentPaid = amountPaid / monthlyInstallment; }
 * tDto.setTotalInsallmentPaid(totalInstallmentPaid);
 * 
 * if (monthlyInstallment != 0L) {
 * 
 * totalInstallment = (monthlyInstallment * 12 * durationPeriod) /
 * monthlyInstallment; }
 * 
 * Long remainingInstallment = totalInstallment - totalInstallmentPaid;
 * tDto.setRemainingInstallment(remainingInstallment); } return tDto; }
 */

/*
 * @PostMapping("/count") public Long count(@RequestBody TransactionDto
 * transactionDto) { Long
 * count=transactionRepository.count(transactionDto.getAppUserId(),
 * transactionDto.getPanId()); return count;
 * 
 * }
 */

/*
 * @GetMapping("/testShowAllTransaction") public List<Transaction>
 * showAllTransaction() { return (List<Transaction>)
 * transactionRepository.findAll(); }
 * 
 * /*@GetMapping("/testShowAll") public Iterable<AppUsers> testShowAllUsers() {
 * return appUsersRepo.findAll(); } /*
 * 
 * @GetMapping("/totalInstallmentPaid") public long count() { long
 * count=transactionRepository.count(); return count; }
 */
