/**
* Spark working with JSON files
*/
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().appName("DataFrameExercise").getOrCreate

val df_json_dd = spark.read.json("f.json")
df_json_dd.show()


/** Scala features to learn in future.
* Sabble -> data manipulation 
* Breeze -> numeric and scientific processing (like numpy, scipy in python)
* IDE -> IntelliJ or Eclliplse