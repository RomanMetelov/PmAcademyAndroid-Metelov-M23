package com.example.pmacademyandroid_metelov_m23.behavioral

import android.util.Log

private const val COMMAND_KEY = "COMMAND_KEY"

fun main() {
    val user = User("Roman")
    val add = AddUser()
    add.execute(user)
    val edit = EditUser()
    edit.execute(user)
    val delete = DeleteUser()
    delete.execute(user)
}

data class User(val name: String)

interface Command {
    fun execute(user: User)
}

class AddUser : Command {
    override fun execute(user: User) {
        Log.d(COMMAND_KEY, "Adding a new user with name: " + user.name)
    }
}

class DeleteUser : Command {
    override fun execute(user: User) {
        Log.d(COMMAND_KEY, "Deleting user with name: " + user.name)
    }
}

class EditUser : Command {
    override fun execute(user: User) {
        Log.d(COMMAND_KEY, "Editing user with name: " + user.name)
    }
}
