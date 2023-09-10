package life.majd.nour.domain.service

import life.majd.nour.repository.EnrollmentCodeRepository
import life.majd.nour.repository.EnrollmentRepository
import life.majd.nour.repository.entity.EnrollmentCodeEntity
import life.majd.nour.repository.entity.EnrollmentEntity
import org.springframework.stereotype.Service

@Service
class EnrollmentCodeService(val enrollmentCodeRepository: EnrollmentCodeRepository) {

    fun createEnrollmentCode(enrollmentCodeEntity: EnrollmentCodeEntity) =
        enrollmentCodeRepository.save(enrollmentCodeEntity)

}
