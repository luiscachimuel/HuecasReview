package com.example.adoptame.casosUso

import com.example.adoptame.database.entidades.Usuario

class UsuarioUseCase {

    private val usuariosDb = listOf<Usuario>(
        Usuario("LUIS", "123456"),
        Usuario("MARTIN", "123456"),
        Usuario("ADMIN", "admin"),
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