package es.miguelherrero.post_it.domain.model

data class Post(val userId: String,
                val id: String,
                val title: String,
                val body: String)