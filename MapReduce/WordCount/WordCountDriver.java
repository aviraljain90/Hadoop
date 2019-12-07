import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.*;
import org.apache.hadoop.fs.*;

import java.io.IOException;

public class WordCountDriver {

    public static void main(String[] args)
    throws IOException,InterruptedException,ClassNotFoundException
    {
        JobConf conf = new JobConf();
        Job job = new Job(conf,"WordCount");

        job.setJarByClass(WordCountDriver.class);
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.addInputPath(conf, new Path("/user/jainaviral901015/wordcount.txt"));
        FileOutputFormat.setOutputPath(conf,new Path("/user/jainaviral901015/wordcount"));

        Boolean result = job.waitForCompletion(true);

        System.exit(result ? 0 : 1);
    }
}
