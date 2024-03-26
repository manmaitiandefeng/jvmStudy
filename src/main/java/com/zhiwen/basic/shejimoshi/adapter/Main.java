package com.zhiwen.basic.shejimoshi.adapter;

/**
 * <p>适配器模式（Adapter Pattern）是一种结构型设计模式，它允许将一个类的接口转换成客户端所期待的另一个接口。适配器模式通常用于让原本不兼容的接口能够一起工作，或者将已有的类库与新的代码进行集成。
 *
 * 主要角色：
 * 目标接口（Target Interface）：客户端期望的接口，适配器模式的目标是将现有的接口转换成这个接口。
 *
 * 适配器（Adapter）：实现了目标接口，并持有一个被适配对象的引用。适配器将客户端的请求委派给被适配对象，并将其结果转换成客户端期望的格式。
 *
 * 被适配对象（Adaptee）：需要被适配的现有对象，它的接口与目标接口不兼容。
 *
 * 使用场景：
 * 当需要使用一个已经存在的类，而它的接口与所需接口不匹配时，可以使用适配器模式。
 * 当需要创建一个可以复用的类，该类与其他不相关的类或不可预见的类协同工作时，可以使用适配器模式。
 * 当需要使用一些已经存在的子类，但是又不能对其进行修改，例如无法继承某个类的情况下，可以通过适配器模式来进行兼容性调整。</p>
 * @author zhiwen
 * @since 2024/2/20 9:51 上午
 */
public class Main {
    public static void main(String[] args) {

        //现在，我们希望添加对 Oracle 数据库的支持。但是 Oracle 数据库的接口与我们现有的接口不兼容。这时，我们可以创建一个适配器来使得 Oracle 数据库能够与我们的系统协同工作

        //通过适配器模式，我们成功地将不兼容的 Oracle 数据库接口转换为符合系统期望的 Database 接口。这使得我们可以无缝地集成新的 Oracle 数据库支持到现有的系统中，而无需修改现有代码。


        // 使用 MySQL 数据库
        Database mysqlDatabase = new MySQLDatabase();
        mysqlDatabase.connect();
        mysqlDatabase.query("SELECT * FROM table");

        // 使用 Oracle 数据库（通过适配器）
        OracleDatabase oracleDatabase = new OracleDatabase();
        Database oracleAdapter = new OracleAdapter(oracleDatabase);
        oracleAdapter.connect();
        oracleAdapter.query("SELECT * FROM table");
    }
}

class OracleDatabase {
    public void connectToOracle() {
        System.out.println("Connecting to Oracle database...");
    }

    public void executeOracleQuery(String sql) {
        System.out.println("Executing Oracle query: " + sql);
    }
}

// 适配器类，将 OracleDatabase 适配到 Database 接口
class OracleAdapter implements Database {
    private OracleDatabase oracleDatabase;

    public OracleAdapter(OracleDatabase oracleDatabase) {
        this.oracleDatabase = oracleDatabase;
    }

    @Override
    public void connect() {
        oracleDatabase.connectToOracle();
    }

    @Override
    public void query(String sql) {
        oracleDatabase.executeOracleQuery(sql);
    }
}


class MySQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database...");
    }

    @Override
    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}


interface Database {
    void connect();

    void query(String sql);
}





