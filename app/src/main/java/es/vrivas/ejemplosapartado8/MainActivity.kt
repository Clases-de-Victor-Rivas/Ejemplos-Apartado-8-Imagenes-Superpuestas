package es.vrivas.ejemplosapartado8

import android.annotation.SuppressLint
import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.View.generateViewId
import android.widget.Button
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var viendo_imagen: Int =0
    lateinit var bt_reiniciar: Button

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Modifico las propiedades de los botones existentes
        bt_poner.setText( getString(R.string.poner_imagen))
        bt_quitar.text="QUITAR IMAGEN"

        // Creo un nuevo botón programáticamente
        val params = FrameLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT )
        bt_reiniciar= Button(this)
        params.gravity=Gravity.BOTTOM+ Gravity.START
        params.bottomMargin=20
        params.leftMargin=350
        bt_reiniciar.text=getString(R.string.reiniciar_imagen)
        bt_reiniciar.setOnClickListener(this)
        addContentView(bt_reiniciar, params)

    }
    // Opción 1: Usamos un callback para cada botón
    @Suppress( "UNUSED_PARAMETER")
    fun bt_poner_click(view: View?){
        viendo_imagen+=if (viendo_imagen<2) 1 else 0
        im_gafas.visibility=if (viendo_imagen>0) View.VISIBLE else View.INVISIBLE
        im_barba.visibility=if (viendo_imagen>1) View.VISIBLE else View.INVISIBLE
    }

    @Suppress( "UNUSED_PARAMETER")
    fun bt_quitar_click(view: View?){
        viendo_imagen-=if (viendo_imagen>0) 1 else 0
        im_gafas.visibility=if (viendo_imagen>0) View.VISIBLE else View.INVISIBLE
        im_barba.visibility=if (viendo_imagen>1) View.VISIBLE else View.INVISIBLE
    }


    // Opción 2: Usamos un solo callback para todos los botones, identificando cuál ha sido pulsado
    fun bt_quitar_poner_click(view: View?){
        when( view ) {
            bt_quitar -> viendo_imagen-=if (viendo_imagen>0) 1 else 0
            bt_poner -> viendo_imagen+=if (viendo_imagen<2) 1 else 0
            bt_reiniciar -> viendo_imagen=0
        }
        im_gafas.visibility=if (viendo_imagen>0) View.VISIBLE else View.INVISIBLE
        im_barba.visibility=if (viendo_imagen>1) View.VISIBLE else View.INVISIBLE
    }

    // Opción 3: La actividad implementa los métodos de la interfaz View.OnClickListener
    override fun onClick(view: View?) {
        when( view ) {
            bt_quitar -> viendo_imagen-=if (viendo_imagen>0) 1 else 0
            bt_poner -> viendo_imagen+=if (viendo_imagen<2) 1 else 0
            bt_reiniciar -> viendo_imagen=0
        }

        im_gafas.visibility=if (viendo_imagen>0) View.VISIBLE else View.INVISIBLE
        im_barba.visibility=if (viendo_imagen>1) View.VISIBLE else View.INVISIBLE
    }


}