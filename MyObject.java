package Module_three;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyObject implements Serializable{
    int id;
    String title;

    public MyObject(int id, String title){
        this.id = id;
        this.title = title;
    }

    public String getName() {
        return title;
    }

    public int getId() {
        return id;
    }
    public String toString(){
        return id + "-" + title;
    }
}


