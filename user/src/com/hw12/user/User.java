package com.hw12.user;

import java.util.Objects;

public class User {
    private String name;
    private String position;

    public User(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) &&
                position.equals(user.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
