package ru.itmo.rain.terentev.typewalker

import java.nio.file.Files
import java.nio.file.Paths


fun main() {
    Files.walkFileTree(Paths.get(System.getProperty("user.dir")), FilesFinder())
}

