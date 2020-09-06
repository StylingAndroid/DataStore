package com.stylingandroid.datastore.ui.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stylingandroid.datastore.databinding.FragmentBasicBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BasicFragment : Fragment() {

    @Inject
    lateinit var viewModel: BasicViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        FragmentBasicBinding.inflate(inflater, container, false).let { binding ->
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
            binding.root
        }
}
