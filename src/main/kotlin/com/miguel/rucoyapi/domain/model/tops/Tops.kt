package com.miguel.rucoyapi.domain.model.tops

import com.fasterxml.jackson.annotation.JsonProperty


data class TopsDto(
    var tops: ArrayList<Top>? = null
)

data class Top(
    val rank: Int,
    @JsonProperty("id_character")
    val idCharacter: String,
    val name: String,
    val level: Int,
    @JsonProperty("start_date_time_stamp")
    val startDateTimeStamp: Long,
    @JsonProperty("last_date_time_stamp")
    val lastDateTimeStamp: Long,
    @JsonProperty("start_date")
    val startDate: String,
    @JsonProperty("last_date")
    val lastDate: String,
    val experience: Long?,
    @JsonProperty("experience_string")
    val experienceString: String?,
    val levels: Int?,
    @JsonProperty("gain_exp")
    val gainExp: String?,
    @JsonProperty("progress_percent")
    val progressPercent: String?,
    val category: String?
)