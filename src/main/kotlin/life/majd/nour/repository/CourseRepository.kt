package life.majd.nour.repository

import life.majd.nour.repository.entity.CourseEntity
import org.springframework.data.repository.CrudRepository
import java.util.*


interface CourseRepository : CrudRepository<CourseEntity, UUID> {

    fun findAllByTutorId(tutorId: UUID): List<CourseEntity>
}