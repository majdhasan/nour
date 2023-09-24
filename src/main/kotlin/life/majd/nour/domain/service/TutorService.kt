package life.majd.nour.domain.service

import life.majd.nour.repository.CourseRepository
import life.majd.nour.repository.TutorRepository
import life.majd.nour.repository.entity.TutorEntity
import life.majd.nour.web.dto.TutorRequest
import life.majd.nour.web.dto.TutorResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class TutorService(
    val tutorRepository: TutorRepository,
    val courseRepository: CourseRepository
) {

    fun getTutors(): List<TutorEntity> {
        return tutorRepository.findAll().toList()
    }

    fun getTutor(email: String): TutorResponse {

        val tutor = tutorRepository.findByEmail(email)
            ?: throw HttpClientErrorException(
                HttpStatus.NOT_FOUND,
                "Tutor not found"
            )
        val courses = courseRepository.findAllByTutorId(tutorId = tutor.id!!)
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