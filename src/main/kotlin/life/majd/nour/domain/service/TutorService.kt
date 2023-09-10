package life.majd.nour.domain.service

import life.majd.nour.repository.CourseRepository
import life.majd.nour.repository.TutorRepository
import life.majd.nour.repository.entity.CourseEntity
import life.majd.nour.repository.entity.TutorEntity
import org.springframework.stereotype.Service

@Service
class TutorService(
    val tutorRepository: TutorRepository
) {

    fun getTutors(): List<TutorEntity> {
        return tutorRepository.findAll().toList()
    }

    fun createTutor(tutorEntity: TutorEntity): TutorEntity {
        return tutorRepository.save(tutorEntity)
    }
}