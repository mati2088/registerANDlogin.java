package com.usuarios.users.dao;

import com.usuarios.users.models.Usuario;

import java.util.List;

public interface UsuarioDao {

        //es un archivo en el que indicamos que funciones deberia tener una clase
    //es estas clases agregamos funciones obligatorias

    List<Usuario>getUsuarios();
    void eliminar(long id);


    void registar(Usuario usuario);
    boolean verificarCredenciales(Usuario usuario);
}
