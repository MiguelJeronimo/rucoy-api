package com.miguel.rucoyapi.data.entities
import com.fasterxml.jackson.annotation.JsonProperty

data class Turso(
    @JsonProperty("baton")
    val baton: Any? = null,
    @JsonProperty("base_url")
    val baseUrl: String? = null,
    @JsonProperty("results")
    val results: List<Results> = emptyList()
)

data class Results(
    @JsonProperty("type")
    val type: String = "",
    @JsonProperty("response")
    val response: Response = Response()
)

data class Response(
    @JsonProperty("type")
    val type: String = "",
    @JsonProperty("result")
    val result: Result? = null
)

data class Result(
    @JsonProperty("cols")
    val cols: List<Col> = emptyList(),
    @JsonProperty("rows")
    val rows: List<List<Row>> = emptyList(),
    @JsonProperty("affected_row_count")
    val affectedRowCount: Int = 0,
    @JsonProperty("last_insert_rowid")
    val lastInsertRowId: Any? = null,
    @JsonProperty("replication_index")
    val replicationIndex: Any? = null,
    @JsonProperty("rows_read")
    val rowsRead: Int = 0,
    @JsonProperty("rows_written")
    val rowsWritten: Int = 0,
    @JsonProperty("query_duration_ms")
    val queryDurationMs: Double = 0.0
)

data class Col(
    @JsonProperty("name")
    val name: String = "",
    @JsonProperty("decltype")
    val decltype: String? = null
)

data class Row(
    @JsonProperty("type")
    val type: String = "",
    @JsonProperty("value")
    val value: String? = null
)
