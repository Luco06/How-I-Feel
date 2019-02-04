package Model;

public class Mood {
    private int mSmiley;
    private int mBackground;
    private String mComment;


    public int getmSmiley(){
        return mSmiley;
    }

    public int getmBackground() {
        return mBackground;
    }

    public String getmComment() {
        return mComment;
    }

    public void setmComment(String mComment) {
        this.mComment = mComment;
    }
    public Mood(int mSmiley, int mBackground, String mComment){
        this.mSmiley = mSmiley;
        this.mBackground = mBackground;
        this.mComment = mComment;
    }
}
