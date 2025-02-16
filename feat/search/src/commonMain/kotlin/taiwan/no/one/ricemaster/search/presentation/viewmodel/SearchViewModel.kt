package taiwan.no.one.ricemaster.search.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.sake.api.SakeRepo

@KoinViewModel
internal class SearchViewModel(
    @Provided private val sakeRepo: SakeRepo,
) : ViewModel() {
    init {
        viewModelScope.launch {
            println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓")
            println(sakeRepo.init())
            println(sakeRepo.getSakeDetail(4))
            println("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑")
        }
    }
}
