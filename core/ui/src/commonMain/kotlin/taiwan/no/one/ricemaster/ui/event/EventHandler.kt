package taiwan.no.one.ricemaster.ui.event

interface EventHandler<E : Event> {
    fun handleEvent(event: E)
}
