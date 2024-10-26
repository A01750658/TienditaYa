package mx.sct.tienditaya

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.room.Room
import mx.sct.tienditaya.model.AppDatabase
import mx.sct.tienditaya.ui.theme.TienditaYaTheme
import mx.sct.tienditaya.view.Main
import android.content.Context
import androidx.activity.viewModels
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.vertexai.vertexAI
import mx.sct.tienditaya.viewmodel.YTVM
import java.io.File

class MainActivity : ComponentActivity() {

    private val viewModel: YTVM by viewModels()
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {

        if (!hasRequiredPermissions()) {
            requestPermissions(CAMERAX_PERMISSION, 0)
        }

        //val db = Room.databaseBuilder(
            //applicationContext,
            //AppDatabase::class.java, "my-database"
        //).build()

        FirebaseApp.initializeApp(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main(viewModel)
        }
    }


    fun checkDatabaseExists(context: Context): Boolean {
        return try {
            val db = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "my-database"
            ).allowMainThreadQueries() // Allow query on main thread for this check
                .build()
            db.query(
                "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'",
                null
            ).moveToFirst()
            db.close()
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun hasRequiredPermissions(): Boolean {
        return CAMERAX_PERMISSION.all {
            ContextCompat.checkSelfPermission(
                applicationContext,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    companion object {
        private val CAMERAX_PERMISSION = arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.RECORD_AUDIO
        )
    }
}