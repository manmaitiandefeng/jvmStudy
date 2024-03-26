package com.zhiwen.basic.shejimoshi.chainResponsibility.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 * @author zhiwen
 * @since 2024/2/20 5:05 下午
 */
@Component
public class ManagerHandler implements Handler {
    private Handler nextHandler;

    @Autowired
    public void setNextHandler(@Qualifier("directorHandler") Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(double amount) {
        if (amount <= 1000) {
            System.out.println("Manager approves the reimbursement request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        } else {
            System.out.println("No one can approve the reimbursement request.");
        }
    }
}
