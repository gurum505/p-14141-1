package com.back.global.app

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class AppConfig(
    @Value("\${custom.site.backUrl}")
    siteBackUrl: String,
) {
    init {
        Companion.siteBackUrl = siteBackUrl
    }

    companion object {
        lateinit var siteBackUrl: String
            private set
    }
}
