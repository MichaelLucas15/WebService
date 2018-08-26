/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplocrudrest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author maycom
 */
public class UsuarioDAO {

    private static UsuarioDAO instance;

    private final List<Usuario> usuario = new ArrayList<>();

    private UsuarioDAO() {
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }

        return instance;
    }

    public void adicionar(Usuario usuario) {
        this.usuario.add(usuario);
    }

    //public String consultar(String nome, String cpf) {
    public String listar(int id) {
        String user = "";
        for (Usuario usuario : this.usuario) {
            user = "Id: " + usuario.id + "Nome: " + usuario.nome + " / CPF: " + usuario.cpf;
        }
        return user;
    }
 
   
    public boolean alterar(int id, Usuario usuario) {
        for (int i = 0; i < this.usuario.size(); i++) {
            if (this.usuario.get(i).getId() == id) {
                this.usuario.set(i, usuario);
                return true;
            }
        }
        return false;
    }

    
    public Usuario recuperar(int id) {
        for (Usuario usuario : this.usuario) {
            if (usuario.getId()==(id)) {
                return usuario;
            }
        }
        return null;
    }
    
    //Vai deletar o usuario pelo ID;
    public boolean deletar(Usuario usuario) {
       for (int i=0;i<this.usuario.size();i++) {
            if (usuario.getId()==(this.usuario.get(i).getId())) {
                return this.usuario.remove(this.usuario.get(i));
            }
        }
        return false;
    }
    /*
    Outra forma de deletar:

    public boolean deletar(Usuario usuario) {
        this.usuario.remove(usuario);
        return true;

    }
    
    */

    public List<Usuario> recuperarTodos() {
        return this.usuario;
    }

   
}
