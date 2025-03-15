package com.complaint_mngmt.maintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.complaint_mngmt.maintenance")
public class MaintenanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MaintenanceApplication.class, args);
	}
}
