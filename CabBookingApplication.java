package com.example.cabbooking;

import com.example.cabbooking.model.Driver;
import com.example.cabbooking.model.Location;
import com.example.cabbooking.model.User;
import com.example.cabbooking.model.Vehicle;
import com.example.cabbooking.service.DriverService;
import com.example.cabbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CabBookingApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private DriverService driverService;

	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Onboard users
		userService.addUser(new User("Abhishek", "M", 23));
		userService.addUser(new User("Rahul", "M", 29));
		userService.addUser(new User("Nandini", "F", 22));

		// Onboard drivers
		driverService.addDriver(new Driver("Driver1", "M", 22, new Vehicle("Swift", "KA-01-12345"), new Location(10, 1), true));
		driverService.addDriver(new Driver("Driver2", "M", 29, new Vehicle("Swift", "KA-01-12345"), new Location(11, 10), true));
		driverService.addDriver(new Driver("Driver3", "M", 24, new Vehicle("Swift", "KA-01-12345"), new Location(5, 3), true));

		// Find and choose rides
		System.out.println(driverService.findRides(new Location(0, 0), new Location(20, 1))); // Output: No ride found
		System.out.println(driverService.findRides(new Location(10, 0), new Location(15, 3))); // Output: Driver1 [Available]
		System.out.println(driverService.findRides(new Location(15, 6), new Location(20, 4))); // Output: No ride found

		driverService.chooseRide("Rahul", "Driver1");
	}
}
