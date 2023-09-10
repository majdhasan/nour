package life.majd.nour.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table(name = "certificate")
data class CertificateEntity(
    @Id val id: UUID?,
    val student: UUID,
    val course: UUID
)