package effective.ch2.item09;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestItem09 {
}

class TyrCatch {
    // 옛날 방식
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // Auto resources 방식
    static String newFirstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    // 옛날 방식
    static void copyFile(String src, String dest) throws IOException {
        InputStream in = new BufferedInputStream(Files.newInputStream(Paths.get(src)));
        try {
            OutputStream out = Files.newOutputStream(Paths.get(dest));
            try {
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    // Auto resources 방식. 복수개 선언 가능
    static void newCopyFile(String src, String dest) throws IOException {
        try (InputStream in = new BufferedInputStream(Files.newInputStream(Paths.get(src)));
             OutputStream out = Files.newOutputStream(Paths.get(dest))) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
    }
}

