package main.java.bean;


/**
 * Created by Sheffy on 2018/4/9.
 */
public class ClassmateBean {
    private String bookId;
    private String classmateName;
    private String sex;
    private String birthday;        //生日的格式是 xxxx-xx-xx
    private String constellation;   //星座
    private String phone;
    private String qq;
    private String address;
    private String leaveWord;
    private String yourWord;
    private String bloodGroup;
    private String hobby;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getClassmateName() {
        return classmateName;
    }

    public void setClassmateName(String classmateName) {
        this.classmateName = classmateName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLeaveWord() {
        return leaveWord;
    }

    public void setLeaveWord(String leaveWord) {
        this.leaveWord = leaveWord;
    }

    public String getYourWord() {
        return yourWord;
    }

    public void setYourWord(String yourWord) {
        this.yourWord = yourWord;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "ClassmateBean[" +
                "bookId=" + bookId +
                ",classmateName=" + classmateName +
                ",sex=" + sex +
                ",birthday=" + birthday +
                ",constellation=" + constellation +
                ",phone=" + phone +
                ",qq=" + qq +
                ",address=" + address +
                ",leaveWord=" + leaveWord+
                ",yourWord=" + yourWord +
                ",bloodGroup=" + bloodGroup +
                ",hobby=" + hobby +
                "]";
    }
}
