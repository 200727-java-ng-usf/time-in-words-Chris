package com.revature;

import com.revature.models.Event;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringBootMainClassApplication {

    public static void main(String[] args) {
        Event event = new Event("test", "location");
        System.out.println(event);
    }
}
