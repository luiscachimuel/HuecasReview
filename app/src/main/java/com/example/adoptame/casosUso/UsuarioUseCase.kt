package com.example.adoptame.casosUso

import com.example.adoptame.entidades.Usuario

class UsuarioUseCase {

    private val usuariosDb = listOf<Usuario>(
        Usuario("EDISON", "mendez"),
        Usuario("GUILLERMO", "lazo"),
        Usuario("LUIS", "miguel"),
        Usuario("JACK", "black")
    )

    fun getUserNameAndPass(name: String, pass: String): Usuario {
        var us = Usuario()

        usuariosDb.forEach() {
            println(it)
            if (it.nombre == name && it.password == pass) {
                us = it
            }
        }
        return us
    }


}