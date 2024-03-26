package com.zhiwen.basic.shejimoshi.chainResponsibility.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p></p>
 * @author zhiwen
 * @since 2024/2/20 5:09 下午
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Handler handler = context.getBean(ManagerHandler.class);

        // 提交报销申请
        handler.handleRequest(800); // Manager approves the reimbursement request.
        handler.handleRequest(3000); // Director approves the reimbursement request.
        handler.handleRequest(10000); // CEO approves the reimbursement request.
    }
}
