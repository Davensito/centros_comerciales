package com.example.centrocomercial

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.centrocomercial.databinding.ActivityScrollingBinding

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TIENDAS
        val fnac = Tienda(1,"Fnac", "Distribuidora en Europa de productos tecnológicos y culturales")
        val game = Tienda(2, "Game", "GAME es la cadena líder en comercialización de videojuegos.")
        val bershka = Tienda(7, "Bershka", "Tienda especializada en moda joven con precios bastante atractivos.")
        val natura = Tienda(10, "Natura","Un espacio lleno de complementos, libros, accesorios de decoración y objetos originales que ni siquiera sabías que existían.")

        //LISTA DE TIENDAS
        val listaTiendas: MutableList<Tienda> = listOf(fnac, bershka, game, natura) as MutableList<Tienda>

        //CENTROS COMERCIALES
        val ccBonaire = CentroComercial(1,"Centro Comercial Bonaire","Autovía del Este, Km. 345, 46960, Valencia",10,listaTiendas)
        val ccAqua = CentroComercial(2,"Centro Comercial Aqua","Carrer de Menorca, 19, 46023 València",15,listaTiendas)
        val ccSaler = CentroComercial(3,"Centro Comercial Saler", "Av. del Professor López Piñero, 16, 46013 València",20,listaTiendas)
        val ccNuevoCentro = CentroComercial(4,"C.C Nuevo Centro", "Av. de Pius XII, 2, 46009 València",25,listaTiendas)

        val centrosComerciales = mutableListOf<CentroComercial>()
        centrosComerciales.add(ccBonaire)
        centrosComerciales.add(ccAqua)
        centrosComerciales.add(ccSaler)
        centrosComerciales.add(ccNuevoCentro)

        //ASIGNAR NOMBRES
        binding.content.nombreCentro1.text = (ccBonaire.nombre)
        binding.content.nombreCentro2.text = (ccAqua.nombre)
        binding.content.nombreCentro3.text = (ccSaler.nombre)
        binding.content.nombreCentro4.text = (ccNuevoCentro.nombre)

        //ASIGNAR DIRECCIONES
        binding.content.tvDireccion1.text = (ccBonaire.direccion)
        binding.content.tvDireccion2.text = (ccAqua.direccion)
        binding.content.tvDireccion3.text = (ccSaler.direccion)
        binding.content.tvDireccion4.text = (ccNuevoCentro.direccion)

        Glide.with(this)
            .load("https://www.tuscentroscomerciales.com/wp-content/uploads/2017/02/centros-comerciales-abiertos-valencia-1024x576.jpg")
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgPortada)
        Glide.with(this)
            .load("https://www.guiagps.com/wp-content/uploads/2020/06/tiendas-moda.jpg")
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgCentro1)
        Glide.with(this)
            .load("https://www.edifesa.com/wp-content/uploads/2016/03/62008_2_fachadaccaqua_valencia-1.jpg")
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgCentro2)
        Glide.with(this)
            .load("https://offloadmedia.feverup.com/valenciasecreta.com/wp-content/uploads/2019/09/21092109/centro-comercial-saler-reforma-1024x597.jpg")
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgCentro3)
        Glide.with(this)
            .load("https://www.lovevalencia.com/wp-content/uploads/2012/01/Nuevo-centro2.jpg")
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(binding.content.imgCentro4)

        binding.content.cvCentro1.setOnClickListener {
            val intent = Intent(this, ScrollingTiendasActivity::class.java)
            intent.putExtra("idcc", ccBonaire.id.toString())
            startActivity(intent)
        }
        binding.content.cvCentro2.setOnClickListener {
            val intent = Intent(this, ScrollingTiendasActivity::class.java)
            intent.putExtra("idcc", ccAqua.id.toString())
            startActivity(intent)
        }
        binding.content.cvCentro3.setOnClickListener {
            val intent = Intent(this, ScrollingTiendasActivity::class.java)
            intent.putExtra("idcc", ccSaler.id.toString())
            startActivity(intent)
        }
        binding.content.cvCentro4.setOnClickListener {
            val intent = Intent(this, ScrollingTiendasActivity::class.java)
            intent.putExtra("idcc", ccNuevoCentro.id.toString())
            startActivity(intent)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    //MUSICA

    override fun onStart() {
        super.onStart()

        mediaPlayer = MediaPlayer.create(this, R.raw.ai_2)
        mediaPlayer?.start()
    }

    override fun onResume() {
        super.onResume()

        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()

        mediaPlayer?.pause()
        if (mediaPlayer != null) {
            position = mediaPlayer!!.currentPosition
        }
    }

    override fun onStop() {
        super.onStop()

        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}