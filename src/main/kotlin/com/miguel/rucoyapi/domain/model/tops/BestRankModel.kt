package com.miguel.rucoyapi.domain.model.tops

import com.fasterxml.jackson.annotation.JsonProperty

data class BestRankModel(
    var tops: ArrayList<BestRank>? = null
)

data class BestRank(
    @JsonProperty("best_rank")
    var bestRank: Int?= null,
    var name: String? = null,
    var category:String? =  null,
    var startDate:String? = null,
    @JsonProperty("start_date_time_stamp")
    var startDateTimeStamp: Long? = null,
)