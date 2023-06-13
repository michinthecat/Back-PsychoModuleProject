package com.unibague.backpsyco.service.infraestructure.entrypoint;

import com.unibague.backpsyco.service.domain.model.Service;
import com.unibague.backpsyco.service.domain.usecase.ServiceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceRestController {

    private final ServiceUseCase serviceUseCase;

    @PostMapping
    public ResponseEntity<Service> saveService(@RequestBody Service service) {
        Service savedService = serviceUseCase.save(service);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable("id") int serviceId, @RequestBody Service service) {
        service.setId(serviceId);
        Service updatedService = serviceUseCase.update(service);
        if (updatedService != null) {
            return ResponseEntity.ok(updatedService);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceUseCase.getAllServices();
        if (services.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(services);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") int serviceId) {
        boolean isDeleted = serviceUseCase.delete(serviceId);
        if (isDeleted) {
            return ResponseEntity.ok("Service deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}