import java.io.*;
import java.lang.ClassNotFoundException;

public class LoadFile {


    public int load(String fileName, User[] arrayUsers){
        InputUsers iu = new InputUsers();

        File f = new File(iu.fileName);

        int count = 0;
        try(ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(f))))
        {
            while(true) {
                iu.arrayUsers[count] = (User) ois.readObject();
                count++;
            }
        } catch(IOException | ClassNotFoundException e) {
            return count;
        }

    }
}
