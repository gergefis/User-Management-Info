import java.io.*;
import java.util.ArrayList;

public class SaveFile {

    public void save(String fileName, ArrayList<User> user) {
        File f = new File(fileName);

        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(f))))
        {
            for(var value: user) out.writeObject(value);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
}

