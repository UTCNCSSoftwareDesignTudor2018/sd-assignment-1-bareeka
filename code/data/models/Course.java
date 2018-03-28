package data.models;

/**
 * Created by Mortimer on 3/27/2018.
 */
public class Course {
    private int id;
    private String name;
    private String desc;

    public Course(){

    }

    public Course(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "Course [id=" + id + ", name=" + name + ", description:" + desc + "]";
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
