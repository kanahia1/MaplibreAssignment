# Maplibre Assignment
This solution aims to utilize **Retrofit, MVVM Architecture** to show all the tracks fetched using enviroCar api for a particular user. Then all the tracks are shown to user in **Recycler View**, on clicking the particular item of recycler view it takes user to another activity where the track is rendered on the map using **MapLibre Library**. The path of the track is shown using red line and the markers are used to illustrate starting and ending points. On clicking a particular marker a pop-up is shown which displays the timestamp.

Tile server used for this assignment: https://docs.maptiler.com/maplibre-gl-native-android/

## Screen Recording
https://github.com/kanahia1/MaplibreAssignment/assets/114223204/df74fcc5-eebc-435a-b0f6-e62147901b60

## Screenshots

### Main Activity to show all the Tracks of the User
<p align="start">
<img src="https://github.com/kanahia1/MaplibreAssignment/assets/114223204/9ac25588-8938-4444-849a-e351d326bd81" width="250"> </p>

### Shows the Track in the Map
<p align="start">
<img src="https://github.com/kanahia1/MaplibreAssignment/assets/114223204/881693f4-1289-4200-860d-1461c39828d3" width="250"> </p>


### Same Track in enviroCar App
<p align="start">
<img src="https://github.com/kanahia1/MaplibreAssignment/assets/114223204/121ea9d2-d505-4746-b813-aeae6b2ac55f" width="250"> </p>

## Instructions
1. Import the project through Android Studio or clone it
   - [https://github.com/kanahia1/MaplibreAssignment.git](https://github.com/kanahia1/MaplibreAssignment.git)
2. Change the `x_user` and `x_token` in `string.xml` file with your own enviroCar credentials
     - `app/src/main/res/values/strings.xml`
3. Change `map_tiler_api_key` with your own API KEY in `strings.xml` file      
4. Yippee! You have hit the mark! 🎯

## APK File
You can download apk file from [here](https://drive.google.com/file/d/1RQpm8zFpVHjeN2dNAah9mVftMYyGqrN1/view?usp=sharing).

## Dependencies
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("org.maplibre.gl:android-sdk:10.0.2")
    implementation("androidx.appcompat:appcompat:1.6.1")

## Need Help?
Feel free to contact me on [LinkedIn](https://www.linkedin.com/in/kanahia-kaushal-9850bb253/)    [Gitter](https://matrix.to/#/@kanahia1:gitter.im)

[![Instagram](https://img.shields.io/badge/Instagram-follow-purple.svg?logo=instagram&logoColor=white)](https://www.instagram.com/kanahia.jpeg/) 
