package com.kodiiiofc.urbanuniversity.dashboard

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kodiiiofc.urbanuniversity.dashboard.databinding.FragmentTasksBinding

class TasksFragment : Fragment(R.layout.fragment_tasks), ClickableCard {

    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tasksRv.adapter = TasksRecyclerViewAdapter(Task.tasks)
        binding.tasksRv.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onClick(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, this)
            .addToBackStack("")
            .commit()
    }

    override fun onBackPressed() {
        val mainFragment = parentFragmentManager.findFragmentByTag("RecyclerView")!!
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, mainFragment)
            .commit()
    }

}