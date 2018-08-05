package es.miguelherrero.post_it

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.miguelherrero.post_it.ui.postlist.PostListFragment

class PostListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PostListFragment.newInstance())
                    .commitNow()
        }
    }

}
