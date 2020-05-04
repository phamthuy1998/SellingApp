package thuypham.n16dccn159.ptithcm.sellingapp.feature.user

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user.*
import org.jetbrains.anko.support.v4.startActivity
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication.EditProfileActivity

/**
 * A simple [Fragment] subclass.
 */
class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkUserLogin()
        addEvents()
    }

    private fun addEvents() {
        tv_manage_order.setOnClickListener {

        }
        tv_received_order.setOnClickListener {

        }
        tv_order_waiting_shiping.setOnClickListener {

        }
        tv_order_success.setOnClickListener {

        }
        tv_order_canceled.setOnClickListener {

        }
        btn_sign_out.setOnClickListener {

        }
        tv_hot_line.setOnClickListener {
            callPhoneNumber()
        }
        ll_info_not_logged.setOnClickListener {

        }

        ll_info_logged.setOnClickListener {
            startActivity<EditProfileActivity>()
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

    private fun checkUserLogin() {

    }



}
