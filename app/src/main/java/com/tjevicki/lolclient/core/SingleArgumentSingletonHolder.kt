package com.tjevicki.lolclient.core

open class SingleArgumentSingletonHolder<SINGLETON_TYPE, ARGUMENT_TYPE>(creator: (ARGUMENT_TYPE) -> SINGLETON_TYPE) {
    private var creator: ((ARGUMENT_TYPE) -> SINGLETON_TYPE)? = creator

    @Volatile private var instance: SINGLETON_TYPE? = null

    fun getInstance(argument: ARGUMENT_TYPE): SINGLETON_TYPE {
        val helperInstance1 = instance

        if (helperInstance1 != null) {
            return helperInstance1
        }

        return synchronized(this) {
            val helperInstance2 = instance

            if (helperInstance2 != null) helperInstance2
            else {
                val createdInstance = creator!!(argument)
                creator = null

                createdInstance
            }
        }
    }
}