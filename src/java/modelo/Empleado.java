/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
 

/**
 *
 * @author emanu
 */
public class Empleado extends Persona {
    private String codigo;
    private int id_puesto;
    private Conexion cn;
    
    public Empleado(){}
    public Empleado(String codigo, int id_puesto, int id, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(id, nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.codigo = codigo;
        this.id_puesto = id_puesto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }
    
    public DefaultTableModel leer() {
    DefaultTableModel tabla = new DefaultTableModel();
    try{
    cn = new Conexion();
    cn.abrir_conexion();
        String query = "SELECT c.id_cliente as id,c.nit,c.nombres,c.apellidos,c.direccion,c.telefono,c.fecha_nacimiento,p.puesto,p.id_puesto  FROM clientes as c  inner join puestos as p on c.id_puestos = p.id_puesto;";
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[] = {"id","codigo","nombres","apellidos","direccion","telefono","fecha_nacimiento","puesto","id_puesto",};
        tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String[9];
        while (consulta.next()) {
            datos[0] = consulta.getString("id");
            datos[1] = consulta.getString("nit");
            datos[2] = consulta.getString("nombres");
            datos[3] = consulta.getString("apellidos");
            datos[4] = consulta.getString("direccion");
            datos[5] = consulta.getString("telefono");
            datos[6] = consulta.getString("fecha_nacimiento");
            datos[7] = consulta.getString("puesto");
            datos[8] = consulta.getString("id_puesto");
            tabla.addRow(datos);
        }
       
        cn.cerrar_conexion();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
return tabla;
    }
    
    @Override
    public int agregar(){
        int retorno = 0;
    try {
    PreparedStatement parametro;
        cn = new Conexion();
        String query = "INSERT INTO clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento,id_puestos) VALUES (?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getCodigo());
            parametro.setString(2, this.getNombres());
            parametro.setString(3, this.getApellidos());
            parametro.setString(4, this.getDireccion());
            parametro.setString(5, this.getTelefono());
            parametro.setString(6, this.getFecha_nacimiento());
            parametro.setInt(7, this.getId_puesto());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
       } catch (Exception ex) {
           System.out.println(ex.getMessage());
           retorno = 0;
       }
    
    return retorno;
    }
    
    @Override
    public int modificar(){
        int retorno = 0;
    try {
    PreparedStatement parametro;
        cn = new Conexion();
        String query = "update clientes set nit=?,nombres=?,apellidos=?,direccion=?,telefono=?,fecha_nacimiento=?,id_puestos=? WHERE id_cliente = ?;";
            
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getCodigo());
            parametro.setString(2, this.getNombres());
            parametro.setString(3, this.getApellidos());
            parametro.setString(4, this.getDireccion());
            parametro.setString(5, this.getTelefono());
            parametro.setString(6, this.getFecha_nacimiento());
            parametro.setInt(7, this.getId_puesto());
            parametro.setInt(8, this.getId());
            
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
            
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
           retorno = 0;
       }
    
    return retorno;
    }
    
    @Override
    public int eliminar () {
        int retorno = 0;
        try {
        PreparedStatement parametro;
        cn = new Conexion();
        String query = "delete from clientes where id_cliente = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
    return retorno;
    }
    }
     
    
    

