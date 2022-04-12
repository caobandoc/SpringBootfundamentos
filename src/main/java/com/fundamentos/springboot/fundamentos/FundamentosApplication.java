package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDepenedency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDepenedency componentDepenedency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	public FundamentosApplication(@Qualifier("componentImplementTwo") ComponentDepenedency componentDepenedency, MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency) {
		this.componentDepenedency = componentDepenedency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDepenedency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}
}