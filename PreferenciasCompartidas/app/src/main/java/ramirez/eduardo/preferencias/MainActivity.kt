package ramirez.eduardo.preferencias

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actualizarUsuario();
        btn_registrar.setOnClickListener(){
            val preferencias = this.getPreferences(Context.MODE_PRIVATE)
            var usuario =  caja_usuario.text.toString()
            var pass = caja_pass.text.toString()

            var editor = preferencias.edit()
            editor.putString("usuario", usuario)
            editor.putString("pass", pass)
            editor.commit()
            actualizarUsuario()
        }
        btn_borrar.setOnClickListener(){
            val preferencias = this.getPreferences(Context.MODE_PRIVATE)
            var editor = preferencias.edit()
            editor.clear()
            editor.commit()
            actualizarUsuario()
        }

    }
    fun actualizarUsuario(){
        val preferencias = this.getPreferences(Context.MODE_PRIVATE)
        val usuario = preferencias.getString("usuario", "usuario")
        val pass = preferencias.getString("pass", "contraseña")
        txt_usuario.text = usuario
        txt_pass.text = pass
    }
}
