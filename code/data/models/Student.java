package data.models;


/**
 * Created by Mortimer on 3/27/2018.
 */
public class Student {
    private int id;
    private String name;
    private int group;
    private int user_id;

    public Student(){

    }


    public Student(int id, String name, int group, int user_id){
        this.id = id;
        this.name = name;
        this.group = group;
        this.user_id = user_id;
    }


    public String toString(){
        return "Student [id=" + id + ", name=" + name + ", group=" + group + ", user id=" + user_id +  "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
