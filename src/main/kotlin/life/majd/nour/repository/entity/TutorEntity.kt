package life.majd.nour.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "tutor")
data class TutorEntity(
    @Id val id: UUID? = null,
    val name: String,
    val email: String,
    val password: String
)