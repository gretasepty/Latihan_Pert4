package binar.greta.latihan_pert4.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import binar.greta.latihan_pert4.StafRepository
import binar.greta.latihan_pert4.data.ResponseStafItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StafVM @Inject constructor(private val api : StafRepository) : ViewModel() {

    private val stafState = MutableStateFlow(emptyList<ResponseStafItem>())

    val datastate : StateFlow<List<ResponseStafItem>>
    get() = stafState

    init {
        viewModelScope.launch {
            val staf = api.getStaf()
            stafState.value = staf
        }
    }
}