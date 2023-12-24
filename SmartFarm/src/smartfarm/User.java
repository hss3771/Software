/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smartfarm;

/**
 *
 * @author Software
 */
public class User {
    //변수 선언
    private String id;
    private String pw;
    private String name;
    private int age;
    private String phoneNum;
    private String address;
    //set, get설정
    public String getId() {
        return id;
    }
    public String getPw() {
        return pw;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
}
