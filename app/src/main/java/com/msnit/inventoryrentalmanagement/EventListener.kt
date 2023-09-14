package com.msnit.inventoryrentalmanagement

interface EventListener<T> {
    fun onEvent(eventData: T)

}