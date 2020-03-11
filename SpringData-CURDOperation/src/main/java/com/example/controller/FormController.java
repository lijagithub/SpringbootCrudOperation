package com.example.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.constants.AppConstants;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.user.User;
@Controller
public class FormController {
	
	@Autowired
	private UserRepository userRepo;
	
	/**
	 * This Method Used For Select List of countries in table
	 * @param model
	 * @return attribute
	 */
	private static void loadCountriesData(Model model) {
		List<String> countries=new ArrayList();
		countries.add("India");
		countries.add("USA");
		countries.add("UK");
		countries.add("Austrelia");
		countries.add("Germany");
		countries.add("London");
		model.addAttribute("countriesList",countries);
	}
	
	
	/**
	 * This method used for to show UI page for UserRegistration 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="/form")
	public String Form(Model model) {
		model.addAttribute(AppConstants.APP_REG_LINK,"USER REGISTRATION FORM");
		return  AppConstants.APP_REG_FORM;
	}
	
	
	/**
	 * This method used for to load a "Form" in UI page 
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="/regUser")
	public String loadForm(Model model) {
		User userObj=new User();
		model.addAttribute(AppConstants.APP_REGISTER,userObj);//user
		loadCountriesData(model);
		return  AppConstants.APP_REGISTER_PAGE;	//regPage(jsp file name-logical view name)
	}
	
	
	/**
	 * This Method used for Register that "Form" in Database
	 * (create Table and Store the Data in Table)
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="/regUser",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user,Model model) {
		UserEntity entity=new UserEntity();
		
		BeanUtils.copyProperties(user, entity);
		
		UserEntity savedEntity=userRepo.save(entity);
		
		if(savedEntity== null ) {
			model.addAttribute(AppConstants.APP_SUCCMSG,"RegisterFailed");//succMsg
		}
		else {
		model.addAttribute(AppConstants.APP_SUCCMSG,"SucessfullyRegister");
	}
		loadCountriesData(model);
		return AppConstants.APP_RESULT_DISPLAY;//result(jsp File name)	
	}
	
	
	/**
	 * This method is Used for to RetriveAll The Record and 
	 * show the Data in a Table format
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="/viewUser")
	public String viewUsers(Model model) {
		Iterable<UserEntity> userEntity = userRepo.findAll();
		List<User> userList = new ArrayList();
		for(UserEntity entity : userEntity) {
			User user = new User();
		BeanUtils.copyProperties(entity, user);
		userList.add(user);
		}
		model.addAttribute(AppConstants.DISPLAYS_USERLIST,userList);//userList(c:forEach=items name)
		loadCountriesData(model);
		return AppConstants.DISPLAY_USERS_VIEW;//viewPage(jsp file name)
	}
	
	
	/**
	 * This Mehod is Used for Delete the record By Using userId
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="deleteUser")
	
	public String deleteUserById(int userid) {
		userRepo.deleteById(userid);
		return "redirect:viewUser";	//invoke the viewUser Method	
	}
	/*public String deleteUserById(@RequestParam("id")Integer id) {
		//userDao.deleteById(id);
		userRepo.softDelete("N", id);
		return "redirect:/viewAll?pn=1";
	}*/

	
	/**
	 * This Method Is Used for Edit the data in that Table
	 * @param model
	 * @return String
	 */
	@RequestMapping(value="/editUser")
	public String editUser(@RequestParam("uid") int userid,Model model) {
		Optional<UserEntity> optEntity=userRepo.findById(userid);
		
		if(optEntity.isPresent()) {
			UserEntity entity = optEntity.get();
			User user = new User();
			BeanUtils.copyProperties(entity,user);
			model.addAttribute(AppConstants.APP_REGISTER,user);//user
		}
			loadCountriesData(model);
		return AppConstants.EDIT_USER_VIEW;//editUser
	}
	
	
	/**
	 * This Method is used for Update The data
	 * @param model
	 * @return String
	 */
	@RequestMapping(value ="/updateUser",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user,Model model,@RequestParam("uid") int userid) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user,entity);
		entity.setUserid(userid);
		userRepo.save(entity);
		model.addAttribute(AppConstants.UPDATE_USER,"Records Successfully Updated");//updateMsg
		
		return AppConstants.APP_RESULT_DISPLAY;//result
	}
	
	
	@RequestMapping(value="/pagingViewUser")
	public String pagingWithviewUser(Model model, @RequestParam("pn") int crntPageNo) {
		
		int pageSize = 3;
		
		PageRequest page = PageRequest.of(crntPageNo-1, pageSize);
		
		Page<UserEntity> pageData = userRepo.findAll(page);   
		
		List<UserEntity> userEntities = pageData.getContent();
		int totalPages = pageData.getTotalPages();
		model.addAttribute("tp",totalPages);
		
		List<User> userList = new ArrayList();
		for(UserEntity entity : userEntities) {
			User user = new User();
		BeanUtils.copyProperties(entity, user);
		userList.add(user);
		}
		model.addAttribute(AppConstants.DISPLAYS_USERLIST,userList);//userList(c:forEach=items name)
		loadCountriesData(model);
		return AppConstants.DISPLAY_USERS_VIEW;//viewPage(jsp file name)
	}
	
}