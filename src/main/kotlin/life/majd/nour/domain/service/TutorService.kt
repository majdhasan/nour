package life.majd.nour.domain.service

import life.majd.nour.repository.CourseRepository
import life.majd.nour.repository.TutorRepository
import life.majd.nour.repository.entity.TutorEntity
import life.majd.nour.web.dto.TutorRequest
import life.majd.nour.web.dto.TutorResponse
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class TutorService(
    val tutorRepository: TutorRepository,
    val courseRepository: CourseRepository
) {

    fun getTutors(): List<TutorEntity> {
        return tutorRepository.findAll().toList()
    }

    fun getTutor(tutorId: UUID): TutorResponse {
        val tutor: TutorEntity =
            tutorRepository.findById(tutorId).orElseThrow { NotFoundException() }
        val courses = courseRepository.findAllByTutorId(tutorId)
        return TutorResponse(tutor.name, courses)

    }

    fun createTutor(tutorEntity: TutorEntity): TutorEntity {
        return tutorRepository.save(tutorEntity)
    }

    fun loginTutor(tutorLoginRequest: TutorRequest.Login): TutorEntity? {
        return tutorRepository.findByEmail(tutorLoginRequest.email)?.let { tutor ->
            if (tutor.password == tutorLoginRequest.password) {
                tutor
            } else {
                null
            }
        }
    }
}