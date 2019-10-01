/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.venta;

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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mateo
 */
@Path("venta")
public class ventaresource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ventaresource
     */
    public ventaresource() {
    }

    /**
     * Retrieves representation of an instance of
     * ec.edu.espe.venta.ventaresource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{peso}")
    public String getJson(@PathParam("peso") String peso) {
        String cadenaDatos = "";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        //Definicion lista de datos

        List<Producto> result = new ArrayList<>();
        //Sentencia SQL
        String SQL_SELECT = "select * from producto where peso > 14 and sensibilidad like 'Fragil';";

        // auto close connection and preparedStatement
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/transportes", "postgres", "1234");
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String codigoprod = resultSet.getString("cod");
                String nombreprod = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                //String peso = resultSet.getString("peso");
                String sensibilidad = resultSet.getString("sensibilidad");
                String valorubit = resultSet.getString("valor unit");

                Producto obj1 = new Producto();
                obj1.setCodigoprod(codigoprod);
                obj1.setNombreprod(nombreprod);
                obj1.setDescripcion(descripcion);
                obj1.setPeso(peso);
                obj1.setSensibilidad(sensibilidad);
                obj1.setValorubit(valorubit);

                result.add(obj1);
                cadenaDatos= cadenaDatos +"\tcod: " + codigoprod +"\tnombre: " + nombreprod + "\tdesrcipcion: " + descripcion +"\t peso"+peso +"\tsensibilida"+sensibilidad+"\tvalor"+valorubit ;
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
     * PUT method for updating or creating an instance of ventaresource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
