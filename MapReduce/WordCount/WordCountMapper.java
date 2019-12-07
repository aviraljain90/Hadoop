import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

    public void map(LongWritable key, Text value, Context context)
    throws IOException,InterruptedException
    {
        String[] words = value.toString().split("[ \t]");
        for (String word : words) {
            context.write(new Text(word), new IntWritable(1));
        }
    }
}
