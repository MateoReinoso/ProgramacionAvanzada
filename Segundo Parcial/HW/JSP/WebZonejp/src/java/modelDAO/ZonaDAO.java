/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDAO;

import config.Conectar;
import interfaces.CRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Zona;

/**
 *
 * @author Mateo
 */
public class ZonaDAO implements CRUD{
    Conectar cn = new Conectar();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Zona zn = new Zona();
    @Override
    public List listar() {
            ArrayList<Zona> lista = new ArrayList<>();
            String sql ="select * from zona";
            try {
            con = cn.getConexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Zona zn = new Zona();
                zn.setCodigo(rs.getInt("codigo"));
                zn.setNombre(rs.getString("nombre"));
                zn.setCiudad(rs.getString("ciudad"));
                lista.add(zn);
            }
        } catch (Exception e) {
        }
            return lista;
    }
    
}
