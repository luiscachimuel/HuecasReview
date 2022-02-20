package com.example.adoptame.casosUso

import com.example.adoptame.database.entidades.Usuario

class UsuarioUseCase {

    private val usuariosDb = listOf<Usuario>(
        Usuario("ADMIN", "admin"),
        Usuario("MARTIN", "123456"),
        Usuario("LUIS", "123456")
    )

    fun getUserNameAndPass(name: String, pass: String): Usuario {
        var us = Usuario()

        usuariosDb.forEach() {
            if (it.nombre == name && it.password == pass) {
                us = it
            }
        }
        return us
    }
}