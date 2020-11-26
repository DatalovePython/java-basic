package main.java.proxy.static_model;

/**
 * @author luzc
 * @date 2020/11/26 15:35
 * @desc
 */
public class Cinema implements Movie{

    RealMovie movie;

    public Cinema(RealMovie movie){
        super();
        this.movie = movie;
    }

    @Override
    public void play() {
        advisement(true);
        movie.play();
        advisement(false);
    }

    public void advisement(boolean isStart){
        if(isStart){
            System.out.println("电影马上开始了，快来买");
        }else{
            System.out.println("电影马上结束了，快来买");
        }
    }
}
