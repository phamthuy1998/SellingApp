package thuypham.n16dccn159.ptithcm.sellingapp.feature.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sign_in_up.*
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.feature.main.adapter.MyFragmentPagerAdapter

class SignInUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MyFragmentPagerAdapter(requireActivity().supportFragmentManager)
        adapter.addFragment(LoginFragment(), getString(R.string.sign_in))
        adapter.addFragment(SignUpFragment(), getString(R.string.sign_up))
        pagerLogin.adapter = adapter
        pagerLogin.offscreenPageLimit = 1
        tabLogin.setupWithViewPager(pagerLogin)
    }
}
