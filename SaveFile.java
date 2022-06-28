package exercise;

import java.io.*;

public class SaveFile {

    InputUsers iu = new InputUsers();


    public void save(String fileName, User[] arrayUsers, int curUsers){
        File f = new File(iu.fileName);

        try(ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream (
                    new FileOutputStream(f))))
        {
            for (int i = 0; i < curUsers; i++) {
                oos.writeObject(arrayUsers[i]);
            }

        } catch(IOException e){
            System.err.println(e);
        }

    }
}
