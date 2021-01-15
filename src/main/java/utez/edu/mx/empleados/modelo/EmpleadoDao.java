package utez.edu.mx.empleados.modelo;

import utez.edu.mx.empleados.servicios.generales.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao extends Conexion {


    public boolean eliminarEmpleado(int idEmpleado){
        try(PreparedStatement pst = crearConexion().prepareStatement("delete from empleado where id=?")){
            pst.setInt(1, idEmpleado);
            if (pst.executeUpdate()==1){
                System.out.println("Si se elimino :D");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean insertarEmpleado(EmpleadoBean bean){
        try(PreparedStatement pst = crearConexion().prepareStatement("insert into empleado (nombreCompleto,domicilio,sexo,fechaNacimiento,email,telefono,contrasenia,area,idRol) values (?,?,?,?,?,?,?,?,?) ")){
            pst.setString(1,bean.getNombreCompleto());
            pst.setString(2,bean.getDomicilio());
            pst.setString(3,bean.getSexo());
            pst.setString(4,bean.getFechaNacimiento());
            pst.setString(5,bean.getEmail());
            pst.setString(6,bean.getTelefono());
            pst.setString(7,bean.getContrasenia());
            pst.setString(8,bean.getArea());
            pst.setInt(9,bean.getIdRol());
            if (pst.executeUpdate()==1)
                System.out.println("Registrado correctamente");
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Algo salio mal");
        return false;
    }

    public boolean updateEmpleado(EmpleadoBean emp){
        System.out.println(emp.getId());
        try(PreparedStatement pst = crearConexion().prepareStatement("update empleado set nombreCompleto=?,domicilio=?,email=?,telefono=?,contrasenia=? where id=?")){
            pst.setString(1,emp.getNombreCompleto());
            pst.setString(2,emp.getDomicilio());
            pst.setString(3,emp.getEmail());
            pst.setString(4,emp.getTelefono());
            pst.setString(5,emp.getContrasenia());
            pst.setInt(6,emp.getId());
            if (pst.executeUpdate()==1){
                System.out.println("Exito...");
                return true;
            }else {
                System.out.println("Error....");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public List<EmpleadoBean> consultarEmpleado(){
        List<EmpleadoBean> empleadoBeanList = new ArrayList<>();
        try(PreparedStatement pst = crearConexion().prepareStatement("select * from empleado where idRol=2 or idRol=3")){
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                empleadoBeanList.add(new EmpleadoBean(rs.getInt("id"),rs.getString("nombreCompleto"),rs.getString("domicilio"),rs.getString("sexo"),rs.getString("fechaNacimiento"),rs.getString("email"),rs.getString("telefono"),rs.getString("contrasenia"),rs.getString("area"),rs.getInt("idRol")));
                System.out.println("Si llego");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return empleadoBeanList;
    }

    public EmpleadoBean empleado(String email){
        EmpleadoBean emp = null;
        System.out.println(email);
        try(PreparedStatement pst = crearConexion().prepareStatement("select * from empleado where email = ?")){
            pst.setString(1,email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                System.out.println("Listo :D");
               emp = new EmpleadoBean(rs.getInt("id"),rs.getString("nombreCompleto"),rs.getString("domicilio"),rs.getString("sexo"),rs.getString("fechaNacimiento"),rs.getString("email"),rs.getString("telefono"),rs.getString("contrasenia"),rs.getString("area"),rs.getInt("idRol"));
            }else{
                System.out.println("Error, no se encontro wey");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return emp;
    }

    public EmpleadoBean seleccionarArea(int idEmp){
        EmpleadoBean emp = null;
        System.out.println(idEmp);
        try(PreparedStatement pst = crearConexion().prepareStatement("select * from empleado where id = ?")){
            pst.setInt(1,idEmp);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                System.out.println("Listo :D");
                emp = new EmpleadoBean(rs.getInt("id"),rs.getString("nombreCompleto"),rs.getString("domicilio"),rs.getString("sexo"),rs.getString("fechaNacimiento"),rs.getString("email"),rs.getString("telefono"),rs.getString("contrasenia"),rs.getString("area"),rs.getInt("idRol"));
            }else{
                System.out.println("Error, no se encontro wey");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return emp;
    }

}
