package med.voll.api.appointments;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AppointmentsRepository extends JpaRepository<AppointmentEntity, Long> {

   Boolean existsByPatientIdAndDateBetween(Long idPatient, LocalDateTime start, LocalDateTime end);

   Boolean existsByPhysicianIdAndDate(Long idPhysician, LocalDateTime date);

   Page<AppointmentEntity> findByActiveTrue(Pageable pagination);
}
