package com.interactivestandard.data.api

import android.content.Context
import com.interactivestandard.data.R
import com.interactivestandard.data.api.service.PointService
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import java.util.concurrent.atomic.AtomicReference

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 18.01.2023 22:22.
 */
class ApiClient(private val context: Context) {

    private var reference: AtomicReference<HttpClient?> = AtomicReference()

    internal val instance: HttpClient
        get() {
            while (true) {
                val oldInstance = reference.get()

                if (oldInstance != null) return oldInstance

                val newInstance = createInstance()

                if (reference.compareAndSet(null, newInstance)) return newInstance
            }
        }

    private fun createInstance(): HttpClient {
        return HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json {
                    isLenient = true
                    prettyPrint = true
                    ignoreUnknownKeys = true
                })
            }

            install(Logging) {
                level = LogLevel.ALL
            }

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTP
                    host = context.getString(R.string.apiBaseUrl)
                }
            }
        }
    }

    fun destroyInstance() {
        val oldInstance = reference.get()

        if (oldInstance != null) {
            oldInstance.close()
            reference.compareAndSet(oldInstance, null)
        }
    }

    val pointService
        get() = PointService(this)
}
