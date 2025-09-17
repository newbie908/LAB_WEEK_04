package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeList = listOf(
            view.findViewById<View>(R.id.affogato),
            view.findViewById<View>(R.id.americano),
            view.findViewById<View>(R.id.latte)
        )

        coffeeList.forEach { coffee ->
            val fragmentBundle = Bundle()
            fragmentBundle.putInt(COFFEE_ID, coffee.id)
            coffee.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    R.id.action_listFragment_to_detailFragment,
                    fragmentBundle
                )
            )
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
