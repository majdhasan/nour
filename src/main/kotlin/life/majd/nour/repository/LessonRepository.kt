package life.majd.nour.repository

import life.majd.nour.repository.entity.CourseEntity
import life.majd.nour.repository.entity.LessonEntity
import org.springframework.data.repository.CrudRepository
import java.util.*


interface LessonRepository : CrudRepository<LessonEntity, UUID>{

    fun findAllByCourseId(courseId: UUID): List<LessonEntity>
}