package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaShopApplication {

	public static void main(String[] args) {
//		Hello hello = new Hello();
//		hello.setData("hello");
//		String data = hello.getData();
//		System.out.println("data = " + data);

		SpringApplication.run(JpaShopApplication.class, args);
	}

	@Bean
	Hibernate5Module hibernate5Module() {
		return new Hibernate5Module();
	}

}
