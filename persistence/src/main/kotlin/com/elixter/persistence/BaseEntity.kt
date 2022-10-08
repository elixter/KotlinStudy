package com.elixter.persistence

import java.time.LocalDateTime

abstract class BaseEntity {
    abstract val createdAt : LocalDateTime
    abstract var updatedAt : LocalDateTime
}