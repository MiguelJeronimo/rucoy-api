package com.miguel.rucoyapi.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class WikiModels(
    val parse: ParseInfo? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ParseInfo(
    val title: String? = null,
    val pageid: Int? = null,
    val text: ContentText? = null
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ContentText(
    @JsonProperty("*")
    val content: String? = null
)