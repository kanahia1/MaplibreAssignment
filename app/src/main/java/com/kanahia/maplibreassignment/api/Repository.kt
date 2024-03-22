package com.kanahia.maplibreassignment.api

import android.content.Context
import com.kanahia.maplibreassignment.models.TracksListModel
import com.kanahia.maplibreassignment.models.TrackModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

class Repository(private val apiService: ApiService, private val context: Context) {

    suspend fun getItems(): Response<TracksListModel> {
        return apiService.getTracks(getUserName(), getToken(), getUserName())
    }

    suspend fun getTrack(trackId: String): Response<TrackModel> {
        return apiService.getTrack(getUserName(), getToken(), trackId, getUserName())
    }

    private fun getUserName(): String {
        return context.getString(com.kanahia.maplibreassignment.R.string.x_user)
    }

    private fun getToken(): String {
        return context.getString(com.kanahia.maplibreassignment.R.string.x_token)
    }

    interface ApiService {
        @GET("/api/stable/users/{name}/tracks")
        suspend fun getTracks(
            @Header("X-User") user: String,
            @Header("X-Token") token: String,
            @Path("name") name: String
        ): Response<TracksListModel>

        @GET("/api/stable/users/{name}/tracks/{trackId}")
        suspend fun getTrack(
            @Header("X-User") user: String,
            @Header("X-Token") token: String,
            @Path("trackId") trackId: String,
            @Path("name") name: String
        ): Response<TrackModel>
    }
}
