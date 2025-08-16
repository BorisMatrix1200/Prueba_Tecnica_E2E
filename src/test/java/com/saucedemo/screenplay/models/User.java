package com.saucedemo.screenplay.models;
//Clases que representan datos o entidades del dominio de la prueba
//Ejemplo: un Cliente, un Producto, credenciales de usuario. Se usan para pasar datos entre pasos.

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
