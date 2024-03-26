package com.zhiwen.basic.shejimoshi.prototype;

/**
 * <p>原型模式</p>
 * @author zhiwen
 * @since 2024/2/20 12:17 上午
 */

class Address implements Cloneable {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}

class Person implements Cloneable {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // 浅拷贝
    public Person shallowCopy() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    // 深拷贝
    public Person deepCopy() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone();
        // 深拷贝 Address 对象
        clonedPerson.address = this.address.clone();
        return clonedPerson;
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 创建原型对象
        Address address = new Address("New York");
        Person originalPerson = new Person("Alice", address);

        // 浅拷贝
        Person shallowClonedPerson = originalPerson.shallowCopy();
        System.out.println("Original City: " + originalPerson.getAddress().getCity());
        System.out.println("Shallow Clone City: " + shallowClonedPerson.getAddress().getCity());

        // 修改克隆对象的城市信息
        shallowClonedPerson.getAddress().setCity("Los Angeles");
        System.out.println("Original City After Shallow Clone Modification: " + originalPerson.getAddress().getCity());
        System.out.println("Shallow Clone City After Modification: " + shallowClonedPerson.getAddress().getCity());

        // 创建原型对象
        Address address2 = new Address("Chicago");
        Person originalPerson2 = new Person("Bob", address2);

        // 深拷贝
        Person deepClonedPerson = originalPerson2.deepCopy();
        System.out.println("Original City: " + originalPerson2.getAddress().getCity());
        System.out.println("Deep Clone City: " + deepClonedPerson.getAddress().getCity());

        // 修改克隆对象的城市信息
        deepClonedPerson.getAddress().setCity("San Francisco");
        System.out.println("Original City After Deep Clone Modification: " + originalPerson2.getAddress().getCity());
        System.out.println("Deep Clone City After Modification: " + deepClonedPerson.getAddress().getCity());
    }
}

