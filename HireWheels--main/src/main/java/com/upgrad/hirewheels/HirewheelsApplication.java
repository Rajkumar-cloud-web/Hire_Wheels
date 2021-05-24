package com.upgrad.hirewheels;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.services.*;
import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootApplication
public class HirewheelsApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(HirewheelsApplication.class, args);
		RoleDao roleDao = context.getBean(RoleDao.class);
		UserDao userDao = context.getBean(UserDao.class);
		FuelTypeDao fuelTypeDao= context.getBean(FuelTypeDao.class);
		LocationDao locationDao= context.getBean(LocationDao.class);
		AdminService adminService=context.getBean(AdminService.class);
		VehicleSubCategoryDao vehicleSubCategoryDao= context.getBean(VehicleSubCategoryDao.class);
		UserService userService=context.getBean(UserService.class);
		VehicleDao vehicleDao =context.getBean(VehicleDao.class);
		BookingService bookingService =context.getBean(BookingService.class);
		VehicleService vehicleService = context.getBean(VehicleService.class);
		InitService initService = context.getBean(InitService.class);
		initService.start();






		Role role1 = new Role();
		Role role2 = new Role();
		role1.setRoleName("User");
		role2.setRoleName("Admin");
		role1 = roleDao.save(role1);
		role2 = roleDao.save(role2);

		User user1 = new User();
		user1.setFirstName("Deepender");
		user1.setLastName("Goyal");
		user1.setEmail("dp@gmail.com");
		user1.setPassword("zomato");
		user1.setMobileNo(9999489489l);
		user1.setWalletMoney(500);
		user1.setRole(role2);

		try {
			userService.createUser(user1);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}

		User user2 = new User();
		user2.setFirstName("Larry");
		user2.setLastName("Page");
		user2.setEmail("lp@gmail.com");
		user2.setPassword("google");
		user2.setMobileNo(9943486789l);
		user2.setWalletMoney(500);
		user2.setRole(role1);

		try {
			userService.createUser(user2);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}

		User user3 = new User();
		user3.setFirstName("Sergey");
		user3.setLastName("Brin");
		user3.setEmail("sb@gmail.com");
		user3.setPassword("google");
		user3.setMobileNo(9956489489l);
		user3.setWalletMoney(500);
		user3.setRole(role1);

		try {
			userService.createUser(user3);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}

		// to check for unique emailId
		User users4 = new User();
		users4.setFirstName("abhi");
		users4.setLastName("mishra");
		users4.setPassword("123456");
		users4.setWalletMoney(800);
		users4.setEmail("sb@gmail.com");// repeated emailId
		users4.setMobileNo(889988998l);
		users4.setRole(role1);
		try {
			userService.createUser(users4);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}

		User users5 = new User();
		users5.setFirstName("raj");
		users5.setLastName("dr");
		users5.setPassword("123456");
		users5.setWalletMoney(700);
		users5.setEmail("dr.raj.com");
		users5.setMobileNo(9943486789l);//repeated Phone number
		users5.setRole(role1);
		try {
			userService.createUser(users5);
		} catch (UserAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println( userService.getUser("dp@gmail.com", "zomato"));
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		try {
			System.out.println(userService.getUser("guru","123456"));

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

		try {
			System.out.println(userService.getUser("guru.com","123455"));

		}catch (Exception e){
			System.out.println(e.getMessage());
		}


		// to check adminService
		Vehicle vehicle= new Vehicle();
		vehicle.setVehicleModel("new");
		vehicle.setVehicleNumber(007);
		vehicle.setColor("red");
		vehicle.setAvailabilityStatus(true);
		vehicle.setVehicleImgUrl("image.url");
		vehicle.setVehicleSubCategory(vehicleSubCategoryDao.findById(9).get());
		vehicle.setFuelType(fuelTypeDao.findById(5).get());
		vehicle.setLocation(locationDao.findById(3).get());

		adminService.registerVehicle(vehicle);

		//adminService.changeAvailability(vehicle);



// to check bookingService
		Booking booking= new Booking();
		booking.setBookingDate(LocalDateTime.now());
		booking.setPickupDate(LocalDateTime.now());
		booking.setDropOffDate(LocalDateTime.now());
		booking.setAmount(150);
		booking.setLocation(locationDao.findById(4).get());
		booking.setUser(userDao.findById(17).get());
		booking.setVehicle(vehicleDao.findById(20).get());
		try{
			bookingService.addBooking(booking, user1);
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
// to test vehicleService
		System.out.println("vehicle list");
		List<Vehicle> vehicleList	= vehicleService.getAllVehicles();
		vehicleList.forEach(System.out::println);
		System.out.println("available vehicle");
		System.out.println(vehicleService.getAvailableVehicles(booking));






	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	}



