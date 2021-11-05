package com.mooc.sb2;

import com.mooc.sb2.initializer.SecondInitializer;
import com.mooc.sb2.listener.SecondListener;
import com.mooc.sb2.selector.MyDeferredImportSelector;
import com.mooc.sb2.selector.MyImportSelector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@MapperScan("com.mooc.sb2.mapper")
@Import({MyImportSelector.class, MyDeferredImportSelector.class})
//@ImportResource("ioc/demo.xml")
//@PropertySource("demo.properties")
public class Sb2Application {

//	@Autowired
//	private Solid solid;

	public static void main(String[] args) {
//		SpringApplication.run(Sb2Application.class, args);

		SpringApplication springApplication = new SpringApplication(Sb2Application.class);
		springApplication.addInitializers(new SecondInitializer());
		springApplication.addListeners(new SecondListener());
		springApplication.run(args);


//		System.out.println("hello");
//		Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close jvm")));
//		System.out.println("word");
	}

}
