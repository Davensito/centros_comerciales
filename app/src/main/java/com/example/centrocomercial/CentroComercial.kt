package com.example.centrocomercial

data class CentroComercial(var id: Int, var nombre:String, var direccion:String, var numTiendas: Int, var listaTiendas:MutableList<Tienda>) {


}