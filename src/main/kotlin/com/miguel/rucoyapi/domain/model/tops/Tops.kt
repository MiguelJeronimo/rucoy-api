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

data class TopsStatsDto(
    var tops: ArrayList<TopStats>? = null
)

data class TopStats(
    val rank: Int,
    @JsonProperty("id_character")
    val idCharacter: String,
    val name: String,
    val level: Int,
    val levels: Int?,
    @JsonProperty("gain_exp")
    val gainExp: String?,
    val progress:Float?,
    @JsonProperty("progress_percent")
    val progressPercent: String?,
    val experience: Long?,
    @JsonProperty("experience_string")
    val experienceString: String?,
    @JsonProperty("start_date_time_stamp")
    val startDateTimeStamp: Long,
    @JsonProperty("last_date_time_stamp")
    val lastDateTimeStamp: Long,
    @JsonProperty("start_date")
    val startDate: String,
    @JsonProperty("last_date")
    val lastDate: String,
    val category: String?
)

data class HistoryDTo(
    var tops: ArrayList<History>? = null
)

data class History(
    val rank: Int,
    val category: String?,
    val name: String,
    val level: Int,
    val levels: Int?,
    @JsonProperty("start_date")
    val startDate: String,
    @JsonProperty("last_date")
    val lastDate: String,
    @JsonProperty("start_date_time_stamp")
    val startDateTimeStamp: Long,
    @JsonProperty("last_date_time_stamp")
    val lastDateTimeStamp: Long,
)