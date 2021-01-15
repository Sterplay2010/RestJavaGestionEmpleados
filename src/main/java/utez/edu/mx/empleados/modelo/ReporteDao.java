package utez.edu.mx.empleados.modelo;

import utez.edu.mx.empleados.servicios.generales.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReporteDao extends Conexion {
    public boolean insertarReporte(ReporteBean bean){
        System.out.println(bean.getDescripcion());
        System.out.println(bean.getIdEmpleado());
        try(PreparedStatement pst = crearConexion().prepareStatement("insert into reporte (descripcion,idEmpleado,estatus) values (?,?,?)")){
           pst.setString(1,bean.getDescripcion());
           pst.setInt(2, bean.getIdEmpleado());
           pst.setInt(3, 0);
           if (pst.executeUpdate()==1){
               System.out.println("Listo :D");
               return true;
           }else {
               System.out.println("Error :'(");
           }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<ReporteBean> consultaGeneral(){
        List<ReporteBean> lista = new ArrayList<>();
        try (PreparedStatement pst = crearConexion().prepareStatement("select * from reporte")){
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                lista.add(new ReporteBean(rs.getInt("idReporte"),rs.getString("fechaHora"),rs.getString("descripcion"),rs.getInt("idEmpleado"),rs.getInt("estatus")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public List<ReporteBean> historialEmpleado(int idEmp){
        List<ReporteBean> lista = new ArrayList<>();
        try (PreparedStatement pst = crearConexion().prepareStatement("select * from reporte where idEmpleado=? order by idReporte DESC ")){
            pst.setInt(1,idEmp);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                System.out.println("todo correcto");
                lista.add(new ReporteBean(rs.getInt("idReporte"),rs.getString("fechaHora"),rs.getString("descripcion"),rs.getInt("idEmpleado"),rs.getInt("estatus")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public boolean updateEstatus(int idReporte){
        try(PreparedStatement pst = crearConexion().prepareStatement("update reporte set estatus=? where idReporte=?")){
            pst.setInt(1,1);
            pst.setInt(2,idReporte);
            if (pst.executeUpdate()==1)
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public ResolucionBean consultarComentario(int idReporte){
        System.out.println(idReporte);
        try(PreparedStatement pst = crearConexion().prepareStatement("select * from resolucion where idReporte = ?")){
            pst.setInt(1,idReporte);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                System.out.println("Correcto");
                return new ResolucionBean(rs.getInt("idReporte"),rs.getString("fechaHoraResolucion"),rs.getString("comentario"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean resolverReporte(int idReporte, String comentario){
        System.out.println(idReporte);
        System.out.println(comentario);
        try (PreparedStatement pst = crearConexion().prepareStatement("insert into resolucion (idReporte,comentario) values (?,?)")){
            pst.setInt(1,idReporte);
            pst.setString(2,comentario);
            if (pst.executeUpdate()==1){
                System.out.println("Completado con exito");
                updateEstatus(idReporte);
                return true;
            }else {
                System.out.println("Error :S");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
