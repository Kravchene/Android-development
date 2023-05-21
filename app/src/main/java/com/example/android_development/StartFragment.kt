package com.example.android_development



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.android_development.databinding.FragmentStartBinding


class StartFragment : Fragment(), NavigationApplication {
    lateinit var binding: FragmentStartBinding
    private val intData: ValueIntRandom by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {
            val a = randomValueButton.setOnClickListener {
                if (startingValue.text.isEmpty() || maximumValue.text.isEmpty()) {
                    findNavController().navigate(R.id.action_startFragment_to_errorFragment2)
                } else {
                    val minValue = startingValue.text.toString().toInt()
                    val maxValue: Int = maximumValue.text.toString().toInt()
                    if (maxValue < minValue) findNavController().navigate(R.id.action_startFragment_to_errorFragment2)
                    else {
                        intData.message.value = (minValue..maxValue).random()

                        navigationApplication()
                    }
                }
            }
            if (textView5.text.isEmpty()) {
                intData.message.observe(activity as LifecycleOwner) {
                    textView5.text = it.toString()
                    textView4.text = getText(R.string.last)
                }

            } else {
                intData.message.observe(activity as LifecycleOwner) {
                    textView5.text = it.toString()
                }

            }
        }
    }

override fun navigationApplication() {
    findNavController().navigate(R.id.action_startFragment_to_resultFragment)
}
}