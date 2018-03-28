package data.models;

/**
 * Created by Mortimer on 3/27/2018.
 */
public class User {
    private int id;
    private int login_id;
    private String name;
    private String card_no;
    private String address;
    private String cnp;

    public User(){

    }

    public User(int id, int login_id,  String card_no, String name,  String address, String cnp){
        this.id = id;
        this.login_id = login_id;
        this.name = name;
        this.address = address;
        this.cnp = cnp;
        this.card_no = card_no;
    }

    public User(int id, int login_id){
        this.id = id;
        this.login_id = login_id;
        this.name = "Anonymous";
        this.address = "Not specified";
        this.cnp = "Not specified";
    }

    public String toString(){
        return "User [id=" + id + ", login id=" + login_id + ", name:" + name + ", address=" + address + ", cnp=" + cnp + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLogin_id() {
        return login_id;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}
