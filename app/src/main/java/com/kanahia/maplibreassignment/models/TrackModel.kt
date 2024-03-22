package com.kanahia.maplibreassignment.models

import com.google.gson.annotations.SerializedName

data class TrackModel(
    val type: String,
    val properties: Properties4,
    val features: List<Feature>,
)

data class Properties4(
    val description: String,
    val created: String,
    val user: User,
    val appVersion: String,
    val touVersion: String,
    val measurementProfile: String,
    val begin: String,
    val end: String,
    val id: String,
    val modified: String,
    val name: String,
    val length: Double,
    val sensor: Sensor2,
    val status: String,
)

data class User(
    val name: String,
    val mail: String,
    val created: String,
    val modified: String,
    val acceptedTermsOfUseVersion: String,
    val acceptedPrivacyStatementVersion: String,
)

data class Sensor2(
    val type: String,
    val properties: Properties2,
)

data class Properties2(
    val fuelType: String,
    val constructionYear: Long,
    val engineDisplacement: Long,
    val weight: Long,
    val model: String,
    val id: String,
    val manufacturer: String,
)

data class Feature(
    val type: String,
    val geometry: Geometry,
    val properties: Properties3,
)

data class Geometry(
    val type: String,
    val coordinates: List<Double>,
)

data class Properties3(
    val id: String,
    val time: String,
    val phenomenons: Phenomenons,
)

data class Phenomenons(
    @SerializedName("Throttle Position")
    val throttlePosition: ThrottlePosition,
    @SerializedName("MAF")
    val maf: Maf,
    @SerializedName("GPS Accuracy")
    val gpsAccuracy: GpsAccuracy,
    @SerializedName("Intake Temperature")
    val intakeTemperature: IntakeTemperature,
    @SerializedName("CO2 Emission (GPS-based)")
    val co2EmissionGpsBased: Co2EmissionGpsBased,
    @SerializedName("Minimum GPS Acceleration")
    val minimumGpsAcceleration: MinimumGpsAcceleration?,
    @SerializedName("GPS Altitude")
    val gpsAltitude: GpsAltitude,
    @SerializedName("GPS VDOP")
    val gpsVdop: GpsVdop,
    @SerializedName("Minimum Acceleration")
    val minimumAcceleration: MinimumAcceleration,
    @SerializedName("Speed")
    val speed: Speed,
    @SerializedName("GPS HDOP")
    val gpsHdop: GpsHdop,
    @SerializedName("Maximum GPS Acceleration")
    val maximumGpsAcceleration: MaximumGpsAcceleration?,
    @SerializedName("Rpm")
    val rpm: Rpm,
    @SerializedName("GPS Speed")
    val gpsSpeed: GpsSpeed,
    @SerializedName("CO2")
    val co2: Co2,
    @SerializedName("Consumption")
    val consumption: Consumption,
    @SerializedName("Consumption (GPS-based)")
    val consumptionGpsBased: ConsumptionGpsBased,
    @SerializedName("Maximum Acceleration")
    val maximumAcceleration: MaximumAcceleration,
    @SerializedName("GPS PDOP")
    val gpsPdop: GpsPdop,
    @SerializedName("Intake Pressure")
    val intakePressure: IntakePressure,
    @SerializedName("Engine Load")
    val engineLoad: EngineLoad,
)

data class ThrottlePosition(
    val value: Double,
    val unit: String,
)

data class Maf(
    val value: Double,
    val unit: String,
)

data class GpsAccuracy(
    val value: Double,
    val unit: String,
)

data class IntakeTemperature(
    val value: Double,
    val unit: String,
)

data class Co2EmissionGpsBased(
    val value: Double,
    val unit: String,
)

data class MinimumGpsAcceleration(
    val value: Double,
    val unit: String,
)

data class GpsAltitude(
    val value: Double,
    val unit: String,
)

data class GpsVdop(
    val value: Double,
    val unit: String,
)

data class MinimumAcceleration(
    val value: Double,
    val unit: String,
)

data class Speed(
    val value: Double,
    val unit: String,
)

data class GpsHdop(
    val value: Double,
    val unit: String,
)

data class MaximumGpsAcceleration(
    val value: Double,
    val unit: String,
)

data class Rpm(
    val value: Double,
    val unit: String,
)

data class GpsSpeed(
    val value: Double,
    val unit: String,
)

data class Co2(
    val value: Double,
    val unit: String,
)

data class Consumption(
    val value: Double,
    val unit: String,
)

data class ConsumptionGpsBased(
    val value: Double,
    val unit: String,
)

data class MaximumAcceleration(
    val value: Double,
    val unit: String,
)

data class GpsPdop(
    val value: Double,
    val unit: String,
)

data class IntakePressure(
    val value: Double,
    val unit: String,
)

data class EngineLoad(
    val value: Double,
    val unit: String,
)
