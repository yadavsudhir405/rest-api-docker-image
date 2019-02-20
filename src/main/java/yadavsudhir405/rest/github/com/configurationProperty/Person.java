package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Created by sudhiry on 2/17/19.
 */
public class Person {
    private static final String DEFAULT_NAME = "defaultUser";
    private static final int DEFAULT_AGE = 23;
    private static final Sex DEFAULT_SEX = Sex.MALE;

    private String name = DEFAULT_NAME;
    private int age = DEFAULT_AGE;
    @NestedConfigurationProperty
    private Sex sex = DEFAULT_SEX;

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
