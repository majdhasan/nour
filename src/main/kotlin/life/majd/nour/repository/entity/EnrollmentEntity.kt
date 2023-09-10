package life.majd.nour.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*


@Table(name = "enrollment")
data class EnrollmentEntity(
    @Id val id : UUID? = null,
    val course : UUID,
    val student : UUID,
    val paid : Boolean? = false
)