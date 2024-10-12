package school.sptech.s3;

import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

public class BucketController {
    public static void listarBuckets() {
//        Instancia uma conexão com o S3
        S3Client s3Client = new S3Provider().getS3Client();

//        Cria requisição para listar os objetos dentro do bucket
        ListObjectsRequest listObjectsRequest = ListObjectsRequest.builder()
                .bucket("innovaxs3")
                .build();

//        Lista objetos do bucket usando a requisição
        List<S3Object> objects = s3Client.listObjects(listObjectsRequest).contents();

        for (S3Object object : objects) {
//            Cria requisição para baixar um objeto do bucket
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket("nome-do-bucket")
                    .key(object.key())
                    .build();

//            Captura objeto usando a requisição e tenta transformar para formato de arquivo que o java interpreta
            InputStream objectContent = s3Client.getObject(getObjectRequest, ResponseTransformer.toInputStream());

            try {
//                Copia arquivo do s3 para um arquivo local com o nome da key do objeto
                Files.copy(objectContent, new File(object.key()).toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
