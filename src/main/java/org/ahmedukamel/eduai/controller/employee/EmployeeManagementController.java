package org.ahmedukamel.eduai.controller.employee;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.ahmedukamel.eduai.dto.employee.AddEmployeeRequest;
import org.ahmedukamel.eduai.service.employee.EmployeeManagementService;
import org.ahmedukamel.eduai.service.employee.IEmployeeManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@PreAuthorize(value = "hasAnyAuthority('ADMIN', 'EMPLOYEE_MANAGER')")
@RequestMapping(value = "api/v1/management/employee")
public class EmployeeManagementController {
    private final IEmployeeManagementService parentService;

    public EmployeeManagementController(EmployeeManagementService service) {
        this.parentService = service;
    }

    @PostMapping(value = "new")
    public ResponseEntity<?> addEmployee(
            @Valid @RequestBody AddEmployeeRequest request) {

        return ResponseEntity.created(URI.create("api/v1/management/employee/new"))
                .body(parentService.addEmployee(request));
    }

    @DeleteMapping(value = "{employeeId}")
    public ResponseEntity<?> deleteEmployee(
            @Min(value = 1) @PathVariable(value = "employeeId") Long id) {

        return ResponseEntity.accepted().body(parentService.deleteEmployee(id));
    }

    @GetMapping(value = "{employeeId}")
    public ResponseEntity<?> getEmployee(
            @Min(value = 1) @PathVariable(value = "employeeId") Long id) {

        return ResponseEntity.ok().body(parentService.getEmployee(id));
    }

    @GetMapping(value = "all")
    public ResponseEntity<?> getAllEmployees(
            @Min(value = 1) @RequestParam(value = "size", defaultValue = "10") int pageSize,
            @Min(value = 0) @RequestParam(value = "page", defaultValue = "0") int pageNumber) {

        return ResponseEntity.ok().body(parentService.getAllEmployees(pageSize, pageNumber));
    }
}