package life.majd.nour.domain.service

import life.majd.nour.repository.CourseRepository
import life.majd.nour.repository.entity.CourseEntity
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(val courseRepository: CourseRepository) {

    fun createCourse(courseEntity: CourseEntity) = courseRepository.save(courseEntity)
    fun getCourse(id: UUID) = courseRepository.findById(id).orElseThrow { NotFoundException() }

    fun getCourses() = courseRepository.findAll().toList()

    fun getCoursesByTutor(tutorId: UUID) = courseRepository.findAllByTutorId(tutorId).toList()
}
