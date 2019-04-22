/**
* Spark dataframes and datasets*/

import org.apache.spark.sql.SparkSession 
val spark = SparkSession.builder().appName("DataFrameExercise").getOrCreate()
val df_emps = spark.read.option("header", "true").csv("file.txt")
df_emps.take(10)
df_emps.schema
df_emps.show()


val dr_cr = spark.read.options("header", "true").csv("file2.txt")
df_cr.take(10)
df_cr.show()
dr_cr.columns


val df_dd = spark.read.options("header", "true").csv("fil2.txt")
df_dd.show()

df_emps.show()
df_emps.createOrReplaceTempView("employees") // creates a temp view to run sql on that df

val sqldf_emps = spark.sql("select * from employees")
val sqldf_emps_by_dept = spark.sql("select department, count(*) from employees group by department")

val sqldf_emps_by_dept_gender = spark.sql("select department, gender, count(*) from employees group by deparment,gender")

val sqldf_depts = spark.sql("select distinct department from employees")

val sqldf_emps_100 = spark.sql("select * from employees where id < 100")
sqldf_emps_100.show()

// joining tables

val df_joined = df_emps.join(df_cr,"region_id")
df_joined.columns
df_joined.show()
