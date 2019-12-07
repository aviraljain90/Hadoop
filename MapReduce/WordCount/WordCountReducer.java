import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text,LongWritable,Text,LongWritable> {

    public void reduce(Text key, Iterable<LongWritable> value, Context context)
            throws IOException,InterruptedException
    {
        long sum = 0;
        for (LongWritable val : value) {
            sum = sum + val.get();
            context.write(key, new LongWritable(sum));
        }
    }
}
