package exercise05;

import java.io.*;
import java.lang.ClassNotFoundException;
import java.util.ArrayList;

public class LoadFile {


    public void load(String fileName, ArrayList<User> user){

        File f = new File(fileName);

        try(ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(f))))
        {
            while(true/*in.available()>0*/)
                user.add((User) in.readObject());
        }
        catch(IOException | ClassNotFoundException e) {
            if (!(e instanceof EOFException)) {
                throw new RuntimeException(e);
            }
        }

    }
}
