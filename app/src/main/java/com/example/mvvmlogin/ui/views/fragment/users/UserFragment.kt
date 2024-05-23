package com.example.mvvmlogin.ui.views.fragment.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmlogin.databinding.FragmentUserBinding
import com.example.mvvmlogin.ui.views.activities.MainActivity
import com.example.mvvmlogin.ui.views.fragment.users.adapter.UserAdapter

class UserFragment : Fragment() {
    private lateinit var binding: FragmentUserBinding
    private lateinit var mainActivity: MainActivity
    val adapter: UserAdapter = UserAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mainActivity = requireActivity() as MainActivity
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(requireActivity())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.userRecyclerView.layoutManager = layoutManager
        binding.userRecyclerView.adapter = adapter

        mainActivity.userViewModel.userLiveData.observe(
            requireActivity()) { usuario ->
            binding.userRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
    }
}