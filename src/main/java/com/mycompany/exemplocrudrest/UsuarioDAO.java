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
 * @author pronatec
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
 
    /* O proprio NetBeans gerou essa parte do Iteratir
     public String consultar(String nome, String cpf) {
        String consultar = "";
        for (Iterator<Pessoa> it = this.pessoas.iterator(); it.hasNext();) {
            Usuario pessoa = it.next();
            consultar = "Nome: " + pessoa.nome + " / CPF: " + pessoa.cpf;
        }
        return consultar;
    }
     */
    public boolean alterar(int id, Usuario usuario) {
        for (int i = 0; i < this.usuario.size(); i++) {
            if (this.usuario.get(i).getId() == id) {
                this.usuario.set(i, usuario);
                return true;
            }
        }
        return false;
    }

    /*
    public void alterar(Usuario usuario) {
        for (Usuario u : this.usuario) {
            if (u.getNome().equals(usuario.getNome())) {
                u.setCpf(usuario.getCpf());
            }
        }
    }
     */
    public Usuario recuperar(int id) {
        for (Usuario usuario : this.usuario) {
            if (usuario.getId()==(id)) {
                return usuario;
            }
        }
        return null;
    }
    
    public boolean deletar(Usuario usuario) {
       for (int i=0;i<this.usuario.size();i++) {
            if (usuario.getId()==(this.usuario.get(i).getId())) {
                return this.usuario.remove(this.usuario.get(i));
            }
        }
        return false;
    }

    public List<Usuario> recuperarTodos() {
        return this.usuario;
    }

   
}
