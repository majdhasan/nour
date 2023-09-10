package life.majd.nour.repository

import life.majd.nour.repository.entity.StudentEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface StudentRepository : CrudRepository<StudentEntity, UUID> {
}