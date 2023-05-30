package com.unibague.backpsyco.appointment.repository;

import com.unibague.backpsyco.appointment.model.AppointmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentDTO, Long> {

    // Método para obtener todas las citas de un paciente por su ID
    List<AppointmentDTO> findByPatientId(Long patientId);

    // Método para obtener todas las citas de un doctor por su ID
    List<AppointmentDTO> findByDoctorId(Long doctorId);

}
