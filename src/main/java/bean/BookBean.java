package main.java.bean;

/**
 * Created by Sheffy on 2018/4/5.
 */
public class BookBean {

    public String BookId;
    public String UserId;
    public String introduce;
    public int face;
    public int pager;

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int getPager() {
        return pager;
    }

    public void setPager(int pager) {
        this.pager = pager;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    @Override
    public String toString() {
        return "BookBean[" +
                "BookId=" + BookId +
                ", UserId=" + UserId +
                ",introduce="+introduce+
                ",face="+face+
                ",pager="+pager+
                "]";
    }
}
