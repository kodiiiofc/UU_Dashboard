package com.kodiiiofc.urbanuniversity.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.kodiiiofc.urbanuniversity.dashboard.databinding.FragmentProjectBinding

class ProjectFragment : Fragment(R.layout.fragment_project), ClickableCard {

    private var _binding: FragmentProjectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.projectChartIv.setImageResource(R.drawable.gantt_chart)
        binding.projectTitleTv.text = getString(R.string.project_title)
        binding.projectDescriptionTv.text = getString(R.string.project_description)
    }


    override fun onClick(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, this)
            .commit()
    }

    override fun onBackPressed() {
        val mainFragment = parentFragmentManager.findFragmentByTag("RecyclerView")!!
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, mainFragment)
            .commit()
    }

}