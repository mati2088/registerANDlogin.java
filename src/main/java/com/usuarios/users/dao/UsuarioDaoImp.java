package com.usuarios.users.dao;

import com.usuarios.users.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional

public class UsuarioDaoImp implements  UsuarioDao{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Usuario> getUsuarios() {
        String query="FROM Usuario";
      return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(long id) {

        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);

    }

    @Override
    public void registar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(Usuario usuario){

        String query="FROM Usuario WHERE email =:email";
        List<Usuario> lista= entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())

                .getResultList();


        String passwordHashed = lista.get(0).getPassword();


        if(lista.isEmpty()){
            return false;
        }

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return  argon2.verify(passwordHashed, usuario.getPassword());


    }
}
