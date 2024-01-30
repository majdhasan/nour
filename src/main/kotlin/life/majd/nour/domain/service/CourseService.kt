package life.majd.nour.domain.service

import life.majd.nour.repository.CourseRepository
import life.majd.nour.repository.LessonRepository
import life.majd.nour.repository.entity.CourseEntity
import life.majd.nour.web.dto.CourseResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import java.util.*

@Service
class CourseService(
    val courseRepository: CourseRepository,
    val lessonRepository: LessonRepository
) {

    fun createCourse(courseEntity: CourseEntity) = courseRepository.save(courseEntity)
    fun getCourse(id: UUID): CourseResponse {
        val foundCourse =
            courseRepository.findById(id)
                .orElseThrow {
                    HttpClientErrorException(
                        HttpStatus.NOT_FOUND,
                        "Course couldn't be found"
                    )
                }.toCourseResponse()
        val foundLessons = lessonRepository.findAllByCourseId(id)
        return foundCourse.copy(lessons = foundLessons)
    }

    fun getCourses() = courseRepository.findAll().toList()

    fun getCoursesByTutor(tutorId: UUID) = courseRepository.findAllByTutorId(tutorId).toList()

    fun getCoursesByNameContaining(text: String) = courseRepository.findAllContainingText(text)

}
