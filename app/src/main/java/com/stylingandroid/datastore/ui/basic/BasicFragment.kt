package com.stylingandroid.datastore.ui.basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.stylingandroid.datastore.R
import com.stylingandroid.datastore.databinding.FragmentBasicBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BasicFragment : Fragment(R.layout.fragment_basic) {

    @Inject
    lateinit var viewModel: BasicViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentBasicBinding.bind(view).let { binding ->
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
        }
    }
}
