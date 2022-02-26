package com.app.lic.service;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lic.constants.CommonConstants;
import com.app.lic.dto.ErrorMessageDetails;
import com.app.lic.dto.PlanDto;
import com.app.lic.dto.PlanResponse;
import com.app.lic.dto.TransactionDto;
import com.app.lic.dto.TransactionResponse;
import com.app.lic.dto.UserDto;
import com.app.lic.dto.UserResponse;
import com.app.lic.model.AppUsers;
import com.app.lic.model.Plan;
import com.app.lic.model.Transaction;
import com.app.lic.repository.AppUsersRepo;
import com.app.lic.repository.PlanRepository;
import com.app.lic.repository.TransactionRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	PlanRepository planRepository;

	@Autowired
	AppUsersRepo appUsersRepo;

	@Autowired
	BussinessLogic bussinessLogic;

	public TransactionResponse addTransaction(TransactionDto transactionDto) {

		ErrorMessageDetails emd = new ErrorMessageDetails();
		TransactionResponse res = new TransactionResponse();
		TransactionDto transactionDto1=null;
   
		try {

			Plan p = planRepository.findByPanId(transactionDto.getPanId());
			AppUsers appUsers = appUsersRepo.findByAppUserId(transactionDto.getAppUserId());

			if (Objects.nonNull(p) && Objects.nonNull(appUsers)) {
				Transaction t = new Transaction();
				t.setPanId(p);
				t.setAppUserId(appUsers);
				t.setAmountPaid(p.getMonthyInstallment());
				// Long r=bussinessLogic.getRemainingAmount(p.getPanId(), appUsers);

				Long remainingAmt = bussinessLogic.getRemainingAmount(transactionDto.getPanId(),
						transactionDto.getAppUserId());
				t.setRemainingAmount(remainingAmt);
                
				transactionRepository.save(t);
			      res.setTransactionDto(transactionDto1);
				emd.setErrorCode(101);
				emd.setErrorMessage("Transaction Successfully added.");

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

	
	public List<Transaction> showData(TransactionDto transactiondto) {

	
		try {
		Plan p = planRepository.findByPanId(transactiondto.getPanId());
		AppUsers appUsers = appUsersRepo.findByAppUserId(transactiondto.getAppUserId());

		if (Objects.nonNull(p) && Objects.nonNull(appUsers)) {
				Transaction t = new Transaction();
				TransactionDto tDto = new TransactionDto();
				Long totalInstallmentPaid = 0L;
				
				tDto.setAmountPaid(t.getAmountPaid());
				tDto.setRemainingAmount(t.getRemainingAmount());
				Integer durationPeriod = p.getDurationPeriod();
				Long monthlyInstallment = p.getMonthyInstallment();
				Long amountPaid = t.getAmountPaid();

				if (amountPaid != null && amountPaid != 0) {
					Long totalInstallment = null;
					if (amountPaid != 0L && amountPaid != null && monthlyInstallment != 0L) {

						totalInstallmentPaid = amountPaid / monthlyInstallment;
					}
					tDto.setTotalInsallmentPaid(totalInstallmentPaid);

					if (monthlyInstallment != 0L) {

						totalInstallment = (monthlyInstallment * 12 * durationPeriod) / monthlyInstallment;
					}

					Long remainingInstallment = totalInstallment - totalInstallmentPaid;
					tDto.setRemainingInstallment(remainingInstallment);
				}
			
				
				transactionRepository.save(t);
		
			   
			   
			} else {

			
			}

		} catch (Exception e) {

			

		}
	return null;
	}


	//Conversion Transaction Dto to transaction entity
	 private Transaction toEntity(TransactionDto transactionDto) {
	  
	  Transaction transaction = new Transaction();
	  transaction.setAppUserId(new AppUsers()); transaction.setPanId(new Plan());
	  transaction.setAmountPaid(transactionDto.getAmountPaid());
	  transaction.setRemainingAmount(transactionDto.getRemainingAmount());
	  return transaction;
	  }
	 //entity to dto
	  private TransactionDto toDto(Transaction transaction) {
	 
	 TransactionDto transactionDto = new TransactionDto(); 
	 
	  transactionDto.setAmountPaid(transaction.getAmountPaid());
	  transactionDto.setRemainingAmount(transaction.getRemainingAmount());
	  
	  return transactionDto;
	  }
	 

}
/*
 * Transaction t=new Transaction(); Long
 * r=bussinessLogic.getRemainingAmount(panId, appUserId);
 * t.setRemainingAmount(r);
 */
/*Long monthlyInstallment=p.getMonthyInstallment();
Long amountPaid=t.getAmountPaid();
Long totalInstallmentPaid=amountPaid/monthlyInstallment;
transactionDto1.setTotalInsallmentPaid(totalInstallmentPaid);

Integer durationPeriod=p.getDurationPeriod();
Long totalInstallment=(monthlyInstallment*12*durationPeriod)/monthlyInstallment;
Long remainingInstallment=totalInstallment-totalInstallmentPaid;
transactionDto1.setRemainingInstallment(remainingInstallment);*/

//show simply all detail without TransactionResponse
	/*
	 * @JsonIgnore public List<Transaction> showTDetail(Long panId, Long appUserId)
	 * {
	 * 
	 * List<Transaction> list = (List<Transaction>)
	 * transactionRepository.findByAppUserIdAndPanId(appUserId, panId);
	 * 
	 * return list; }
	 */

	/*
	 * public List<Transaction> showDetailByPanIdAndUserId(Long appUserId, Long
	 * panId) {
	 * 
	 * return transactionRepository.findByAppUserIdAndPanId(appUserId, panId); }
	 */
