package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Created by sudhiry on 2/17/19.
 */
public class Person {
    private String name;
    private int age;
    @NestedConfigurationProperty
    private Sex sex;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
