package life.majd.nour.domain.service

import life.majd.nour.repository.LessonRepository
import life.majd.nour.repository.entity.LessonEntity
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class LessonService(val lessonRepository: LessonRepository) {

    fun createLesson(lessonEntity: LessonEntity) = lessonRepository.save(lessonEntity)
    fun getLesson(id: UUID): LessonEntity =
        lessonRepository.findById(id).orElseThrow { NotFoundException() }

    fun getLessons(): List<LessonEntity> = lessonRepository.findAll().toList()

    fun getLessonsByCourseId(courseId: UUID) = lessonRepository.findAllByCourseId(courseId).toList()

}
