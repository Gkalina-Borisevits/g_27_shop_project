package de.aittr.g_27_shop_project.domain.interfaces;

public interface Customer {

    int getId();

    boolean isActive();

    String getName();
    int getAge();
    String getEmail();

    Cart getCart();

    void setId(int id);

    void setCart(Cart cart);

    void setActive(boolean isActive);

    void setName(String name);

    void setAge(int age);

    void setEmail(String email);

}
