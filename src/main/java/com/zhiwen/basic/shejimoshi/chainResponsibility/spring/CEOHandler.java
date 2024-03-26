package com.zhiwen.basic.shejimoshi.chainResponsibility.spring;

import org.springframework.stereotype.Component;

/**
 * <p></p>
 * @author zhiwen
 * @since 2024/2/20 5:06 下午
 */
@Component("cEOHandler")
public class CEOHandler implements Handler {
    @Override
    public void handleRequest(double amount) {
        System.out.println("CEO approves the reimbursement request.");
    }
}
