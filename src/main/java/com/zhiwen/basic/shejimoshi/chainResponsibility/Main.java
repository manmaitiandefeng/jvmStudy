package com.zhiwen.basic.shejimoshi.chainResponsibility;

/**
 * <p></p>
 * @author zhiwen
 * @since 2024/2/20 4:58 下午
 */
public class Main {
    public static void main(String[] args) {
        // 创建处理者
        Handler managerHandler = new ManagerHandler();
        Handler directorHandler = new DirectorHandler();
        Handler ceoHandler = new CEOHandler();

        // 设置责任链顺序
        managerHandler.setNextHandler(directorHandler);
        directorHandler.setNextHandler(ceoHandler);

        // 提交报销申请
        managerHandler.handleRequest(800); // Manager approves the reimbursement request.
        managerHandler.handleRequest(3000); // Director approves the reimbursement request.
        managerHandler.handleRequest(10000); // CEO approves the reimbursement request.
    }
}

interface Handler {
    void handleRequest(double amount);
    void setNextHandler(Handler nextHandler);
}

class ManagerHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
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

class DirectorHandler implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(double amount) {
        if (amount <= 5000) {
            System.out.println("Director approves the reimbursement request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        } else {
            System.out.println("No one can approve the reimbursement request.");
        }
    }
}

class CEOHandler implements Handler {
    @Override
    public void handleRequest(double amount) {
        System.out.println("CEO approves the reimbursement request.");
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        throw new UnsupportedOperationException("CEO is the final approver.");
    }
}

