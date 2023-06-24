package com.example.demoproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class TestAdapter : RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.frgament_vp_test, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text="test $position"
    }

    override fun getItemCount(): Int {
        return 10
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.tvTest)
    }

    class TestFragment : Fragment() {


        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.frgament_vp_test, container, false)

            val textView = view.findViewById<TextView>(R.id.tvTest)
            textView.text = "Test " + arguments?.getInt("test").toString()

            return view
        }

        companion object {
            fun newInstance(pos: Int): TestFragment {
                val args = Bundle()
                args.putInt("test", pos)
                val fragment = TestFragment()
                fragment.arguments = args
                return fragment
            }
        }
    }

}