package com.kanahia.maplibreassignment.models

data class TracksListModel(
    val tracks: List<Track>,
)

data class Track(
    val begin: String,
    val end: String,
    val id: String,
    val modified: String,
    val name: String,
    val length: Double,
    val sensor: Sensor,
    val status: String,
)

data class Sensor(
    val type: String,
    val properties: Properties,
)

data class Properties(
    val fuelType: String,
    val constructionYear: Long,
    val engineDisplacement: Long,
    val weight: Long,
    val model: String,
    val id: String,
    val manufacturer: String,
)