package school.sptech.s3;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;

import java.util.List;

public class BucketController {
    public static void listarBuckets() {
        S3Client s3Client = new S3Provider().getS3Client();
        List<Bucket> buckets = s3Client.listBuckets().buckets();
        for (Bucket bucket : buckets) {
            System.out.println("Bucket: " + bucket.name());
        }
    }
}
