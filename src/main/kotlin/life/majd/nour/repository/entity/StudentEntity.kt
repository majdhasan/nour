package life.majd.nour.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "student")
data class StudentEntity(
    @Id val id: UUID? = null,
    val name: String,
    val email: String
)