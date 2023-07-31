package uz.ruzibekov.gita_bank_app.ui.screens.privacy

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.ruzibekov.gita_bank_app.ui.screens.privacy.state.PrivacyPolicyState
import javax.inject.Inject

@HiltViewModel
class PrivacyPolicyViewModel @Inject constructor() : ViewModel() {

    val state = PrivacyPolicyState()
}