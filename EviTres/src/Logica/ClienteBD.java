package Logica;

import Datos.Conexion;
import Entidades.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteBD {

    public Cliente buscarCliente(int codigo) {
        Connection cn = Conexion.getConexcion();
        String sql = "select * from cliente where id_cliente= " + codigo;
        Cliente cliente = null;
        try {
            Statement cmd = cn.createStatement();
            ResultSet rs = cmd.executeQuery(sql);
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombreCliente(rs.getString("nombreCliente"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTel(rs.getString("tel"));
                cliente.setPrestamo(rs.getInt("prestamo"));
                cliente.setNombreEmple(rs.getString("nombreEmple"));
            } else {
                cliente = null;
            }

        } catch (SQLException ex) {
            cliente = null;
        } finally {
            return cliente;
        }
    }

    public Cliente Bcliente(String nombre) {
        Connection cn = Conexion.getConexcion();
        String sql = "select * from cliente where nombreCliente= '" + nombre + "'";
        Cliente cliente = null;
        try {
            Statement cmd = cn.createStatement();
            ResultSet rs = cmd.executeQuery(sql);
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNombreCliente(rs.getString("nombreCliente"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTel(rs.getString("tel"));
                cliente.setPrestamo(rs.getInt("prestamo"));
                cliente.setNombreEmple(rs.getString("nombreEmple"));
            } else {
                cliente = null;
            }

        } catch (SQLException ex) {
            cliente = null;
        } finally {
            return cliente;
        }

    }

    public boolean Insertar(String nombre, String dir, String tel, int pres, String emple) {
        Connection cn = Conexion.getConexcion();
        String sql = "insert into cliente(nombreCliente,direccion,tel,prestamo,nombreEmple) values('" + nombre + "','"
                + dir + "','" + tel + "'," + pres + ",'" + emple + "')";

        try {
            Statement cmd = cn.createStatement();
            int x = cmd.executeUpdate(sql);
            if (x > -1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;

        } finally {
            Conexion.CerrarDB();
        }
        
    }
    
     public boolean Eliminar(String nombre) {
        Connection cn = Conexion.getConexcion();
        String sql = "delete from cliente where nombreCliente='"+nombre+"'";

        try {
            Statement cmd = cn.createStatement();
            int x = cmd.executeUpdate(sql);
            if (x > -1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        } finally {
            Conexion.CerrarDB();
        }
        
    }
     public boolean Actualizar(Cliente objCliente) {
        Connection cn = Conexion.getConexcion();
        String sql = "update cliente set nombreCliente='"+objCliente.getNombreCliente()+"',direccion='"+objCliente.getDireccion()+
                "',tel='"+objCliente.getTel()+"',prestamo="+objCliente.getPrestamo()+",nombreEmple='"+objCliente.getNombreEmple()+
                "' where id_cliente="+objCliente.getId_cliente();

        try {
            Statement cmd = cn.createStatement();
            int x = cmd.executeUpdate(sql);
            if (x > -1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        } finally {
            Conexion.CerrarDB();
        }
        
    }
}
