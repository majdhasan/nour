package life.majd.nour.web.dto

import life.majd.nour.repository.entity.EnrollmentEntity
import java.util.*

data class EnrollmentRequest(
    val courseId: UUID,
    val studentId: UUID,
    val enrollmentCode: String?
) {

    fun toEntity() = EnrollmentEntity(
        course = courseId,
        student = studentId
    )
}

