package taiwan.no.one.ricemaster.map

import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.update

class ConcurrentMap<K, V> {
    private val map = atomic(mutableMapOf<K, V>())

    operator fun set(key: K, value: V) {
        put(key = key, value = value)
    }

    operator fun get(key: K): V? = map.value[key]

    fun getOrPut(key: K, defaultValue: () -> V): V {
        while (true) {
            val current = map.value
            val value = current[key]

            if (value != null) return value

            val newValue = defaultValue()

            if (map.compareAndSet(current, current.toMutableMap().apply { put(key, newValue) })) {
                return newValue
            }
        }
    }

    fun remove(key: K): V? {
        var removedValue: V? = null

        map.update { current ->
            removedValue = current[key]
            if (removedValue != null) {
                current.toMutableMap().apply { remove(key) }
            } else {
                current
            }
        }
        return removedValue
    }

    fun clear() {
        map.value = mutableMapOf()
    }

    private fun put(key: K, value: V) {
        map.update { it.toMutableMap().apply { put(key, value) } }
    }
}
