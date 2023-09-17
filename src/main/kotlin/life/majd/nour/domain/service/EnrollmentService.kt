package life.majd.nour.domain.service

import life.majd.nour.repository.CourseRepository
import life.majd.nour.repository.EnrollmentCodeRepository
import life.majd.nour.repository.EnrollmentRepository
import life.majd.nour.repository.entity.EnrollmentEntity
import life.majd.nour.web.dto.EnrollmentRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException

@Service
class EnrollmentService(
    val enrollmentRepository: EnrollmentRepository,
    val courseRepository: CourseRepository,
    val enrollmentCodeRepository: EnrollmentCodeRepository
) {


    fun enrollStudent(req: EnrollmentRequest): EnrollmentEntity {
        val course = courseRepository.findById(req.courseId).orElseThrow {
            HttpClientErrorException(
                HttpStatus.NOT_FOUND,
                "Course couldn't be found"
            )
        }
        // If course is public -> enroll student without further checks
        if (course.isPublic) createEnrollment(req.toEntity())

        // If course is not public and enrollment code is empty or null then reject
        if (req.enrollmentCode.isNullOrBlank()) throw HttpClientErrorException(
            HttpStatus.NOT_ACCEPTABLE,
            "Course requires a valid enrollment code"
        )

        // Check if enrollment code is valid and active
        val foundCodes =
            enrollmentCodeRepository.findByCodeAndCourseId(req.enrollmentCode, req.courseId)

        val activeCodes = foundCodes.filter { it.isActive }

        // If no active code for the enrollment to succeed -> reject
        if (activeCodes.isEmpty()) throw HttpClientErrorException(
            HttpStatus.NOT_ACCEPTABLE,
            "Enrollment code is not valid"
        )

        // code was found, accept enrollment and deactivate code if is OnceValid.
        val firstCode = activeCodes.first()
        if (firstCode.validOnce == true) enrollmentCodeRepository.save(firstCode.copy(isActive = false))

        return createEnrollment(req.toEntity())
    }

    private fun createEnrollment(enrollmentEntity: EnrollmentEntity) =
        enrollmentRepository.save(enrollmentEntity)

}
