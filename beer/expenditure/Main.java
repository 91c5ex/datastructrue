package beer.expenditure;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SparkSession;

public class Main {

    public static void main(String[] args)  throws Exception{


        SparkConf conf = new SparkConf().setAppName("beer.expenditure").setMaster("local");
//
//        JavaSparkContext context = new JavaSparkContext(conf);
//
//       JavaRDD<String> text = context.textFile("../resources/16.csv");

        SparkContext context = new SparkContext(conf);

        SparkSession session = new SparkSession(context);

      Dataset<Row> dataset =   session.read().option("sep", "|")
                .option("inferSchema", "true")
                .option("header", "true").csv("resources/16.csv");



        dataset.printSchema();


     SQLContext sqlContext =  dataset.sqlContext();

     dataset.createOrReplaceTempView("dd");

//    Dataset<Row> da = session.sql("select * from dd where lower(`Transaction Remarks`) like '%wine%' or lower(`Transaction Remarks`) like '%bee%'");
//    Dataset<Row> da = session.sql("select sum(`Withdrawal Amount (INR )`)  from dd where lower(`Transaction Remarks`) like '%satej%' ");
//    Dataset<Row> da = session.sql("select `Transaction Remarks`, sum(`Withdrawal Amount (INR )`) from dd where lower(`Transaction Remarks`)" +
//            " like '%wine%' or lower(`Transaction Remarks`) like '%bee%'  group by `Transaction Remarks`");
//
        Dataset<Row> da = session.sql("select  sum(`Withdrawal Amount (INR )`) from dd where lower(`Transaction Remarks`)" +
                " like '%wine%' or lower(`Transaction Remarks`) like '%bee%' or lower(`Transaction Remarks`) like '%bar%'");

    da.show();;


        //da.write().format("csv").option("header", "true").save("resources/file.csv");







    }

}
