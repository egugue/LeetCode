import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.streams.toList
import kotlin.system.exitProcess

private val solutionDirPattern = "^[_]+[0-9]+$".toRegex()

fun main(args: Array<String>) {
  try {
    val javaRootDir = args.first()
    val solutionList1 = readSolutionList(
      Paths.get("$javaRootDir/com/htoyama/leetcode")
    )
    val solutions = Solutions(language = "Java", solutions = solutionList1)
    val moshi = Moshi.Builder()
      .add(KotlinJsonAdapterFactory())
      .build()

    println(moshi.adapter(Solutions::class.java).toJson(solutions))
  } catch (e: Throwable) {
    e.printStackTrace()
    exitProcess(1)
  }
}

private fun readSolutionList(sourceDir: Path): List<Solution> {
  return Files.walk(sourceDir).use { pathStream ->
    pathStream
      .filter { it.isDirectory() && it.fileName.toString().matches(solutionDirPattern) }
      .map { newSolution(it) }
      .toList()
  }
}

private fun newSolution(dir: Path): Solution {
  val dirName = dir.fileName.toString()
  val firstNumIndex = dirName.indexOfFirst { it in '0'..'9' }
  val problemID = dirName.substring(firstNumIndex).toIntOrNull() ?: -1
  if (problemID == -1) {
    throw IllegalStateException("couldn't find problemId. dir = $dir")
  }

  val files = Files.walk(dir).use { children ->
    children.filter { it.isDirectory().not() } .toList()
  }
  val path = if (files.size == 1) "$dirName/${files.first().fileName}" else dirName

  return Solution(
    problem_id = problemID,
    path = "jvm/src/main/java/com/htoyama/leetcode/$path"
  )
}

private fun Path.isDirectory() = toFile().isDirectory

private data class Solutions(
  val language: String,
  val solutions: List<Solution>
)

private data class Solution(
  val problem_id: Int,
  val path: String
)
