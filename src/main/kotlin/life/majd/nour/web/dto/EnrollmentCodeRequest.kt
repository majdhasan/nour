package life.majd.nour.web.dto

import life.majd.nour.repository.entity.EnrollmentCodeEntity
import life.majd.nour.util.StringUtil
import java.util.*

data class EnrollmentCodeRequest(
    val tutorId: UUID,
    val courseId: UUID?,
    val studentId: UUID?,
    val code: String?,
    val validOnce: Boolean?
) {

    fun toEntity() = EnrollmentCodeEntity(
        tutorId = tutorId,
        courseId = courseId,
        studentId = studentId,
        code = code ?: StringUtil.generateRandomCode(),
        validOnce = validOnce

    )
}