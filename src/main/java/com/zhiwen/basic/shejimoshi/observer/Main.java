package com.zhiwen.basic.shejimoshi.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * @author zhiwen
 * @since 2024/2/20 11:29 上午
 */
public class Main {
    public static void main(String[] args) {

        //当新闻发布者发布新闻时，所有订阅者都会收到通知，并更新自己的状态。观察者模式使得新闻发布者与订阅者之间实现了解耦，提高了系统的灵活性和可维护性。

        // 创建主题（新闻发布者）
        NewsPublisher publisher = new NewsPublisher();

        // 创建观察者（新闻订阅者）
        Observer subscriber1 = new NewsSubscriber("Subscriber 1");
        Observer subscriber2 = new NewsSubscriber("Subscriber 2");

        // 订阅新闻
        publisher.registerObserver(subscriber1);
        publisher.registerObserver(subscriber2);

        // 发布新闻
        publisher.publishNews("Breaking news: COVID-19 vaccine approved!");

        // 移除观察者
        publisher.removeObserver(subscriber2);

        // 再次发布新闻
        publisher.publishNews("Latest update: Economic recovery underway!");
    }
}


//主题接口
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String news);
}

//观察者接口
interface Observer {
    void update(String news);
}

//具体的主题类
class NewsPublisher implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String news) {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void publishNews(String news) {
        System.out.println("Publishing news: " + news);
        notifyObservers(news);
    }
}

//具体的观察者类
class NewsSubscriber implements Observer {
    private String name;

    public NewsSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}








