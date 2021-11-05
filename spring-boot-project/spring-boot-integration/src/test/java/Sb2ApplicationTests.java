package com.mooc.sb2;

import com.mooc.sb2.bean.Demo;
import com.mooc.sb2.bean.DemoExample;
import com.mooc.sb2.condi.A;
import com.mooc.sb2.event.WeatherRunListener;
import com.mooc.sb2.ioc.ann.MyImportBeanDefinitionRegistrar;
import com.mooc.sb2.ioc.ann.Teacher;
import com.mooc.sb2.ioc.xml.HelloService;
import com.mooc.sb2.mapper.DemoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Sb2Application.class})
@Import(MyImportBeanDefinitionRegistrar.class)
//@ContextConfiguration(locations = "classpath:ioc/demo.xml")
public class  Sb2ApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private WeatherRunListener weatherRunListener;

    @Autowired
    private HelloService helloService;

    @Autowired
    private Teacher teacher;


    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    @Test
    public void testEvent() {
        weatherRunListener.rain();
        weatherRunListener.snow();
    }


    @Test
    public void testA() {
        System.out.println(applicationContext.getBean(A.class));
    }

    @Test
    public void testB() {
        Demo demo = new Demo();
        demo.setName("xx");
        demo.setJob("student");
        System.out.println(demoMapper.insert(demo));
    }


    @Test
    public void testQuery() {
        DemoExample demoExample = new DemoExample();
        demoExample.createCriteria().andJobEqualTo("student");
        List<Demo> demoList = demoMapper.selectByExample(demoExample);
    }

    @Test
    public void testHello() {
        System.out.println(helloService.getAnimal().toString());
    }


    @Test
    public void testTeacher() {
        System.out.println(teacher.getName());
    }
}
