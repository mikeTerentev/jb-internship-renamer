package ru.itmo.rain.terentev.typewalker

import java.io.File
import java.lang.Exception
import java.nio.file.FileVisitResult
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.FileVisitResult.CONTINUE


class FilesFinder : SimpleFileVisitor<Path>() {
    companion object {
        const val POSTFIX = ".2019"
        val EXTENSIONS = arrayOf("kt", "java")
    }

    override fun visitFile(path: Path, attrs: BasicFileAttributes): FileVisitResult {
        val file = File(path.toUri())
        when {
            isOld(file.extension) -> changeExtension(file)
        }
        return CONTINUE
    }

    private fun isOld(extension: String) = extension in EXTENSIONS

    private fun changeExtension(f: File) {
        val nPath = f.absolutePath + POSTFIX;
        when {
            f.renameTo(File(nPath)) -> println(nPath)
            else -> System.err.println("Can't rename " + f.absolutePath)
        }
    }
}