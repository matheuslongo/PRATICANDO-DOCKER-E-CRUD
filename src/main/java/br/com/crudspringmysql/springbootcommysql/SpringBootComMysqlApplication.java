package br.com.crudspringmysql.springbootcommysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.crudspringmysql.springbootcommysql.*")
@EntityScan(basePackages = "br.com.crudspringmysql.springbootcommysql.model")
public class SpringBootComMysqlApplication {

	public static void main(String[] args) {
		System.out.println("entrou");
		SpringApplication.run(SpringBootComMysqlApplication.class, args);
	}

}
