package life.majd.nour.domain.service

import life.majd.nour.repository.EnrollmentRepository
import life.majd.nour.repository.entity.EnrollmentEntity
import org.springframework.stereotype.Service

@Service
class EnrollmentService(val enrollmentRepository: EnrollmentRepository) {

    fun createEnrollment(enrollmentEntity: EnrollmentEntity) =
        enrollmentRepository.save(enrollmentEntity)

}
