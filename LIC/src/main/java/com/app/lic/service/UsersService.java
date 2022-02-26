package com.app.lic.service;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.lic.constants.CommonConstants;
import com.app.lic.dto.ErrorMessageDetails;
import com.app.lic.dto.UserDto;
import com.app.lic.dto.UserResponse;
import com.app.lic.model.AppUsers;
import com.app.lic.model.Transaction;
import com.app.lic.repository.AppUsersRepo;

@Service
public class UsersService {

	@Autowired
	AppUsersRepo appUsersRepo;

	public UserResponse addUser(UserDto userDto) {

		ErrorMessageDetails emd = new ErrorMessageDetails();

UserResponse res = new UserResponse();
		UserDto userDto1 = null;

		try {
			AppUsers appUser = toEntity(userDto);

		  AppUsers appUsers=	appUsersRepo.findByAdharNo(userDto.getAdharNo().trim());
		  
		  
		  if(Objects.nonNull(appUsers)) {
			  
				emd.setErrorCode(CommonConstants.USER_ALREADY_PRESENT_MESSAGE.getValue());
				emd.setErrorMessage(CommonConstants.USER_ALREADY_PRESENT_MESSAGE.getKey());
				res.setErrorMessageDetails(emd);

				res.setUserdto(userDto1);
				
				return res;
		  }
			     
			AppUsers appUserDB = appUsersRepo.save(appUser);

			userDto1 = toDto(appUserDB);

		} catch (Exception e) {
			emd.setErrorCode(CommonConstants.USER_ADDED_MESSAGE_FAIL.getValue());
			emd.setErrorMessage(CommonConstants.USER_ADDED_MESSAGE_FAIL.getKey());
			e.printStackTrace();
		}

		emd.setErrorCode(CommonConstants.USER_ADDED_MESSAGE_SUCCESS.getValue());
		emd.setErrorMessage(CommonConstants.USER_ADDED_MESSAGE_SUCCESS.getKey());
		res.setErrorMessageDetails(emd);

		res.setUserdto(userDto1);

		return res;
	}
	
	
	
	public UserResponse updateUser(UserDto userDto) {

		ErrorMessageDetails emd = new ErrorMessageDetails();
		UserResponse res = new UserResponse();
		UserDto userDto1 = null;

		try {
			AppUsers appUser = toEntity(userDto);

		  AppUsers appUsers=	appUsersRepo.findByAdharNo(userDto.getAdharNo().trim());
		  
		  
		  if(Objects.isNull(appUsers)) {
			  
				emd.setErrorCode(CommonConstants.NO_RECORD_FOUND.getValue());
				emd.setErrorMessage(CommonConstants.NO_RECORD_FOUND.getKey());
				res.setErrorMessageDetails(emd);

				res.setUserdto(userDto1);
				
				return res;
		  }     
		  
		  if (!userDto.getAddress().isEmpty()) {
			  appUsers.setAddress(userDto.getAddress());

		}
		  if (!userDto.getFirstName().isEmpty()) {
			  appUsers.setFirstName(userDto.getFirstName());

		}
		  
		  if (!userDto.getPanNo().isEmpty()) {
			  appUsers.setPanNo(userDto.getPanNo());

		  if (!userDto.getLastName().isEmpty()) {
			  appUsers.setLastName(userDto.getLastName());

		}  if (!userDto.getAdharNo().isEmpty()) {
			  appUsers.setAdharNo(userDto.getAdharNo());

		}
		
		
			AppUsers appUserDB = appUsersRepo.save(appUsers);

			userDto1 = toDto(appUserDB);
		  }
		} catch (Exception e) {
			emd.setErrorCode(CommonConstants.USER_ADDED_MESSAGE_FAIL.getValue());
			emd.setErrorMessage(CommonConstants.USER_ADDED_MESSAGE_FAIL.getKey());
			e.printStackTrace();
		}

		emd.setErrorCode(CommonConstants.USER_UPDATED_MESSAGE_SUCCESS.getValue());
		emd.setErrorMessage(CommonConstants.USER_UPDATED_MESSAGE_SUCCESS.getKey());
		res.setErrorMessageDetails(emd);

		res.setUserdto(userDto1);

		return res;
	}

