package BTVN_buoi3_bai1;

public class Group {
    private int image;
    private String title;
    private String fan;
    private String post;
    private String close;


    public Group(int image, String title, String fan, String post, String close) {
        this.image = image;
        this.title = title;
        this.fan = fan;
        this.post = post;
        this.close = close;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFan() {
        return fan;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }
}
