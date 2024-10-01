import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SimpleExample {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();  // Creating a JSON object

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.ser"))) {
            // This line should be flagged by the rule
            Object obj = objectInputStream.readObject();
            System.out.println("Object read: " + obj);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
