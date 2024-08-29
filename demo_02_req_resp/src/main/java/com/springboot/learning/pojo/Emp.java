package com.springboot.learning.pojo;

public class Emp {
    private String name;
    private Integer age;
    private String image;
    private String gender;
    private String job;

    public Emp(String name, Integer age, String image, String gender, String job) {
        this.name = name;
        this.age = age;
        this.image = image;
        this.gender = gender;
        this.job = job;
    }

    public Emp() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getImage() {
        return image;
    }

    public String getGender() {
        return gender;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
