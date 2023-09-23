package life.majd.nour.web

import life.majd.nour.domain.service.EnrollmentService
import life.majd.nour.repository.entity.EnrollmentEntity
import life.majd.nour.web.dto.EnrollmentRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/enroll", consumes = [MediaType.APPLICATION_JSON_VALUE])
class EnrollmentController(val enrollmentService: EnrollmentService) {

    @PostMapping("")
    fun createEnrollment(@RequestBody enrollmentRequest: EnrollmentRequest): ResponseEntity<EnrollmentEntity> {
        val createdCourse = enrollmentService.enrollStudent(enrollmentRequest)
        return ResponseEntity(createdCourse, HttpStatus.CREATED)
    }

}
