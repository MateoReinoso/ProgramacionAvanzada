/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.servicios;

import ec.edu.espe.model.Cliente;
import ec.edu.espe.model.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mateo
 */
@Path("Client")
public class ClientResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientResource
     */
    public ClientResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.servicios.ClientResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
         String cadenaDatos="";
        try{
        Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.getMessage();
        }
        //Definicion lista de datos
        
        List<Cliente> result = new ArrayList<>();
        //Sentencia SQL
        String SQL_SELECT = "select * from cliente";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/transportes", "postgres", "1234");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                String ci = resultSet.getString("ci");
                String ruc = resultSet.getString("ruc");
                String nombre = resultSet.getString("nombre");
                String dirreccion = resultSet.getString("direccion");
                String telfconvencional = resultSet.getString("Fono convenccional");
                         
                        

                Cliente obj = new Cliente();
                obj.setCi(ci);
                obj.setRuc(ruc);
                obj.setNombre(nombre);
                obj.setDirreccion(dirreccion);
                obj.setTelfconvencional(telfconvencional);

                result.add(obj);
                cadenaDatos= cadenaDatos +"\tci: " + ci +"\truc: " + ruc + "\tnombre: " + nombre +"\t dirrecion"+dirreccion +"\tFono convenional"+telfconvencional ;
            }
            result.forEach(x -> System.out.println(x));

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
       return cadenaDatos; 
    }
    
    /**
     * PUT method for updating or creating an instance of ClientResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
