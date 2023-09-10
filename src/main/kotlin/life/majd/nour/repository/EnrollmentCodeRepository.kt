package life.majd.nour.repository

import life.majd.nour.repository.entity.EnrollmentCodeEntity
import life.majd.nour.repository.entity.EnrollmentEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface EnrollmentCodeRepository : CrudRepository<EnrollmentCodeEntity, UUID> {

}