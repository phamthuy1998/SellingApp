package thuypham.n16dccn159.ptithcm.sellingapp.feature.user

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.support.v4.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.data.Status
import thuypham.n16dccn159.ptithcm.sellingapp.databinding.FragmentUserBinding
import thuypham.n16dccn159.ptithcm.sellingapp.di.Injection
import thuypham.n16dccn159.ptithcm.sellingapp.ext.*
import thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication.EditProfileActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication.LoginActivity
import thuypham.n16dccn159.ptithcm.sellingapp.feature.order.OrderActivity
import thuypham.n16dccn159.ptithcm.sellingapp.viewmodel.UserViewModel

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideAuthViewModelFactory()
        )[UserViewModel::class.java]
    }

    private lateinit var binding: FragmentUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel.getUserInfo(requireActivity().getIntPref(USER_ID) ?:0)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addEvents()
        bindViewModel()
    }

    private fun bindViewModel() {
        userViewModel.userInfo.observe(viewLifecycleOwner) {
            binding.user = it
        }
        userViewModel.networkUserInfo.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.RUNNING -> binding.progressUser.visible()
                Status.SUCCESS -> {
                    binding.progressUser.gone()
                }
                Status.FAILED -> {
                    binding.progressUser.gone()
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun addEvents() {
        /* imageView.load("") {
             placeholder()
             error()
         }*/
        tv_manage_order.setOnClickListener {
            startActivity<OrderActivity>()
        }
        tv_received_order.setOnClickListener {
            val intent = Intent(context, OrderActivity::class.java)
            intent.putExtra(ORDER_STATUS_ID, id)
            requireActivity().startActivity(intent)
        }
        tv_order_waiting_shiping.setOnClickListener {
            val intent = Intent(context, OrderActivity::class.java)
            intent.putExtra(ORDER_STATUS_ID, id)
            requireActivity().startActivity(intent)
        }
        tv_order_success.setOnClickListener {
            val intent = Intent(context, OrderActivity::class.java)
            intent.putExtra(ORDER_STATUS_ID, id)
            requireActivity().startActivity(intent)
        }
        tv_order_canceled.setOnClickListener {
            val intent = Intent(context, OrderActivity::class.java)
            intent.putExtra(ORDER_STATUS_ID, id)
            requireActivity().startActivity(intent)
        }

        btn_sign_out.setOnClickListener { confirmSignOut() }

        tv_hot_line.setOnClickListener {
            callPhoneNumber()
        }

        ll_info_logged.setOnClickListener {
            startActivity<EditProfileActivity>()
        }
    }

    private fun confirmSignOut() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setCancelable(false)
        with(builder)
        {
            setMessage(getString(R.string.dialogLogOut))
            setPositiveButton(getString(R.string.dialogOk)) { dialog, _ ->
                requireContext().removeValueSharePrefs(USER_EMAIL)
                startActivity<LoginActivity>()
                requireActivity().finish()
                dialog.dismiss()
            }
            setNegativeButton(getString(R.string.dialogCancel)) { dialog, _ ->
                dialog.dismiss()
            }
            show()
        }

    }

    private fun callPhoneNumber() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CALL_PHONE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                )
            ) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.CALL_PHONE), targetRequestCode
                )

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0373865759"))
            startActivity(intent)
        }
    }


}
