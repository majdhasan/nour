package life.majd.nour.repository

import life.majd.nour.repository.entity.CourseEntity
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import java.util.*


interface CourseRepository : CrudRepository<CourseEntity, UUID> {

    fun findAllByTutorId(tutorId: UUID): List<CourseEntity>

    @Query(value = "SELECT * FROM nour.nour.course WHERE name ILIKE :text OR description ILIKE :text")
    fun findAllContainingText(text: String): List<CourseEntity>
}