package com.example.my2flexiblefragment


import android.app.AlertDialog
import android.bluetooth.BluetoothProfile
import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_detail_category.*

/**
 * A simple [Fragment] subclass.
 */
class DetailCategoryFragment : Fragment(), View.OnClickListener {
    lateinit var tvCategoryName: TextView
    lateinit var tvCategoryDescripton: TextView
    lateinit var btnProfile: Button
    lateinit var btnDialog: Button

    var descripton: String? = null
    companion object{
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescripton = view.findViewById(R.id.tv_category_description)
        btnProfile = view.findViewById(R.id.btn_profile)
        btnDialog = view.findViewById(R.id.btn_show_dialog)
        btnProfile.setOnClickListener(this)
        btnDialog.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null){
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            descripton = descFromBundle
        }
        if (arguments != null){
            val categoryName = arguments?.getString(EXTRA_NAME)
            tv_category_name.text = categoryName
            tv_category_description.text = descripton
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_profile -> {

            }
            R.id.btn_show_dialog -> {
                val mOptionDialogFragment = OptionDialogFragment()
                val mFragmentManager = childFragmentManager
                mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment::class.java.simpleName)
            }
        }
    }

    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener = object : OptionDialogFragment.OnOptionDialogListener{
        override fun onOptionChosen(text: String?) {
            Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
        }
    }


}
