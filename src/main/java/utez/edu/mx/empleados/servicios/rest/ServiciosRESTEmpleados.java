package utez.edu.mx.empleados.servicios.rest;

import utez.edu.mx.empleados.modelo.*;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/servicio")
public class ServiciosRESTEmpleados {
    EmpleadoDao emp = new EmpleadoDao();
    ReporteDao reporte = new ReporteDao();

    @POST
    @Path("/insertarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean insertarEmpleado(EmpleadoBean empleado){
        return emp.insertarEmpleado(empleado);
    }

    @GET
    @Path("/empleado/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmpleadoBean empleado(@PathParam("email") String email){
        return emp.empleado(email);
    }

    @DELETE
    @Path("eliminarEmpleado/{idEmp}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean eliminarEmpleado(@PathParam("idEmp") int idEmpleado){
        return emp.eliminarEmpleado(idEmpleado);
    }

    @GET
    @Path("/consultarEmpleados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmpleadoBean> consultarEmpleado(){
        return emp.consultarEmpleado();
    }

    @PUT
    @Path("/actualizarEmpleado")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean actualizarEmpleado(EmpleadoBean empleadoBean){
        return emp.updateEmpleado(empleadoBean);
    }

    @POST
    @Path("/insertarReporte")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean insertarReporte(ReporteBean reporteBean){
        return reporte.insertarReporte(reporteBean);
    }

    @POST
    @Path("/resolucion")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean resolverPeticion(@QueryParam("idReporte") int idReporte,@QueryParam("comentario") String comentario){
        return reporte.resolverReporte(idReporte,comentario);
    }

    @GET
    @Path("/consultarReportes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReporteBean> consultarReportes(){
        return reporte.consultaGeneral();
    }

    @GET
    @Path("/consultarReportesEmpleados/{idEmp}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReporteBean> consultarReportesEmpleados(@PathParam("idEmp") int idEmp){
        return reporte.historialEmpleado(idEmp);
    }

    @GET
    @Path("/consultarEmpId/{idEmp}")
    @Produces(MediaType.APPLICATION_JSON)
    public EmpleadoBean consultarArea(@PathParam("idEmp") int idEmp){
        return emp.seleccionarArea(idEmp);
    }

    @GET
    @Path("/consultarComentario/{idReporte}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResolucionBean consultarReportes(@PathParam("idReporte") int idReporte){
        return reporte.consultarComentario(idReporte);
    }

}
