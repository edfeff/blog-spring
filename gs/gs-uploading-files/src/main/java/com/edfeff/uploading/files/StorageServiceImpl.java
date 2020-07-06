package com.edfeff.uploading.files;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author wangpp
 */
//@Service
public class StorageServiceImpl implements StorageService {
    private final Logger log = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    StorageProperties storageProperties;

    //    @PostConstruct
    @Override
    public void init() {
        if (StringUtils.isEmpty(storageProperties.getLocation())) {
            String property = System.getProperty("java.io.tmpdir");
            if (StringUtils.isEmpty(property)) {
                property = "C:/Users/thisisit/AppData/Local/Temp";
            }
            File file = new File(property + File.separator + "blog_upload");
            if (!file.isDirectory()) {
                file.mkdirs();
            }
            log.info(file.getAbsolutePath());
            System.setProperty("java.io.tmpdir", file.getAbsolutePath());
        } else {
            System.setProperty("java.io.tmpdir", storageProperties.getLocation());
        }
    }

    @Override
    public void store(MultipartFile file) {
        String baseDir = System.getProperty("java.io.tmpdir");
        try (FileOutputStream out = new FileOutputStream(new File(baseDir + File.separator + file.getOriginalFilename()))) {
            int n = IOUtils.copy(file.getInputStream(), out);
            log.info("save {} , size {}", file.getOriginalFilename(), n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        String baseDir = System.getProperty("java.io.tmpdir");
        return Arrays.stream(Objects.requireNonNull(Paths.get(baseDir).toFile().listFiles(File::isFile)))
                .map(File::toPath);
    }

    @Override
    public Path load(String filename) {
        String baseDir = System.getProperty("java.io.tmpdir");
        return Paths.get(baseDir, filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        Path filePath = load(filename);
        return new FileSystemResource(filePath);
    }

    @Override
    public void deleteAll() {
        String baseDir = System.getProperty("java.io.tmpdir");
        for (File file : Objects.requireNonNull(new File(baseDir).listFiles(File::isFile))) {
            file.delete();
        }
    }
}
