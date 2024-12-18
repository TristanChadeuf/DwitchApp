package com.example.dwitchapp.ui.theme
import com.squareup.moshi.Moshi
import retrofit2.Retrofit

class DwitchApiService {

    interface DwitchService {
        // Vos requêtes ici
    }

    val moshi = Moshi.Builder()
        //... Ajoutez vos adapters ici (notamment pour les dates)
        .build()

    var retrofit = Retrofit.Builder()
        //... Les paramètres Retrofit ici (notamment un petit lien avec moshi)
        .build()


    var dwitchService = retrofit.create(DwitchService::class.java)


}