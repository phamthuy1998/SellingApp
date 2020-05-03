package thuypham.n16dccn159.ptithcm.sellingapp.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import thuypham.n16dccn159.ptithcm.sellingapp.R
import thuypham.n16dccn159.ptithcm.sellingapp.feature.Search.SearchFragment
import thuypham.n16dccn159.ptithcm.sellingapp.feature.category.CategoryFragment
import thuypham.n16dccn159.ptithcm.sellingapp.feature.home.HomeFragment
import thuypham.n16dccn159.ptithcm.sellingapp.feature.main.adapter.MyFragmentPagerAdapter
import thuypham.n16dccn159.ptithcm.sellingapp.feature.user.UserFragment

class MainActivity : AppCompatActivity() , ViewPager.OnPageChangeListener {
    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                botNavigation.selectedItemId = R.id.bot_nav_home
            }
            1 -> {
                botNavigation.selectedItemId = R.id.bot_nav_category
            }
            2 -> {
                botNavigation.selectedItemId = R.id.bot_nav_search
            }
            3 -> {
                botNavigation.selectedItemId = R.id.bot_nav_user
            }
        }
    }

    private val homeFragment by lazy {
        HomeFragment()
    }
    private val searchFragment by lazy {
        SearchFragment()
    }
    private val categoryFragment by lazy {
        CategoryFragment()
    }
    private val userFragment by lazy {
        UserFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addViewPager()
        addBotNavEvents()
        addEvents()
    }

    private fun addEvents() {
        viewPagerMain.addOnPageChangeListener(this)
        edtSearchMain.setOnClickListener {
            viewPagerMain.currentItem = 2
            edtSearchMain.requestFocus()
        }
    }

    private fun addBotNavEvents() {
        botNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bot_nav_home -> {
                    edtSearchMain.requestFocus()
                    viewPagerMain.currentItem = 0
                    true
                }
                R.id.bot_nav_category -> {
                    viewPagerMain.currentItem = 1
                    true
                }
                R.id.bot_nav_search -> {
                    viewPagerMain.currentItem = 2
                    true
                }
                R.id.bot_nav_user -> {
                    viewPagerMain.currentItem = 4
                    true
                }
                else -> false
            }
        }
    }

    private fun addViewPager() {
        val viewPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(homeFragment, "Home fragment")
        viewPagerAdapter.addFragment(categoryFragment, "Category fragment")
        viewPagerAdapter.addFragment(searchFragment, "Search fragment")
        viewPagerAdapter.addFragment(userFragment, "User fragment")
        viewPagerMain.adapter = viewPagerAdapter
    }
}
