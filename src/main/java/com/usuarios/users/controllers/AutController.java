package com.usuarios.users.controllers;

import com.usuarios.users.dao.UsuarioDao;
import com.usuarios.users.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutController {
    //gestianos el inicio de sesion

    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value ="api/login", method =  RequestMethod.POST
    )
    public  String login(@RequestBody Usuario usuario){

      if (usuarioDao.verificarCredenciales(usuario)) {
          return "ok";
      }
      return "FAIL";
    }


}
