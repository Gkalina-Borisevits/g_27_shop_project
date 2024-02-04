package de.aittr.g_27_shop_project.domain.jdbc;

import de.aittr.g_27_shop_project.domain.interfaces.Cart;
import de.aittr.g_27_shop_project.domain.interfaces.Customer;

import java.util.Objects;

public class CommonCustomer implements Customer {

    private int id;
    private boolean isActive;
    private String name;
    private int age;
    private String email;
    private Cart cart;

    public CommonCustomer() {
        this.isActive = true;
    }

    public CommonCustomer(String name, Cart cart) {
        this.name = name;
        this.cart = cart;
        this.isActive = true;
    }

    public CommonCustomer(int id, boolean isActive, String name, int age, String email, Cart cart) {
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.cart = cart;
        this.age = age;
        this.email = email;
    }

    public CommonCustomer(int id, boolean isActive, String name, Cart cart) {
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.cart = cart;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(int age) { this.age = age;

    }

    @Override
    public void setEmail(String email) { this.email = email;

    }

    @Override
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCustomer that = (CommonCustomer) o;
        return id == that.id && isActive == that.isActive && age == that.age && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActive, name, age, email, cart);
    }

    @Override
    public String toString() {
        return String.format("Покупатель: ID -%d, имя - %s, активен - %s", id, name, age, email, isActive ? "да" : "нет");
    }
}
