package com.revature.models;

import com.revature.services.TimeReformatService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;

@Entity
public class Event {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

    @Column
    String location;

    @Column
    String time;

    public Event() {
    }

    public Event(Integer id, String name, String location) {
        this(name, location);
        this.id = id;
    }

    public Event(String name, String location) {
        this.name = name;
        this.location = location;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:m");
        this.time = date.format(formatter);
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                Objects.equals(name, event.name) &&
                Objects.equals(location, event.location) &&
                Objects.equals(time, event.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, time);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
