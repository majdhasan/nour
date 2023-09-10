package life.majd.nour.repository

import life.majd.nour.repository.entity.EnrollmentEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface EnrollmentRepository : CrudRepository<EnrollmentEntity, UUID> {

}