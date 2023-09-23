package life.majd.nour.repository

import life.majd.nour.repository.entity.TutorEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TutorRepository : CrudRepository<TutorEntity, UUID> {

    fun findByEmail(email: String): TutorEntity?
}