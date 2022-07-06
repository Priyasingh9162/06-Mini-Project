package priya.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import priya.in.repo.ChildRepo;
import priya.in.repo.Repo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		//Repo bean = run.getBean(Repo.class);
		//System.out.println(bean.findAll());
		
		
		}

}
