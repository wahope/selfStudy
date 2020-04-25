package com.selfStudy.core.pojo.vo;

/**
 * @author ：凌文
 * @ClassName
 * @date ：Created in 2019/4/9 20:37
 * @description：
 * @modified By：
 * @version: $
 * @Class:
 */
public class SsCollectionVo {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private String bookName;
    private String bookIntro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }
}
