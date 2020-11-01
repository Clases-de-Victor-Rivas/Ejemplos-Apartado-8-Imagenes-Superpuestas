package es.vrivas.ejemplosapartado8

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var viendo_imagen: Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Modifico las propiedades de los botones existentes
        bt_poner.setText( "PONER IMAGEN")
        bt_quitar.text="QUITAR IMAGEN"

        // Creo un nuevo botón programáticamente
        var bt_reiniciar = Button(this)
        val params = FrameLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT )

        params.gravity=Gravity.BOTTOM+ Gravity.LEFT
        params.bottomMargin=20
        params.leftMargin=350

        bt_reiniciar.text="REINICIAR IMAGEN"

        addContentView(bt_reiniciar, params)
    }

    // Opción 1: Usamos un callback para cada botón
    @Suppress( "UNUSED_PARAMETER")
    fun bt_poner_click(view: View){
        viendo_imagen+=if (viendo_imagen<2) 1 else 0
        im_gafas.visibility=if (viendo_imagen>0) View.VISIBLE else View.INVISIBLE
        im_barba.visibility=if (viendo_imagen>1) View.VISIBLE else View.INVISIBLE
    }

    @Suppress( "UNUSED_PARAMETER")
    fun bt_quitar_click(view: View){
        viendo_imagen-=if (viendo_imagen>0) 1 else 0
        im_gafas.visibility=if (viendo_imagen>0) View.VISIBLE else View.INVISIBLE
        im_barba.visibility=if (viendo_imagen>1) View.VISIBLE else View.INVISIBLE
    }


    // Opción 2: Usamos un solo callback para todos los botones, identificando cuál ha sido pulsado
    @Suppress( "UNUSED_PARAMETER")
    fun bt_quitar_poner_click(view: View){
        when( view.id ) {
            R.id.bt_quitar -> viendo_imagen-=if (viendo_imagen>0) 1 else 0
            R.id.bt_poner -> viendo_imagen+=if (viendo_imagen<2) 1 else 0
        }
        im_gafas.visibility=if (viendo_imagen>0) View.VISIBLE else View.INVISIBLE
        im_barba.visibility=if (viendo_imagen>1) View.VISIBLE else View.INVISIBLE
    }

}