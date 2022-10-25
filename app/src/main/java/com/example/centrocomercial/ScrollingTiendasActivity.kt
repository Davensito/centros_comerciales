package com.example.centrocomercial

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.centrocomercial.databinding.ActivityScrollingTiendasBinding

class ScrollingTiendasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingTiendasBinding

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingTiendasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val openUrl = Intent(Intent.ACTION_VIEW)

        //TIENDAS
        val fnac = Tienda(1,"Fnac", "Distribuidora en Europa de productos tecnológicos y culturales")
        val game = Tienda(2, "Game", "GAME es la cadena líder en comercialización de videojuegos.")
        val bershka = Tienda(3, "Bershka", "Tienda especializada en moda joven con precios bastante atractivos.")
        val natura = Tienda(4, "Natura","Un espacio lleno de complementos, libros, accesorios de decoración y objetos originales que ni siquiera sabías que existían.")

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

        val extras = intent.extras
        if (extras != null){
            val idcc = extras.getString("idcc")!!.toInt()
            for ((indexcc, cc) in centrosComerciales.withIndex()){
                if (cc.id ==idcc){
                    binding.content2.tvTitle.text = (cc.nombre)
                    if(indexcc == 0){
                        Glide.with(this)
                            .load("https://www.guiagps.com/wp-content/uploads/2020/06/tiendas-moda.jpg")
                            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                            .centerCrop()
                            .into(binding.content2.imgPortada)
                    }
                    if(indexcc == 1){
                        Glide.with(this)
                            .load("https://www.edifesa.com/wp-content/uploads/2016/03/62008_2_fachadaccaqua_valencia-1.jpg")
                            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                            .centerCrop()
                            .into(binding.content2.imgPortada)
                    }
                    if(indexcc == 2){
                        Glide.with(this)
                            .load("https://offloadmedia.feverup.com/valenciasecreta.com/wp-content/uploads/2019/09/21092109/centro-comercial-saler-reforma-1024x597.jpg")
                            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                            .centerCrop()
                            .into(binding.content2.imgPortada)
                    }
                    if(indexcc == 3){
                        Glide.with(this)
                            .load("https://www.lovevalencia.com/wp-content/uploads/2012/01/Nuevo-centro2.jpg")
                            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                            .centerCrop()
                            .into(binding.content2.imgPortada)
                    }


                    for ((index, tienda) in cc.listaTiendas.withIndex()) {
                        if (index == 0){
                            binding.content2.tvNombreTienda1.text = (tienda.nombre)
                            binding.content2.tvDescripcionTienda1.text = (tienda.descripcion)
                            Glide.with(this)
                                .load("https://s1.eestatic.com/2020/11/13/omicrono/omicrono_535706818_164994732_1706x960.jpg")
                                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                .centerCrop()
                                .into(binding.content2.imgTienda1)
                            binding.content2.comprar1.setOnClickListener {
                                val url1 = "https://www.fnac.es/"
                                openUrl.data = Uri.parse(url1)
                                startActivity(openUrl)
                            }
                        }
                        if (index == 1){
                            binding.content2.tvNombreTienda2.text = (tienda.nombre)
                            binding.content2.tvDescripcionTienda2.text = (tienda.descripcion)
                            Glide.with(this)
                                .load("https://i0.wp.com/turkpidya.com/wp-content/uploads/2022/01/Bershka-Turkey.jpg?w=850&ssl=1")
                                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                .centerCrop()
                                .into(binding.content2.imgTienda2)
                            binding.content2.comprar2.setOnClickListener {
                                val url1 = "https://www.bershka.com/"
                                openUrl.data = Uri.parse(url1)
                                startActivity(openUrl)
                            }
                        }
                        if (index == 2){
                            binding.content2.tvNombreTienda3.text = (tienda.nombre)
                            binding.content2.tvDescripcionTienda3.text = (tienda.descripcion)
                            Glide.with(this)
                                .load("https://www.elingenio.es/wp-content/uploads/2019/02/game-ok.png")
                                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                .centerCrop()
                                .into(binding.content2.imgTienda3)
                            binding.content2.comprar3.setOnClickListener {
                                val url1 = "https://www.game.es/"
                                openUrl.data = Uri.parse(url1)
                                startActivity(openUrl)
                            }
                        }
                        if (index == 3){
                            binding.content2.tvNombreTienda4.text = (tienda.nombre)
                            binding.content2.tvDescripcionTienda4.text = (tienda.descripcion)
                            Glide.with(this)
                                .load("https://www.naturaselection.com/img/LOGO-NATURA-VERDE.png")
                                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                .centerCrop()
                                .into(binding.content2.imgTienda4)
                            binding.content2.comprar4.setOnClickListener {
                                val url1 = "https://www.naturaselection.com/es/"
                                openUrl.data = Uri.parse(url1)
                                startActivity(openUrl)
                            }
                        }
                    }

                }
            }

        }

    }

    //MUSICA

    /*override fun onStart() {
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

    override fun onBackPressed() {
        super.onBackPressed()
        val position = intent.extras
    }*/

}