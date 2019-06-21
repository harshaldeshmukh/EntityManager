package com.example.spring.entitymanager;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spring.entitymanager.Repository.CourseRepository;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class EntitiyManagerDemoApplication implements CommandLineRunner {
	
	private Logger logger= org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepositoryImpl sudentImp;
	
	public static void main(String[] args) {
		SpringApplication.run(EntitiyManagerDemoApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		Course cousr=	courseRepository.findById(10000L);
		//List<Course> cous=	courseRepository.criteria();
		sudentImp.nameByCourse();
		
		sudentImp.completedProject();
		//sudentImp.FindByOpps();
	
		//logger.info("Couse -----------------------{}"  , cous);
		logger.info("Couse ------------&&&&&&&&&&&&& FinfByOpps *********************"  , sudentImp.FindByOpps());
		
		
		logger.info("Couse ------------sdfsgsf-----------{}"  , sudentImp.nameByCourse());
		
		
		logger.info("Couse ------------sudentImp.completedProject();-----------{}"  , sudentImp.completedProject());
		
	}
	
	

}
