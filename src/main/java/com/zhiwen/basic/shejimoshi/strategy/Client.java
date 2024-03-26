package com.zhiwen.basic.shejimoshi.strategy;

/**
 * <p>ChatGPT
 * 策略模式（Strategy Pattern）是一种行为设计模式，它定义了一系列算法，将每个算法封装起来，并且使它们可以互相替换。策略模式可以使算法的变化独立于使用它们的客户端。
 *
 * 主要角色：
 * 策略接口（Strategy Interface）：定义了所有支持的算法的通用接口。通常包含一个或多个方法，用于执行具体的算法。
 *
 * 具体策略类（Concrete Strategy）：实现了策略接口，提供了具体的算法实现。
 *
 * 环境类（Context）：持有一个策略接口的引用，在运行时可以切换不同的策略。环境类将具体的算法委托给策略对象处理。
 *
 * 使用场景：
 * 当一个类有多种行为，而且这些行为在运行时可以互相替换时，可以使用策略模式。
 * 当一个类中有许多条件分支语句，并且每个条件都会执行不同的操作时，可以考虑使用策略模式来代替条件分支。</p>
 * @author zhiwen
 * @since 2024/2/20 10:42 上午
 */
public class Client {

    //假设有一个购物车系统，根据不同的商品计算折扣。我们可以使用策略模式来实现这个功能。
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // 普通会员购买
        cart.setDiscountStrategy(new RegularDiscountStrategy());
        double totalPriceForRegularMember = cart.checkout(100);
        System.out.println("Total price for regular member: " + totalPriceForRegularMember);

        // VIP会员购买
        cart.setDiscountStrategy(new VipDiscountStrategy());
        double totalPriceForVipMember = cart.checkout(100);
        System.out.println("Total price for VIP member: " + totalPriceForVipMember);
    }
}

interface DiscountStrategy {
    double applyDiscount(double totalPrice);
}

class RegularDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalPrice) {
        // 普通会员没有折扣
        return totalPrice;
    }
}

class VipDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalPrice) {
        // VIP会员有8折优惠
        return totalPrice * 0.8;
    }
}

class ShoppingCart {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double checkout(double totalPrice) {
        // 调用具体的折扣策略计算最终价格
        return discountStrategy.applyDiscount(totalPrice);
    }
}