	public UserResponse deleteUser(String  adharCard) {

		ErrorMessageDetails emd = new ErrorMessageDetails();
		UserResponse res = new UserResponse();
		UserDto userDto1 = null;

		try {
			System.out.println("data"+adharCard.length());

System.out.println("data"+adharCard.trim().length());
		  AppUsers appUsers=	appUsersRepo.findByAdharNo(adharCard.trim());
		  
		  
		  if(Objects.isNull(appUsers)) {
			  
				emd.setErrorCode(CommonConstants.NO_RECORD_FOUND.getValue());
				emd.setErrorMessage(CommonConstants.NO_RECORD_FOUND.getKey());
				res.setErrorMessageDetails(emd);

				res.setUserdto(userDto1);
				
				return res;
		  }     else {
			  
			  
			  appUsersRepo.delete(appUsers);
		  }
		 

		 
		} catch (Exception e) {
			emd.setErrorCode(CommonConstants.USER_DELETE_MESSAGE_FAIL.getValue());
			emd.setErrorMessage(CommonConstants.USER_DELETE_MESSAGE_FAIL.getKey());
			e.printStackTrace();
		}

		emd.setErrorCode(CommonConstants.USER_DELETED_MESSAGE_SUCCESS.getValue());
		emd.setErrorMessage(CommonConstants.USER_DELETED_MESSAGE_SUCCESS.getKey());
		res.setErrorMessageDetails(emd);

		res.setUserdto(userDto1);

		return res;
	}
	public List<UserResponse> showAllUser(UserDto userDto) {

		ErrorMessageDetails emd = new ErrorMessageDetails();
		UserResponse res = new UserResponse();
		UserDto userDto1 = null;

		try {
	        Iterable<AppUsers> itr=	appUsersRepo.findAll();
	        Iterator<AppUsers> iterator = itr.iterator();
			while (iterator.hasNext()) {
				AppUsers a = iterator.next();
				System.out.println(a);
			}
		  
		 
				res.setUserdto(userDto1);
				
				return (List<UserResponse>) res;
		 
		} catch (Exception e) {
			emd.setErrorCode(CommonConstants.USER_NOT_GET_SUCCESSFULLTY.getValue());
			emd.setErrorMessage(CommonConstants.USER_NOT_GET_SUCCESSFULLTY.getKey());
			e.printStackTrace();
		}

		emd.setErrorCode(CommonConstants.USER_GET_SUCCESSFULLY.getValue());
		emd.setErrorMessage(CommonConstants.USER_GET_SUCCESSFULLY.getKey());
		res.setErrorMessageDetails(emd);

		res.setUserdto(userDto1);

		return (List<UserResponse>) res;
	}

	private AppUsers toEntity(UserDto userDto) {

		AppUsers appuser = new AppUsers();
		appuser.setAddress(userDto.getAddress().trim());
		appuser.setFirstName(userDto.getFirstName().trim());
		appuser.setLastName(userDto.getLastName().trim());
		appuser.setPanNo(userDto.getPanNo().trim());
		appuser.setAdharNo(userDto.getAdharNo().trim());

		return appuser;
	}

	private UserDto toDto(AppUsers appUsers) {

		UserDto userDto = new UserDto();
		userDto.setAddress(appUsers.getAddress());
		userDto.setFirstName(appUsers.getFirstName());
		userDto.setLastName(appUsers.getLastName());
		userDto.setPanNo(appUsers.getPanNo());
		userDto.setAdharNo(appUsers.getAdharNo());

		return userDto;
	}
	
	

}
