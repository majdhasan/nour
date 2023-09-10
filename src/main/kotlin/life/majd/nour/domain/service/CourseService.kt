package life.majd.nour.domain.service

import life.majd.nour.repository.CourseRepository
import life.majd.nour.repository.entity.CourseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(
    val courseRepository: CourseRepository
) {

    fun createCourse(courseEntity: CourseEntity): CourseEntity {
        return courseRepository.save(courseEntity)
    }

    fun getCourses(): List<CourseEntity> {
        val all = courseRepository.findAll()
        return all.toList()
    }

    fun getCoursesByTutor(tutorId: UUID): List<CourseEntity> {
        val all = courseRepository.findAllByTutorId(tutorId)
        return all.toList()
    }
}