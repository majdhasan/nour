package life.majd.nour.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*


@Table(name = "enrollment_code")
data class EnrollmentCodeEntity(
    @Id val id : UUID? = null,
    val tutorId: UUID,
    val courseId: UUID?,
    val studentId: UUID?,
    val code: String,
    val validOnce: Boolean? = true,
    val isActive: Boolean = true
)