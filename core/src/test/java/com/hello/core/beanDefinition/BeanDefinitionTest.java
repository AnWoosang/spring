package com.hello.core.beanDefinition;

import com.hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext ac1 = new GenericXmlApplicationContext("AppConfig.xml");

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void 메타정보확인() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition bd = ac.getBeanDefinition(beanDefinitionName);

            if (bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("bd = " + beanDefinitionName + "\n- 해당 bd 객체 { " + bd + "}");
            }
        }
    }


    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void 메타정보확인2() {
        String[] beanDefinitionNames = ac1.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition bd = ac1.getBeanDefinition(beanDefinitionName);

            if (bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("bd = " + beanDefinitionName + "\n- 해당 bd 객체 { " + bd + "}");
            }
        }
    }

}
