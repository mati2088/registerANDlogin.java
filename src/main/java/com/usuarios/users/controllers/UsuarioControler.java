package com.usuarios.users.controllers;

import com.usuarios.users.dao.UsuarioDao;
import com.usuarios.users.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioControler {

    @Autowired
    private UsuarioDao usuarioDao;


    @RequestMapping(value ="api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable long id){
        Usuario usuario= new Usuario();
        usuario.setId(id);
        usuario.setNombre("Matias");
        usuario.setApellido("Arana");
        usuario.setEmail("matiasarana46@gmail.com");
        usuario.setTelefono("2215012999");
        return usuario;
    }
    //LISTA DE USUARIOS
    @RequestMapping(value ="api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }
    //LISTA DE USUARIOS

    @RequestMapping(value ="api/usuarios", method =  RequestMethod.POST
    )
    public  void registrarUsuario(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
           String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
            usuario.setPassword(hash);
         usuarioDao.registar(usuario);
    }


    //editar, eliminar, buscar


    @RequestMapping(value ="ediar")
    public Usuario editar(){
        Usuario usuario= new Usuario();
        usuario.setNombre("Matias");
        usuario.setApellido("Arana");
        usuario.setEmail("matiasarana46@gmail.com");
        usuario.setTelefono("2215012999");
        return usuario;
    }
    @RequestMapping(value ="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void  eliminar(@PathVariable long id){
        usuarioDao.eliminar(id);
    }

    @RequestMapping(value ="buscar")
    public Usuario buscar(){
        Usuario usuario= new Usuario();
        usuario.setNombre("Matias");
        usuario.setApellido("Arana");
        usuario.setEmail("matiasarana46@gmail.com");
        usuario.setTelefono("2215012999");
        return usuario;
    }

}
