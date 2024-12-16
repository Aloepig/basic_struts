package effective.ch12;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class TestDeserialization {

    @Test
    public void bombTest() throws IOException, ClassNotFoundException {
        byte[] serialized = bomb();
        // System.out.println(serialized);
        // Set<Object> deserialize = (Set<Object>) new ObjectInputStream(new ByteArrayInputStream(serialized)).readObject();
        // System.out.println(deserialize);
    }

    private byte[] bomb() throws IOException {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            Set<Object> t1 = new HashSet<>();
            //Set<Object> t2 = new HashSet<>();
            t1.add("foo" + i);

            //System.out.println(i + "S:" + s1);
            //System.err.println(i + "S:" + root);

            s1.add(t1);
            System.out.println(i + ":" + s1);
            System.err.println(i + ":" + root);

            // s1.add(t2);
            // s2.add(t1);
            // s2.add(t2);

            s1 = t1;
            System.out.println(i + "C:" + s1);
            System.err.println(i + "C:" + root);

            // s2 = t2;

        }
        return serialize(root);
    }

    private byte[] serialize(Set<Object> s) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(s);
        objectOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
