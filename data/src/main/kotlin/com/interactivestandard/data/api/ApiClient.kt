package com.interactivestandard.data.api

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
class ApiClient {

    private var reference: AtomicReference<HttpClient?> = AtomicReference()

    val instance: HttpClient
        get() {
            return reference.get() ?: synchronized(this) {
                reference.get() ?: run {
                    val newInstance = createInstance()
                    reference.set(newInstance)
                    newInstance
                }
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
                    host = "localhost"
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
}
