package app.vazovsky.starwars.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import app.vazovsky.starwars.data.model.base.LoadableResult
import app.vazovsky.starwars.managers.CachedPagingDataUtils
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/** Базовый класс для ViewModel */
abstract class BaseViewModel : ViewModel() {
    @Inject lateinit var cachedPagingDataUtils: CachedPagingDataUtils

    private val _navigationLiveEvent = SingleLiveEvent<NavigationCommand>()
    val navigationLiveEvent: LiveData<NavigationCommand> = _navigationLiveEvent

    protected fun navigate(navigationCommand: NavigationCommand) {
        _navigationLiveEvent.value = navigationCommand
    }

    fun navigateBack() {
        _navigationLiveEvent.value = (NavigationCommand.Back)
    }

    protected fun <T> MutableLiveData<LoadableResult<T>>.launchLoadData(
        block: Flow<LoadableResult<T>>,
    ): Job = viewModelScope.launch {
        block.collect { result ->
            this@launchLoadData.postValue(result)
        }
    }

    protected fun <T : Any> MutableLiveData<PagingData<T>>.launchPagingData(
        block: () -> Flow<PagingData<T>>
    ): Job = viewModelScope.launch {
        block()
            .let { cachedPagingDataUtils.cacheIn(it, viewModelScope) }
            .collectLatest { this@launchPagingData.postValue(it) }
    }

    protected fun MutableLiveData<LoadableResult<Unit>>.bindPagingState(loadState: CombinedLoadStates) {
        when (loadState.source.refresh) {
            is LoadState.NotLoading ->
                if (this.value != null && this.value !is LoadableResult.Success) {
                    this.postValue(LoadableResult.success(Unit))
                }

            is LoadState.Loading -> this.postValue(LoadableResult.loading())
            is LoadState.Error -> this.postValue(LoadableResult.failure((loadState.source.refresh as LoadState.Error).error))
        }
    }
}