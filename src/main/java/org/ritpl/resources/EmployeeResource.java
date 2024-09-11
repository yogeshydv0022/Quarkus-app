package org.ritpl.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.ritpl.dto.request.EmployeeDto;
import org.ritpl.entities.Employee;
import org.ritpl.services.EmployeeService;

import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @POST
    public Response createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        Employee employee = employeeService.createEmployee(employeeDto);
        return Response.status(Response.Status.CREATED).entity(employee).build();
    }

    @GET
    public Response getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return Response.ok(employees).build();
    }

    @GET
    @Path("/{id}")
    public Response getEmployeeById(@PathParam("id") Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return Response.ok(employee).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateEmployee(@PathParam("id") Long id,@RequestBody @Valid EmployeeDto employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return Response.ok(updatedEmployee).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteEmployee(@PathParam("id") Long id) {
        String message = employeeService.deleteEmployee(id);
        return Response.ok(message).build();
    }
}
