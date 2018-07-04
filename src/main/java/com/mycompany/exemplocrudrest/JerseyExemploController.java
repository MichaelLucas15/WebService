/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplocrudrest;

/**
 *
 * @author pronatec
 */
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("meuwebservice")
public class JerseyExemploController {

    private static UsuarioDAO usuarioDAO;

    public JerseyExemploController() {
        usuarioDAO = UsuarioDAO.getInstance();
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent to
     * the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("ola")
    @Produces(MediaType.TEXT_PLAIN)
    public String olaMundo() {
        return "Olá mundo!";
    }

    // http://localhost:8080/WebService-master/meuwebservice/add?id=1&nome=Sucesso&cpf=000000000000
    @POST
    @Path("add")
    public Response adicionar(
            @QueryParam("id") int id,
            @QueryParam("nome") String nome,
            @QueryParam("cpf") String cpf) {
        Usuario usuario = new Usuario(id, nome, cpf);
        this.usuarioDAO.adicionar(usuario);
        return Response.status(Status.OK).build();
    }

    // http://localhost:8080/ExemploCrudREST/meuwebservice/consultar
    @GET
    @Path("listar")
    @Produces(MediaType.APPLICATION_JSON)
    public String listar() {
        return new Gson().toJson(usuarioDAO.recuperarTodos());
    }

    //http://localhost:8080/WebService/meuwebservice/atualizar?id=1&nome=Michael&cpf=000000000
    @PUT
    @Path("alterar")
    public Response alterar(
            @QueryParam("id") int id,
            @QueryParam("nome") String novoNome,
            @QueryParam("cpf") String novoCpf) {
        Usuario novoUser = new Usuario(id, novoNome, novoCpf);
        usuarioDAO.alterar(id, novoUser);
        return Response.status(Status.OK).build();
    }

    //http://localhost:8080/WebService/meuwebservice/consultar1?id=1
    @GET
    @Path("listar1")
    @Produces(MediaType.TEXT_PLAIN)
    public Response listar(@QueryParam("id") int id) {
        Gson gson = new Gson();
        return Response.status(Status.OK).entity(gson.toJson(usuarioDAO.recuperar(id))).build();
    }

    // http://localhost:8084/ExemploCrudREST/meuwebservice/remover?nome=Leonardo&cpf=00000000000
    @DELETE
    @Path("deletar")
    public Response deletar(
            @QueryParam("id") int id
            ){
        Usuario usuario = new Usuario(id);
        this.usuarioDAO.deletar(usuario);
        return Response.status(Status.OK).build();
    }
}

