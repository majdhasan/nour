package life.majd.nour.web

import life.majd.nour.domain.service.CourseService
import life.majd.nour.domain.service.EnrollmentService
import life.majd.nour.repository.entity.CourseEntity
import life.majd.nour.repository.entity.EnrollmentEntity
import life.majd.nour.web.dto.CourseRequest
import life.majd.nour.web.dto.EnrollmentRequest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.function.ServerResponse
import java.util.*

@RestController
@RequestMapping("/enroll", consumes = [MediaType.APPLICATION_JSON_VALUE])
class EnrollmentController(val enrollmentService: EnrollmentService) {

    @PostMapping("")
    fun createEnrollment(@RequestBody enrollmentRequest: EnrollmentRequest): ResponseEntity<EnrollmentEntity> {
        val createdCourse = enrollmentService.enrollStudent(enrollmentRequest)
        return ResponseEntity(createdCourse, HttpStatus.CREATED)
    }

}
