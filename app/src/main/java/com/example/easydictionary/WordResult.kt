package com.example.easydictionary

data class WordResult(
    val word: String,
    val phonetic: String?,
    val meanings: List<Meaning>,

    )
data class Meaning(
    val phonetic: String,
    val definitions: List<Definition>,
    val synonyms: List<String>,
    val antonyms: List<String>,
    val partOfSpeech: String,
)


data class Definition(
    val definition: String

)
