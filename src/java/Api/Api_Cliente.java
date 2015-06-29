package Api;

import Application.Apl_Cliente;
import Model.Cliente;
import Model.Socio;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Luiz
 */
@Path("cliente")
public class Api_Cliente {
    
    @GET
    @Produces("application/json")
    public String hello() {
        
        List<Cliente> registros = Apl_Cliente.consultarTodosRegistros("Cliente");
        
        Gson gson = new Gson();
            
        return gson.toJson(registros);
    }
    
    
    @GET
    @Path("{Id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String incluir(@PathParam("Id") int id){
        
        Cliente obj = (Cliente) Apl_Cliente.getRegistro("Cliente", id);
        
        Gson gson = new Gson();
            
        return gson.toJson(obj);
        
    }
    
    
    @GET
    @Path("deletar/{Id}")
    @Produces(MediaType.TEXT_PLAIN)
    public int deletar(@PathParam("Id") int id) throws Exception{
            
        return Application.Apl_Cliente.deletar("Cliente", id);
        
    }
    
    
    @GET
    @Path("incluir")
    @Produces(MediaType.TEXT_PLAIN)
    public int incluir(
            @QueryParam("nome") String nome,
            @QueryParam("end") String endereco,
            @QueryParam("telefone") String telefone,
            @QueryParam("sexo") String sexo,
            @QueryParam("cpf") String cpf,
            @QueryParam("data_nascimento") String data_nascimento
            ){
        
        char s = sexo.charAt(0);
        
        return Application.Apl_Cliente.incluirSocio(nome, endereco, telefone, s, cpf, data_nascimento); 
        
    }
    
  
    @GET
    @Path("alterar")
    @Produces(MediaType.TEXT_PLAIN)
    public int alterar(
            @QueryParam("id") int id,
            @QueryParam("nome") String nome,
            @QueryParam("end") String endereco,
            @QueryParam("telefone") String telefone,
            @QueryParam("sexo") String sexo,
            @QueryParam("cpf") String cpf,
            @QueryParam("data_nascimento") String data_nascimento
            ) throws Exception{
        
        Cliente obj = (Cliente) Apl_Cliente.getRegistro("Cliente", id);
        
        obj.setNome(nome);
        obj.setData_nascimento(data_nascimento);
        
        return Application.Apl_Cliente.update(obj);
        
    }
    
    
}
