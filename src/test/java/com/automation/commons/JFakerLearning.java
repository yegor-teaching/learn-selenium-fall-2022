package com.automation.commons;

import com.github.javafaker.Faker;
import org.junit.Test;

public class JFakerLearning {

    @Test
    public void LearnFaker(){
        Faker faker = new Faker();

        //We can use the various faker methods in order to generate random FAKE data
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.idNumber().ssnValid());
        System.out.println(faker.internet().emailAddress());
    }
}
