package life.majd.nour.web.dto

import life.majd.nour.repository.entity.TutorEntity

data class TutorRequest(

    val name: String,
    val email: String
) {

    fun toEntity() = TutorEntity(
        name = name,
        email = email
    )
}

