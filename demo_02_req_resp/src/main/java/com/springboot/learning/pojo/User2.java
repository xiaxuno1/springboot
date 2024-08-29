package com.springboot.learning.pojo;
//复杂实体类，类中有其他类
public class User2 {
    private String id;
    private String name;
    private Address address;

    public User2() {
    }

    public User2(Address address, String name, String id) {
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public User2(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
