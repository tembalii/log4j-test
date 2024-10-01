public class SampleCode {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.ser"))) {
            // This line should be flagged by the rule
            Object deserializedObject = objectInputStream.readObject();

            System.out.println("Deserialized object: " + deserializedObject);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
