import java.io.*;
import java.lang.ClassNotFoundException;

public class LoadFile {


    public int load(String fileName, User[] arrayUsers){

        File f = new File(fileName);

        int count = 0;
        try(ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(f))))
        {
            while(true) {
                arrayUsers[count] = (User) ois.readObject();
                count++;
            }
        } catch(IOException | ClassNotFoundException e) {
            return count;
        }

    }
}
